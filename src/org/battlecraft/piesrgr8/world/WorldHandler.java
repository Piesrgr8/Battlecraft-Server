package org.battlecraft.piesrgr8.world;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.clans.Clans;
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

public class WorldHandler implements Listener, CommandExecutor {

	BattlecraftServer plugin;

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
			Clans.sendMotd(p);
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

		if (cmd.getName().equalsIgnoreCase("time")) {
			World w = p.getLocation().getWorld();
			if (args.length == 0) {
				sender.sendMessage(Color.c(Prefix.prefixWorld + "&eRight now, it is &a" + checkTime(p) + ", "
						+ w.getTime() + " &ein server ticks!"));

				if (RanksEnum.isAtLeast(p, Ranks.ADMIN))
					sender.sendMessage(
							Color.c(Prefix.prefixWorld + "&eIf you want to set the time, use &a/time set {time}!"));
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("set")) {
					if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
						sender.sendMessage(Color
								.c(Prefix.prefixWorld + "&cYou do not have permission to set the time in the world!"));
						return true;
					}

					sender.sendMessage(Color.c(Prefix.prefixWorld + "&eWhat would you like the time to be?"));
					return true;
				}
			}

			if (args.length == 2) {

				if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
					sender.sendMessage(
							Color.c(Prefix.prefixWorld + "&cYou do not have permission to set the time in the world!"));
					return true;
				}

				if (args[1].equalsIgnoreCase("day")) {
					w.setTime(1000);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase("night")) {
					w.setTime(13000);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase("noon")) {
					w.setTime(6000);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase("morning")) {
					w.setTime(22925);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase("afternoon")) {
					w.setTime(10000);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				w.setTime(Long.parseLong(args[1]));
				p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
				return true;
			}
		}
		return true;
	}

	public static String checkTime(Player p) {
		World w = p.getLocation().getWorld();
		long l = w.getTime();

		if (l >= 6000 && l <= 7500)
			return "noon";
		if (l >= 7501 && l <= 12999)
			return "afternoon";
		if (l >= 13000 && l <= 17999)
			return "night";
		if (l >= 18000 && l <= 22924)
			return "midnight";
		if (l >= 22925 && l <= 24000)
			return "morning";
		if (l >= 0 && l <= 5999)
			return "morning";
		return null;
	}
}
