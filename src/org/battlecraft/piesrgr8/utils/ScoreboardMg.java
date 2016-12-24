package org.battlecraft.piesrgr8.utils;

import java.io.File;
import java.util.UUID;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardMg implements Listener {

	static BattlecraftServer plugin;

	public ScoreboardMg(BattlecraftServer p) {
		ScoreboardMg.plugin = p;
	}

	public static void createBoard(final Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				board1(p);
			}
		}, 90, 240);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				board2(p);
			}
		}, 90, 240);
	}

	public static void removeBoard(Player p) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		p.setScoreboard(mg.getNewScoreboard());
		Bukkit.getServer().getScheduler().cancelTasks(plugin);
	}

	public static void board1(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();

		Objective ob = b.registerNewObjective("test", "dummy");

		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ob.setDisplayName(ChatColor.translateAlternateColorCodes('&', "     &c&lBATTLECRAFT    "));

		// OTHER THINGS

		Score s6 = ob.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "            STATS    ");
		s6.setScore(13);

		Score s7 = ob.getScore(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------");
		s7.setScore(1);

		// SETS

		Score s = ob.getScore(ChatColor.GREEN + "Kills: " + ChatColor.YELLOW + yaml.getInt("stats.kills"));
		s.setScore(12);

		Score s1 = ob.getScore(ChatColor.GREEN + "Deaths: " + ChatColor.YELLOW + yaml.getInt("stats.deaths"));
		s1.setScore(10);

		Score s2 = ob.getScore(ChatColor.GREEN + "DmgDealt: " + ChatColor.YELLOW + yaml.getInt("stats.damagedelt"));
		s2.setScore(8);

		Score s3 = ob.getScore(ChatColor.GREEN + "DmgTaken: " + ChatColor.YELLOW + yaml.getInt("stats.damagetaken"));
		s3.setScore(6);

		Score s4 = ob.getScore(ChatColor.GREEN + "MinedBlocks: " + ChatColor.YELLOW + yaml.getInt("stats.blockbreaks"));
		s4.setScore(4);

		Score s5 = ob
				.getScore(ChatColor.GREEN + "Created Items: " + ChatColor.YELLOW + yaml.getInt("stats.itemcreations"));
		s5.setScore(2);

		// SPACES
		Score space = ob.getScore(" ");
		space.setScore(11);

		Score space1 = ob.getScore("  ");
		space1.setScore(9);

		Score space2 = ob.getScore("   ");
		space2.setScore(7);

		Score space3 = ob.getScore("    ");
		space3.setScore(5);

		Score space4 = ob.getScore("     ");
		space4.setScore(3);

		p.setScoreboard(b);
	}

	public static void board2(Player p) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();
		
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

		Objective ob = b.registerNewObjective("test", "dummy");

		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ob.setDisplayName(ChatColor.translateAlternateColorCodes('&', "     &c&lBATTLECRAFT    "));

		Score s = ob.getScore(ChatColor.GREEN + "Welcome, " + ChatColor.YELLOW + fromUUID.getName() + "!");
		s.setScore(9);

		Score s1 = ob.getScore(ChatColor.RED + "" + ChatColor.BOLD + "Displayname:");
		s1.setScore(7);

		Score s2 = ob.getScore(fromUUID.getDisplayName());
		s2.setScore(6);

		Score s3 = ob.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players Online:");
		s3.setScore(4);

		Score s4 = ob.getScore(ChatColor.AQUA + "" + Bukkit.getServer().getOnlinePlayers().size());
		s4.setScore(3);

		Score s5 = ob.getScore(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------");
		s5.setScore(1);

		// FOR SPACES

		Score sa1 = ob.getScore(" ");
		sa1.setScore(8);

		Score sa2 = ob.getScore("  ");
		sa2.setScore(5);

		Score sa3 = ob.getScore("   ");
		sa3.setScore(2);

		p.setScoreboard(b);
	}
}
