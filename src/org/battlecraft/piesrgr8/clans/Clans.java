package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Clans {

	BattlecraftServer plugin;

	static String err = "ERR";

	public Clans(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void createClans(BattlecraftServer p) {
		if (!new File("plugins//BattlecraftServer//clans//").isDirectory()) {
			try {
				new File("plugins//BattlecraftServer//clans//").mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void createClansAlt() {
		if (!new File("plugins//BattlecraftServer//clans//").isDirectory()) {
			try {
				new File("plugins//BattlecraftServer//clans//").mkdir();
			} catch (Exception e) {
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
		yaml.createSection("desc");
		yaml.createSection("motd");
		List<String> values = new ArrayList<String>();
		values.add(p.getName());
		yaml.set("players", values);
		yaml.set("Owner", p.getName());
		yaml.set("Tag", clanName);
		yaml.set("Clan", clanName);
		yaml.set("desc", "My clan is awesome!");
		yaml.set("motd", "Welcome to the clan!");
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
			} catch (Exception e) {
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

	public static String getDesc(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				try {
					return a.getString("desc");
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}

	public static String getMotd(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				try {
					return a.getString("motd");
				} catch (Exception e) {
					e.getCause().getMessage();
					return "ERR";
				}
			}
		}
		return "";
	}

	public static List<String> getPlayerList(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				return a.getStringList("players");
			}
		}
		return null;
	}
	
	public static boolean isInSameClan(Player p, Player p1) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File f : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(f);
			if (a.getStringList("players").contains(p.getName()) && a.getStringList("players").contains(p1.getName()))
				return true;
		}
		return false;
	}
	
	public static boolean isInExactClan(Player p, String name) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File f : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(f);
			if (a.getString("Clan").equals(name) && a.getStringList("players").contains(p.getName()))
				return true;
		}
		return false;
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
			if (a.getStringList("players").contains(p.getName())) {
				l.remove(p.getName());
				a.set("players", l);
				try {
					a.save(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (p.getName().equals(a.getString("Owner"))) {
				removeClanFile(p.getName());
			}
		}
	}
	
	public static void removeFromClan(String remove, String owner) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			List<String> l = a.getStringList("players");
			if (a.getStringList("players").contains(remove)) {
				l.remove(remove);
				a.set("players", l);
				try {
					a.save(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (remove.equals(a.getString("Owner"))) {
				removeClanFile(remove);
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

	public static void setDesc(String msg) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
				a.set("desc", msg);
				try {
					a.save(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	

	public static void setMotd(String msg) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
				a.set("motd", msg);
				try {
					a.save(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static boolean isOwner(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (p1.getName().equalsIgnoreCase(p.getName()) || a.getString("Owner").equals(p.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static void sendMotd(Player p) {
		String path = "plugins//BattlecraftServer//clans//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration a = YamlConfiguration.loadConfiguration(p1);
			if (a.getStringList("players").contains(p.getName())) {
				p.sendMessage(Prefix.prefixClans + ChatColor.GOLD + "Message of the Day: " + ChatColor.YELLOW + "" + ChatColor.ITALIC + a.getString("motd"));
			}
		}
	}

	private static void removeClanFile(String p) {
		File f = new File("plugins//BattlecraftServer//clans//" + p + ".yml");
		f.delete();
	}
}
