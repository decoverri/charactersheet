package com.decoverri.charactersheet.models;

import com.decoverri.charactersheet.enums.Size;

public class AcManager {

	private Ability dexterity;
	private Size size;

	public AcManager(Ability dexterity, Size size) {
		this.dexterity = dexterity;
		this.size = size;
	}

	public Integer getAc() {
		return 10 + dexterity.getModifier() + size.getACBonus();
	}

	public Integer getTouch(){
		return 10 + dexterity.getModifier() + size.getACBonus();
	}

	public Integer getFlatFooted(){
		return 10 + size.getACBonus();
	}

}
