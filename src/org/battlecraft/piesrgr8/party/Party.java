package org.battlecraft.piesrgr8.party;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Party {

	BattlecraftServer plugin;

	public Party(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void startParty(Player p) {
		File f = new File("plugins//BattlecraftServer//party//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		yaml.createSection("leader");
		yaml.createSection("roster");
		yaml.set("leader", p.getName());

		List<String> v = new ArrayList<String>();
		v.add(p.getName());
		yaml.set("roster", v);

		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void stopParty(Player p) {
		File f = new File("plugins//BattlecraftServer//party//" + p.getName() + ".yml");
		f.delete();
	}

	public static void stopEveryParty(BattlecraftServer plugin) {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			try {
				p.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<String> getRoster() {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {

			if (!p.exists())
				continue;

			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			try {
				return a.getStringList("roster");
			} catch (Exception e) {
				return Arrays.asList("ERR");
			}
		}
		return null;
	}

	public static List<String> getMembers(Player p1) {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			if (a.getStringList("roster").contains(p1.getName())) {
				try {
					return a.getStringList("roster");
				} catch (Exception e) {
					return Arrays.asList("ERR");
				}
			}
		}
		return null;
	}

	public static String getLeaderName(Player p) {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("roster").contains(p.getName())) {
				try {
					return a.getString("leader");
				} catch (Exception e) {
					return "ERR";
				}
			}
		}
		return "";
	}
	
	@SuppressWarnings("deprecation")
	public static Player getLeader(Player p) {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			Player pl = Bukkit.getServer().getPlayer(a.getString("leader"));
			return pl;
			}
		return null;
	}

	public static boolean isInParty(Player p1) {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			if (a.getStringList("roster").contains(p1.getName()))
				return true;
		}
		return false;
	}

	public static void addPartyMember(Player p, String owner) {
		File f = new File("plugins//BattlecraftServer//party//" + owner + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		List<String> val = yaml.getStringList("roster");
		val.add(p.getName());
		yaml.set("roster", val);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removePartyMember(Player p, String owner) {
		if (!isInParty(p)) {
			File f = new File("plugins//BattlecraftServer//party//" + owner + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			List<String> val = yaml.getStringList("roster");

			val.remove(p.getName());
			yaml.set("roster", val);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Integer partyLength() {
		String path = "plugins//BattlecraftServer//party//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			return a.getStringList("roster").size();
		}
		return null;
	}
}
