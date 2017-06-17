package org.battlecraft.piesrgr8.shop;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.shop.material.ShopMaterial;
import org.battlecraft.piesrgr8.shop.tool.ShopTool;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Chase.main.API;

public class Shop implements Listener {

	BattlecraftServer plugin;

	public Shop(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Shop");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.BRICK);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.ENDER_CHEST);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta hg1 = hg.getItemMeta();

		ItemStack fc = new ItemStack(Material.IRON_SWORD);
		ItemMeta fc1 = fc.getItemMeta();

		ItemStack gm = new ItemStack(Material.IRON_HOE);
		ItemMeta gm1 = gm.getItemMeta();

		ItemStack sb = new ItemStack(Material.SLIME_BALL);
		ItemMeta sb1 = sb.getItemMeta();

		ItemStack custom = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData());
		ItemMeta custom1 = custom.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		main1.setDisplayName(ChatColor.YELLOW + "Building Materials");
		main.setItemMeta(main1);

		mg1.setDisplayName(ChatColor.BLUE + "Tools");
		mg.setItemMeta(mg1);

		sw1.setDisplayName(ChatColor.LIGHT_PURPLE + "Mystical");
		sw.setItemMeta(sw1);

		hg1.setDisplayName(ChatColor.RED + "Redstone");
		hg.setItemMeta(hg1);

		fc1.setDisplayName(ChatColor.DARK_RED + "Weapons");
		fc.setItemMeta(fc1);

		gm1.setDisplayName(ChatColor.GREEN + "Farming");
		gm.setItemMeta(gm1);

		sb1.setDisplayName(ChatColor.GRAY + "Misc");
		sb.setItemMeta(sb1);

		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);

		// Set the items in their places.
		// THEY WILL BE SET IN SETS OF 9's!

		// ITEMS BEING SET
		inv.setItem(1, main);
		inv.setItem(3, mg);
		inv.setItem(5, sw);
		inv.setItem(7, hg);
		inv.setItem(28, fc);
		inv.setItem(31, gm);
		inv.setItem(34, sb);

		// RANDOM AIR SLATES
		inv.setItem(0, custom);
		inv.setItem(2, custom);
		inv.setItem(4, custom);
		inv.setItem(6, custom);
		inv.setItem(8, custom);
		inv.setItem(9, custom);
		inv.setItem(10, custom);
		inv.setItem(11, custom);
		inv.setItem(12, custom);
		inv.setItem(13, custom);
		inv.setItem(14, custom);
		inv.setItem(15, custom);
		inv.setItem(16, custom);
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

		// LINE 4 (ITEMS REMOVED FROM THIS LIST)
		inv.setItem(27, custom);
		inv.setItem(29, custom);
		inv.setItem(30, custom);
		inv.setItem(32, custom);
		inv.setItem(33, custom);
		inv.setItem(35, custom);

		// LINE 5
		inv.setItem(36, custom);
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, custom);
		inv.setItem(40, custom);
		inv.setItem(41, custom);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);

		// LINE 6
		inv.setItem(45, custom);
		inv.setItem(46, custom);
		inv.setItem(47, custom);
		inv.setItem(48, custom);
		inv.setItem(49, custom);
		inv.setItem(50, custom);
		inv.setItem(51, custom);
		inv.setItem(52, custom);
		inv.setItem(53, custom);
		
		try{
		p.openInventory(inv);
		}catch (Exception e) {
			p.sendMessage("The SHOP inventory couldnt be opened!");
			e.printStackTrace();
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Shop"))
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
			ShopMaterial.openGUI(p);
			break;

		case IRON_PICKAXE:
			ShopTool.openGUI(p);
			break;

		case ENDER_CHEST:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!", 30);
			break;

		case REDSTONE_BLOCK:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!", 30);
			break;

		case IRON_SWORD:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!", 30);
			break;

		case IRON_HOE:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!", 30);
			break;

		case SLIME_BALL:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!", 30);
			break;

		default:
			e.setCancelled(true);
			break;
		}
	}
	
	public static void addItem(Player p, ItemStack it) {
		p.getInventory().addItem(it);
	}
	
	public static String successfulMessage(Player p, String itemName, int i) {
		String m = Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + itemName
				+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$" + i + "!";
		return m;
	}
	
	public static void sub(Player p, double b) {
		API.minBal(p, (double) b);
	}
}
