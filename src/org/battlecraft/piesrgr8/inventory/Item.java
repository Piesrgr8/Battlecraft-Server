package org.battlecraft.piesrgr8.inventory;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Item implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("item")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("bc.item")) {
				p.sendMessage("You dont have permission!");
				return true;
			}
			
			if (args.length == 0) {
				p.sendMessage("<rename : enchant : lore>");
			}
		}
		return true;
	}
}
