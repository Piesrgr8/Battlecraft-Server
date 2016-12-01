package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RestartCommand implements Listener {

	BattlecraftServer plugin;

	public RestartCommand(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void listenForCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] array = msg.split(" ");

		if (p.isOp()) {

			if (array[0].equalsIgnoreCase("/restart")) {
				e.setCancelled(true);
				p.sendMessage(
						BattlecraftServer.prefixAdmin + ChatColor.YELLOW + "SERVER IS RESTARTING UNDER YOUR COMMAND!");
				restartMessage();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Bukkit.getServer().shutdown();
					}
				}, 180L);
			}

			if (array[0].equalsIgnoreCase("/reload")) {
				e.setCancelled(true);
				p.sendMessage(
						BattlecraftServer.prefixAdmin + ChatColor.YELLOW + "SERVER IS RELOADING UNDER YOUR COMMAND!");
				reloadMessage();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(BattlecraftServer.prefixMain + ChatColor.YELLOW
								+ "Server reloading! Please dont move! If you were in a game, please navigate yourself to the hub!");
						Bukkit.getServer().reload();
					}
				}, 180L);
			}

			if (array[0].equalsIgnoreCase("/stop")) {
				e.setCancelled(true);
				p.sendMessage(BattlecraftServer.prefixAdmin + ChatColor.YELLOW
						+ "SERVER IS SHUTTING DOWN UNDER YOUR COMMAND!");
				shuttingDown();
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Bukkit.broadcastMessage(BattlecraftServer.prefixMain + ChatColor.YELLOW
								+ "Server reloading! Please dont move! If you were in a game, please navigate yourself to the hub!");
						Bukkit.getServer().shutdown();
					}
				}, 180L);
			}
		} else {
			return;
		}
	}

	public void reloadMessage() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(
						BattlecraftServer.prefixMain + ChatColor.RED + "" + ChatColor.BOLD + "SERVER RELOADING!");
			}
		}, 13L, 10L);
	}

	public void restartMessage() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(BattlecraftServer.prefixMain + "SERVER RESTARTING!");
			}
		}, 13L, 10L);
	}

	public void shuttingDown() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(BattlecraftServer.prefixMain + "SERVER SHUTTING DOWN!");
			}
		}, 13L, 10L);
	}
}
