package org.battlecraft.piesrgr8.fake;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Spammer implements CommandExecutor, Listener {

	BattlecraftServer plugin;

	public Spammer(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spam")) {
			if (!sender.isOp()) {
				sender.sendMessage(
						Prefix.prefixMain + ChatColor.RED + "You must be an operator to execute this task!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.RED
						+ "Enter a string or use /spam cancel to end task!");
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("cancel")) {
					Bukkit.getServer().getScheduler().cancelTasks(plugin);
					sender.sendMessage(Prefix.prefixMain + ChatColor.GREEN + "The spammer has stopped!");
					return true;
				}
			}

			if (args.length >= 1) {
				String bc = "";
				for (String message : args) {
					bc = (bc + message + " ");
				}
				spam(bc, 15, 1);
			}
		}
		return true;
	}

	public void spam(final String msg, int time, int repeat) {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(msg);
			}
		}, repeat, time);
	}
}
