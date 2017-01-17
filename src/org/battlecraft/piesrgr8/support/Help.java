package org.battlecraft.piesrgr8.support;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("help")) {
			if (!RanksEnum.isStaff(p)) {
				p.sendMessage(ChatColor.YELLOW + "These are the help messages!");
				p.sendMessage(ChatColor.YELLOW + "If you dont know where to go on the server, use " + ChatColor.AQUA + "/menu.");
				p.sendMessage(ChatColor.YELLOW + "If you have any questions, use " + ChatColor.AQUA + "/a <message>.");
				p.sendMessage(ChatColor.YELLOW + "Our server usually stays up 24/7, so if you want to come hang, you know where to go ;)");
			}
			
			if (RanksEnum.isAtLeast(p, Ranks.HELPER)) {
				p.sendMessage(ChatColor.YELLOW + "These are the help messages for " + ChatColor.AQUA + "HELPER!");
				p.sendMessage(ChatColor.YELLOW + "If you dont know where to go on the server, use " + ChatColor.AQUA + "/menu.");
				p.sendMessage(ChatColor.YELLOW + "If there are any questions, use " + ChatColor.AQUA + "/ans <player> <message>.");
				p.sendMessage(ChatColor.YELLOW + "Punish people with " + ChatColor.AQUA + "/punish <player> " + ChatColor.YELLOW + "if people misbehave.");
				p.sendMessage(ChatColor.YELLOW + "Our server usually stays up 24/7, so if you want to come hang, you know where to go ;)");
			}
			if (RanksEnum.isAtLeast(p, Ranks.COWNER) || RanksEnum.isAtLeast(p, Ranks.OWNER)) {
				return false;
			}
		}
		return true;
	}
}
