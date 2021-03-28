package me.thesam.plugins.AntiCombatLog;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		if(Main.playersToKill.contains(e.getPlayer())) {
			e.getPlayer().setHealth(0.0D);
		}
	}
	
	
}
