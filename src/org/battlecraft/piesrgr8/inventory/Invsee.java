package org.battlecraft.piesrgr8.inventory;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Invsee implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.MOD)) {
				p.sendMessage(Prefix.prefixInv + ChatColor.RED
						+ "You dont have permission to see another player's inventory!");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixInv + ChatColor.RED + "Now the players name.");
				return true;
			}

			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);
				Inventory inv = tar.getInventory();
				p.sendMessage(Prefix.prefixInv + ChatColor.GREEN + tar.getName()
							+ "'s inventory has been opened!");
					p.openInventory(inv);
						Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " is inspecting " + ChatColor.YELLOW + tar.getName() + ChatColor.GREEN + "'s inventory!");
					return true;
				}
			}
		return true;
	}
}
