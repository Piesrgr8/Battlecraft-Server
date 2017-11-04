package org.battlecraft.piesrgr8.utils;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Prefixes implements Listener{
	
	BattlecraftServer plugin;
    Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
    Team team = null;
	
	public Prefixes(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        
        if (RanksEnum.getRank(p).equals(Ranks.OWNER)) {
        	if (sb.getTeam(p.getName()) == null) {
        		team = sb.registerNewTeam(p.getName());
        	}else{
        		team = sb.getTeam(p.getName());
        	}
        	
        	team.setPrefix(ChatColor.translateAlternateColorCodes('&', "&4&lOWNER&r "));
        	team.addPlayer(p);
        }
		
		
	}
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
