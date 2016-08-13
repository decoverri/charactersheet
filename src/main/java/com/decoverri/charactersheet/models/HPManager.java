package com.decoverri.charactersheet.models;

public class HPManager {

	private Integer total;
	private Integer current;
	private Integer nonlethalDamage;

	public HPManager(Integer total) {
		this.total = total;
		this.current = total;
		this.nonlethalDamage = 0;
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
