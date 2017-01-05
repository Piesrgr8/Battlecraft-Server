package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MaintenanceMain {

	static BattlecraftServer plugin;

	public MaintenanceMain(BattlecraftServer p) {
		MaintenanceMain.plugin = p;
	}

	public static void startMaintenance() {
		Bukkit.getServer().setWhitelist(true);

		Bukkit.broadcastMessage(
				Prefix.prefixMain + ChatColor.YELLOW + "THE SERVER IS NOW IN MAINTENANCE MODE!");

		// ADD MORE TO THIS METHOD!
	}

	public static void stopMaintenance() {
		Bukkit.getServer().setWhitelist(false);

		Bukkit.broadcastMessage(
				Prefix.prefixMain + ChatColor.YELLOW + "THE SERVER IS NO LONGER IN MAINTENANCE MODE!");

		// ADD MORE TO THIS METHOD!
	}

}
