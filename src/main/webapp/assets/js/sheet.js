(function(){

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

		,bab: 0

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
	
})();