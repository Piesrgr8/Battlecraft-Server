package org.battlecraft.piesrgr8.essentials;

import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	List<Player> pl = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot fly as a computer!");
				return true;
			}

			Player p = (Player) sender;
			if (!p.hasPermission("bc.fly")) {
				p.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "You don't have permission to fly!");
				return true;
			}
			
			if (pl.contains(p)) {
				p.setFlying(false);
				p.setAllowFlight(false);
				p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Flying is now " + ChatColor.YELLOW
						+ "disabled!");
				pl.remove(p);
				return true;
			} else if (!pl.contains(p)) {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Flying is now " + ChatColor.YELLOW
						+ "enabled!");
				pl.add(p);
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
