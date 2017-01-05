package org.battlecraft.piesrgr8.staff;

import java.io.File;
import java.io.IOException;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor{
	
	BattlecraftServer plugin;
	
	public Admin(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void sendMessage(String s) {
		for (Player on : Bukkit.getServer().getOnlinePlayers()) {
			if (RanksEnum.isAtLeast(on, Ranks.ADMIN)) {
		on.sendMessage(Prefix.prefixAdmin + ChatColor.WHITE + s);
		on.playSound(on.getLocation(), Sound.BLOCK_NOTE_PLING, 10000, 1);
			}
		}
	}
	
	public static void tasks(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        
		for (@SuppressWarnings("unused") Player on : Bukkit.getServer().getOnlinePlayers()) {
		if (RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
			while (yaml.getInt(p.getName() + ".logins") >= 0) {
			if (yaml.getInt(p.getName() + ".logins") == 10) {
				sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " has logged in " + ChatColor.YELLOW + "10 times!");
			}
			
			if (yaml.getInt(p.getName() + ".logins") == 30) {
				sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " has logged in " + ChatColor.YELLOW + "30 times!");
			}
			
			if (yaml.getInt(p.getName() + ".logins") == 50) {
				sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " has logged in " + ChatColor.YELLOW + "50 times!");
			}
			}
		}
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("admin")) {
			Player p = (Player) sender;
			File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
	        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
	        
			if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
				p.sendMessage(Prefix.prefixAdmin + ChatColor.RED + "You are not an admin on this server!");
				return true;
			}
			
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixAdmin + ChatColor.YELLOW + "<toggle>");
				return true;
			}
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("toggle")) {
					p.sendMessage(Prefix.prefixAdmin + ChatColor.YELLOW + "Toggle what? <msg>");
					return true;
				}
			}
			
			if (args.length == 2) {
				if (args[1].equalsIgnoreCase("msg")) {
					p.sendMessage(Prefix.prefixAdmin + ChatColor.YELLOW + "Yes or No?");
					return true;
				}
			}
			
			if (args.length == 3) {
				if (args[2].equalsIgnoreCase("yes")) {
					if (yaml.contains(p.getName() + ".adminM", false)) {
						try {
							yaml.set(p.getName() + ".adminM", true);
							p.sendMessage(Prefix.prefixAdmin + ChatColor.GREEN + "You will receive admin messages!");
							yaml.save(f);
						}catch (IOException e) {
							p.sendMessage(Prefix.prefixAdmin + ChatColor.RED + "There seems to be an issue with saving!");
							e.printStackTrace();
						}
						return true;
					}
				}
				
				if (args[2].equalsIgnoreCase("no")) {
					if (yaml.contains(p.getName() + ".adminM", true)) {
						try {
							yaml.set(p.getName() + ".adminM", false);
							p.sendMessage(Prefix.prefixAdmin + ChatColor.GREEN + "You will no longer receive admin messages!");
							yaml.save(f);
						}catch (IOException e) {
							p.sendMessage(Prefix.prefixAdmin + ChatColor.RED + "There seems to be an issue with saving!");
							e.printStackTrace();
						}
						return true;
					}
				}
			}
		}
		return true;
	}
}
