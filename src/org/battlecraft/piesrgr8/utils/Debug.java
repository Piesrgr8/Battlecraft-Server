package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Debug {

	BattlecraftServer plugin;

	String s;
	DebugType t;

	static String prefix = ChatColor.GOLD + "[Debug] " + ChatColor.WHITE;

	public Debug(BattlecraftServer p) {
		this.plugin = p;
	}

	public static String debugBroadcast(String s) {
		Bukkit.broadcastMessage(prefix + s);
		return s;
	}

	public static String debugConsole(String s) {
		System.out.println(prefix + s);
		return s;
	}

	public Debug(String s, DebugType t) {
		this.s = s;
		this.t = t;
	}

	public DebugType getType() {
		return t;
	}
}
