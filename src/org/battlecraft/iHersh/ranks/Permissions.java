package org.battlecraft.iHersh.ranks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class Permissions {

	BattlecraftServer plugin;

	static HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();

	File f = new File("plugins//BattlecraftServer//permissions.yml");
	YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
	
	public Permissions(BattlecraftServer p) {
		this.plugin = p;
	}

	public void createPermissions() {
		for (Ranks r : RanksEnum.Ranks.values()) {
			if (yaml.contains("groups." + r.name()))
				continue;
			yaml.createSection("groups." + r.name() + ".permissions");
		}
		try {
			yaml.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setupPermissions(Player p) {
		PermissionAttachment attach = p.addAttachment(plugin.getInstance());
		perms.put(p.getUniqueId(), attach);
		loadPermissions(p);
	}

	public void loadPermissions(Player p) {
		PermissionAttachment attach = perms.get(p.getUniqueId());

		for (String groups : yaml.getConfigurationSection("groups").getKeys(false)) {
			for (String permissions : yaml.getStringList("groups." + groups + ".permissions")) {
				attach.setPermission(permissions, true);
				System.out.println("Registered " + permissions);
			}
		}

	}

	public void removePermissions(Player p) {
		if (perms.containsKey(p.getUniqueId())) {
			perms.remove(p.getUniqueId());
		} else {
			System.out.println("Player was not in permissions map!");
			return;
		}
	}
}
