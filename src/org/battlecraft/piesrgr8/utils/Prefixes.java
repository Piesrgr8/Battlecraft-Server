package org.battlecraft.piesrgr8.utils;

import org.bukkit.event.Listener;

public class Prefixes implements Listener{
	/*
	BattlecraftServer plugin;
	
	private static Scoreboard sb;
	private static Objective obj;
	
	public Prefixes(BattlecraftServer p) {
		this.plugin = p;
	}
	
	public static void start(Player p) {
		sb = p.getScoreboard();
		
		if (sb.getObjective("Prefix") == null) {
			obj = sb.registerNewObjective("Prefix", "dummy");
			obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		} else {
			obj = sb.getObjective("Prefix");
			obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
		}
		
		createTeams();
	}
	 
	public static void assignPrefix(Player p) {
		String teamName = "t" + RanksEnum.getRank(p);
		Team t = p.getScoreboard().getTeam(teamName);
		
		if (!t.getEntries().contains(p))
			t.addEntry(p.getName());
	}
	
	private static void createTeams() {
		Ranks[] ranks = Ranks.values();
		for (int i = 0; i < Ranks.values().length; i++) {
			if (sb.getTeam("t" + ranks[i]) == null)
				sb.registerNewTeam("t" + ranks[i]);
			updatePrefix(ranks[i]);
		}
	}
	
	private static void updatePrefix(Ranks r) {
		switch(r.name()) {
		case "owner":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lOWNER&r "));
			break;
			
		case "cowner":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lCO-OWNER&r "));
			break;
			
		case "admin":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&c&lADMIN&r "));
			break;
			
		case "dev":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lDEV&r "));
			break;
			
		case "leader":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lLD&r "));
			break;
			
		case "srmod":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lSR.MOD&r "));
			break;
			
		case "mod":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lMOD&r "));
			break;
			
		case "helper":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&3&lHELPER&r "));
			break;
			
		case "builder":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&9&lBUILDER&r "));
			break;
			
		case "architect":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&9&lARCHITECT&r "));
			break;
			
		case "plusvipplus":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&b&l+&a&lVIP&b&l+&r "));
			break;
			
		case "vipplus":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&a&lVIPb&l+&r "));
			break;
			
		case "vip":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&a&lVIP&r "));
			break;
			
		case "premium":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&6&lPREMIUM&r "));
			break;
			
		case "master":
			sb.getTeam("t" + r.name()).setPrefix(ChatColor.translateAlternateColorCodes('&', "&b&lMASTER&r "));
			break;
			
		case "default":
			break;
		}
	}
	
	/*private static void createPrefixes() {
		Ranks[] ranks = Ranks.values();
		for (int i = 0; i < Ranks.values().length; i++) {
			obj.getScoreboard().getTeam("t" + ranks[i]).setPrefix("ATest ");
		}
	}*/
	
	/*
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
	
	*/
	
}
