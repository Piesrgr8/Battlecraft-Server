package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SoundEffects implements Listener{
	
	static BattlecraftServer plugin;
	
	public SoundEffects(BattlecraftServer p) {
		SoundEffects.plugin = p;
	}
	
	public static void alertS(final Player p) {
		final Location loc = p.getLocation();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.BLOCK_NOTE_PLING, 10000, 2);
			}
		}, 1);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.BLOCK_NOTE_PLING, 10000, 2);
			}
		}, 3);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.BLOCK_NOTE_PLING, 10000, 2);
			}
		}, 14);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.BLOCK_NOTE_PLING, 10000, 2);
			}
		}, 16);
	}
	
	public static void adminS(final Player p) {
		final Location loc = p.getLocation();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10000, 2);
			}
		}, 1);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10000, 1);
			}
		}, 4);
	}
}
