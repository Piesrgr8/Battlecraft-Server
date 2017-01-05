package org.battlecraft.piesrgr8.utils;

import java.util.HashMap;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Cooldown {

	public static HashMap<Player, Integer> cooldownTime;
	public static HashMap<Player, BukkitRunnable> cooldownTask;

	BattlecraftServer plugin;

	public Cooldown(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void cooldownMessage(Player p) {
		p.sendMessage(Prefix.prefixCooldown + ChatColor.RED + "You must wait " + ChatColor.YELLOW
				+ Cooldown.cooldownTime.get(p) + ChatColor.YELLOW + " seconds!");
	}
}
