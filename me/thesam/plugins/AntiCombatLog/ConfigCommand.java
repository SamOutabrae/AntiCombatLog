package me.thesam.plugins.AntiCombatLog;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ConfigCommand implements CommandExecutor {

	String notEnoughArgs = ChatColor.RED + "Not enough arguments.";
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if(sender.isOp()) {
			if(args.length < 1) {
				sender.sendMessage(notEnoughArgs);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				for(String key : Main.dataManager.configData.keySet()) {
					sender.sendMessage(key + " = " + Main.dataManager.configData.get(key));
				}
			}
			
			if(args[0].equalsIgnoreCase("valueof")) {
				if(args.length < 2) {
					sender.sendMessage(notEnoughArgs);
					return true;
				}
				
				Object value = Main.dataManager.configData.get(args[1]);
				
				if(value.equals(null)) {
					sender.sendMessage(ChatColor.YELLOW + "That key does not exist.");
					return true;
				}
			
				sender.sendMessage(ChatColor.GREEN + (String) value);
				
				return true;
			}
			
			if(args[0].equalsIgnoreCase("set")) {
				if(args.length < 3) {
					sender.sendMessage(notEnoughArgs);
				}
				
				if(!Main.dataManager.configData.containsKey(args[1]) ) {
					sender.sendMessage(ChatColor.RED + "That key does not exist.");
					return true;
				}
				
				Main.dataManager.configData.put(args[1], args[2]);
				sender.sendMessage(ChatColor.GREEN + "The updated value of " + args[1] + " is " + args[2]);
				
				return true;
			}
		}
		
		return true;
	}
	
}
