package org.battlecraft.piesrgr8.world;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class WorldTime implements CommandExecutor, Listener {

	BattlecraftServer plugin;

	public WorldTime(BattlecraftServer p) {
		this.plugin = p;
	}

	String[] times = { "day", "night", "noon", "morning", "afternoon" };
	int[] timesN = { 1000, 13000, 6000, 22925, 10000 };

	public static void onTimeChange() {
		World w = null;
		
		if (Bukkit.getServer().getWorld("Campus") != null) {
			w = Bukkit.getServer().getWorld("Campus");
		} else {
			return;
		}

		DateFormat dg = new SimpleDateFormat("HHmm");
		Date date = new Date();
		String rdat = String.valueOf(dg.format(date) + "0");

		int now = Integer.parseInt(rdat);
		now -= 6000;

		if (now < 0)
			now += 24000;

		w.setTime(now);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("time")) {
			World w = p.getLocation().getWorld();
			if (args.length == 0) {
				sender.sendMessage(Color.c(Prefix.prefixWorld + "&eRight now, it is &a" + checkTime(p) + ", "
						+ w.getTime() + " &ein server ticks!"));
				TitleManager.sendTitle(p, ChatColor.GOLD + "" + w.getTime() + " ticks",
						ChatColor.RED + "In the world: " + ChatColor.YELLOW + w.getName(), 60, 0, 0);

				if (RanksEnum.isAtLeast(p, Ranks.ADMIN))
					sender.sendMessage(
							Color.c(Prefix.prefixWorld + "&eIf you want to set the time, use &a/time set {time}!"));
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("set")) {
					if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
						sender.sendMessage(Color
								.c(Prefix.prefixWorld + "&cYou do not have permission to set the time in the world!"));
						return true;
					}

					sender.sendMessage(Color.c(Prefix.prefixWorld + "&eWhat would you like the time to be?"));
					return true;
				}
			}

			if (args.length == 2) {

				if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
					sender.sendMessage(
							Color.c(Prefix.prefixWorld + "&cYou do not have permission to set the time in the world!"));
					return true;
				}

				if (args[1].equalsIgnoreCase(times[0])) {
					w.setTime(timesN[0]);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase(times[1])) {
					w.setTime(timesN[1]);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase(times[2])) {
					w.setTime(timesN[2]);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase(times[3])) {
					w.setTime(timesN[3]);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				if (args[1].equalsIgnoreCase(times[4])) {
					w.setTime(timesN[4]);
					p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
					return true;
				}

				w.setTime(Long.parseLong(args[1]));
				p.sendMessage(Color.c(Prefix.prefixWorld + "&aYou have set the time to " + args[1] + "!"));
				return true;
			}
		}
		return true;
	}

	public static String checkTime(Player p) {
		World w = p.getLocation().getWorld();
		long l = w.getTime();

		if (l >= 6000 && l <= 7500)
			return "noon";
		if (l >= 7501 && l <= 12999)
			return "afternoon";
		if (l >= 13000 && l <= 17999)
			return "night";
		if (l >= 18000 && l <= 22924)
			return "midnight";
		if (l >= 22925 && l <= 24000)
			return "morning";
		if (l >= 0 && l <= 5999)
			return "morning";
		return null;
	}

}
