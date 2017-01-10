package org.battlecraft.piesrgr8.config;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.clans.Clans;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigMg {

	//Register all of the ymls so that any class can use them.
	public static File issue = new File("plugins//BattlecraftServer//issues.yml");
	public static YamlConfiguration issueY = YamlConfiguration.loadConfiguration(issue);

	public static File report = new File("plugins//BattlecraftServer//reports.yml");
	public static YamlConfiguration reportY = YamlConfiguration.loadConfiguration(report);
	
	public static File warp = new File("plugins//BattlecraftServer//warps.yml");
	public static YamlConfiguration warpY = YamlConfiguration.loadConfiguration(warp);
	
	public static File spawn = new File("plugins//BattlecraftServer//spawns.yml");
	public static YamlConfiguration spawnY = YamlConfiguration.loadConfiguration(spawn);
	
	public static File poll = new File("plugins//BattlecraftServer//polls.yml");
	public static YamlConfiguration pollY = YamlConfiguration.loadConfiguration(poll);
	
	public static File staff = new File("plugins//BattlecraftServer//staff.yml");
	public static YamlConfiguration staffY = YamlConfiguration.loadConfiguration(staff);
	
	public static File console = new File("plugins//BattlecraftServer//console.yml");
	public static YamlConfiguration consoleY = YamlConfiguration.loadConfiguration(console);

	BattlecraftServer plugin;

	public ConfigMg(BattlecraftServer p) {
		this.plugin = p;
	}

	//This is not really important to the class.
	public void saveConfig(String name, FileConfiguration config) {
		if (!name.endsWith(".yml")) {
			name = name + ".yml";
		}

		File file = new File(plugin.getDataFolder(), name);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//We will save everything if this method is used.
	public static void saveEverything(BattlecraftServer plugin) {
		saveIssueYaml(plugin);
		saveReportYaml(plugin);
		saveWarpYaml(plugin);
		saveSpawnYaml(plugin);
		savePollYaml(plugin);
		saveStaffYaml(plugin);
		saveConsoleYaml(plugin);
		Clans.createClans();
	}

	//Then the list continues, saving every individual yml.
	public static void saveIssueYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "issues.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "issues.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			issueY.save(issue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveReportYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "reports.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "reports.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			reportY.save(report);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveWarpYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "warps.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "warps.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			warpY.save(warp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveSpawnYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "spawns.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "spawns.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			spawnY.save(spawn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void savePollYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "polls.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "polls.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			pollY.save(poll);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveStaffYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "staff.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "staff.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			staffY.save(staff);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveConsoleYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "console.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "console.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			consoleY.save(console);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
