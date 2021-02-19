package org.battlecraft.piesrgr8.chat;

import org.bukkit.ChatColor;

public class Fade {

	public enum FadeType {
		BLUE,
		RED,
		GREEN,
		
		DEFAULT
	}
	
	public static String useFade(String s, FadeType e) {
		char[] ch = s.toCharArray();
		String now = "";
		if (e.equals(FadeType.BLUE)) {
			for(int i = 0; i < ch.length; i++) {
				if (i < 5) {
					now = now + ChatColor.BLUE + ch[i];
				} else if (i < 10) {
					now = now + ChatColor.DARK_BLUE + ch[i];
				}
			}
		}
		return now;
	}
	
}

