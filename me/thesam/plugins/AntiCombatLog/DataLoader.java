package me.thesam.plugins.AntiCombatLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataLoader {
	
	String path = new File(".").getAbsolutePath();
	
	public DataLoader() {
		File f = new File(path + "AntiCombatLog");
		
		if(f.exists() && f.isDirectory()) {
			return;
		}
		
		if(f.exists()) {
			f.delete();
			f.mkdir();
			return;
		}
		
		f.mkdir();
		return;
	}
	
	public int getTimeout() {
		int timeout;
		
		try {
		
			File f = new File(path + "timeout.txt");
			FileInputStream fIN = new FileInputStream(f);
		
			byte[] byteArray = fIN.readAllBytes();
			
			String fileData = new String(byteArray, StandardCharsets.UTF_8);
			
			timeout = Integer.parseInt(fileData);
		
		} catch(IOException e) {
		
			timeout = 20;
		}
		
		return timeout;
	}

}
