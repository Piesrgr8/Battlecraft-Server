package org.battlecraft.piesrgr8.players;

import java.util.ArrayList;
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

public class Piesrgr8 implements Listener {

	BattlecraftServer plugin;
	
	public static ArrayList<Player> spoken = new ArrayList<Player>();

	public Piesrgr8(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void piesOn(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("Piesrgr8")) {
			e.setJoinMessage(ChatColor.BLUE + e.getPlayer().getName() + ChatColor.GOLD + " has joined the server!");

			for (Player pl : Bukkit.getOnlinePlayers()) {
				PacketUtil.sendActionMsg(plugin, pl,
						ChatColor.BLUE + "Piesrgr8: " + ChatColor.GOLD + "Im here to save the day!");
			}
		}
	}

	@EventHandler
	public void autoMessage(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		final Player p1 = getPies();
		if (RanksEnum.isStaff(p)) {
			if (e.getMessage().equalsIgnoreCase("brb")
					|| e.getMessage().contains("brb") && p1.getName().equals("Piesrgr8")) {
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

			if (e.getMessage().equalsIgnoreCase("owner") || e.getMessage().contains("owner")
					|| e.getMessage().contains("Piesrgr8")
					|| e.getMessage().equalsIgnoreCase("Piesrgr8")
					|| e.getMessage().equalsIgnoreCase("pies")
					|| e.getMessage().contains("Pies") && p1.getName().equals("Piesrgr8")) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						spoken.add(p);
						Random rand = new Random();
						int r = rand.nextInt(4);
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
			
			if (e.getMessage().equalsIgnoreCase("owner") || e.getMessage().contains("owner")
					|| e.getMessage().contains("Piesrgr8")
					|| e.getMessage().equalsIgnoreCase("Piesrgr8")
					|| e.getMessage().equalsIgnoreCase("pies")
					|| e.getMessage().contains("Pies") && p1.getName().equals("Piesrgr8")) {
				if (!spoken.contains(p)) {
					return;
				}
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
							Chat.sendFormattedMessage(p1, "yeeeees?????");
					}
				}, 30);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static Player getPies() {
		Player p = Bukkit.getPlayerExact("Piesrgr8");
		return p;
	}
}