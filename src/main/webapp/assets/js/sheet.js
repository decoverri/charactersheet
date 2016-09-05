(function(){
"use strict"
	
new Vue({
	 el: "#sheet"
	
	,data: {
		
		characterLevel: 0
		
		,strBase: 0
		,dexBase: 0
		,conBase: 0
		,intBase: 0
		,wisBase: 0
		,chaBase: 0
	
		,strBonuses: [0]
		,dexBonuses: [0]
		,conBonuses: [0]
		,intBonuses: [0]
		,wisBonuses: [0]
		,chaBonuses: [0]

		,baseHP: 0
		,damage: 0
		,nonlethalDamage: 0
		,hit: ''

		,bab: 0
		
		,acrobaticsRanks: 0
		,appraiseRanks: 0
		,bluffRanks: 0
		,climbRanks: 0
		,diplomacyRanks: 0
		,disabledeviceRanks: 0
		,disguiseRanks: 0
		,escapeartistRanks: 0
		,flyRanks: 0
		,handleanimalRanks: 0
		,healRanks: 0
		,intimidateRanks: 0
		,knowledgearcanaRanks: 0
		,knowledgedungeoneeringRanks: 0
		,knowledgeengineeringRanks: 0
		,knowledgegeographyRanks: 0
		,knowledgehistoryRanks: 0
		,knowledgelocalRanks: 0
		,knowledgenatureRanks: 0
		,knowledgenobilityRanks: 0
		,knowledgeplanesRanks: 0
		,knowledgereligionRanks: 0
		,linguisticsRanks: 0
		,perceptionRanks: 0
		,rideRanks: 0
		,sensemotiveRanks: 0
		,sleightofhandRanks: 0
		,spellcraftRanks: 0
		,stealthRanks: 0
		,survivalRanks: 0
		,swimRanks: 0
		,usemagicdeviceRanks: 0
		
		,acrobaticsBonuses: [0]
		,appraiseBonuses: [0]
		,bluffBonuses: [0]
		,climbBonuses: [0]
		,diplomacyBonuses: [0]
		,disabledeviceBonuses: [0]
		,disguiseBonuses: [0]
		,escapeartistBonuses: [0]
		,flyBonuses: [0]
		,handleanimalBonuses: [0]
		,healBonuses: [0]
		,intimidateBonuses: [0]
		,knowledgearcanaBonuses: [0]
		,knowledgedungeoneeringBonuses: [0]
		,knowledgeengineeringBonuses: [0]
		,knowledgegeographyBonuses: [0]
		,knowledgehistoryBonuses: [0]
		,knowledgelocalBonuses: [0]
		,knowledgenatureBonuses: [0]
		,knowledgenobilityBonuses: [0]
		,knowledgeplanesBonuses: [0]
		,knowledgereligionBonuses: [0]
		,linguisticsBonuses: [0]
		,perceptionBonuses: [0]
		,rideBonuses: [0]
		,sensemotiveBonuses: [0]
		,sleightofhandBonuses: [0]
		,spellcraftBonuses: [0]
		,stealthBonuses: [0]
		,survivalBonuses: [0]
		,swimBonuses: [0]
		,usemagicdeviceBonuses: [0]

		,classSkills: []
	}

	,computed: {

		//****** Abilities ******
		 str: function(){
			 return getAbilityTotal(this.strBase, this.strBonuses);
		 }
		,dex: function(){
			 return getAbilityTotal(this.dexBase, this.dexBonuses);
		 }

		,con: function(){
			 return getAbilityTotal(this.conBase, this.conBonuses);
		 }

		,int: function(){
			 return getAbilityTotal(this.intBase, this.intBonuses);
		 }

		,wis: function(){
			 return getAbilityTotal(this.wisBase, this.wisBonuses);
		 }

		,cha: function(){
			 return getAbilityTotal(this.chaBase, this.chaBonuses);
		 }

		//****** Abilities Modifiers ******		
		,strMod: function() {
			return modifierFor(this.str);
		}
		,dexMod: function() {
			return modifierFor(this.dex);
		}
		,conMod: function() {
			return modifierFor(this.con);
		}
		,intMod: function() {
			return modifierFor(this.int);
		}
		,wisMod: function() {
			return modifierFor(this.wis);
		}
		,chaMod: function() {
			return modifierFor(this.cha);
		}
		
		//****** HP ******
		,totalHP: function() {
			return parseInt(this.baseHP) + parseInt(this.characterLevel) * (parseInt(this.conMod));
		}
		,currentHP: function() {
			return this.totalHP - parseInt(this.damage);
		}
		
		//****** Initiative ******
		,initiative: function(){
			return this.dexMod;
		}
		
		//****** AC ******
		,AC: function() {
			return 10 + 10 + 3 + 1 + parseInt(this.dexMod);
		}
		,touchAC: function() {
			return 10 + 1 + parseInt(this.dexMod);
		}
		,flatfootedAC: function() {
			return 10 + 10 + 3 + 1;
		}
		
		//****** Attack ******
		,meleeBonus: function() {
			return parseInt(this.bab) + parseInt(this.strMod);
		}
		,rangedBonus: function() {
			return parseInt(this.bab) + parseInt(this.dexMod);
		}
		
		//****** Abilities ******
		,acrobaticsTotal : function() {
			return skillTotal(this.acrobaticsRanks, this.dexMod, this.acrobaticsBonuses, this.classSkills.indexOf("acrobatics"));
		}
		,appraiseTotal : function() {
			return skillTotal(this.appraiseRanks, this.intMod, this.appraiseBonuses, this.classSkills.indexOf("appraise"));
		}
		,bluffTotal : function() {
			return skillTotal(this.bluffRanks, this.chaMod, this.bluffBonuses, this.classSkills.indexOf("bluff"));
		}
		,climbTotal : function() {
			return skillTotal(this.climbRanks, this.strMod, this.climbBonuses, this.classSkills.indexOf("climb"));
		}
		,diplomacyTotal : function() {
			return skillTotal(this.diplomacyRanks, this.chaMod, this.diplomacyBonuses, this.classSkills.indexOf("diplomacy"));
		}
		,disabledeviceTotal : function() {
			return skillTotal(this.disabledeviceRanks, this.dexMod, this.disabledeviceBonuses, this.classSkills.indexOf("disabledevice"));
		}
		,disguiseTotal : function() {
			return skillTotal(this.disguiseRanks, this.chaMod, this.disguiseBonuses, this.classSkills.indexOf("disguise"));
		}
		,escapeartistTotal : function() {
			return skillTotal(this.escapeartistRanks, this.dexMod, this.escapeartistBonuses, this.classSkills.indexOf("escapeartist"));
		}
		,flyTotal : function() {
			return skillTotal(this.flyRanks, this.dexMod, this.flyBonuses, this.classSkills.indexOf("fly"));
		}
		,handleanimalTotal : function() {
			return skillTotal(this.handleanimalRanks, this.chaMod,this.handleanimalBonuses, this.classSkills.indexOf("handleanimal"));
		}
		,healTotal : function() {
			return skillTotal(this.healRanks, this.wisMod, this.healBonuses, this.classSkills.indexOf("heal"));
		}
		,intimidateTotal : function() {
			return skillTotal(this.intimidateRanks, this.chaMod, this.intimidateBonuses, this.classSkills.indexOf("intimidate"));
		}
		,knowledgearcanaTotal : function() {
			return skillTotal(this.knowledgearcanaRanks, this.intMod, this.knowledgearcanaBonuses, this.classSkills.indexOf("knowledgearcana"));
		}
		,knowledgedungeoneeringTotal : function() {
			return skillTotal(this.knowledgedungeoneeringRanks, this.intMod, this.knowledgedungeoneeringBonuses, this.classSkills.indexOf("knowledgedungeoneering"));
		}
		,knowledgeengineeringTotal : function() {
			return skillTotal(this.knowledgeengineeringRanks, this.intMod, this.knowledgeengineeringBonuses, this.classSkills.indexOf("knowledgeengineering"));
		}
		,knowledgegeographyTotal : function() {
			return skillTotal(this.knowledgegeographyRanks, this.intMod, this.knowledgegeographyBonuses, this.classSkills.indexOf("knowledgegeography"));
		}
		,knowledgehistoryTotal : function() {
			return skillTotal(this.knowledgehistoryRanks, this.intMod, this.knowledgehistoryBonuses, this.classSkills.indexOf("knowledgehistory"));
		}
		,knowledgelocalTotal : function() {
			return skillTotal(this.knowledgelocalRanks, this.intMod, this.knowledgelocalBonuses, this.classSkills.indexOf("knowledgelocal"));
		}
		,knowledgenatureTotal : function() {
			return skillTotal(this.knowledgenatureRanks, this.intMod, this.knowledgenatureBonuses, this.classSkills.indexOf("knowledgenature"));
		}
		,knowledgenobilityTotal : function() {
			return skillTotal(this.knowledgenobilityRanks, this.intMod, this.knowledgenobilityBonuses, this.classSkills.indexOf("knowledgenobility"));
		}
		,knowledgeplanesTotal : function() {
			return skillTotal(this.knowledgeplanesRanks, this.intMod, this.knowledgeplanesBonuses, this.classSkills.indexOf("knowledgeplanes"));
		}
		,knowledgereligionTotal : function() {
			return skillTotal(this.knowledgereligionRanks, this.intMod, this.knowledgereligionBonuses, this.classSkills.indexOf("knowledgereligion"));
		}
		,linguisticsTotal : function() {
			return skillTotal(this.linguisticsRanks, this.intMod, this.linguisticsBonuses, this.classSkills.indexOf("linguistics"));
		}
		,perceptionTotal : function() {
			return skillTotal(this.perceptionRanks, this.wisMod, this.perceptionBonuses, this.classSkills.indexOf("perception"));
		}
		,rideTotal : function() {
			return skillTotal(this.rideRanks, this.dexMod, this.rideBonuses, this.classSkills.indexOf("ride"));
		}
		,sensemotiveTotal : function() {
			return skillTotal(this.sensemotiveRanks, this.wisMod, this.sensemotiveBonuses, this.classSkills.indexOf("sensemotive"));
		}
		,sleightofhandTotal : function() {
			return skillTotal(this.sleightofhandRanks, this.dexMod, this.sleightofhandBonuses, this.classSkills.indexOf("sleightofhand"));
		}
		,spellcraftTotal : function() {
			return skillTotal(this.spellcraftRanks, this.intMod, this.spellcraftBonuses, this.classSkills.indexOf("spellcraft"));
		}
		,stealthTotal : function() {
			return skillTotal(this.stealthRanks, this.dexMod, this.stealthBonuses, this.classSkills.indexOf("stealth"));
		}
		,survivalTotal : function() {
			return skillTotal(this.survivalRanks, this.wisMod, this.survivalBonuses, this.classSkills.indexOf("survival"));
		}
		,swimTotal : function() {
			return skillTotal(this.swimRanks, this.strMod, this.swimBonuses, this.classSkills.indexOf("swim"));
		}
		,usemagicdeviceTotal : function() {
			return skillTotal(this.usemagicdeviceRanks, this.chaMod, this.usemagicdeviceBonuses, this.classSkills.indexOf("usemagicdevice"));
		}
		
	}
	
	,methods: {
		 takeDamage: function(){
			if(this.hit != ''){
				this.damage = parseInt(this.damage) + parseInt(this.hit);
				this.hit = '';
			}
		 }
		,heal: function(){
			if(this.hit != ''){
				var _damage = parseInt(this.damage) - parseInt(this.hit);
				var _nldamage = parseInt(this.nonlethalDamage) - parseInt(this.hit);
				if(_damage > 0){
					this.damage = _damage;				
				}else{
					this.damage = 0;
				}
				if(_nldamage > 0){
					this.nonlethalDamage = _nldamage;				
				}else{
					this.nonlethalDamage = 0;
				}
				this.hit = '';
			}
		}
		,takeNonlethalDamage: function(){
			if(this.hit != ''){
				this.nonlethalDamage = parseInt(this.nonlethalDamage) + parseInt(this.hit);			
				this.hit = '';
			}

		}
		,healNonlethalDamage: function(){
			if(this.hit != ''){
				var _nldamage = parseInt(this.nonlethalDamage) - parseInt(this.hit);
				if(_nldamage > 0){
					this.nonlethalDamage = _nldamage;				
				}else{
					this.nonlethalDamage = 0;
				}
				this.hit = '';
			}

		}
	}

});

function modifierFor(ability){
	if(!(ability < 0)){
		return Math.floor( (ability - 10) / 2 );
	}
}

function addSign(number){
	if(number >= 0){
		return "+" + number;
	}
	return number.toString();
}

function getAbilityTotal(base, bonuses) {
	var total = parseInt(base) + bonuses.reduce(function(a,b){return a+b;})
	if(isNaN(total) || total < 0){
		return 0;
	}
	return total;
}

function skillTotal(ranks, ability, bonuses, isClass){
	var total = parseInt(ranks) + parseInt(ability) + bonuses.reduce(function(a,b){return a+b;})
	if(isClass !=-1 && ranks > 0) {
		total += 3;
	}
	return total;
}
	
})();