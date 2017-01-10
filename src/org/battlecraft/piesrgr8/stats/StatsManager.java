package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
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
				p.sendMessage("<kills : deaths : damage1 or damage2 : blocks : itemc : enchants>");
				return true;
			}

			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("kills")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have killed "
							+ ChatColor.YELLOW + yaml.getInt("stats.kills") + ChatColor.GREEN + " entities!");
					return true;
				}

				if (args[0].equalsIgnoreCase("deaths")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have died " + ChatColor.YELLOW
							+ yaml.getInt("stats.deaths") + ChatColor.GREEN + " times!");
					return true;
				}

				if (args[0].equalsIgnoreCase("itemc")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have created "
							+ ChatColor.YELLOW + yaml.getInt("stats.itemcreations") + ChatColor.GREEN + " items!");
					return true;
				}

				if (args[0].equalsIgnoreCase("damage1")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have dealt " + ChatColor.YELLOW
							+ yaml.getInt("stats.damagedelt") + ChatColor.GREEN + " damage!");
					return true;
				}
				
				if (args[0].equalsIgnoreCase("damage2")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have taken " + ChatColor.YELLOW
							+ yaml.getInt("stats.damagetaken") + ChatColor.GREEN + " damage!");
					return true;
				}

				if (args[0].equalsIgnoreCase("blocks")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have broke " + ChatColor.YELLOW
							+ yaml.getInt("stats.blockbreaks") + ChatColor.GREEN + " blocks!");
					return true;
				}
				
				if (args[0].equalsIgnoreCase("enchants")) {
					p.sendMessage(Prefix.prefixStats + ChatColor.GREEN + "You have enchanted " + ChatColor.YELLOW
							+ yaml.getInt("stats.enchants") + ChatColor.GREEN + " items!");
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
			yaml.createSection("stats.enchants");
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Integer getKills(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer kills = yaml.getInt("stats.kills");
		
		return kills;
	}
	
	public static Integer getDeaths(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer deaths = yaml.getInt("stats.deaths");
		
		return deaths;
	}
	
	public static Integer getItemCreations(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer items = yaml.getInt("stats.itemcreations");
		
		return items;
	}
	
	public static Integer getDamageTaken(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer damage1 = yaml.getInt("stats.damagetaken");
		
		return damage1;
	}
	
	public static Integer getDamageDealt(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer damage2 = yaml.getInt("stats.damagedelt");
		
		return damage2;
	}
	
	public static Integer getBlockBreaks(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer blocks = yaml.getInt("stats.blockbreaks");
		
		return blocks;
	}
	
	public static Integer getEnchantedItems(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		Integer enchants = yaml.getInt("stats.enchants");
		
		return enchants;
	}
}
