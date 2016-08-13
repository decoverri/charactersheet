package com.decoverri.charactersheet.models;

public class Ability {
	
	private Integer value;
	private String name;

	public Ability(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public Integer getModifier() {
		return new Double(Math.floor((value - 10) / 2.0)).intValue();
	}
	
	public String getFormattedModifier(){
		Integer modifier = getModifier();
		String formatted = "";
		if(modifier > -1){
			formatted += "+";
		}
		return formatted += modifier;
	}
	
	public String getName() {
		return name;
	}

	public String getShortName() {
		return name.substring(0, 3).toUpperCase();
	}
}
