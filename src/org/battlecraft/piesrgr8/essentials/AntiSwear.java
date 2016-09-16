package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSwear implements Listener{
	
	private BattlecraftServer plugin;
	
	public AntiSwear(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if(!e.getPlayer.hasPermission("BC.swear")) {
			for (String word : e.getMessage().split(" ")) {
				if (plugin.getConfig().getStringList("badwords").contains(word)) {
				
					word.replaceAll(word, "*");
					e.setCancelled(true);
				 	e.getPlayer().sendMessage(ChatColor.RED + "Cursing is against the rules on this server!");
				}
			}
		}
	}
}
