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

	public static void debug(DebugType t, String s) {
		if (t.equals(DebugType.START)) {
			System.out.println("Debugging the " + s + " method!");
		} else

		if (t.equals(DebugType.END)) {
			System.out.println("Ending of the " + s + " method!");
		} else {
			System.out.println("No debug type specified!");
		}
	}

	public static String startDebugMsg(String s) {
		System.out.println("Debug started with the " + s + " function!");
		return s;
	}

	public static String stopDebugMsg(String s) {
		System.out.println("Debug ended with the " + s + " function!");
		return s;
	}
}
