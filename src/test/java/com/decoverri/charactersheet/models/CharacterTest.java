package com.decoverri.charactersheet.models;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.decoverri.charactersheet.Boot;
import com.decoverri.charactersheet.daos.BaseClassDao;
import com.decoverri.charactersheet.daos.RaceDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Boot.class)
public class CharacterTest {

	@Autowired
	private BaseClassDao baseClassDao;
	@Autowired
	private RaceDao raceDao;

	@Test
	public void createACharacter() {
		Character character = new Character();
		character.setName("Sirion");
		character.setAlignment("LG");
		character.setPlayer("Deco");
		
		LevelsInClass levelsInClass = new LevelsInClass();
		levelsInClass.setLevel(7);
		levelsInClass.setBaseClass(baseClassDao.findByName("Halfling"));
		character.setClasses(Arrays.asList(levelsInClass));

		character.setRace(raceDao.findByName("Paladin"));
		
		character.setStrength(14);
		character.setDexterity(12);
		character.setConstitution(16);
		character.setIntelligence(14);
		character.setWisdom(10);
		character.setCharisma(23);
		
		character.setTotalHP(88);
		
		System.out.println(character);
	}

}
