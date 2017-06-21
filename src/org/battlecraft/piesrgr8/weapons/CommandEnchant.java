package org.battlecraft.piesrgr8.weapons;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandEnchant implements CommandExecutor {

	BattlecraftServer plugin;

	public CommandEnchant(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("enchant")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.ADMIN)) {
				if (!sender.isOp()) {
					sender.sendMessage("You cannot enchant anything since you're not op!");
					return true;
				}

				if (args.length == 0) {
					sender.sendMessage(Prefix.prefixEnchant + ChatColor.YELLOW
							+ "Now hold an item in your hand and type the enchantment id and the level.");
					return true;
				}

				if (args.length == 1) {
					sender.sendMessage(Prefix.prefixEnchant + Enchantment.getByName(args[0]) + ChatColor.RED
							+ " - You must include a level.");
					return true;
				}

				if (args.length >= 2) {
					Player p = (Player) sender;
					ItemStack it = p.getInventory().getItemInHand();

					if (it.equals(Material.AIR)) {
						p.sendMessage(Prefix.prefixEnchant + ChatColor.RED + "You must be holding an item to enchant.");
						return true;
					}

					it.addUnsafeEnchantment(Enchantment.getByName(args[0]), Integer.parseInt(args[1]));
					p.sendMessage(Prefix.prefixEnchant + ChatColor.GREEN + "You have successfully enchanted your "
							+ ChatColor.YELLOW + it.getType());
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " has enchanted their "
							+ ChatColor.YELLOW + it.getType());
					return true;
				}
			}
		}
		return true;
	}
}