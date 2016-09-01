package com.decoverri.charactersheet.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.decoverri.charactersheet.daos.BaseClassDao;
import com.decoverri.charactersheet.daos.RaceDao;
import com.decoverri.charactersheet.daos.SkillDao;
import com.decoverri.charactersheet.models.BaseClass;
import com.decoverri.charactersheet.models.Race;
import com.decoverri.charactersheet.models.Skill;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@Controller
@Transactional
@RequestMapping("/fitData")
public class FitDataController {

	private static final String DATA_FOLDER = "jsonData/";
	private static final String DATA_EXTENSION = ".json";

	private XStream xstream = new XStream(new JettisonMappedXmlDriver());

	@Autowired
	private BaseClassDao baseClassDao;

	@Autowired
	private RaceDao raceDao;

	@Autowired
	private SkillDao skillDao;

	@RequestMapping("/")
	@ResponseBody
	public void fitDdata() throws Exception{
		createBaseClasses();
		createRaces();
		createSkills();
	}

	private String formatFileName(String fileName){
		return DATA_FOLDER + fileName + DATA_EXTENSION;
	}

	private Scanner createScannerFor(String fileName) throws FileNotFoundException {
		return new Scanner(new FileInputStream(formatFileName(fileName)));
	}
	
	private void createBaseClasses() throws Exception {
		xstream.alias("baseClass", BaseClass.class);
		
		Scanner scanner = createScannerFor("baseClasses");
		while(scanner.hasNextLine()){
			String nextClass = scanner.nextLine();
			BaseClass baseClass = (BaseClass) xstream.fromXML(nextClass);
			System.out.println(baseClassDao);
			baseClassDao.saveNew(baseClass);
		}
				
	}

	private void createRaces() throws Exception {
		xstream.alias("race", Race.class);
		
		Scanner scanner = createScannerFor("races");
		while(scanner.hasNextLine()){
			String nextRace = scanner.nextLine();
			Race race = (Race) xstream.fromXML(nextRace);
			raceDao.saveOrUpdateByName(race);
		}
				
	}
	
	private void createSkills() throws Exception {
		xstream.alias("skill", Skill.class);
		
		Scanner scanner = createScannerFor("skills");
		while(scanner.hasNextLine()){
			String nextSkill = scanner.nextLine();
			Skill skill = (Skill) xstream.fromXML(nextSkill);
			skillDao.saveOrUpdateByName(skill);
		}
	}

}
