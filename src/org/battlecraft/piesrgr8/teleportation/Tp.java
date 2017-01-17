package org.battlecraft.piesrgr8.teleportation;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Tp {
	
	public static void setupWarp(Player p, String name) {
		File f = new File("plugins//BattlecraftServer//warps//" + name + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		yaml.createSection(name);
		yaml.createSection(name + ".world");
		yaml.createSection(name + ".xPos");
		yaml.createSection(name + ".yPos");
		yaml.createSection(name + ".zPos");
		yaml.set(name + ".world", p.getLocation().getWorld().getName());
		yaml.set(name + ".xPos", p.getLocation().getBlockX());
		yaml.set(name + ".yPos", p.getLocation().getBlockY());
		yaml.set(name + ".zPos", p.getLocation().getBlockZ());
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteWarp(String name) {
		File f = new File("plugins//BattlecraftServer//warps//" + name + ".yml");
		f.delete();
	}
	
	public static YamlConfiguration getYaml(String n) {
		File f = new File("plugins//BattlecraftServer//warps//" + n + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		return yaml;
	}
	
	public static File getFolder() {
		File f = new File("plugins//BattlecraftServer//warps//");
		return f;
	}
	
	public static boolean isAWarp(String n) {
		File f = new File("plugins//BattlecraftServer//warps//" + n + ".yml");
		if (f.getName().equals(n)) {
			return true;
		}
		return false;
	}
}
