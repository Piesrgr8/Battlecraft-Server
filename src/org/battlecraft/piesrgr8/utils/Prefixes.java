package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Scoreboard;

public class Prefixes implements Listener{
	
	static BattlecraftServer plugin;
	static Scoreboard sb;
	
	public Prefixes(BattlecraftServer p) {
		Prefixes.plugin = p;
	}
	
	
	/*
	public static void registerPrefixes() {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		sb.registerNewTeam("0000Owner");
		sb.registerNewTeam("0001Dev");
		sb.registerNewTeam("0002Admin");
		sb.registerNewTeam("0003Cowner");
		sb.registerNewTeam("0004Leader");
		sb.registerNewTeam("0005Srmod");
		sb.registerNewTeam("0006Mod");
		sb.registerNewTeam("0007Helper");
		sb.registerNewTeam("0008Builder");
		sb.registerNewTeam("0009Architect");
		sb.registerNewTeam("0010Vip");
		sb.registerNewTeam("0011Vipplus");
		sb.registerNewTeam("0012Plusvipplus");
		sb.registerNewTeam("0013Premium");
		sb.registerNewTeam("0014Master");
		sb.registerNewTeam("0014Player");
		
		sb.getTeam("0000Owner").setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lOWNER&r "));
		sb.getTeam("0001Dev").setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lDEV&r "));
		sb.getTeam("0002Admin").setPrefix(ChatColor.translateAlternateColorCodes('&', "&c&lADMIN&r "));
		sb.getTeam("0003Cowner").setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lCO-OWNER&r "));
		sb.getTeam("0004Leader").setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lLD&r "));
		sb.getTeam("0005Srmod").setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lSR.MOD&r "));
		sb.getTeam("0006Mod").setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lMOD&r "));
		sb.getTeam("0007Helper").setPrefix(ChatColor.translateAlternateColorCodes('&', "&3&lHELPER&r "));
		sb.getTeam("0008Builder").setPrefix(ChatColor.translateAlternateColorCodes('&', "&9&lBUILDER&r "));
		sb.getTeam("0009Architect").setPrefix(ChatColor.translateAlternateColorCodes('&', "&9&lARCHITECT&r "));
		sb.getTeam("0010Vip").setPrefix(ChatColor.translateAlternateColorCodes('&', "&a&lVIP&r "));
		sb.getTeam("0011Vipplus").setPrefix(ChatColor.translateAlternateColorCodes('&', "&a&lVIPb&l+&r "));
		sb.getTeam("0012Plusvipplus").setPrefix(ChatColor.translateAlternateColorCodes('&', "&b&l+&a&lVIP&b&l+&r "));
		sb.getTeam("0013Premium").setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lPREMIUM&r "));
		sb.getTeam("0014Master").setPrefix(ChatColor.translateAlternateColorCodes('&', "&b&lMASTER&r "));
	}
	
	public static void setPrefix(Player p) {
		String team = "";
		if (RanksEnum.getRank(p).equals(Ranks.OWNER)) {
			Debug.debugConsole("This player has Owner!");
			team = "0000Owner";
		}else if (RanksEnum.getRank(p).equals(Ranks.DEV)) {
			team = "0001Dev";
		}else if (RanksEnum.getRank(p).equals(Ranks.ADMIN)) {
			team = "0002Admin";		
		}else if (RanksEnum.getRank(p).equals(Ranks.COWNER)) {
			team = "0003Cowner";
		}else if (RanksEnum.getRank(p).equals(Ranks.LEADER)) {
			team = "0004Leader";
		}else if (RanksEnum.getRank(p).equals(Ranks.SRMOD)) {
			team = "0005Srmod";
		}else if (RanksEnum.getRank(p).equals(Ranks.MOD)) {
			team = "0006Mod";
		}else if (RanksEnum.getRank(p).equals(Ranks.HELPER)) {
			team = "0007Helper";
		}else if (RanksEnum.getRank(p).equals(Ranks.BUILDER)) {
			team = "0008Builder";
		}else if (RanksEnum.getRank(p).equals(Ranks.ARCHITECT)) {
			team = "0009Architect";
		}else if (RanksEnum.getRank(p).equals(Ranks.VIP)) {
			team = "0010Vip";
		}else if (RanksEnum.getRank(p).equals(Ranks.VIPPLUS)) {
			team = "0011Vipplus";
		}else if (RanksEnum.getRank(p).equals(Ranks.PLUSVIPPLUS)) {
			team = "0012Plusvipplus";
		}else if (RanksEnum.getRank(p).equals(Ranks.PREMIUM)) {
			team = "0013Premium";
		}else if (RanksEnum.getRank(p).equals(Ranks.MASTER)) {
			team = "0014Master";
		}else {
			team = "0015Player";
		}
		
		sb.getTeam(team);
		p.setDisplayName(sb.getTeam(team).getPrefix() + p.getName());
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setScoreboard(sb);
		}
	}
	*/
}
