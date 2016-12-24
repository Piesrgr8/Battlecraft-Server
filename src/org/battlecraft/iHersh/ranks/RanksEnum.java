package org.battlecraft.iHersh.ranks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Debug;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class RanksEnum implements Listener, CommandExecutor {

	public static Map<Player, Enum<Ranks>> arrayRanks = new HashMap<Player, Enum<Ranks>>();
	static File f = new File("plugins/BattlecraftServer/ranks.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	public enum Ranks {
		OWNER, // 4
		COWNER, // 4
		DEV, // 4
		LEADER, // 4
		ADMIN, // 4
		SRMOD, // c
		MOD, // c
		HELPER, // c

		BUILDER, // 9
		ARCHITECT, // 9
		VIP, // a
		VIPPLUS, // ab
		PLUSVIPPLUS, // ab
		PREMIUM, // d
		MASTER // e
	}

	public RanksEnum(BattlecraftServer battlecraftServer) {

	}

	public static String getPrefix(Enum<Ranks> e) {

		if (e != null) {
			if (e.equals(Ranks.OWNER))
				return "&4&lOWNER&r";
			else if (e.equals(Ranks.COWNER))
				return "&4&lCO-OWNER";
			else if (e.equals(Ranks.DEV))
				return "&4&lDEV&r";
			else if (e.equals(Ranks.LEADER))
				return "&6&lLEADER&r";
			else if (e.equals(Ranks.ADMIN))
				return "&c&lADMIN&r";
			else if (e.equals(Ranks.DEV))
				return "&c&lDEV&r";
			else if (e.equals(Ranks.MOD))
				return "&6&lMOD&r";
			else if (e.equals(Ranks.SRMOD))
				return "&6&lSR.MOD&r";
			else if (e.equals(Ranks.HELPER))
				return "&3&lHELPER&r";

			else if (e.equals(Ranks.BUILDER))
				return "&9&lBUILDER&r";
			else if (e.equals(Ranks.ARCHITECT))
				return "&9&lARCHITECT&r";
			else if (e.equals(Ranks.VIP))
				return "&a&lVIP&r";
			else if (e.equals(Ranks.VIPPLUS))
				return "&a&lVIP&b&l+&r";
			else if (e.equals(Ranks.PLUSVIPPLUS))
				return "&b&l+&a&lVIP&b&l+&r";
			else if (e.equals(Ranks.PREMIUM))
				return "&6&lPREMIUM&r";
			else if (e.equals(Ranks.MASTER))
				return "&3&lMASTER&r";
		}

		return "";
	}

	// only to make the file for ranks. used in BattlecraftServer.java as an
	// initiator
	public static void startRanks(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "ranks.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "ranks.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// probably gonna be used for /updaterank <player> <rank>
	public static void setRank(Player p, Enum<Ranks> e) {
		arrayRanks.put(p, e);
	}

	// This checks whether the player <p> is a staff member (Includes helper)
	public static boolean isStaff(Player p) {
		if (arrayRanks.get(p) == Ranks.OWNER || arrayRanks.get(p) == Ranks.COWNER || arrayRanks.get(p) == Ranks.LEADER
				|| arrayRanks.get(p) == Ranks.DEV || arrayRanks.get(p) == Ranks.ADMIN
				|| arrayRanks.get(p) == Ranks.SRMOD || arrayRanks.get(p) == Ranks.MOD
				|| arrayRanks.get(p) == Ranks.HELPER) {
			return true;
		} else
			return false;
	}

	// Just to get the rank of the player, will be used everywhere and many
	// times.
	public static Enum<Ranks> getRank(Player p) {
		if (arrayRanks.containsKey(p)) {
			return arrayRanks.get(p);
		} else
			return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getLabel().equalsIgnoreCase("updaterank")) {

				if (RanksEnum.isAtLeast(p, Ranks.DEV)) {
					@SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer(args[0]);
					Enum<Ranks> rank = getEnum(args[1]);

					arrayRanks.put(target, rank);
					yaml.set(target.getName(), rank.toString());
					try {
						yaml.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}

					p.sendMessage(c(
							BattlecraftServer.prefixRanks + target.getName() + "'s rank is now &6" + rank.toString()));
					return true;
				} else {
					p.sendMessage(c(BattlecraftServer.prefixRanks + "This requires permission rank [&6DEV&7]."));
					return true;
				}
			}
		} else {
			if (label.equalsIgnoreCase("updaterank")) {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

				@SuppressWarnings("deprecation")
				Player target = Bukkit.getPlayer(args[0]);
				Enum<Ranks> rank = getEnum(args[1]);

				arrayRanks.put(target, rank);
				yaml.set(target.getName(), rank.toString());
				try {
					yaml.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}

				console.sendMessage(c(BattlecraftServer.prefixRanks + "&6" + target.getName() + "&7's rank is now &6"
						+ rank.toString()));
				return true;
			}
		}
		return false;
	}

	// I decided to make it so if the player's name isn't in the config they're
	// considered default. Makes my life easier.
	// Day 2: It did NOT make my life easier.
	/*
	 * @EventHandler public void onJoin(PlayerJoinEvent e) { Player p =
	 * e.getPlayer();
	 * 
	 * if() }
	 */

	// Checks to see if the player is at least x rank (in terms of staff
	// hierarchy)
	public static boolean isAtLeast(Player p, Enum<Ranks> e) {

		if (RanksEnum.getRank(p) != null) {
			if (e.equals(Ranks.VIP)) {
				if (RanksEnum.getRank(p).equals(Ranks.VIPPLUS) || RanksEnum.getRank(p).equals(Ranks.PLUSVIPPLUS)
						|| RanksEnum.getRank(p).equals(Ranks.MASTER) || RanksEnum.getRank(p).equals(Ranks.PREMIUM)
						|| RanksEnum.getRank(p).equals(Ranks.HELPER) || RanksEnum.getRank(p).equals(Ranks.MOD)
						|| RanksEnum.getRank(p).equals(Ranks.ADMIN) || RanksEnum.getRank(p).equals(Ranks.DEV)
						|| RanksEnum.getRank(p).equals(Ranks.LEADER) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.VIPPLUS)) {
				if (RanksEnum.getRank(p).equals(Ranks.PLUSVIPPLUS) || RanksEnum.getRank(p).equals(Ranks.MASTER)
						|| RanksEnum.getRank(p).equals(Ranks.PREMIUM) || RanksEnum.getRank(p).equals(Ranks.HELPER)
						|| RanksEnum.getRank(p).equals(Ranks.MOD) || RanksEnum.getRank(p).equals(Ranks.ADMIN)
						|| RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.LEADER)
						|| RanksEnum.getRank(p).equals(Ranks.COWNER) || RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.PLUSVIPPLUS)) {
				if (RanksEnum.getRank(p).equals(Ranks.MASTER) || RanksEnum.getRank(p).equals(Ranks.PREMIUM)
						|| RanksEnum.getRank(p).equals(Ranks.HELPER) || RanksEnum.getRank(p).equals(Ranks.MOD)
						|| RanksEnum.getRank(p).equals(Ranks.ADMIN) || RanksEnum.getRank(p).equals(Ranks.DEV)
						|| RanksEnum.getRank(p).equals(Ranks.LEADER) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.MASTER)) {
				if (RanksEnum.getRank(p).equals(Ranks.PREMIUM) || RanksEnum.getRank(p).equals(Ranks.HELPER)
						|| RanksEnum.getRank(p).equals(Ranks.MOD) || RanksEnum.getRank(p).equals(Ranks.ADMIN)
						|| RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.LEADER)
						|| RanksEnum.getRank(p).equals(Ranks.COWNER) || RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.PREMIUM)) {
				if (RanksEnum.getRank(p).equals(Ranks.HELPER) || RanksEnum.getRank(p).equals(Ranks.MOD)
						|| RanksEnum.getRank(p).equals(Ranks.ADMIN) || RanksEnum.getRank(p).equals(Ranks.DEV)
						|| RanksEnum.getRank(p).equals(Ranks.LEADER) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.HELPER)) {
				if (RanksEnum.getRank(p).equals(Ranks.HELPER) || RanksEnum.getRank(p).equals(Ranks.MOD)
						|| RanksEnum.getRank(p).equals(Ranks.ADMIN) || RanksEnum.getRank(p).equals(Ranks.DEV)
						|| RanksEnum.getRank(p).equals(Ranks.LEADER) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.MOD)) {
				if (RanksEnum.getRank(p).equals(Ranks.MOD) || RanksEnum.getRank(p).equals(Ranks.ADMIN)
						|| RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.LEADER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.SRMOD)) {
				if (RanksEnum.getRank(p).equals(Ranks.SRMOD) || RanksEnum.getRank(p).equals(Ranks.ADMIN)
						|| RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.LEADER)
						|| RanksEnum.getRank(p).equals(Ranks.COWNER) || RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.ADMIN)) {
				if (RanksEnum.getRank(p).equals(Ranks.ADMIN) || RanksEnum.getRank(p).equals(Ranks.DEV)
						|| RanksEnum.getRank(p).equals(Ranks.LEADER) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.LEADER)) {
				if (RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.LEADER)
						|| RanksEnum.getRank(p).equals(Ranks.COWNER) || RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.DEV)) {
				if (RanksEnum.getRank(p).equals(Ranks.DEV) || RanksEnum.getRank(p).equals(Ranks.COWNER)
						|| RanksEnum.getRank(p).equals(Ranks.OWNER)) {
					return true;
				} else
					return false;
			}

			if (e.equals(Ranks.OWNER))
				return true;
		} else
			return false;
		return false;
	}

	public static String c(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}

	public static Enum<Ranks> getEnum(String s) {
		if (s != null) {
			for (Enum<Ranks> b : Ranks.values()) {
				if (s.equalsIgnoreCase(b.name()))
					return b;
			}
		}
		return null;
	}

	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		Debug.debugConsole("A player is logging in!");
		if (yaml.contains(p.getName())) {
			RanksEnum.setRank(p, getEnum(yaml.getString(p.getName())));
		}

	}

}
