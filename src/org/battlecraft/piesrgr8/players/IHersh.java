package org.battlecraft.piesrgr8.players;

import java.util.Random;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.chat.Chat;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class IHersh implements Listener {

	BattlecraftServer plugin;
	
	String name = ChatColor.RED + "" + ChatColor.BOLD + "iHersh";

	public IHersh(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void hershOn(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("iHersh")) {
			e.setJoinMessage(name + ChatColor.GOLD + " joined");

			for (Player pl : Bukkit.getOnlinePlayers()) {
				PacketUtil.sendActionMsg(plugin, pl,
						ChatColor.RED + "iHersh: " + ChatColor.GOLD + "Hekin memes dude.");
			}
		}
	}

	@EventHandler
	public void autoMessage(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		final Player p1 = getHersh();
		if (RanksEnum.isStaff(p)) {
			if (e.getMessage().equalsIgnoreCase("brb")
					|| e.getMessage().contains("brb") && p1.getName().equals("iHersh")) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Random rand = new Random();
						int r = rand.nextInt(5);
						if (r == 0 || r == 1) {
							Chat.sendFormattedAdminMessage(p1, "Ok. Ill be here.");
						} else if (r == 2) {
							Chat.sendFormattedAdminMessage(p1, "Ok");
						} else if (r == 3) {
							Chat.sendFormattedAdminMessage(p1, "Alright");
						} else if (r == 4) {
							Chat.sendFormattedAdminMessage(p1, "K");
						} else if (r == 5) {
							Chat.sendFormattedAdminMessage(p1, "Dont take long ok lol?!");
						}
					}
				}, 30);
			}

			if (e.getMessage().equalsIgnoreCase("dev") || e.getMessage().contains("dev")
					|| e.getMessage().contains("ihersh")
					|| e.getMessage().equalsIgnoreCase("ihersh")
					|| e.getMessage().equalsIgnoreCase("hersh")
					|| e.getMessage().contains("hersh") && p1.getName().equals("iHersh")) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Random rand = new Random();
						int r = rand.nextInt(5);
						if (r == 0 || r == 1) {
							Chat.sendFormattedMessage(p1, "Yes?");
						} else if (r == 2) {
							Chat.sendFormattedMessage(p1, "Sup");
						} else if (r == 3) {
							Chat.sendFormattedMessage(p1, "Yea?");
						} else if (r == 4) {
							Chat.sendFormattedMessage(p1, "Whats up?");
						}
					}
				}, 30);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static Player getHersh() {
		Player p = Bukkit.getPlayerExact("iHersh");
		return p;
	}
}
