package com.decoverri.charactersheet.models;

public class HPManager {

	private Integer total;
	private Integer current;
	private Integer nonlethalDamage;

	public HPManager(Integer total) {
		this(total, total, 0);
	}

	public HPManager(Integer total, Integer current, Integer nonlethalDamage) {
		this.total = total;
		this.current = current;
		this.nonlethalDamage = nonlethalDamage;
	}

	public Integer getTotal() {
		return total;
	}
	
	public Integer getCurrent() {
		return current;
	}
	
	public Integer getNonlethalDamage() {
		return nonlethalDamage;
	}
}
