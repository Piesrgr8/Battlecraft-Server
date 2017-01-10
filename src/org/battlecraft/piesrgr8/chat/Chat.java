package org.battlecraft.piesrgr8.chat;

import java.io.File;
import java.util.Random;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.clans.Clans;
import org.battlecraft.piesrgr8.essentials.Nick;
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

		// Using the new UUID system!!
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		String nick = Nick.getNick(fromUUID);

		// This was just to avoid any errors when making a message. Had
		// something to do with ChatColor.
		if (e.getMessage().contains("%")) {
			e.setMessage(e.getMessage().replaceAll("%", "percent"));
		}

		// If the rank is existent, then use the format for that specific rank.
		if (RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY
							+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));

			// If a player has a nickname in their play info yml, use it as
			// their message format.
			if (yaml.contains(fromUUID.getName() + ".nick")
					&& !yaml.getString(fromUUID.getName() + ".nick").equals(fromUUID.getName())) {
				try {
					e.setFormat(ChatColor.translateAlternateColorCodes('&',
							RanksEnum.getPrefix(RanksEnum.getRank(p)) + " *" + nick + " " + ChatColor.GRAY + ""
									+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
				} catch (Exception e1) {
					e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "ERR " + ChatColor.GRAY
							+ fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
							+ ChatColor.GRAY + e.getMessage());
					e1.getMessage();
				}
			}
			
			if (Clans.isInClan(fromUUID)) {
				try {
					e.setFormat(ChatColor.translateAlternateColorCodes('&',
							RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY + "["
									+ Clans.getClanTag(p) + "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
									+ ChatColor.RESET + e.getMessage()));
				} catch (Exception e1) {
					e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "ERR " + ChatColor.GRAY
							+ fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
							+ ChatColor.GRAY + e.getMessage());
					e1.getMessage();
				}
			}
		} else {
			// Otherwise, use the default format.
			e.setFormat(ChatColor.GRAY + fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
					+ ChatColor.GRAY + e.getMessage());
		}
	}

	public static void sendFormattedMessage(Player p, String msg) {
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
		if (RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY
							+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + msg));
		}
	}

	public static void sendFormattedStaffMessage(Player p, String msg) {
		if (!RanksEnum.staff.contains(p)) {
			return;
		}

			// LOOK AT THIS LATER!!

			int rand = new Random().nextInt(RanksEnum.staff.size());
			Player p1 = RanksEnum.staff.get(rand);

			if (RanksEnum.getPrefix(RanksEnum.getRank(p1)) != "") {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						RanksEnum.getPrefix(RanksEnum.getRank(p1)) + " " + p1.getDisplayName() + " " + ChatColor.GRAY
								+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + msg));
			}
	}

	public static void sendFormattedAdminMessage(Player p, String msg) {
		if (!RanksEnum.admin.contains(p)) {
			return;
		}

			// LOOK AT THIS LATER!!

			int rand = new Random().nextInt(RanksEnum.admin.size());
			Player p1 = RanksEnum.admin.get(rand);

			if (RanksEnum.getPrefix(RanksEnum.getRank(p1)) != "") {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						RanksEnum.getPrefix(RanksEnum.getRank(p1)) + " " + p1.getDisplayName() + " " + ChatColor.GRAY
								+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + msg));
		}
	}
}
