package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RestartCommand implements CommandExecutor {

	BattlecraftServer plugin;

	public RestartCommand(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("reload")) {
			sender.sendMessage(Prefix.prefixAdmin + ChatColor.YELLOW + "Server is reloading under your command!");
			Bukkit.getServer().reload();
			return true;
		}
		return true;
	}
/*
	public void reloadMessage() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(
						Prefix.prefixMain + ChatColor.RED + "" + ChatColor.BOLD + "SERVER RELOADING!");
			}
		}, 13L, 10L);
	}

	public void restartMessage() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(Prefix.prefixMain + "SERVER RESTARTING!");
			}
		}, 13L, 10L);
	}

	public void shuttingDown() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(Prefix.prefixMain + "SERVER SHUTTING DOWN!");
			}
		}, 13L, 10L);
	} */
}
