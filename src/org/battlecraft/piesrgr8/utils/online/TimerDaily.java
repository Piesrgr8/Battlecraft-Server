package org.battlecraft.piesrgr8.utils.online;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.battlecraft.piesrgr8.BattlecraftServer;
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
					
				list.add(p);
				p.sendMessage(BattlecraftServer.prefixMain + ChatColor.YELLOW
						+ "You have completed your daily login for 5 minutes! Come back tomorrow to increase the numbers!");
				yaml.set(p.getName() + ".logins", yaml.getInt(p.getName() + ".logins") + 1);
				resetDaily(p);
				try {
					yaml.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
		}, 6000L);
	}
		public static void resetDaily(final Player p) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					list.remove(p);
				}
			}, c.getTimeInMillis());
		}

	public String getRemainingTime(long millis) {
		long sec = millis / 1000;
		long min = 0;
		while (sec > 60) {
			sec -= 60;
			min++;
		}
		long hour = 0;
		while (min > 60) {
			min -= 60;
			hour++;
		}
		return hour + "h " + min + "m " + sec + "s ";
	}
}
