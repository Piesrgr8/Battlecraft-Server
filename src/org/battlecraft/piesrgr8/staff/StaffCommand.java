package org.battlecraft.piesrgr8.staff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.utils.Debug;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {

	static File f = new File("plugins/BattlecraftServer/staff.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// MAIN COMMAND

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("staff")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(
						Prefix.prefixStaff + ChatColor.RED + "You are not allowed to use this command!");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixStaff + ChatColor.RED + "Arguments Missing!: " + ChatColor.YELLOW
						+ "/staff check, /staff job, /staff list, /staff register");
				return true;
			}

			if (args.length >= 1) {

				if (args[0].equalsIgnoreCase("register")) {
					StaffList.checkStaffList(p);
					try {
						yaml.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}

				if (args[0].equalsIgnoreCase("remove")) {
					StaffList.removeStaff(p);
					p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN
							+ "Removed! If you ever want to have this system, do /staff register!");
					return true;
				}

				if (args[0].equalsIgnoreCase("list")) {
					List<String> pl = new ArrayList<String>();
					pl = yaml.getStringList("players");
					if (pl != null) {
						if (pl.size() >= 1) {
							p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN
									+ "These are the players of honorary mention!");
							Debug.debugConsole(
									"A player used /staff list and there are some people already on that list!");
						}
					} else {
						Debug.debugConsole("A player used /staff list and the list doesnt exist!");
						p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN
								+ "There are no players in the list :(");
					}

					for (int i = 0; i < pl.size(); i++) {
						String s = pl.get(i);
						p.sendMessage("     " + ChatColor.YELLOW + s);
					}
				}

				if (args[0].equalsIgnoreCase("job")) {
					List<String> jobs = new ArrayList<String>();
					jobs = yaml.getStringList(p.getName() + ".jobs");
					if (jobs != null) {
						if (jobs.size() > 0) {
							Debug.debugConsole("A player used /staff job and they have jobs currently available!");
							p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN
									+ "You have jobs that are currently available!");
						}
					} else {
						Debug.debugConsole("A player used /staff job and they are not even on the list!");
						p.sendMessage(Prefix.prefixStaff + ChatColor.GREEN + "You dont have any jobs!");
					}

					for (int i = 0; i < jobs.size(); i++) {
						String s = jobs.get(i);
						p.sendMessage("     " + ChatColor.BLUE + i + ".) " + ChatColor.YELLOW + s);
					}
				}
			}
		}
		return true;
	}
}
