package org.battlecraft.piesrgr8.chat;

import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.config.PlayersYML;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Notifications {
	
	public enum NotifType {
		MSG,
		ADMIN,
		CRITIC,
		CLANS,
		STAFF
	}
	
	public static void notify(Player p) {
		YamlConfiguration yaml = PlayersYML.getYaml(p);
		String path = p.getName() + ".messagelist";
		List<String> list = new ArrayList<String>();
		
		if (!p.hasPlayedBefore()) {
			return;
		}

		if (yaml.getStringList(path).isEmpty()) {
			return;
		} else {
			list = yaml.getStringList(path);
			for (int i = 0; i < list.size(); i++) {
				String s = list.get(i);
				p.sendMessage(ChatColor.BLUE + "" + (i+1) + ".) " + ChatColor.RESET + ""
						+ ChatColor.translateAlternateColorCodes('&', s));
			}

			PlayersYML.clearMessageList(p);
			return;
		}
	}
}
