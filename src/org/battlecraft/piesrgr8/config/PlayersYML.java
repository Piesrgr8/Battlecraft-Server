package org.battlecraft.piesrgr8.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.chat.Fade.FadeType;
import org.battlecraft.piesrgr8.chat.Notifications.NotifType;
import org.battlecraft.piesrgr8.utils.online.TimerDaily;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayersYML implements Listener {

	BattlecraftServer plugin;

	public PlayersYML(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler

	// Once a play joins, they will have their file created for them to create a
	// nickname or something.
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!yaml.contains(p.getName())) {
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".ip");
			yaml.createSection(p.getName() + ".muted");
			yaml.createSection(p.getName() + ".logins");
			yaml.createSection(p.getName() + ".nick");
			yaml.createSection(p.getName() + ".fly");
			yaml.createSection(p.getName() + ".adminM");
			yaml.createSection(p.getName() + ".firstJoin");
			yaml.createSection(p.getName() + ".lastLogin");
			yaml.createSection(p.getName() + ".logTime");
			yaml.createSection(p.getName() + ".chatFade");
			yaml.createSection(p.getName() + ".claninvites");
			yaml.createSection(p.getName() + ".partyinvites");
			yaml.createSection(p.getName() + ".messagelist");
			yaml.set(p.getName() + ".muted", false);
			yaml.set(p.getName() + ".fly", false);
			yaml.set(p.getName() + ".adminM", true);
			yaml.set(p.getName() + ".afk", false);
			yaml.set(p.getName() + ".nick", p.getName());
			yaml.set(p.getName() + ".logins", 0);
			yaml.set(p.getName() + ".firstJoin", "log");
			yaml.set(p.getName() + ".lastLogin", "log");
			yaml.set(p.getName() + ".chatFade", "default");
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (!yaml.contains(p.getName() + ".nick")) {
			yaml.createSection(p.getName() + ".nick");
			yaml.set(p.getName() + ".nick", p.getName());
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (!yaml.contains(p.getName() + ".firstJoin")) {
			yaml.createSection(p.getName() + ".firstJoin");
			yaml.set(p.getName() + ".firstJoin", "log");
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (!yaml.contains(p.getName() + ".lastLogin")) {
			yaml.createSection(p.getName() + ".lastLogin");
			yaml.set(p.getName() + ".lastLogin", "log");
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if (!yaml.contains(p.getName() + ".messagelist")) {
			yaml.createSection(p.getName() + ".messagelist");
			yaml.set(p.getName() + ".messagelist", "");
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if (!yaml.contains(p.getName() + ".chatFade")) {
			yaml.createSection(p.getName() + ".chatFade");
			yaml.set(p.getName() + ".chatFade", "default");
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	// List continues with methods for other classes to use so that it sets a
	// value for each section of the yml.
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

	public static void setFly(Player p, boolean b) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!yaml.contains(p.getName() + ".fly")) {
			yaml.set(p.getName() + ".fly", b);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		yaml.set(p.getName() + ".fly", b);
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

	public static void setFirstLogin(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".firstJoin", TimerDaily.getTime());
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setLoginTime(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getString(p.getName() + ".logTime").isEmpty()) {
			yaml.set(p.getName() + ".logTime", "meh");
		}

		yaml.set(p.getName() + ".logTime", TimerDaily.getTime());
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setLastLogin(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".lastLogin", TimerDaily.getFullTime());
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setClanInvites(OfflinePlayer off, List<String> l) {
		File f = new File("plugins//BattlecraftServer//players//" + off.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!yaml.contains(off.getName() + ".claninvites")) {
			yaml.createSection(off.getName() + ".claninvites");
			yaml.set(off.getName() + ".claninvites", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			yaml.set(off.getName() + ".claninvites", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setMessageList(OfflinePlayer p, String m, NotifType et) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		List<String> l = yaml.getStringList(p.getName() + ".messagelist");
		String st = "";
		
		if (et.equals(NotifType.MSG)) 
			st = "[MSG]";
		if (et.equals(NotifType.ADMIN))
			st = "[ADMIN]";
		if (et.equals(NotifType.CRITIC)) 
			st = "[CRITIC]";
		if (et.equals(NotifType.STAFF) && RanksEnum.isOfflinePlayerStaff(p))
			st = "[STAFF]";
		if (et.equals(NotifType.CLANS))
			st = "[CLANS]";
			
		
		if (!yaml.contains(p.getName() + ".messagelist")) {
			yaml.createSection(p.getName() + ".messagelist");
			l.add(st + " " + m);
			yaml.set(p.getName() + ".messagelist", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			l.add(st + " " + m);
			yaml.set(p.getName() + ".messagelist", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setPartyInvites(Player off, List<String> l) {
		File f = new File("plugins//BattlecraftServer//players//" + off.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!yaml.contains(off.getName() + ".partyinvites")) {
			yaml.createSection(off.getName() + ".partyinvites");
			yaml.set(off.getName() + ".partyinvites", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			yaml.set(off.getName() + ".partyinvites", l);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void setIp(Player p, String s) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!yaml.contains(p.getName() + ".ip")) {
			yaml.createSection(p.getName() + ".ip");
			yaml.set(p.getName() + ".ip", s);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			yaml.set(p.getName() + ".ip", s);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setChatFade(Player p, FadeType ft) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		if (yaml.contains(p.getName() + ".chatFade")) {
			if (ft.equals(FadeType.DEFAULT)) {
				yaml.set(p.getName() + ".chatFade", "default");
			} else if (ft.equals(FadeType.BLUE)) {
				yaml.set(p.getName() + ".chatFade", "blue");
			}
		}
	}

	public static boolean getFlySetting(Player p, boolean b) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getBoolean(p.getName() + ".fly") == true) {
			return true;
		}
		return false;
	}

	public static String getLastLogin(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		String s = yaml.getString(p.getName() + ".lastLogin");
		return s;
	}
	
	public static List<String> getMessageList(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		List<String> m = yaml.getStringList(p.getName() + ".messagelist");
		return m;
	}
	
	public static void clearMessageList(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.set(p.getName() + ".messagelist", "");
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean adminToggleEnable(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		if (yaml.getBoolean(p.getName() + ".adminM") == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public static FadeType getChatFade(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		
		if (yaml.getString(p.getName() + ".chatFade").equals("blue")) {
		return FadeType.BLUE;
		}
		return FadeType.DEFAULT;
	}
	
	public static File getFile(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		return f;
	}
	
	public static YamlConfiguration getYaml(Player p) {
		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		return yaml;
	}
}
