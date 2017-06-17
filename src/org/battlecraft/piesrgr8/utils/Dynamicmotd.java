package org.battlecraft.piesrgr8.utils;

import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.ChatColor;

public class Dynamicmotd implements Listener {

	BattlecraftServer plugin;

	String permanent = ChatColor.translateAlternateColorCodes('&',
			"&7&l&m>&c&m---&e&m---&a&m---&9&m---&7&l&m>&r &c&lBATTLECRAFT&r &7&l&m<&9&m---&a&m---&e&m---&c&m---&7&l&m<&r\n");

	public Dynamicmotd(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void motdDynamic(ServerListPingEvent e) {

		Random rand = new Random();
		int random = rand.nextInt(3);

		if (random == 0) {
			e.setMotd(permanent + "                " + ChatColor.YELLOW + "" + ChatColor.BOLD + "1.9 " + ChatColor.RED + "/"
					+ ChatColor.YELLOW + "" + ChatColor.BOLD + " 1.10 " + ChatColor.RED + "/"
					+ ChatColor.YELLOW + "" + ChatColor.BOLD + " 1.11 ");
		} else if (random == 1) {
			e.setMotd(permanent + "    " + ChatColor.translateAlternateColorCodes('&',
					"&7&l( &cMinigames " + "&7- &6SkyBlock &7- &eFactions &7- &2SG &7- &bSW &7&l)"));
		} else if (random == 2) {
			e.setMotd(permanent + "    " + ChatColor.GOLD + "" + ChatColor.BOLD + "!NEW! " + ChatColor.AQUA
					+ "Mystery Crates!");
		}

	}

}
