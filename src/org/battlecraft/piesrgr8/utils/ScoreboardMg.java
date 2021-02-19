package org.battlecraft.piesrgr8.utils;

import java.util.UUID;

import org.battlecraft.piesrgr8.BattlecraftServer;
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
	private static int playerCount = 0;

	public ScoreboardMg(BattlecraftServer p) {
		ScoreboardMg.plugin = p;
	}

	public static void removeHubBoard(Player p) {
		Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
		p.setScoreboard(b);
	}

	@SuppressWarnings("deprecation")
	public static void board1(Player p) {
		ScoreboardManager mg = Bukkit.getScoreboardManager();
		Scoreboard b = mg.getNewScoreboard();

		Objective ob;
		
		if (b.getObjective("Hub") == null) {
			ob = b.registerNewObjective("Hub", "dummy");
		} else {
			ob = b.getObjective("Hub");
		}
		
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
		
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

		Score s4 = ob.getScore(ChatColor.AQUA + "" + playerCount());
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

	public static void createBoard(Player p, String objectiveName, DisplaySlot display) {
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
	
	private static int playerCount() {
		
		if (playerCount < Bukkit.getOnlinePlayers().size()) {
			playerCount = Bukkit.getOnlinePlayers().size();
		}
		
		return playerCount;
	}
}
