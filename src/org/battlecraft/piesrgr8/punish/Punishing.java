package org.battlecraft.piesrgr8.punish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Punishing implements CommandExecutor {

	BattlecraftServer plugin;

	String exline = "\n";
	String website = ChatColor.GREEN + "www.bcpvp101.enjin.com/forum";

	static File f = new File("plugins/BattlecraftServer/players.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	public Punishing(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// USE DEBUGGING METHOD TO TEST OUT!

		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				sender.sendMessage(ChatColor.RED + "You do not have permission to kick someone!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixPunish + ChatColor.RED + "Please specify a player!");
				return true;
			}
			if (args.length == 1) {

				if (args[0].equalsIgnoreCase(sender.getName())) {
					sender.sendMessage(
							BattlecraftServer.prefixPunish + ChatColor.RED + "Really? You're trying to kick yourself?");
					return true;
				}

				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(BattlecraftServer.prefixPunish + ChatColor.RED + args[0] + " isnt online!");
					return true;
				} else {
					target.kickPlayer(BattlecraftServer.prefixPunish + exline + ChatColor.YELLOW
							+ "You have been kicked for......" + exline + ChatColor.YELLOW
							+ "Well, it says that there was no reason for being kicked." + exline + ChatColor.YELLOW
							+ "We believe that this is a mistake, and we are sorry. Join back!");

					Bukkit.broadcastMessage(BattlecraftServer.prefixPunish + target.getDisplayName() + ChatColor.YELLOW
							+ " was kicked by " + sender.getName());
				}
			}
			if (args.length >= 2) {

				Player target = Bukkit.getServer().getPlayer(args[0]);
				String bc = "";
				for (String message : args) {
					if (message.contains(sender.getName())) {
						continue;
					}
					bc = (bc + message + " ");
				}

				target.kickPlayer(BattlecraftServer.prefixPunish + exline + ChatColor.YELLOW
						+ "You have been kicked for......" + exline + ChatColor.GREEN + bc + exline + ChatColor.YELLOW
						+ "This means that its not the end of the world. Join back!");

				Bukkit.broadcastMessage(BattlecraftServer.prefixPunish + target.getDisplayName() + ChatColor.YELLOW
						+ " was kicked by " + sender.getName() + ChatColor.YELLOW + " for " + ChatColor.GREEN + bc);
			}
		}

		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (RanksEnum.getRank((Player) sender).equals(Ranks.MOD)) {
				if (args.length == 0) {
					sender.sendMessage(BattlecraftServer.prefixPunish + ChatColor.RED + "Please specify a player!");
					return true;
				}
				if (args.length == 1) {

					if (args[0].equalsIgnoreCase(sender.getName())) {
						sender.sendMessage(BattlecraftServer.prefixPunish + ChatColor.RED
								+ "Really? Your trying to ban yourself?");
						return true;
					}

					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null) {
						sender.sendMessage("That player isnt online!");
						return true;
					} else {
						target.kickPlayer(BattlecraftServer.prefixPunish + exline + ChatColor.YELLOW
								+ "You have been banned for......" + exline + ChatColor.YELLOW
								+ "Well, it says that there was no reason for being banned." + exline + ChatColor.YELLOW
								+ "Report to " + website + ChatColor.YELLOW + " and submit an appeal!" + exline
								+ ChatColor.YELLOW + "Just be sure to take a screenshot of THIS message!");
						target.setBanned(true);
						Bukkit.broadcastMessage(BattlecraftServer.prefixPunish + target.getDisplayName()
								+ ChatColor.YELLOW + " was banned by " + sender.getName());
						yaml.set(target.getName() + ".banned", true);
						try {
							yaml.save(f);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if (args.length >= 2) {

					Player target = Bukkit.getServer().getPlayer(args[0]);
					String bc = "";
					for (String message : args) {
						if (message.contains(sender.getName())) {
							continue;
						}
						bc = (bc + message + " ");
					}
					target.kickPlayer(BattlecraftServer.prefixPunish + exline + ChatColor.YELLOW
							+ "You have been banned for......" + exline + ChatColor.GREEN + bc + exline
							+ ChatColor.YELLOW + "If you believe that you were wrongfully banned, report it!" + exline
							+ ChatColor.YELLOW + "Go to " + website + ChatColor.YELLOW + " and submit and appeal.");
					Bukkit.broadcastMessage(BattlecraftServer.prefixPunish + target.getDisplayName() + ChatColor.YELLOW
							+ " was banned by " + sender.getName() + ChatColor.YELLOW + " for " + ChatColor.GREEN + bc);
					yaml.set(target.getName() + ".banned", true);
					try {
						yaml.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}
}