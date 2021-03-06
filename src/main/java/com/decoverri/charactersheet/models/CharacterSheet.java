package com.decoverri.charactersheet.models;

import java.util.Arrays;
import java.util.List;

import com.decoverri.charactersheet.enums.Alignment;

public class CharacterSheet {

	private Character character;
	
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability wisdom;
	private Ability charisma;
	private Ability intelligence;

	private AcManager acManager;
	
	private List<Skill> skills;
	
	public void setCharacter(Character character) {
		this.character = character;
		strength = new Ability(character.getStrength(), "Strength");        
		dexterity = new Ability(character.getDexterity(), "Dexterity");      
		constitution = new Ability(character.getConstitution(), "Constitution");
		intelligence = new Ability(character.getIntelligence(), "Intelligence");
		wisdom = new Ability(character.getWisdom(), "Wisdom");            
		charisma = new Ability(character.getCharisma(), "Charisma");
		
		acManager = new AcManager(dexterity, character.getRace().getSize());
	}
	
	public String getName(){
		return this.character.getName();
	}

	public Alignment getAlignment(){
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
		return Arrays.asList(strength, dexterity, constitution, intelligence, wisdom, charisma);			 
	}
	
	public AcManager getAcManager(){
		return acManager;
	}
	
	public Integer getBaseAtackBonus(){
		return character.getBab();
	}
	
	public Integer getMeleeBonus(){
		return character.getBab() + strength.getModifier() + character.getRace().getSize().getAttackBonus();
	}
	
	public Integer getRangedBonus(){
		return character.getBab() + dexterity.getModifier() + character.getRace().getSize().getAttackBonus();
	}

	public HPManager getHpManager() {
		return this.character.getHpManager();
	}
	
	public Integer getInitiative(){
		return this.dexterity.getModifier();
	}
	
	public Integer getBaseHP(){
		return character.getBaseHP();
	}
	
	public Integer getCharacterLevel(){
		return this.character.getLevels();
	}
	
	public List<Skill> getSkills(){
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
}
