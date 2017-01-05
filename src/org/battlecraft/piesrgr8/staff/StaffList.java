package org.battlecraft.piesrgr8.staff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Debug;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StaffList {

	BattlecraftServer plugin;

	static ArrayList<String> staff = new ArrayList<>();

	static File f = new File("plugins/BattlecraftServer/staff.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	public StaffList(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void checkStaffList(Player p) {
		if (yaml.contains(p.getName())) {
			Debug.debugConsole("A staff memeber is on the list already!");
			p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN + "You are on the list!");
		} else {
			Debug.debugConsole("A member is not on the list!");
			p.sendMessage(
					Prefix.prefixStaff + ChatColor.RED + "You are not on the list! Adding to the list...");
			if (p.hasPermission("bc.staff")) {
				registerPlayer(p);
				registerName(p);
				staff.add(p.getName());
				p.sendMessage(
						Prefix.prefixStaff + ChatColor.GREEN + "Congratz on becoming staff on Battlecraft!");
			} else {
				p.sendMessage(Prefix.prefixStaff + ChatColor.RED + "Looks like you are not part of staff!");
			}
		}
	}

	public static void registerPlayer(Player p) {
		yaml.createSection(p.getName());
		yaml.createSection(p.getName() + ".jobs");
		yaml.createSection(p.getName() + ".rank");
		yaml.set(p.getName() + ".rank", "");
		List<String> values = new ArrayList<String>();
		values.add("Look out for suspicious players!");
		values.add("Stay Alert!");
		yaml.set(p.getName() + ".jobs", values);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void registerName(Player p) {
		yaml.createSection("players");
		yaml.set("players", p.getDisplayName());
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removeStaff(Player p) {
		yaml.set(p.getName(), null);
		yaml.set(p.getName() + ".jobs", null);
		yaml.set(p.getName() + ".rank", null);
		List<String> values = new ArrayList<String>();
		values.remove(p.getDisplayName());
		yaml.set("players", values);
		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
