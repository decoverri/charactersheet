(function(){

new Vue({
	 el: "#sheet"
	
	,data: {
		
		 strBase: 0
		,dexBase: 0
		,conBase: 0
		,intBase: 0
		,wisBase: 0
		,chaBase: 0			
	
		,strBonuses: []
		,dexBonuses: []
		,conBonuses: []
		,intBonuses: []
		,wisBonuses: []
		,chaBonuses: []

	}

	,computed: {
		
		 str: getAbilityTotal(this.strBase, this.strBonuses)
		,dex: getAbilityTotal(this.dexBase, this.dexBonuses)
		,con: getAbilityTotal(this.conBase, this.conBonuses)
		,int: getAbilityTotal(this.intBase, this.intBonuses)
		,wis: getAbilityTotal(this.wisBase, this.wisBonuses)
		,cha: getAbilityTotal(this.chaBase, this.chaBonuses)
		
		,strMod: function () {
			return modifierFor(this.dex);
		}
		,dexMod: function () {
			return modifierFor(this.dex);
		}
		,conMod: function () {
			return modifierFor(this.dex);
		}
		,intMod: function () {
			return modifierFor(this.dex);
		}
		,wisMod: function () {
			return modifierFor(this.dex);
		}
		,chaMod: function () {
			return modifierFor(this.dex);
		}
	}

});

function modifierFor(ability){
	if(ability){
		return addSign( Math.floor( (ability - 10) / 2 ) );
	}
	return 0;
}

function addSign(number){
	if(number >= 0){
		return "+" + number;
	}
	return number.toString();
}

function getAbilityTotal(base, bonuses) {
	return base + bonuses.reduce(function(a,b){ return a + b; });
}

})();