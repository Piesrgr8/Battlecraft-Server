package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class ItemCreations implements Listener {

	BattlecraftServer plugin;

	public ItemCreations(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onCreation(CraftItemEvent e) {

		Player p = (Player) e.getWhoClicked();

		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set("stats.itemcreations", yaml.getInt("stats.itemcreations") + 1);
		try {
			yaml.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
