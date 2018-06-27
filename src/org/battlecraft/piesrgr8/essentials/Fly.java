package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot fly as a computer!");
				return true;
			}

			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				p.sendMessage(Prefix.prefixMain + ChatColor.RED + "You don't have permission to fly!");
				return true;
			}

			if (PlayersYML.getFlySetting(p, true) || p.getAllowFlight() == true) {
				p.setFlying(false);
				PlayersYML.setFly(p, false);
				p.sendMessage(Prefix.prefixMain + ChatColor.GREEN + "Flying is now " + ChatColor.YELLOW + "disabled!");
				return true;
			} else if (PlayersYML.getFlySetting(p, false) || p.getAllowFlight() == false) {
				p.setFlying(true);
				PlayersYML.setFly(p, true);
				p.sendMessage(Prefix.prefixMain + ChatColor.GREEN + "Flying is now " + ChatColor.YELLOW + "enabled!");
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

}
