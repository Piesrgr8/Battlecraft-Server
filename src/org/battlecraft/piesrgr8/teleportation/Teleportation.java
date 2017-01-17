package org.battlecraft.piesrgr8.teleportation;

import java.io.File;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Teleportation implements CommandExecutor {

	static File f = new File("plugins//BattlecraftServer//warps//");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "Arguments are: /tp <player : all>");
				return true;
			}
			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);
				if (tar == null) {
					p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "That player isnt on the server!");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					p.teleport(new Location(tar.getWorld(), tar.getLocation().getX(), tar.getLocation().getY(),
							tar.getLocation().getZ()));
					p.sendMessage(Prefix.prefixWarp + ChatColor.GREEN + "Teleported to " + ChatColor.YELLOW
							+ tar.getName());
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported to "
							+ ChatColor.YELLOW + tar.getName() + "!");
					return true;
				}

				if (args[0].equalsIgnoreCase("all")) {

					tar.teleport(p.getLocation());
					tar.sendMessage(Prefix.prefixWarp + ChatColor.GREEN + "Teleported everyone to "
							+ ChatColor.YELLOW + sender.getName() + "'s " + ChatColor.GREEN + "position!");
					p.sendMessage(Prefix.prefixWarp + ChatColor.GREEN + "Teleported everyone!");
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported everyone!");
					return true;
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("tpc")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "Arguments are: /tp <x : y : z>");
				return true;
			}
			if (args.length >= 1) {
				World w = p.getWorld();
				Location loc = new Location(w, Double.parseDouble(args[0]), Double.parseDouble(args[1]),
						Double.parseDouble(args[2]));
				p.teleport(loc);
				p.sendMessage(Prefix.prefixWarp + ChatColor.GREEN + "Teleported to " + ChatColor.YELLOW
						+ args[0] + ", " + args[1] + ", " + args[2] + "!");
				Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported to coordinates "
						+ ChatColor.YELLOW + args[0] + ", " + args[1] + ", " + args[2] + "!");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("tphere")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "Arguments are: /tphere <player>");
				return true;
			}
			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);

				if (tar == null) {
					p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "That player isnt on the server!");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					tar.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(),
							p.getLocation().getZ()));
					tar.sendMessage(Prefix.prefixWarp + ChatColor.GREEN + "You were teleported to "
							+ ChatColor.YELLOW + p.getName());
					Admin.sendMessage(ChatColor.YELLOW + tar.getName() + ChatColor.GREEN + " was teleported to "
							+ ChatColor.YELLOW + sender.getName() + "!");
					return true;
				}
			}
		}
		return true;
	}
}
