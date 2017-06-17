package org.battlecraft.piesrgr8.utils;

import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ErrorUtil {

	public static void cantTeleport(Player p, String msg) {
		p.sendMessage(Prefix.prefixHub + ChatColor.RED + "Can't teleport to " + ChatColor.RED
				+ ChatColor.BOLD + msg);
	}

	public static void noPoll(Player p) {
		p.sendMessage(Prefix.prefixPolls + ChatColor.RED + "There are no polls available at this time!");
	}

	public static void generalError(Player p, String msg, Exception e) {
		p.sendMessage(Prefix.prefixError + ChatColor.RED
				+ "An error has occured with this method. Report it to Piesrgr8!");
		e.printStackTrace();
	}
	
	public static void noRank(Player p, Enum<Ranks> e) {
		p.sendMessage(Prefix.prefixMain + ChatColor.RED + "You must have the " + e + ChatColor.RED + " rank to do this!");
	}
}
