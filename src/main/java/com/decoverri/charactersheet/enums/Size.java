package com.decoverri.charactersheet.enums;

public enum Size {

	SMALL("Small", 1, 4, 0.75),
	MEDIUM("Medium", 0, 0, 1.0);
	
	private String name;
	private Integer bonus;
	private Integer stealthBonus;
	private Double carringCapacityMultiplier;

	Size(String name, Integer bonus, Integer stealthBonus, Double carringCapacity){
		this.name = name;
		this.bonus = bonus;
		this.stealthBonus = stealthBonus;
		this.carringCapacityMultiplier = carringCapacity;
	}

	public Double getCarringCapacityMultiplier() {
		return carringCapacityMultiplier;
	}

	public Integer getStealthBonus() {
		return stealthBonus;
	}

	public Integer getAttackBonus() {
		return bonus;
	}
	
	public Integer getACBonus() {
		return bonus;
	}
	
	public Integer getCMBBonus() {
		return -bonus;
	}
	
	public Integer getCMDBonus() {
		return -bonus;
	}
	
	public String getName() {
		return name;
	}
	
}
