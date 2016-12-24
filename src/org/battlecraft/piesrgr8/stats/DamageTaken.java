package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageTaken implements Listener {

	BattlecraftServer plugin;

	public DamageTaken(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onDamageDelt(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			yaml.set("stats.damagedelt", yaml.getInt("stats.damagedelt") + (int) e.getDamage());
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@EventHandler
	public void onDamageTaken(EntityDamageByEntityEvent e) {
		Entity en = e.getEntity();
		if (en instanceof Player) {
			Player p = (Player) en;
			File f = new File("plugins//BattlecraftServer//stats//" + p.getName() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			yaml.set("stats.damagetaken", yaml.getInt("stats.damagetaken") + (int) e.getDamage());
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
