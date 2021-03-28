package me.thesam.plugins.AntiCombatLog;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLeaveCombatTask extends BukkitRunnable {

	Player player;
	
	
	public PlayerLeaveCombatTask(Player p) {
		this.player = p;
	}

	@Override
	public void run() {
		Main.playersToKill.remove(Main.playersToKill.indexOf(this.player));
		
		
		this.player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "YOU ARE NO LONGER IN COMBAT. YOU MAY NOW LOG OUT.");
	}
}
