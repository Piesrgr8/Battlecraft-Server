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

public class DarthLaser123 implements Listener {

	BattlecraftServer plugin;

	public static ArrayList<Player> spoken = new ArrayList<Player>();

	String specialName = ChatColor.RED + "" + ChatColor.MAGIC + "k" + ChatColor.DARK_RED + "" + ChatColor.BOLD + ""
			+ ChatColor.ITALIC + "DarthLaser123" + ChatColor.RED + "" + ChatColor.MAGIC + "k" + ChatColor.RESET + " ";

	public DarthLaser123(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void piesOn(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("DarthLaser123")) {
			e.setJoinMessage(specialName + ChatColor.GOLD + "" + ChatColor.ITALIC + "joined");

			for (Player pl : Bukkit.getOnlinePlayers()) {
				PacketUtil.sendActionMsg(plugin, pl,
						ChatColor.DARK_RED + "DarthLaser123: " + ChatColor.GOLD + "Heyo!");
			}
		}
	}

	@EventHandler
	public void autoMessage(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		final Player p1 = getDarth();
		if (RanksEnum.isStaff(p)) {
			if (e.getMessage().equalsIgnoreCase("brb")
					|| e.getMessage().contains("brb") && p1.getName().equals("DarthLaser123")) {
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

			if (e.getMessage().equalsIgnoreCase("coowner") || e.getMessage().contains("coowner")
					|| e.getMessage().contains("DarthLaser123") || e.getMessage().equalsIgnoreCase("DarthLaser123")
					|| e.getMessage().equalsIgnoreCase("darth")
					|| e.getMessage().contains("darth") && p1.getName().equals("DarthLaser123")) {
				if (spoken.contains(p)) {
					return;
				}
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
			
			if (e.getMessage().equalsIgnoreCase("coowner") || e.getMessage().contains("coowner")
					|| e.getMessage().contains("DarthLaser123") || e.getMessage().equalsIgnoreCase("DarthLaser123")
					|| e.getMessage().equalsIgnoreCase("darth")
					|| e.getMessage().contains("darth") && p1.getName().equals("DarthLaser123")) {
				if (!spoken.contains(p)) {
					return;
				}
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
							Chat.sendFormattedMessage(p1, "yeeeees?????");
							spoken.remove(p);
					}
				}, 30);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static Player getDarth() {
		Player p = Bukkit.getPlayerExact("DarthLaser123");
		return p;
	}

}
