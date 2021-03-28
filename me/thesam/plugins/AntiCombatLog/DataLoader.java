package me.thesam.plugins.AntiCombatLog;

import java.io.File;

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
	
	

}
