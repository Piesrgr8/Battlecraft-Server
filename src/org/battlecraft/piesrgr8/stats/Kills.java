package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Kills implements Listener {

	BattlecraftServer plugin;

	public Kills(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		Player k = (Player) e.getEntity().getKiller();
		
	   if (!(k instanceof Player)) {
		   return;
	   }
	   
		File f = new File("plugins//BattlecraftServer//stats//" + k.getName() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        
		if (e.getEntity().isDead() && f.exists()) {
			yaml.set("stats.kills", yaml.getInt("stats.kills") + 1);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.getMessage();
			}
		}
	}
}
