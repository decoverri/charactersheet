package com.decoverri.charactersheet.models;

public class LevelsInClass {

	private BaseClass baseClass;
	private Integer level;

	public BaseClass getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(BaseClass baseClass) {
		this.baseClass = baseClass;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return baseClass.getName() + " level " + level;
	}
}
