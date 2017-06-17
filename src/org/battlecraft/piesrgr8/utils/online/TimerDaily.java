package org.battlecraft.piesrgr8.utils.online;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TimerDaily implements Listener {

	static BattlecraftServer plugin;

	static File f = new File("plugins//BattlecraftServer//players.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
	public static ArrayList<Player> list = new ArrayList<Player>();

	public TimerDaily(BattlecraftServer p) {
		TimerDaily.plugin = p;
	}

	public static void timer(final Player p) {
		if (!yaml.contains(p.getName() + ".logins")) {
			yaml.createSection(p.getName() + ".logins");
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (p != null) {
					
				p.sendMessage(Prefix.prefixMain + ChatColor.YELLOW
						+ "You have completed your daily login for 5 minutes! Come back tomorrow to increase the numbers!");
				PlayersYML.setLogins(p, 1);
			}
			}
		}, 6000L);
	}

	public static String getCurrentTime() {
		long current = System.currentTimeMillis();
		Date currentD = new Date(current);
		
		DateFormat df = new SimpleDateFormat("h:mm aa");
		
		String time = df.format(currentD);
		return time;
	}
	
	public static String getTime() {
		long current = System.currentTimeMillis();
		Date currentD = new Date(current);
		
		DateFormat df = new SimpleDateFormat("h:mm");
		
		String time = df.format(currentD);
		return time;
	}
	
	public static String getFullTime() {
		long current = System.currentTimeMillis();
		Date currentD = new Date(current);
		
		String full = currentD.toString();
		
		return full;
	}
}
