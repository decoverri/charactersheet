package com.decoverri.charactersheet.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BaseSaveBonusProgressionTest {

	@Test
	public void level1GoodProgressionReturns2() {
		assertEquals(2, BaseSaveBonusProgression.GOOD.getBonus(1));
	}

	@Test
	public void level2GoodProgressionReturns3() {
		assertEquals(3, BaseSaveBonusProgression.GOOD.getBonus(2));
	}

	@Test
	public void level3GoodProgressionReturns3() {
		assertEquals(3, BaseSaveBonusProgression.GOOD.getBonus(3));
	}

	@Test
	public void level8GoodProgressionReturns6() {
		assertEquals(6, BaseSaveBonusProgression.GOOD.getBonus(8));
	}

	@Test
	public void level13GoodProgressionReturns8() {
		assertEquals(8, BaseSaveBonusProgression.GOOD.getBonus(13));
	}

	@Test
	public void level14GoodProgressionReturns9() {
		assertEquals(9, BaseSaveBonusProgression.GOOD.getBonus(14));
	}

	@Test
	public void level20GoodProgressionReturns12() {
		assertEquals(12, BaseSaveBonusProgression.GOOD.getBonus(20));
	}

	@Test
	public void level1BadProgressionReturns0() {
		assertEquals(0, BaseSaveBonusProgression.BAD.getBonus(1));
	}

	@Test
	public void level2BadProgressionReturns0() {
		assertEquals(0, BaseSaveBonusProgression.BAD.getBonus(2));
	}

	@Test
	public void level3BadProgressionReturns1() {
		assertEquals(1, BaseSaveBonusProgression.BAD.getBonus(3));
	}

	@Test
	public void level5BadProgressionReturns1() {
		assertEquals(1, BaseSaveBonusProgression.BAD.getBonus(5));
	}

	@Test
	public void level6BadProgressionReturns2() {
		assertEquals(2, BaseSaveBonusProgression.BAD.getBonus(6));
	}

	@Test
	public void level12BadProgressionReturns4() {
		assertEquals(4, BaseSaveBonusProgression.BAD.getBonus(12));
	}

	@Test
	public void level20BadProgressionReturns6() {
		assertEquals(6, BaseSaveBonusProgression.BAD.getBonus(20));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void levelBelow1ThrowsException() throws Exception {
		BaseSaveBonusProgression.GOOD.getBonus(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void levelAbove20ThrowsException() throws Exception {
		BaseSaveBonusProgression.GOOD.getBonus(21);
	}

}
