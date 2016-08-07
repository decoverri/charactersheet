package com.decoverri.charactersheet.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class BabProgressionTest {

	@Test
	public void level1GoodProgressionReturns1() {
		assertEquals(1, BabProgression.GOOD.getBab(1));
	}

	@Test
	public void level6GoodProgressionReturns6() {
		assertEquals(6, BabProgression.GOOD.getBab(6));
	}

	@Test
	public void level11GoodProgressionReturns11() {
		assertEquals(11, BabProgression.GOOD.getBab(11));
	}
	
	@Test
	public void level20GoodProgressionReturns20() {
		assertEquals(20, BabProgression.GOOD.getBab(20));
	}
	
	@Test
	public void level1MediumProgressionReturns0() {
		assertEquals(0, BabProgression.MEDIUM.getBab(1));
	}
	
	@Test
	public void level4MediumProgressionReturns3() {
		assertEquals(3, BabProgression.MEDIUM.getBab(4));
	}

	@Test
	public void level5MediumProgressionReturns3() {
		assertEquals(3, BabProgression.MEDIUM.getBab(5));
	}

	@Test
	public void level8MediumProgressionReturns6() {
		assertEquals(6, BabProgression.MEDIUM.getBab(8));
	}

	@Test
	public void level20MediumProgressionReturns15() {
		assertEquals(15, BabProgression.MEDIUM.getBab(20));
	}

	@Test
	public void level1BadProgressionreturns0() {
		assertEquals(0, BabProgression.BAD.getBab(1));
	}

	@Test
	public void level12BadProgressionreturns6() {
		assertEquals(6, BabProgression.BAD.getBab(12));
	}

	@Test
	public void level20BadProgressionreturns10() {
		assertEquals(10, BabProgression.BAD.getBab(20));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void levelBelow1ThrowsException() throws Exception {
		BabProgression.GOOD.getBab(0);
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void levelAbove20ThrowsException() throws Exception {
		BabProgression.GOOD.getBab(21);
	}
}
