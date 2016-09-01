package com.decoverri.charactersheet.controllers;

import static com.decoverri.charactersheet.enums.Alignment.LG;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.charactersheet.daos.BaseClassDao;
import com.decoverri.charactersheet.daos.RaceDao;
import com.decoverri.charactersheet.daos.SkillDao;
import com.decoverri.charactersheet.factories.CharacterSheetFactory;
import com.decoverri.charactersheet.models.Character;
import com.decoverri.charactersheet.models.CharacterSheet;
import com.decoverri.charactersheet.models.HPManager;
import com.decoverri.charactersheet.models.LevelsInClass;
import com.decoverri.charactersheet.models.Skill;

@Controller
public class SheetController {
	
	@Autowired
	private BaseClassDao baseClassDao;
	
	@Autowired
	private RaceDao raceDao;
	
	@Autowired
	private SkillDao skillDao;

	@RequestMapping("/")
	public String sheet(Model model) {
		Character character = new Character();
		character.setName("Sirion");
		character.setAlignment(LG);
		character.setPlayer("Deco");
		
		LevelsInClass levelsInClass = new LevelsInClass();
		levelsInClass.setLevel(7);
		levelsInClass.setBaseClass(baseClassDao.findByName("Paladin"));
		character.setClasses(Arrays.asList(levelsInClass));

		character.setRace(raceDao.findByName("Halfling"));
		
		character.setStrength(14);
		character.setDexterity(12);
		character.setConstitution(16);
		character.setIntelligence(14);
		character.setWisdom(10);
		character.setCharisma(23);
		
		character.setBaseHP(67);
		
		character.setHpManager(new HPManager(88, 88, 0));
		CharacterSheet sheet = new CharacterSheetFactory().createSheetFor(character);
		List<Skill> skills = skillDao.list();
		sheet.setSkills(skills);
		model.addAttribute("sheet",sheet);
		return "sheet";
	}
}
