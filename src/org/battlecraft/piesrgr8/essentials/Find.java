package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.utils.ErrorUtil;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Find implements CommandExecutor {

	BattlecraftServer plugin;

	public Find(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player tar = Bukkit.getServer().getPlayer(args[0]);
		if (cmd.getName().equalsIgnoreCase("find")) {
			if (RanksEnum.isStaff(p)) {
				if (args.length == 0) {
					p.sendMessage(Prefix.prefixStaff + ChatColor.RED + "Must specify the player name!");
					return true;
				}

				if (args.length == 1) {
					
					if (tar == null) {
						p.sendMessage(Prefix.prefixStaff + ChatColor.RED + "This player has been offline since: "
								+ ChatColor.YELLOW + PlayersYML.getLastLogin(tar));
						return true;
					} else {
						p.sendMessage(Prefix.prefixStaff + ChatColor.YELLOW + tar.getName() + ChatColor.GREEN
								+ " is online in world: " + ChatColor.YELLOW + tar.getLocation().getWorld().getName());
						return true;
					}
				}
			} else {
				ErrorUtil.noRank(p, RanksEnum.getPrefix(RanksEnum.getRank(p)));
				return true;
			}
		}
		return true;
	}
}
