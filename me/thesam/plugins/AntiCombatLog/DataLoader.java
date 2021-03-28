package me.thesam.plugins.AntiCombatLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DataLoader {
	
	String path = new File(".").getAbsolutePath();
	
	HashMap<String, Object> configData = new HashMap<String, Object>();
	
	public DataLoader() throws FileNotFoundException {
		
		configData.put("timeout", null);
		configData.put("playersOnly", null);
		configData.put("", configData);
		
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
	
	
	// TODO add handling for if these return null
	
	public boolean getPlayersOnly() {
		return Boolean.parseBoolean((String) configData.get("playersOnly"));
	}
	
	public boolean getAnnounce() {
		return Boolean.parseBoolean( (String) configData.get("annoucne"));
	}
	
	public int getTimeout() {
		return Integer.parseInt((String) configData.get("timeout"));
	}
}
