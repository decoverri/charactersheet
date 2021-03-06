package com.decoverri.charactersheet.models;

import java.util.List;

import com.decoverri.charactersheet.enums.Alignment;

public class Character {

	private String name;
	private Alignment alignment;
	private String player;
	private List<LevelsInClass> classes;
	private Race race;
	
	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	
	private Integer baseHP;
	private HPManager hpManager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public List<LevelsInClass> getClasses() {
		return classes;
	}

	public void setClasses(List<LevelsInClass> classes) {
		this.classes = classes;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public HPManager getHpManager() {
		return hpManager;
	}

	public void setHpManager(HPManager hpManager) {
		this.hpManager = hpManager;
	}
	
	public Integer getBaseHP() {
		return baseHP;
	}
	
	public void setBaseHP(Integer baseHP) {
		this.baseHP = baseHP;
	}

	public Integer getBab() {
		int bab = 0;
		for (LevelsInClass classi : getClasses()) {
			bab = classi.getBaseClass().getBabProgression().getBab(classi.getLevel());
		}
		return bab;
	}

	@Override
	public String toString() {
		return player + "'s character: " + name + ", a " + race + " " + classes.get(0);
	}

	public Integer getLevels() {
		return classes.stream().mapToInt(levelInClass -> levelInClass.getLevel()).sum();
	}
}
