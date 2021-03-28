package me.thesam.plugins.AntiCombatLog;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.thesam.plugins.AntiCombatLog.DataManager;


//TODO 
//add data saver so that data updated with /aclconfig actually gets updated
//add plugin.yml

public class Main extends JavaPlugin {
	
	public static DataManager dataManager = new DataManager();
	public static ArrayList<Player> playersToKill = new ArrayList<Player>();
	
	public static boolean announce;
	public static int combatTimeout;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		getCommand("combatconfig").setExecutor(new ConfigCommand());
		
		announce = dataManager.getAnnounce();
		combatTimeout = dataManager.getTimeout();
	}
	
	@Override
	public void onDisable() {
		
	}
}
