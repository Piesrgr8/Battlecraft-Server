package org.battlecraft.piesrgr8.utils;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Skulls implements CommandExecutor {

	BattlecraftServer plugin;

	public Skulls(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("skull")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixSkull + ChatColor.RED + "You are not a player!");
				return true;
			}

			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.MOD)) {
				p.sendMessage(
						BattlecraftServer.prefixSkull + ChatColor.RED + "You dont have permission to receive a skull.");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixSkull + ChatColor.YELLOW + "Must include a name");
				return true;
			}

			if (args.length == 1) {
				OfflinePlayer tar = Bukkit.getServer().getOfflinePlayer(args[0]);
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(tar.getName());
				meta.setDisplayName(tar.getName() + "'s head");
				skull.setItemMeta(meta);
				try {
					p.getInventory().addItem(skull);
				} catch (Exception e) {
					p.sendMessage(BattlecraftServer.prefixSkull + ChatColor.DARK_RED
							+ "There seems to be an issue with your inventory.");
					e.printStackTrace();
				}
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " has received "
						+ ChatColor.YELLOW + tar.getName() + ChatColor.GREEN + "'s head!");
				p.sendMessage(BattlecraftServer.prefixSkull + ChatColor.GREEN + "Added a head to your inventory!");
			}
		}
		return true;
	}
}
