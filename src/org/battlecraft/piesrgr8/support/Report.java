package org.battlecraft.piesrgr8.support;

import java.io.File;
import java.io.IOException;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {

	static File f = new File("plugins/BattlecraftServer/reports.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	String bg = Prefix.prefixReport;

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(bg + ChatColor.RED + "You are not a player!");
				return true;
			}

			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(bg + ChatColor.RED + "This feature is for reporting players who are behaving terribly. "
						+ "Please continue the command with their name and the reason why they are getting reported.");
				return true;
			}

			Player tar = Bukkit.getServer().getPlayer(args[0]);
			if (args.length == 1) {
				if (tar == null) {
					p.sendMessage(bg + ChatColor.RED
							+ "This player isnt online. If you are reporting this player, remind staff!");
					return true;
				}
				if (tar.getName().equalsIgnoreCase(args[0])) {
					p.sendMessage(bg + ChatColor.RED + "Please continue the report. "
							+ "Having their name only will not help us with the report.");
					return true;
				}
			}

			if (args.length >= 2) {
				StringBuilder sb = new StringBuilder();
				String msg;
				for(int i = 1; i < args.length; i++)
    					sb.append(args[i]).append(" ");
				msg = sb.toString();

				p.sendMessage(bg + ChatColor.GREEN + "Thank you! The report has been saved in our "
						+ "records and has alerted staff members!");
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (RanksEnum.isStaff(on)) {
						on.sendMessage(Prefix.prefixStaff + ChatColor.YELLOW + "A player has reported "
								+ args[0] + " for: " + ChatColor.GREEN + msg);
					}
				}
				yaml.createSection(args[0]);
				yaml.createSection(args[0] + ".report");
				yaml.set(args[0] + ".report", msg);
				try {
					yaml.save(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return true;
	}
}
