package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Clans {

	BattlecraftServer plugin;
	
	static String err = "ERR";

	public Clans(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void createClans() {
		if (!new File("plugins//BattlecraftServer//clans//").exists()) {
			try {
				new File("plugins//BattlecraftServer//clans//").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createYamlClan(Player p, String clanName) {
		File f = new File("plugins//BattlecraftServer//clans//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		yaml.createSection("Clan");
		yaml.createSection("Owner");
		yaml.createSection("Tag");
		yaml.createSection("players");
		yaml.createSection("NameChanges");
		List<String> values = new ArrayList<String>();
		values.add(p.getName());
		yaml.set("players", values);
		yaml.set("Owner", p.getName());
		yaml.set("Tag", clanName);
		yaml.set("Clan", clanName);
		yaml.set("NameChanges", 0);
		try {
			yaml.save(f);
		} catch (IOException e) {
			p.sendMessage(Prefix.prefixClans + "There seems to be an issue with creating this clan!");
			e.printStackTrace();
		}
	}
	
	public static void saveYML() {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			try {
				a.save(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static YamlConfiguration getYML() {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			try {
				return a;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getClanTag(Player pl) {
		// THANKS TO A DEV WHO FINALLY MADE THIS "SIMPLE" THING HAPPEN!
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			if (a.getStringList("players").contains(pl.getName())) {
				try {
					return a.getString("Tag");
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}

	public static boolean isInClan(Player p1) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p);
			if (a.getStringList("players").contains(p1.getName())) 
				return true;
		}
		return false;
	}
	
	public static String getMembers(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				try {
					return a.getStringList("players").toString();
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}
	
	public static String getOwnerName(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				try {
					return a.getString("Owner");
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}
	
	public static String getClanName(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				try {
					return a.getString("Clan");
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}
	
	public static List<String> getPlayerList() {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			try {
			return a.getStringList("players");
			} catch (Exception e) {
				return Arrays.asList(err);
			}
		}
		return null;
	}
	
	public static void addPlayerToClan(Player p, String owner) {
		File f = new File("plugins//BattlecraftServer//clans//" + owner + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		List<String> l = yaml.getStringList("players");
		
		l.add(p.getName());
		yaml.set("players", l);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void removePlayerFromClan(Player p, String owner) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			List<String> l = a.getStringList("players");
			if (a.getString("Owner").equals(owner) && a.getStringList("players").contains(p.getName())) {
				l.remove(p.getName());
				a.set("players", l);
				try {
					a.save(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (a.getString("Owner").equals(p.getName())) {
				removeClanFile(p);
			}
		}
	}
	
	public static void setNameChanges(int i) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			a.set("NameChanges", a.getInt("NameChanges") + i);
			try {
				a.save(p1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setClanName(String msg) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			a.set("Clan", msg);
			try {
				a.save(p1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setClanTag(String msg) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			a.set("Tag", msg);
			try {
				a.save(p1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void removeClanFile(Player p) {
		File f = new File("plugins//BattlecraftServer//clans//" + p.getName() + ".yml");
		f.delete();
	}
}
