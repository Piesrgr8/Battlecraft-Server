package org.battlecraft.piesrgr8.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Dynamicmotd implements Listener {

	BattlecraftServer plugin;

	String permanent = ChatColor.translateAlternateColorCodes('&',
			"&7&l&m>&c&m---&e&m---&a&m---&9&m---&7&l&m>&r &c&lBATTLECRAFT&r &7&l&m<&9&m---&a&m---&e&m---&c&m---&7&l&m<&r\n");
	
	public static Map<String, String> motdPlayer = new HashMap<String, String>();

	public Dynamicmotd(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void motdDynamic(ServerListPingEvent e) {
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
		        "Friday", "Saturday" };
		
		String playerName = "not-so-good friend!";
		String ip = e.getAddress().toString();
		
		ip = ip.replaceAll("/", "");
		ip = ip.replaceAll("\\.", "-");
		
		if (motdPlayer.containsKey(ip)) {
			playerName = motdPlayer.get(ip);
		} else {
			playerName = "my friend!";
		}
		
		if (dayOfMonth == 31) {
			e.setMotd(permanent + "              " + Color.c("&e&lHAPPY &6&lHALLOWEEN!"));
			return;
		}
		
		if (MaintenanceMain.enabled == true) {
			e.setMotd(permanent + "                   " + ChatColor.RED + "" + ChatColor.BOLD + "MAINTENANCE MODE!");
		} else {

			Random rand = new Random();
			int random = rand.nextInt(4);

			if (random == 0) {
				e.setMotd(permanent + "                      " + ChatColor.YELLOW + "" + ChatColor.BOLD + "1.9 "
						+ ChatColor.RED + "/" + ChatColor.YELLOW + "" + ChatColor.BOLD + " 1.10 " + ChatColor.RED + "/"
						+ ChatColor.YELLOW + "" + ChatColor.BOLD + " 1.11 ");
			} else if (random == 1) {
				e.setMotd(permanent + "    " + ChatColor.translateAlternateColorCodes('&',
						"&7&l( &cMinigames " + "&7- &6SkyBlock &7- &eFactions &7- &2SG &7- &bSW &7&l)"));
			} else if (random == 2) {
				e.setMotd(permanent + "    " + ChatColor.GOLD + "" + ChatColor.BOLD + "!NEW! " + ChatColor.AQUA
						+ "Mystery Crates!");
			} else if (random == 3) {
				e.setMotd(permanent + Color.c("                  &eHappy &6" + strDays[cal.get(Calendar.DAY_OF_WEEK) - 1] + ", &d&o" + playerName));
			}
		}
	}
}
