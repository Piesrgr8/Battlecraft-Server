package org.battlecraft.piesrgr8.shop.tool;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.shop.Shop;
import org.battlecraft.piesrgr8.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopTool implements Listener {

	BattlecraftServer plugin;

	public ShopTool(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Shop - Tools");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.IRON_AXE);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.IRON_SHOVEL);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.NAME_TAG);
		ItemMeta hg1 = hg.getItemMeta();

		ItemStack fc = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta fc1 = fc.getItemMeta();

		ItemStack custom = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta custom1 = custom.getItemMeta();

		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta back1 = back.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		main1.setDisplayName(ChatColor.YELLOW + "Pickaxes");
		main1.setLore(Arrays.asList(ChatColor.YELLOW + "All pickaxes!",
				ChatColor.GRAY + "Ex: Iron pickaxe, Diamond pickaxe."));
		main.setItemMeta(main1);

		mg1.setDisplayName(ChatColor.YELLOW + "Axes");
		mg1.setLore(Arrays.asList(ChatColor.YELLOW + "All axes!",
				ChatColor.GRAY + "Ex: Iron axe, Wooden axe, Diamond axe."));
		mg.setItemMeta(mg1);

		sw1.setDisplayName(ChatColor.YELLOW + "Shovels");
		sw1.setLore(
				Arrays.asList(ChatColor.YELLOW + "All shovels!", ChatColor.GRAY + "Ex: Golden shovel, Iron shovel."));
		sw.setItemMeta(sw1);

		hg1.setDisplayName(ChatColor.YELLOW + "Other");
		hg1.setLore(Arrays.asList(ChatColor.YELLOW + "Tools with different purposes!",
				ChatColor.GRAY + "Ex: Compass, Clock, Shears."));
		hg.setItemMeta(hg1);

		fc1.setDisplayName(ChatColor.YELLOW + "Enchanted Books");
		fc1.setLore(Arrays.asList(ChatColor.YELLOW + "Tool enchantments",
				ChatColor.GRAY + "Ex: Just enchanted books only for tools!"));
		fc.setItemMeta(fc1);

		back1.setDisplayName(ChatColor.RED + "Back");
		back.setItemMeta(back1);

		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);

		// Set the items in their places.
		// THEY WILL BE SET IN SETS OF 9's!

		// ITEMS BEING SET
		inv.setItem(10, main);
		inv.setItem(16, mg);
		inv.setItem(37, sw);
		inv.setItem(49, hg);
		inv.setItem(43, fc);

		// RANDOM AIR SLATES
		inv.setItem(0, custom);
		inv.setItem(1, custom);
		inv.setItem(2, custom);
		inv.setItem(3, custom);
		inv.setItem(4, custom);
		inv.setItem(5, custom);
		inv.setItem(6, custom);
		inv.setItem(7, custom);
		inv.setItem(8, custom);
		inv.setItem(9, custom);
		inv.setItem(11, custom);
		inv.setItem(12, custom);
		inv.setItem(13, custom);
		inv.setItem(14, custom);
		inv.setItem(15, custom);
		inv.setItem(17, custom);

		// LINE 3
		inv.setItem(18, custom);
		inv.setItem(19, custom);
		inv.setItem(20, custom);
		inv.setItem(21, custom);
		inv.setItem(22, custom);
		inv.setItem(23, custom);
		inv.setItem(24, custom);
		inv.setItem(25, custom);
		inv.setItem(26, custom);

		// LINE 4
		inv.setItem(27, custom);
		inv.setItem(28, custom);
		inv.setItem(29, custom);
		inv.setItem(30, custom);
		inv.setItem(31, custom);
		inv.setItem(32, custom);
		inv.setItem(33, custom);
		inv.setItem(34, custom);
		inv.setItem(35, custom);

		// LINE 5 (ITEMS REMOVED FROM THIS LIST)
		inv.setItem(36, custom);
		inv.setItem(38, custom);
		inv.setItem(39, custom);
		inv.setItem(40, custom);
		inv.setItem(41, custom);
		inv.setItem(42, custom);
		inv.setItem(44, custom);

		// LINE 6 (ITEMS REMOVED FROM THIS LIST)
		inv.setItem(45, back);
		inv.setItem(46, custom);
		inv.setItem(47, custom);
		inv.setItem(48, custom);
		inv.setItem(50, custom);
		inv.setItem(51, custom);
		inv.setItem(52, custom);
		inv.setItem(53, custom);

		p.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick1(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Shop - Tools"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}

		switch (e.getCurrentItem().getType()) {
		case IRON_PICKAXE:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case IRON_AXE:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case IRON_SHOVEL:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case NAME_TAG:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case ENCHANTED_BOOK:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case ARROW:
			Shop.openGUI(p);
			break;

		default:
			e.setCancelled(true);
			break;
		}
	}
}