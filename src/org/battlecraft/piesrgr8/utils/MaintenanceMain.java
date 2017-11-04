package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MaintenanceMain {

	static BattlecraftServer plugin;
	
	public static boolean enabled = false;

	public MaintenanceMain(BattlecraftServer p) {
		MaintenanceMain.plugin = p;
	}

	public static void startMaintenance() {
		for (Player on : Bukkit.getOnlinePlayers())
			on.kickPlayer(Color.c("&7[&c&lBC&9&lMaintenance&7]&r\n"
					+ "&eSorry, but the server is currently in maintenance mode!\n"
					+ "&ePlease come back later when we are ready!"));
		
		Bukkit.getServer().setWhitelist(true);

		Bukkit.broadcastMessage(
				Prefix.prefixMain + ChatColor.YELLOW + "THE SERVER IS NOW IN MAINTENANCE MODE!");
		enabled = true;

		// ADD MORE TO THIS METHOD!
	}

	public static void stopMaintenance() {
		Bukkit.getServer().setWhitelist(false);

		Bukkit.broadcastMessage(
				Prefix.prefixMain + ChatColor.YELLOW + "THE SERVER IS NO LONGER IN MAINTENANCE MODE!");
		enabled = false;

		// ADD MORE TO THIS METHOD!
	}
}
