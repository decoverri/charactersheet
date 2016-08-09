package com.decoverri.charactersheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.decoverri.charactersheet.daos.BaseClassDao;
import com.decoverri.charactersheet.daos.RaceDao;
import com.decoverri.charactersheet.models.BaseClass;
import com.decoverri.charactersheet.models.Race;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@SpringBootApplication
public class Boot {

	private static final String DATA_FOLDER = "jsonData/";
	private static final String DATA_EXTENSION = ".json";

	private static XStream xstream;

	private static BaseClassDao baseClassDao;
	private static RaceDao raceDao;

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Boot.class, args);
		
		xstream = new XStream(new JettisonMappedXmlDriver());

		instanciateDaos(context);
		
		createBaseClasses();
		createRaces();

	}

	private static void instanciateDaos(ConfigurableApplicationContext context) {
		baseClassDao = context.getBean(BaseClassDao.class);
		raceDao = context.getBean(RaceDao.class);
	}

	private static String formatFileName(String fileName){
		return DATA_FOLDER + fileName + DATA_EXTENSION;
	}

	private static Scanner createScannerFor(String fileName) throws FileNotFoundException {
		return new Scanner(new FileInputStream(formatFileName(fileName)));
	}
	
	@Transactional
	public static void createBaseClasses() throws Exception {
		xstream.alias("baseClass", BaseClass.class);
		
		Scanner scanner = createScannerFor("baseClasses");
		while(scanner.hasNextLine()){
			String nextClass = scanner.nextLine();
			BaseClass baseClass = (BaseClass) xstream.fromXML(nextClass);
			baseClassDao.saveOrUpdateByName(baseClass);
		}
				
	}

	@Transactional
	public static void createRaces() throws Exception {
		xstream.alias("race", Race.class);
		
		Scanner scanner = createScannerFor("races");
		while(scanner.hasNextLine()){
			String nextRace = scanner.nextLine();
			Race race = (Race) xstream.fromXML(nextRace);
			raceDao.saveOrUpdateByName(race);
		}
				
	}


}
