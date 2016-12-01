package org.battlecraft.piesrgr8.fake;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeJoin implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "Fake a login! Just type the name!");
				return true;
			}
			sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Sent successfully!");
			Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + args[0]
					+ ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + " joined");
		}
		else 
		{
			sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "Access denied!");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("fakel")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "Access denied!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "Fake a leave! Just type the name!");
				return true;
			}
			sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Sent successfully!");
			Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + args[0]
					+ ChatColor.DARK_RED + "" + ChatColor.ITALIC + " left");
		}
		return true;
	}
}
