package org.battlecraft.piesrgr8.kitpvp.challenges;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ChalScoreboard {
	
	private static ScoreboardManager man;
	private static Scoreboard bo;
	private static Objective obj;
	private static Score s;
	
	@SuppressWarnings("deprecation")
	public static void createBoard(Player p) {
		man = Bukkit.getScoreboardManager();
		bo = man.getNewScoreboard();
		obj = bo.registerNewObjective("test", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("Challenge Progress");
		
		for (Player on : Challenges.list) {
		s = obj.getScore(on);
		s.setScore(0);
		on.setScoreboard(bo);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void setScore(Player p, Integer in) {
		man = Bukkit.getScoreboardManager();
		bo = man.getMainScoreboard();
		obj = bo.getObjective("Challenge Progress");
		s = obj.getScore(p);
		
		s.setScore(s.getScore() + in);
	}
	
	public static void removeBoard() {
		man = Bukkit.getScoreboardManager();
		
		for (Player on : Challenges.list)
		on.setScoreboard(man.getNewScoreboard());
	}
	
	public static Scoreboard getBoard() {
		ScoreboardManager man = Bukkit.getScoreboardManager();
		Scoreboard bo = man.getMainScoreboard();
		return bo;
	}
	
	@SuppressWarnings("deprecation")
	public static Score getScore(Player p) {
		man = Bukkit.getScoreboardManager();
		bo = man.getMainScoreboard();
		obj = bo.getObjective("Challenge Progress");
		s = obj.getScore(p);
		return s;
	}
}
