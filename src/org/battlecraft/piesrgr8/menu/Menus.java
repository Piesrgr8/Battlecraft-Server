package org.battlecraft.piesrgr8.menu;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.essentials.PlayerTp;
import org.battlecraft.piesrgr8.hub.Hub;
import org.battlecraft.piesrgr8.shop.Shop;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menus implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public Menus(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Menu");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.BRICK);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.ENDER_CHEST);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta hg1 = hg.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		main1.setDisplayName(ChatColor.YELLOW + "Game Selector");
		main.setItemMeta(main1);

		mg1.setDisplayName(ChatColor.BLUE + "Shop");
		mg.setItemMeta(mg1);

		sw1.setDisplayName(ChatColor.LIGHT_PURPLE + "Player Teleportation");
		sw.setItemMeta(sw1);

		hg1.setDisplayName(ChatColor.RED + "Quick Game");
		hg.setItemMeta(hg1);

		// Set the items in their places.
		// THEY WILL BE SET IN SETS OF 9's!

		// ITEMS BEING SET
		inv.setItem(1, main);
		inv.setItem(3, mg);
		inv.setItem(5, sw);
		inv.setItem(7, hg);

		p.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Menu"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}

		switch (e.getCurrentItem().getType()) {
		case BRICK:
			Hub.openGUI(p);
			break;

		case IRON_PICKAXE:
			Shop.openGUI(p);
			break;

		case ENDER_CHEST:
			if (!p.hasPermission("bc.teleport")) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, (float) 0.5);
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport!");
				e.setCancelled(true);
			}
			PlayerTp.openGUI(p);
			break;

		case REDSTONE_BLOCK:
			NavGame.openGUI(p);
			break;

		default:
			e.setCancelled(true);
			break;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("menu")) {
			Player p = (Player) sender;
			openGUI(p);
			return true;
		}
		return false;
	}
}
