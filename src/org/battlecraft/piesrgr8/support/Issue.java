package org.battlecraft.piesrgr8.support;

import java.io.File;
import java.io.IOException;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Issue implements CommandExecutor {

	static File f = new File("plugins/BattlecraftServer/Issues.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	String bg = BattlecraftServer.prefixReport;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("issue")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(bg + ChatColor.RED + "You are not a player!");
				return true;
			}

			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(bg + ChatColor.RED + "If you see an issue with a plugin or a map, "
						+ "report them here! Keep writing your report with this command "
						+ "if you wish to send a report!");
				return true;
			}

			if (args.length >= 1) {

				String bc = "";
				for (String message : args) {
					bc = (bc + message + " ");
				}

				p.sendMessage(bg + ChatColor.GREEN + "Thank you for reporting the issue! Staff has been alerted "
						+ "and they will try the best they can to help solve the issue!");
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
						on.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + "A player has made an issue: "
								+ ChatColor.GREEN + bc);
					}
				}
				yaml.createSection(p.getName());
				yaml.createSection(p.getName() + ".issue");
				yaml.set(p.getName() + ".issue", bc);
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
