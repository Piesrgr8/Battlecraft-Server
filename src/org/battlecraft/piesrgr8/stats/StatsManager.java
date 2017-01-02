package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StatsManager implements CommandExecutor {

	BattlecraftServer plugin;

	public StatsManager(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("stats")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("<kills : deaths : damage : blocks : itemc>");
				return true;
			}

			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("kills")) {
					p.sendMessage(BattlecraftServer.prefixStats + ChatColor.GREEN + "You have killed "
							+ ChatColor.YELLOW + yaml.getInt("stats.kills") + ChatColor.GREEN + " entities!");
					return true;
				}

				if (args[0].equalsIgnoreCase("deaths")) {
					p.sendMessage(BattlecraftServer.prefixStats + ChatColor.GREEN + "You have died " + ChatColor.YELLOW
							+ yaml.getInt("stats.deaths") + ChatColor.GREEN + " times!");
					return true;
				}

				if (args[0].equalsIgnoreCase("itemc")) {
					p.sendMessage(BattlecraftServer.prefixStats + ChatColor.GREEN + "You have created "
							+ ChatColor.YELLOW + yaml.getInt("stats.itemcreations") + ChatColor.GREEN + " items!");
					return true;
				}

				if (args[0].equalsIgnoreCase("damage1")) {
					p.sendMessage(BattlecraftServer.prefixStats + ChatColor.GREEN + "You have dealt " + ChatColor.YELLOW
							+ yaml.getInt("stats.damagedelt") + ChatColor.GREEN + " damage!");
					return true;
				}

				if (args[0].equalsIgnoreCase("blocks")) {
					p.sendMessage(BattlecraftServer.prefixStats + ChatColor.GREEN + "You have broke " + ChatColor.YELLOW
							+ yaml.getInt("stats.blockbreaks") + ChatColor.GREEN + " blocks!");
					return true;
				}
			}
		}
		return true;
	}

	public static void createStats(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			yaml.createSection("stats");
			yaml.createSection("stats.kills");
			yaml.createSection("stats.deaths");
			yaml.createSection("stats.itemcreations");
			yaml.createSection("stats.damagetaken");
			yaml.createSection("stats.damagedelt");
			yaml.createSection("stats.blockbreaks");
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
