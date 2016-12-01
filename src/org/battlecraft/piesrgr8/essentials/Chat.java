package org.battlecraft.piesrgr8.essentials;

import java.io.File;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	BattlecraftServer plugin;

	File f = ConfigMg.player;
	YamlConfiguration yaml = ConfigMg.playerY;

	public Chat(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String nick = ChatColor.translateAlternateColorCodes('&', yaml.getString(p.getName() + ".nick"));
		
		if (e.getMessage().contains("%")) {
			e.setMessage(e.getMessage().replaceAll("%", "percent"));
		}
		
		if (yaml.contains(p.getName() + ".nick")) {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + nick + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
		}
		
		if(RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + p.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
		}
		else
		{
			e.setFormat(ChatColor.GRAY + p.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.GRAY + e.getMessage());
		}
	}

}
