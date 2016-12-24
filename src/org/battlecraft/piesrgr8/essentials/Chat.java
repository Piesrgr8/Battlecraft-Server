package org.battlecraft.piesrgr8.essentials;

import java.io.File;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	BattlecraftServer plugin;

	public Chat(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		//Using the new UUID system!!
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
		
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        
		String nick = ChatColor.translateAlternateColorCodes('&', yaml.getString(fromUUID.getName() + ".nick"));
		
		//This was just to avoid any errors when making a message. Had something to do with ChatColor.
		if (e.getMessage().contains("%")) {
			e.setMessage(e.getMessage().replaceAll("%", "percent"));
		}
		
		//If a player has a nickname in their play info yml, use it as their message format.
		if (yaml.contains(fromUUID.getName() + ".nick")) {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + nick + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
		}
		
		//If the rank is existent, then use the format for that specific rank.
		if(RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
		}
		else
		{
			//Otherwise, use the default format.
			e.setFormat(ChatColor.GRAY + fromUUID.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.GRAY + e.getMessage());
		}
	}

}
