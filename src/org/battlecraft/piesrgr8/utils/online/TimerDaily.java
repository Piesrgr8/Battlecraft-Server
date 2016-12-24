package org.battlecraft.piesrgr8.utils.online;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
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
					
				p.sendMessage(BattlecraftServer.prefixMain + ChatColor.YELLOW
						+ "You have completed your daily login for 5 minutes! Come back tomorrow to increase the numbers!");
				PlayersYML.setLogins(p, 1);
			}
			}
		}, 6000L);
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
