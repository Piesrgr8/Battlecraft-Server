package org.battlecraft.piesrgr8.world;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.essentials.Invisibility;
import org.battlecraft.piesrgr8.hub.HubInv;
import org.battlecraft.piesrgr8.inventory.RestoreInventory;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.utils.ScoreboardMg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

public class WorldHandler implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public WorldHandler(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onWorldSwitch(PlayerChangedWorldEvent e) {
		final Player p = e.getPlayer();
		PlayerInventory inv = e.getPlayer().getInventory();
		if (p.getWorld().getName().equals("Creative")) {
			p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "-------------- "
					+ ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.BOLD + "WARNING " + ChatColor.RED + ""
					+ ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "--------------");
			p.sendMessage(ChatColor.YELLOW
					+ "It appears that you have switched to the creative world. This is just a heads up to let you know that once you leave this world, "
					+ "your inventory will be " + ChatColor.RED + "" + ChatColor.BOLD + "CLEARED!" + ChatColor.YELLOW
					+ " So save everything in your enderchest " + "by using " + ChatColor.GREEN + "/enderchest."
					+ ChatColor.YELLOW + " Thank you!");
			p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "-------------- "
					+ ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.BOLD + "WARNING " + ChatColor.RED + ""
					+ ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "--------------");
		} else if (e.getFrom().getName().equals("Creative")) {
			inv.clear();
			p.sendMessage(Prefix.prefixMain + ChatColor.YELLOW
					+ "You left the Creative world! Inventory Cleared!");
		}

		if (p.getWorld().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveInventory(p);
					HubInv.hubInv(p);
					ScoreboardMg.createBoard(p);
					Invisibility.showAllPlayers(p);
					Invisibility.vanish.remove(p);
				}
			}, 10);
		} else if (e.getFrom().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadInventory(p);
					ScoreboardMg.removeBoard(p);
					Invisibility.showAllPlayers(p);
					Invisibility.vanish.remove(p);
				}
			}, 10);
		}
		return;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		if (p.getWorld().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveInventory(p);
					ScoreboardMg.createBoard(p);
				}
			}, 35);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					HubInv.hubInv(p);
				}
			}, 50);
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("world")) {
			Player p = (Player) sender;
			String world = p.getLocation().getWorld().getName();
			p.sendMessage(Prefix.prefixWorld + ChatColor.GREEN + "You are in this world: " + world);
			return true;
		}
		return true;
	}
}
