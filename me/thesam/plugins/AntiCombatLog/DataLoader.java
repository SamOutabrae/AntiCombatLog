package me.thesam.plugins.AntiCombatLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.xml.stream.events.Characters;

public class DataLoader {
	
	String path = new File(".").getAbsolutePath();
	
	HashMap<String, Object> configData = new HashMap<String, Object>();
	
	public DataLoader() throws FileNotFoundException {
		
		configData.put("timeout", null);
		configData.put("playersOnly", null);
		
		File f = new File(path + "AntiCombatLog.conf");
		
		if(f.exists()) {
		
			f.delete();
			f.mkdir();
		
		} else {
		
			f.mkdir();
		
		}
			
		
		try {
			
			FileInputStream fIN = new FileInputStream(f);
			
			byte[] byteArray = fIN.readAllBytes();
			String fileData = new String(byteArray, StandardCharsets.UTF_8);
			
			String[] fileDataArray;
			
			fileDataArray = fileData.split(";");
			
			for(String line : fileDataArray) {
				String[] config = line.split("=");
				
				configData.put(config[0], config[1]);
				
				continue;
			}
			
			fIN.close();
			
		} catch(IOException e) {
		
			e.printStackTrace();
			
		}
	
		
		return;
	}
	
		
}
