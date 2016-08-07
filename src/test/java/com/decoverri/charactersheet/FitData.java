package com.decoverri.charactersheet;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.decoverri.charactersheet.daos.BaseClassDao;
import com.decoverri.charactersheet.models.BaseClass;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Boot.class)
@Transactional
public class FitData {

	private static final String DATA_FOLDER = "jsonData/";
	private static final String DATA_EXTENSION = ".json";
	
	private XStream xstream = new XStream(new JettisonMappedXmlDriver());

	@Autowired
	private BaseClassDao baseClassDao;

	private String formatFileName(String fileName){
		return DATA_FOLDER + fileName + DATA_EXTENSION;
	}

	private Scanner createScannerFor(String fileName) throws FileNotFoundException {
		return new Scanner(new FileInputStream(formatFileName(fileName)));
	}

	@Test
	public void createBaseClasses() throws Exception {
		
		xstream.alias("baseClass", BaseClass.class);
		
		Scanner scanner = createScannerFor("baseClasses");
		
		while(scanner.hasNextLine()){
			String nextClass = scanner.nextLine();
			BaseClass baseClass = (BaseClass) xstream.fromXML(nextClass);
			baseClassDao.saveOrUpdateByName(baseClass);
		}
				
	}
}
