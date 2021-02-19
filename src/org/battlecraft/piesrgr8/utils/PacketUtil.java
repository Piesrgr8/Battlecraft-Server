package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PacketUtil implements Listener {

	BattlecraftServer plugin;

	public PacketUtil(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public static void onJoin(final BattlecraftServer plugin, final Player p) {
		TitleManager.sendTitle(p.getPlayer(), ChatColor.translateAlternateColorCodes('&', "&c&lBATTLECRAFT"),
				ChatColor.translateAlternateColorCodes('&', "&aWelcome to the server, " + p.getName()), 40, 20, 10);
	}
}