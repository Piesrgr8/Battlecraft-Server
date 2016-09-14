package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener{
	
	BattlecraftServer plugin;
	
	public Chat(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (p.isOp()) {
			p.setDisplayName(ChatColor.YELLOW + p.getName());
		}else {
			p.setDisplayName(ChatColor.WHITE + p.getName());
		}
		
		if(p.getName.equals("iHersh")) {
			//manually added myself because f*ck permissions
			e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "DEV " + ChatColor.RESET + p.getDisplayName() + " " +
		ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
			return;
		}
		
		//cant do this because for op's it check if you have the owner permission first and since op's have
		//all permissions it'll assume they have it and set them with the owner tag
		if (p.hasPermission("bc.prefix.owner")) {
			e.setFormat(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OWNER " + ChatColor.RESET + p.getDisplayName() + " " +
		ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		} else if (p.hasPermission("bc.prefix.admin")) {
			e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.RESET + p.getDisplayName() + " " +
					ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		} else if (p.hasPermission("bc.prefix.mod")) {
			e.setFormat(ChatColor.GOLD + "" + ChatColor.BOLD + "MOD " + ChatColor.RESET + p.getDisplayName() + " " +
					ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		} else if (p.hasPermission("bc.prefix.helper")) {
			e.setFormat(ChatColor.GREEN + "" + ChatColor.BOLD + "HELPER " + ChatColor.RESET + p.getDisplayName() + " " +
					ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		} else if (p.hasPermission("bc.prefix.builder")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "BUILDER " + ChatColor.RESET + p.getDisplayName() + " " +
					ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		} else {
			e.setFormat(ChatColor.GRAY + "" + ChatColor.ITALIC + "Player " + ChatColor.RESET + p.getDisplayName() + " " +
					ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage());
		}
	}

}
