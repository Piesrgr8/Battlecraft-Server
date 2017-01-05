package org.battlecraft.piesrgr8.fake;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeBan implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fakeb")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.ADMIN)) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.RED + "Access denied!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.RED + "Fake a ban! Just type the name!");
				return true;
			}
			if (args.length == 1) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.GREEN + "Sent successfully!");
				Bukkit.getServer().broadcastMessage(Prefix.prefixPunish + ChatColor.YELLOW + "Player "
						+ args[0] + " has been banned by " + sender.getName() + "!");

				if (!(args[0] == null)) {
					Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "" + ChatColor.BOLD
							+ args[0] + ChatColor.DARK_RED + "" + ChatColor.ITALIC + " left");
				}
			}
		}
		return true;
	}
}
