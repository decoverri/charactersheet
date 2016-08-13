package com.decoverri.charactersheet.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.decoverri.charactersheet.enums.Size;

@Entity
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@NotNull
	private Integer baseSpeed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Integer getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(Integer baseSpeed) {
		this.baseSpeed = baseSpeed;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
