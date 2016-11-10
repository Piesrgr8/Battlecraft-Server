package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Debug;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
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
		
	   try {
		if (!k.getType().equals(EntityType.PLAYER)) {
			Debug.debugConsole("An entity has killed another entity, and they are not players!");
			return;
		}
	   }catch(Exception e1) {
		   e1.getMessage();
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
