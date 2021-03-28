package me.thesam.plugins.AntiCombatLog;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static int combatTimeout;
	
	public static DataLoader dataLoader = new DataLoader();
	
	public ArrayList<Player> playersToKill = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
