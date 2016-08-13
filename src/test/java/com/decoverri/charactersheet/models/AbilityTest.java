package com.decoverri.charactersheet.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbilityTest {

	@Test
	public void abilityWithValue9HasModifierMinus1() {
		Ability ability = new Ability(9, "");
		assertEquals(new Integer(-1), ability.getModifier());
	}

	@Test
	public void abilityWithValue10HasModifierMinus0() {
		Ability ability = new Ability(10, "");
		assertEquals(new Integer(0), ability.getModifier());
	}

	@Test
	public void abilityWithValue11HasModifierMinus0() {
		Ability ability = new Ability(11, "");
		assertEquals(new Integer(0), ability.getModifier());
	}

	@Test
	public void abilityWithValue12HasModifier1() {
		Ability ability = new Ability(12, "");
		assertEquals(new Integer(1), ability.getModifier());
	}
}
