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

public class LilyMc101 implements Listener {

	BattlecraftServer plugin;
	
	public static ArrayList<Player> spoken = new ArrayList<Player>();
	
	String name = ChatColor.GREEN + "" + ChatColor.BOLD + "LilyMc101";

	public LilyMc101(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void hershOn(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("LilyMc101")) {
			e.setJoinMessage(name + ChatColor.GOLD + " joined");

			for (Player pl : Bukkit.getOnlinePlayers()) {
				PacketUtil.sendActionMsg(plugin, pl,
						ChatColor.RED + "LilyMc101: " + ChatColor.GOLD + "Gamer, taken, has no life. Fight me.");
			}
		}
	}

	@EventHandler
	public void autoMessage(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		final Player p1 = getLily();
		if (RanksEnum.isStaff(p)) {
			if (e.getMessage().equalsIgnoreCase("brb")
					|| e.getMessage().contains("brb") && p1.getName().equals("LilyMc101")) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Random rand = new Random();
						int r = rand.nextInt(5);
						if (r == 0 || r == 1) {
							Chat.sendFormattedStaffMessage(p1, "Ok. Ill be here.");
						} else if (r == 2) {
							Chat.sendFormattedStaffMessage(p1, "Ok");
						} else if (r == 3) {
							Chat.sendFormattedStaffMessage(p1, "Alright");
						} else if (r == 4) {
							Chat.sendFormattedStaffMessage(p1, "K");
						} else if (r == 5) {
							Chat.sendFormattedStaffMessage(p1, "Dont take long ok lol?!");
						}
					}
				}, 30);
			}

			if (e.getMessage().equalsIgnoreCase("builder") || e.getMessage().contains("builder")
					|| e.getMessage().contains("lily")
					|| e.getMessage().equalsIgnoreCase("lily") && p1.getName().equals("LilyMc101")) {
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
			
			if (e.getMessage().equalsIgnoreCase("builder") || e.getMessage().contains("builder")
					|| e.getMessage().contains("lily")
					|| e.getMessage().equalsIgnoreCase("lily") && p1.getName().equals("LilyMc101")) {
				
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
	public static Player getLily() {
		Player p = Bukkit.getPlayerExact("LilyMc101");
		return p;
	}

}
