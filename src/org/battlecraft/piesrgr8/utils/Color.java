package org.battlecraft.piesrgr8.utils;

import org.bukkit.ChatColor;

public class Color {
	
	public static String c(String msg) 
	{
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}
}
