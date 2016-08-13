package com.decoverri.charactersheet.enums;

public enum Alignment {
	LG("Lawful Good"),
	NG("Neutral Good"),
	CG("Chaotic Good"),
	LN("Lawful Neutral"),
	N("Neutral"),
	CN("Chaotic Neutral"),
	LE("Lawful Evil"),
	NE("Neutral Evil"),
	CE("Chaotic Evil");
	
	
	
	private String alignment;

	Alignment(String alignment){
		this.alignment = alignment;
	}
	
	public String getAlignment() {
		return alignment;
	}
}
