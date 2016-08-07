package com.decoverri.charactersheet.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.decoverri.charactersheet.enums.BabProgression;
import com.decoverri.charactersheet.enums.BaseSaveBonusProgression;

@Entity
public class BaseClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(unique=true)
	private String name;
	
	@NotNull
	private Integer hitDie;
	
	@NotNull
	private Integer skillRanksPerLevel;

	@NotNull
	@Enumerated(EnumType.STRING)
	private BabProgression babProgression;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BaseSaveBonusProgression fortitudeProgression;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BaseSaveBonusProgression reflexProgression;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private BaseSaveBonusProgression willProgression;

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

	public Integer getHitDie() {
		return hitDie;
	}

	public void setHitDie(Integer hitDie) {
		this.hitDie = hitDie;
	}

	public Integer getSkillRanksPerLevel() {
		return skillRanksPerLevel;
	}

	public void setSkillRanksPerLevel(Integer skillRanksPerLevel) {
		this.skillRanksPerLevel = skillRanksPerLevel;
	}

	public BabProgression getBabProgression() {
		return babProgression;
	}

	public void setBabProgression(BabProgression babProgression) {
		this.babProgression = babProgression;
	}

	public BaseSaveBonusProgression getFortitudeProgression() {
		return fortitudeProgression;
	}

	public void setFortitudeProgression(BaseSaveBonusProgression fortitudeProgression) {
		this.fortitudeProgression = fortitudeProgression;
	}

	public BaseSaveBonusProgression getReflexProgression() {
		return reflexProgression;
	}

	public void setReflexProgression(BaseSaveBonusProgression reflexProgression) {
		this.reflexProgression = reflexProgression;
	}

	public BaseSaveBonusProgression getWillProgression() {
		return willProgression;
	}

	public void setWillProgression(BaseSaveBonusProgression willProgression) {
		this.willProgression = willProgression;
	}

}
