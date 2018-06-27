package org.battlecraft.piesrgr8.staff;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// MAIN COMMAND

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("staffchat")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(
						Prefix.prefixStaff + ChatColor.RED + "You are not allowed to use this command!");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixStaff + ChatColor.RED + "Arguments Missing!: " + ChatColor.YELLOW
						+ "A fully constructed message.");
				return true;
			}

			if (args.length >= 1) {
				StringBuilder sb = new StringBuilder();
				String msg;
				for(int i = 0; i < args.length; i++)
    					sb.append(args[i]).append(" ");
				msg = sb.toString();
				
				for (Player on : Bukkit.getServer().getOnlinePlayers()) {
					if (RanksEnum.isAtLeast(on, Ranks.ADMIN)) {
						on.sendMessage(Prefix.prefixStaffChat + ChatColor.GOLD + p.getName() + ": " + ChatColor.GREEN + msg);
					}
				}
			}
		}
		return true;
	}
}
