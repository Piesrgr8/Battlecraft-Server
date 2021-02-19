package org.battlecraft.piesrgr8.players;

import java.util.Random;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.chat.Chat;
import org.battlecraft.piesrgr8.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Piesrgr8 implements Listener {

	BattlecraftServer plugin;

	public Piesrgr8(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void piesOn(PlayerJoinEvent e) {
		if (e.getPlayer().getName().equals("Piesrgr8")) {
			e.setJoinMessage(ChatColor.BLUE + e.getPlayer().getName() + ChatColor.GOLD + " has joined the server!");
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1));

			for (Player pl : Bukkit.getOnlinePlayers()) {
				TitleManager.sendActionBar(pl, ChatColor.BLUE + "Piesrgr8: " + ChatColor.GOLD + "Im here to save the day!");
			}
		}
	}

	@EventHandler
	public void autoMessage(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		final Player p1 = Bukkit.getServer().getPlayer("Piesrgr8");
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
}