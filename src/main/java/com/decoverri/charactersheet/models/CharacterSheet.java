package com.decoverri.charactersheet.models;

import java.util.Arrays;
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
	
	public List<Ability> getAbilities(){
		return Arrays.asList(new Ability(character.getStrength(), "Strength"),
							new Ability(character.getDexterity(), "Dexterity"),
							new Ability(character.getConstitution(), "Constitution"),
							new Ability(character.getIntelligence(), "Intelligence"),
							new Ability(character.getWisdom(), "Wisdom"),
							new Ability(character.getCharisma(), "Charisma"));
	}
	
	public HPManager getHpManager() {
		return new HPManager(character.getTotalHP());
	}
}
