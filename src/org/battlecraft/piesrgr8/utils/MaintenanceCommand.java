package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MaintenanceCommand implements CommandExecutor {

	BattlecraftServer plugin;
	public int input = 0;

	public MaintenanceCommand(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("maintenance")) {
			if (!sender.isOp()) {
				sender.sendMessage(
						Prefix.prefixMain + ChatColor.RED + "You must be an operator to do this!");
				return true;
			}

			if (args.length < 1) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.YELLOW + "What would you like to do?");
				sender.sendMessage(
						ChatColor.GOLD + "/maintenance schedule" + " - " + ChatColor.YELLOW + "Schedule maintenance.");
				sender.sendMessage(
						ChatColor.GOLD + "/maintenance start" + " - " + ChatColor.YELLOW + "Force start maintenance.");
				sender.sendMessage(
						ChatColor.GOLD + "/maintenance stop" + " - " + ChatColor.YELLOW + "Stop maintenance.");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("schedule")) {
					sender.sendMessage(
							Prefix.prefixMain + ChatColor.YELLOW + "Usage: /maintenance schedule <time>");
					return true;
				}

				if (args.length == 2) {

					Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
						public void run() {
							if (input != -1 && input != 0) {
								Bukkit.broadcastMessage(
										Prefix.prefixMain + ChatColor.DARK_RED + "MAINTENANCE IN " + input);
								input--;
							} else {
								MaintenanceMain.startMaintenance();
								input--;
							}
						}
					}, 0L, 20L);
				}

				if (args[0].equalsIgnoreCase("start")) {
					MaintenanceMain.startMaintenance();
					return true;
				}

				if (args[0].equalsIgnoreCase("stop")) {
					MaintenanceMain.stopMaintenance();
					return true;
				}
			}
		}
		return true;
	}
}
