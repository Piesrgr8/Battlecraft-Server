package org.battlecraft.piesrgr8.essentials;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
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

	static File f = new File("plugins/BattlecraftServer/warps.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("bc.teleport")) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "Arguments are: /tp <player : all>");
				return true;
			}
			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);
				if (tar == null) {
					p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "That player isnt on the server!");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					p.teleport(new Location(tar.getWorld(), tar.getLocation().getX(), tar.getLocation().getY(),
							tar.getLocation().getZ()));
					p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Teleported to " + ChatColor.YELLOW
							+ tar.getName());
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported to "
							+ ChatColor.YELLOW + tar.getName() + "!");
					return true;
				}

				if (args[0].equalsIgnoreCase("all")) {

					tar.teleport(p.getLocation());
					tar.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Teleported everyone to "
							+ ChatColor.YELLOW + sender.getName() + "'s " + ChatColor.GREEN + "position!");
					p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Teleported everyone!");
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported everyone!");
					return true;
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("tpc")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("bc.teleport")) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "Arguments are: /tp <x : y : z>");
				return true;
			}
			if (args.length >= 1) {
				World w = p.getWorld();
				Location loc = new Location(w, Double.parseDouble(args[0]), Double.parseDouble(args[1]),
						Double.parseDouble(args[2]));
				p.teleport(loc);
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Teleported to " + ChatColor.YELLOW
						+ args[0] + ", " + args[1] + ", " + args[2] + "!");
				Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " teleported to coordinates "
						+ ChatColor.YELLOW + args[0] + ", " + args[1] + ", " + args[2] + "!");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("tphere")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("bc.teleport")) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You dont have permission to teleport.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "Arguments are: /tphere <player>");
				return true;
			}
			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);

				if (tar == null) {
					p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "That player isnt on the server!");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					tar.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(),
							p.getLocation().getZ()));
					tar.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "You were teleported to "
							+ ChatColor.YELLOW + p.getName());
					Admin.sendMessage(ChatColor.YELLOW + tar.getName() + ChatColor.GREEN + " teleported to "
							+ ChatColor.YELLOW + sender.getName() + "!");
					return true;
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("setwarp")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!p.hasPermission("bc.setwarp")) {
				p.sendMessage(
						BattlecraftServer.prefixWarp + ChatColor.RED + "You dont have permission to set up a warp.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "What will the name be?");
				return true;
			}

			if (args.length == 1) {
				String bc = "";
				for (String message : args) {
					bc = (bc + message + "");
				}
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Successfully created warp!");
				Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " created warp "
						+ ChatColor.YELLOW + bc + "!");
				yaml.createSection(bc);
				yaml.createSection(bc + ".world");
				yaml.createSection(bc + ".xPos");
				yaml.createSection(bc + ".yPos");
				yaml.createSection(bc + ".zPos");
				yaml.set(bc + ".world", p.getLocation().getWorld().getName());
				yaml.set(bc + ".xPos", p.getLocation().getBlockX());
				yaml.set(bc + ".yPos", p.getLocation().getBlockY());
				yaml.set(bc + ".zPos", p.getLocation().getBlockZ());
				try {
					yaml.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("warp")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "You are not a player!");
				return true;
			}
			Player p = (Player) sender;

			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "Arguments are: /warp <name>");
				return true;
			}
			if (args.length == 1) {
				if (!yaml.contains(args[0])) {
					p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.RED + "Warp doesnt exist");
					return true;
				}

				p.sendMessage(BattlecraftServer.prefixWarp + ChatColor.GREEN + "Warp successful");
				Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " went to warp " + ChatColor.YELLOW + args[0]);
				p.teleport(new Location(Bukkit.getWorld(yaml.getString(args[0] + ".world")),
						yaml.getDouble(args[0] + ".xPos"), yaml.getDouble(args[0] + ".yPos"),
						yaml.getDouble(args[0] + ".zPos")));
			}
		}
		return true;
	}
}
