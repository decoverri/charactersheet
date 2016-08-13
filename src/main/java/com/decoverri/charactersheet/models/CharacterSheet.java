package com.decoverri.charactersheet.models;

import java.util.List;

public class CharacterSheet {

	private Character character;

	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public String getName(){
		return this.character.getName();
	}

	public String getAlignment(){
		return this.character.getAlignment();
	}
	
	public String getPlayer(){
		return this.character.getPlayer();
	}
	
	public List<LevelsInClass> getClasses(){
		return this.character.getClasses();
	}
	
	public String getRaceName(){
		return this.character.getRace().getName();
	}
	
	public String getSize() {
		return this.character.getRace().getSize().getName();
	}
}
