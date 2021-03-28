package me.thesam.plugins.AntiCombatLog;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

public class Listeners implements Listener {
	
	@EventHandler
	public void onDisconnect(PlayerQuitEvent e) {
		if(Main.playersToKill.contains(e.getPlayer())) {
			e.getPlayer().setHealth(0.0D);
		}
	}
	
	@EventHandler
	public void playerAttackPlayer(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			
			Main.playersToKill.add(player);
			Main.playersToKill.add(damager);
			
			BukkitTask playerTask = new PlayerLeaveCombatTask(player).runTaskLater(Main.getProvidingPlugin(Main.class), Integer.toUnsignedLong(Main.combatTimeout));
			BukkitTask damagerTask = new PlayerLeaveCombatTask(damager).runTaskLater(Main.getProvidingPlugin(Main.class), Integer.toUnsignedLong(Main.combatTimeout));
		
			String message = ChatColor.YELLOW + "" + ChatColor.BOLD + "YOU ARE NOW IN COMBAT. PLEASE DO NOT LOG OUT.";
			
			if(Main.announce) {
				player.sendMessage(message);
				damager.sendMessage(message);
			}
		}
	}
	
	
}
