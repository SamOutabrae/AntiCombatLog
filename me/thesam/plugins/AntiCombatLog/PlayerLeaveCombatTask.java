package me.thesam.plugins.AntiCombatLog;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLeaveCombatTask extends BukkitRunnable {

	Player player;
	
	
	public PlayerLeaveCombatTask(Player p) {
		this.player = p;
	}

	@Override
	public void run() {
		
	}
}
