package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deaths implements Listener {

	BattlecraftServer plugin;

	public Deaths(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (p.isDead()) {
			yaml.set("stats.deaths", yaml.getInt("stats.deaths") + 1);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
