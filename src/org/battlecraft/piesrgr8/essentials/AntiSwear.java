package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSwear implements Listener {

	private BattlecraftServer plugin;

	public AntiSwear(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	
	//When a player uses a bad word, their message will be terminated. All bad words are in the general config.
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		for (String word : e.getMessage().split(" ")) {
			if (plugin.getConfig().getStringList("badwords").contains(word)) {
				
				if(e.getPlayer().getName().equals("iHersh") || e.getPlayer().getName().equals("Piesgr8") || e.getPlayer().getName().equals("SBG_Memes"))
				{
					return;
				}
				else
				{
					e.setCancelled(true);
					e.getPlayer().sendMessage(ChatColor.RED + "Cursing is against the rules on this server!");
				}
				
				
			}
		}
	}

}
