package org.battlecraft.piesrgr8.weapons;

import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Weapons implements CommandExecutor {

	BattlecraftServer plugin;

	public Weapons(BattlecraftServer p) {
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// THE BEGGINING OF THE COMMAND!

		if (cmd.getName().equalsIgnoreCase("sword")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "You must be a player!");
				return true;
			}

			if (!sender.hasPermission("bc.sword")) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED
						+ "You dont have permission to recieve swords!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "Please specify a sword #.");
				return true;
			}

			if (args.length == 1) {
				Player p = (Player) sender;
				

				// ************************************************************
				// ***************** THE SWORDS OF THE WORTHY *****************
				// ************************************************************

				if (args[0].equalsIgnoreCase("leg1")) {
					WeapMethod.legendary1(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				if (args[0].equalsIgnoreCase("leg2")) {
					WeapMethod.legendary2(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				if (args[0].equalsIgnoreCase("ex1")) {
					WeapMethod.ex1(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				// ************************************************************
				// ********************* RARE TYPE ITEMS **********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("r1")) {
					WeapMethod.rare1(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				if (args[0].equalsIgnoreCase("rb")) {
					WeapMethod.rarebow(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}
				// ************************************************************
				// ******************** COMMON TYPE ITEMS *********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("uc1")) {
					WeapMethod.uc1(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				if (args[0].equalsIgnoreCase("uc2")) {
					WeapMethod.uc2(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				// ************************************************************
				// ******************* COMMON TYPE ITEMS **********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("c1")) {
					WeapMethod.c1(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}

				if (args[0].equalsIgnoreCase("c2")) {
					WeapMethod.c2(p);
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
							+ " has recieved a sword from the /sword command!");
					return true;
				}
			} else {
				Player p = (Player) sender;
				p.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "That weapon doesn't exist!");
			}
		}
		return true;
	}

	public static ItemStack setMeta(ItemStack material, String name, List<String> lore) {
		if (((material == null) || material.getType() == Material.AIR) || (name == null && lore == null))
			return null;

		ItemMeta im = material.getItemMeta();
		if (name != null)
			im.setDisplayName(name);
		if (lore != null)
			im.setLore(lore);

		material.setItemMeta(im);
		return material;
	}
}