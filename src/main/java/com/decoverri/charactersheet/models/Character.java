package com.decoverri.charactersheet.models;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.decoverri.charactersheet.enums.Alignment;

public class Character {

	private String name;
	private Alignment alignment;
	private String player;
	private List<LevelsInClass> classes;
	private Race race;
	
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability intelligence;
	private Ability wisdom;
	private Ability charisma;
	
	private Integer totalHP;

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

	public Ability getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = new Ability(strength, "strength");
	}

	public Ability getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = new Ability(dexterity, "dexterity");
	}

	public Ability getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = new Ability(constitution, "constitution");
	}

	public Ability getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = new Ability(intelligence, "intelligence");
	}

	public Ability getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = new Ability(wisdom, "wisdom");
	}

	public Ability getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = new Ability(charisma, "charisma");
	}

	public Integer getTotalHP() {
		return totalHP;
	}

	public void setTotalHP(Integer totalHP) {
		this.totalHP = totalHP;
	}

	@Override
	public String toString() {
		return player + "'s character: " + name + ", a " + race + " " + classes.get(0);
	}
}
