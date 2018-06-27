package org.battlecraft.piesrgr8.utils;

import java.util.UUID;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.stats.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

	static int id;
	static int id2;

	public static void createBoard(final Player p) {
		id = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				board1(p);
			}
		}, 90, 240);

		id2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				board2(p);
			}
		}, 90, 240);
	}

	public static void removeBoard(Player p) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		p.setScoreboard(mg.getNewScoreboard());
		Bukkit.getServer().getScheduler().cancelTask(id);
		Bukkit.getServer().getScheduler().cancelTask(id2);
	}

	public static void board1(Player p) {

		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();

		Objective ob = b.registerNewObjective("Hub", "dummy");

		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		ob.setDisplayName(ChatColor.translateAlternateColorCodes('&', "     &c&lBATTLECRAFT    "));

		// OTHER THINGS

		Score s6 = ob.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "            STATS    ");
		s6.setScore(11);

		Score s7 = ob.getScore(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------");
		s7.setScore(1);

		// SETS (UNUSED: s2, s3)

		Score s = ob.getScore(ChatColor.GREEN + "Kills: " + ChatColor.YELLOW + StatsManager.getKills(p));
		s.setScore(10);

		Score s1 = ob.getScore(ChatColor.GREEN + "Deaths: " + ChatColor.YELLOW + StatsManager.getDeaths(p));
		s1.setScore(8);

		Score s4 = ob.getScore(ChatColor.GREEN + "MinedBlocks: " + ChatColor.YELLOW + StatsManager.getBlockBreaks(p));
		s4.setScore(6);

		Score s5 = ob
				.getScore(ChatColor.GREEN + "Created Items: " + ChatColor.YELLOW + StatsManager.getItemCreations(p));
		s5.setScore(4);

		Score s8 = ob
				.getScore(ChatColor.GREEN + "Enchanted Items: " + ChatColor.YELLOW + StatsManager.getEnchantedItems(p));
		s8.setScore(2);

		// SPACES
		Score space = ob.getScore(" ");
		space.setScore(3);

		Score space1 = ob.getScore("  ");
		space1.setScore(5);

		Score space2 = ob.getScore("   ");
		space2.setScore(7);

		Score space3 = ob.getScore("    ");
		space3.setScore(9);

		p.setScoreboard(b.getObjective("Hub").getScoreboard());
	}

	public static void board2(Player p) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();

		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

		Objective ob = b.registerNewObjective("Hub", "dummy");

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

		p.setScoreboard(b.getObjective("Hub").getScoreboard());
	}

	public static void createNewBoard(Player p, String objectiveName, DisplaySlot display) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();

		if (p != null || objectiveName != null || display != null) {
			Objective obj = b.getObjective(display);
			obj.setDisplayName(objectiveName);
			p.setScoreboard(b);
		} else {
			System.out.println("Cannot set scoreboard for different reasons!");
		}
	}
}
