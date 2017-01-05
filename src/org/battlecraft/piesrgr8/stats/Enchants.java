package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class Enchants implements Listener{
	
	BattlecraftServer plugin;
	
	public Enchants(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onItemEnchant(EnchantItemEvent e) {
		Player p = e.getEnchanter();
		
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		yaml.set("stats.enchants", yaml.getInt("stats.enchants") + 1);
		try {
			yaml.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
