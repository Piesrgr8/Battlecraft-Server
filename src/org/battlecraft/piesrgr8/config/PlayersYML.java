package org.battlecraft.piesrgr8.config;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayersYML implements Listener{
	
	BattlecraftServer plugin;

	public PlayersYML(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	
	//Once a play joins, they will have their file created for them to create a nickname or something.
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
        File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		if (!yaml.contains(p.getName())) {
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".muted");
			yaml.createSection(p.getName() + ".logins");
			yaml.createSection(p.getName() + ".nick");
			yaml.createSection(p.getName() + ".adminM");
			yaml.set(p.getName() + ".muted", false);
			yaml.set(p.getName() + ".adminM", true);
			yaml.set(p.getName() + ".nick", null);
			yaml.set(p.getName() + ".logins", 0);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//List continues with methods for other classes to use so that it sets a value for each section of the yml.
	public static void setMute(Player p, boolean b) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".muted", b);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAdminM(Player p, boolean b) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".adminM", b);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setNick(Player p, String s) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".nick", s);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setLogins(Player p, Integer in) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".logins", yaml.getInt(p.getName() + ".logins") + in);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
