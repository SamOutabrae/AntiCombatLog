package me.thesam.plugins.AntiCombatLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DataManager {
	
	String path = new File(".").getAbsolutePath();
	
	HashMap<String, Object> configData = new HashMap<String, Object>();
	
	public DataManager() {
		
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
				
				configData.put(config[0], config[1].replace("\n", ""));
				
				continue;
			}
			
			fIN.close();
			
		} catch(IOException e) {
		
			e.printStackTrace();
			
		}
	
		
		return;
	}
	
	
	public boolean getPlayersOnly() {
		
		Object playersOnly = configData.get("playersOnly");
		
		if(configData.equals(null)) {
			return true;
		}
		
		return Boolean.parseBoolean( (String) playersOnly);
	}
	
	public boolean getAnnounce() {
		
		Object announce = configData.get("announce");
		
		if(announce.equals(null)) {
			return true;
		}
		
		return Boolean.parseBoolean( (String) announce);
	}
	
	public int getTimeout() {
		Object timeout = configData.get("timeout");
		
		if(timeout.equals(null)) {
			return 200;
		}
		
		return Integer.parseInt( (String) timeout);
	}

	public void saveConf() {
		File f = new File(this.path + "AntiCombatLog.conf");
		
		if(f.exists()) {
			f.delete();
		}
		
		try {
			
			FileWriter fw = new FileWriter(f);
			for(String key : this.configData.keySet()) {
				fw.write(key + "=" + this.configData.get(key) + ";\n");
			}
			
			
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return;
	}
	
	
}
