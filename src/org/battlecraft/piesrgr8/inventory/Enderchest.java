package org.battlecraft.piesrgr8.inventory;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Enderchest implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;

			if (args.length == 0) {
				p.openInventory(p.getEnderChest());
				return true;
			}

			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);
				Inventory inv = tar.getEnderChest();
				if (!(tar == null)) {
					p.sendMessage(Prefix.prefixInv + ChatColor.RED + "This player isnt online.");

					p.sendMessage(Prefix.prefixInv + ChatColor.GREEN + tar.getName()
							+ "'s inventory has been opened!");
					p.openInventory(inv);
					return true;
				}
			}
		}
		return true;
	}

}
