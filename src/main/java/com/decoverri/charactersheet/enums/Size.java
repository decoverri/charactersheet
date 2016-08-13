package com.decoverri.charactersheet.enums;

public enum Size {

	SMALL("Small"),
	MEDIUM("Medium");
	
	private String name;

	Size(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
