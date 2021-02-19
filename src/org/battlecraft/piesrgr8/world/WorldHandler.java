package org.battlecraft.piesrgr8.world;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.ClanMain;
import org.battlecraft.piesrgr8.clans.Clans;
import org.battlecraft.piesrgr8.essentials.Invisibility;
import org.battlecraft.piesrgr8.hub.HubInv;
import org.battlecraft.piesrgr8.inventory.RestoreInventory;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.utils.ScoreboardMg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffectType;

public class WorldHandler implements Listener, CommandExecutor{

	BattlecraftServer plugin;
	ClanMain clanPL;

	public WorldHandler(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onWorldSwitch(PlayerChangedWorldEvent e) {
		final Player p = e.getPlayer();

		if (e.getFrom().getName().equals("Waiting")) {
			return;
		}

		if (p.getWorld().getName().equals("Creative")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadFactionInventory(p);
				}
			}, 25);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveFactionInventory(p);
				}
			}, 35);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadCreativeInventory(p);
				}
			}, 50);
		} else if (e.getFrom().getName().equals("Creative")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveCreativeInventory(p);
				}
			}, 10);
		}

		if (p.getWorld().getName().equals("ASkyBlock")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadFactionInventory(p);
				}
			}, 25);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveFactionInventory(p);
				}
			}, 35);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadSkyBlockInventory(p);
				}
			}, 50);
		} else if (e.getFrom().getName().equals("ASkyBlock")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveSkyBlockInventory(p);
				}
			}, 10);
		}

		if (p.getWorld().getName().equals("KitPvP")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadFactionInventory(p);
				}
			}, 25);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveFactionInventory(p);
				}
			}, 35);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadKitPvPInventory(p);
				}
			}, 45);
		} else if (e.getFrom().getName().equals("KitPvP")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveKitPvPInventory(p);
				}
			}, 10);
		}

		if (p.getWorld().getName().equals("world") || p.getWorld().getName().equals("Factions")
				|| p.getWorld().getName().equals("Minigame")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.loadFactionInventory(p);
				}
			}, 25);

		} else if (e.getFrom().getName().equals("world") || e.getFrom().getName().equals("Factions")
				|| e.getFrom().getName().equals("Minigame")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveFactionInventory(p);
				}
			}, 10);
		}

		if (p.getWorld().getName().equals("Factions")) {
			Clans c = new Clans(clanPL);
			c.sendMotd(p);
		}
		return;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		if (p.getWorld().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					RestoreInventory.saveInvFor(p, p.getLocation().getWorld());
					ScoreboardMg.board1(p);
				}
			}, 35);

			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					HubInv.hubInv(p);
				}
			}, 50);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onWorldChange(PlayerChangedWorldEvent e) {
		final Player p = e.getPlayer();

		if (p.getWorld().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					HubInv.hubInv(p);
					ScoreboardMg.board1(p);
					Invisibility.showAllPlayers(p);
					Invisibility.vanish.remove(p);
				}
			}, 20);
		} else if (e.getFrom().getName().equals("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					ScoreboardMg.removeHubBoard(p);
					Invisibility.showAllPlayers(p);
					Invisibility.vanish.remove(p);
					p.getInventory().clear();
					p.removePotionEffect(PotionEffectType.SPEED);
				}
			}, 5);
		}
	}

	@EventHandler
	public void onWeatherChanges(WeatherChangeEvent e) {
		World w = e.getWorld();

		if (w.getName().equals("Hub1")) {
			e.setCancelled(true);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("world")) {
			Player p = (Player) sender;
			String world = p.getLocation().getWorld().getName();
			p.sendMessage(Prefix.prefixWorld + ChatColor.GREEN + "You are in this world: " + world);
			return true;
		}
		
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("weather")) {
			if (RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("rain") || args[0].equalsIgnoreCase("storm")) {
						p.getWorld().setStorm(true);
						p.getWorld().setThundering(true);
						p.sendMessage(Color.c(Prefix.prefixWorld + "&7You set the weather to rainy."));
						return true;
					} else if (args[0].equalsIgnoreCase("sun") || args[0].equalsIgnoreCase("sunny")
							|| args[0].equalsIgnoreCase("clear")) {
						p.getWorld().setStorm(false);
						p.getWorld().setThundering(false);
						p.sendMessage(Color.c(Prefix.prefixWorld + "&7You set the weather to clear."));
						return true;
					}
				} else {
					sender.sendMessage(Color.c(Prefix.prefixWorld + "&7Syntax: /weather <clear | storm>"));
					return true;
				}
			} else {
				sender.sendMessage(Prefix.prefixWorld + ChatColor.RED
						+ "You do not have permission to change the weather in the world!");
				return true;
			}
		}
		return true;
	}
}
