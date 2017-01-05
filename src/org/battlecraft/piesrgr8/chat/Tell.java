package org.battlecraft.piesrgr8.chat;

import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tell implements CommandExecutor {

	String bg = Prefix.prefixMain;

	@SuppressWarnings("deprecation")
	
	//Registering a command to be usable.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tell")) {
			if (args.length == 0) {
				sender.sendMessage(bg + ChatColor.RED + "/tell <player> <message>");
				return true;
			}

			Player tar = Bukkit.getServer().getPlayer(args[0]);
			
			//Checking to see if the target is null when they hit enter. Otherwise, it will ask them for a message if nothing else is typed in.
			if (args.length == 1) {
				if (tar == null) {
					sender.sendMessage(bg + ChatColor.RED + "This player isnt online.");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					sender.sendMessage(bg + ChatColor.RED + "What will the message be?");
					return true;
				}
			}

			//This will now send the message using the string build method.
			if (args.length > 2) {
				StringBuilder sb = new StringBuilder();
				String msg;
				for(int i = 1; i < args.length; i++)
    					sb.append(args[i]).append(" ");
				msg = sb.toString();

				String msg1 = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.YELLOW + "" + ChatColor.BOLD
						+ sender.getName() + " " + ChatColor.GOLD + "" + ChatColor.BOLD + "> " + ChatColor.YELLOW + ""
						+ ChatColor.BOLD + tar.getName() + ChatColor.GOLD + "" + ChatColor.BOLD + "] ";
				String msg2 = ChatColor.GOLD + "" + ChatColor.BOLD + "[" + ChatColor.YELLOW + "" + ChatColor.BOLD
						+ tar.getName() + " " + ChatColor.GOLD + "" + ChatColor.BOLD + "< " + ChatColor.YELLOW + ""
						+ ChatColor.BOLD + sender.getName() + ChatColor.GOLD + "" + ChatColor.BOLD + "] ";
				sender.sendMessage(msg1 + ChatColor.YELLOW + "" + ChatColor.BOLD + msg);
				tar.sendMessage(msg2 + ChatColor.YELLOW + "" + ChatColor.BOLD + msg);
			}
		}
		return true;
	}
}
