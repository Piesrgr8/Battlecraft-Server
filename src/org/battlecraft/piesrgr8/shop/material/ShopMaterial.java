package org.battlecraft.piesrgr8.shop.material;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.shop.Shop;
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

public class ShopMaterial implements Listener {

	BattlecraftServer plugin;

	public ShopMaterial(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Shop - Building Materials");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.OAK_WOOD);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.STONE);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.COAL_BLOCK);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.LEGACY_WOOL, 1, DyeColor.LIME.getDyeData());
		ItemMeta hg1 = hg.getItemMeta();

		ItemStack fc = new ItemStack(Material.LEGACY_STAINED_CLAY, 1, DyeColor.LIME.getDyeData());
		ItemMeta fc1 = fc.getItemMeta();

		ItemStack gm = new ItemStack(Material.GLASS);
		ItemMeta gm1 = gm.getItemMeta();

		ItemStack sb = new ItemStack(Material.OAK_STAIRS);
		ItemMeta sb1 = sb.getItemMeta();

		ItemStack nb = new ItemStack(Material.PURPUR_BLOCK);
		ItemMeta nb1 = nb.getItemMeta();

		ItemStack fn = new ItemStack(Material.OAK_FENCE);
		ItemMeta fn1 = fn.getItemMeta();

		ItemStack un = new ItemStack(Material.SAND);
		ItemMeta un1 = un.getItemMeta();

		ItemStack custom = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta custom1 = custom.getItemMeta();

		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta back1 = back.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		main1.setDisplayName(ChatColor.YELLOW + "Wood");
		main1.setLore(Arrays.asList(ChatColor.YELLOW + "All wood types!",
				ChatColor.GRAY + "Ex: Oak Wood, Oak Planks, Jungle Wood"));
		main.setItemMeta(main1);

		mg1.setDisplayName(ChatColor.YELLOW + "Stone");
		mg1.setLore(Arrays.asList(ChatColor.YELLOW + "All stone types!",
				ChatColor.GRAY + "Ex: Stone, Cobblestone, Stone Brick, Brick"));
		mg.setItemMeta(mg1);

		sw1.setDisplayName(ChatColor.YELLOW + "Resources");
		sw1.setLore(Arrays.asList(ChatColor.YELLOW + "Mineable resources!",
				ChatColor.GRAY + "Ex: Gold, iron, diamond, emerald."));
		sw.setItemMeta(sw1);

		hg1.setDisplayName(ChatColor.YELLOW + "Colored Wool");
		hg1.setLore(Arrays.asList(ChatColor.YELLOW + "Wool with different colors!",
				ChatColor.GRAY + "Ex: Red wool, White wool, Blue wool."));
		hg.setItemMeta(hg1);

		fc1.setDisplayName(ChatColor.YELLOW + "Colored Clay");
		fc1.setLore(Arrays.asList(ChatColor.YELLOW + "Clay with different colors!",
				ChatColor.GRAY + "Ex: Red clay, White clay, Blue clay."));
		fc.setItemMeta(fc1);

		gm1.setDisplayName(ChatColor.YELLOW + "Glass");
		gm1.setLore(Arrays.asList(ChatColor.YELLOW + "Glass blocks or similar to glass!",
				ChatColor.GRAY + "Ex: Glass, Glass pane (Colored), Glowstone"));
		gm.setItemMeta(gm1);

		sb1.setDisplayName(ChatColor.YELLOW + "Stairs");
		sb1.setLore(Arrays.asList(ChatColor.YELLOW + "Blocks used for walking up or down!",
				ChatColor.GRAY + "Ex: Oak Stair, Jungle stair, Birch stair."));
		sb.setItemMeta(sb1);

		nb1.setDisplayName(ChatColor.YELLOW + "New Blocks");
		nb1.setLore(Arrays.asList(ChatColor.YELLOW + "Blocks in 1.9!", ChatColor.GRAY + "Ex: Purpur, Prismarine"));
		nb.setItemMeta(nb1);

		un1.setDisplayName(ChatColor.YELLOW + "Uncategorized");
		un1.setLore(Arrays.asList(ChatColor.YELLOW + "Blocks that haven't been categorized!",
				ChatColor.GRAY + "Ex: Sand, Gravel"));
		un.setItemMeta(un1);

		fn1.setDisplayName(ChatColor.YELLOW + "Fences");
		fn1.setLore(Arrays.asList(ChatColor.YELLOW + "Guard your base with these!",
				ChatColor.GRAY + "Ex: You know what I mean by 'fence'."));
		fn.setItemMeta(fn1);

		back1.setDisplayName(ChatColor.RED + "Back");
		back.setItemMeta(back1);

		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);

		// Set the items in their places.
		// THEY WILL BE SET IN SETS OF 9's!

		// ITEMS BEING SET
		inv.setItem(1, main);
		inv.setItem(3, mg);
		inv.setItem(5, sw);
		inv.setItem(7, hg);
		inv.setItem(19, fc);
		inv.setItem(21, gm);
		inv.setItem(23, sb);
		inv.setItem(25, nb);
		inv.setItem(39, un);
		inv.setItem(41, fn);

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

		// LINE 3 (ITEMS REMOVED FROM THIS LIST)
		inv.setItem(18, custom);
		inv.setItem(20, custom);
		inv.setItem(22, custom);
		inv.setItem(24, custom);
		inv.setItem(26, custom);

		// LINE 4 (ITEMS REMOVED FROM THIS LIST)
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
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(40, custom);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);

		// LINE 6
		inv.setItem(45, back);
		inv.setItem(46, custom);
		inv.setItem(47, custom);
		inv.setItem(48, custom);
		inv.setItem(49, custom);
		inv.setItem(50, custom);
		inv.setItem(51, custom);
		inv.setItem(52, custom);
		inv.setItem(53, custom);

		p.openInventory(inv);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick1(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Shop - Building Materials"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}

		switch (e.getCurrentItem().getType()) {
		case OAK_WOOD:
			ShopMaterialWood.openGUI(p);
			break;

		case STONE:
			ShopMaterialStone.openGUI(p);
			break;

		case COAL_BLOCK:
			ShopMaterialResource.openGUI(p);
			break;

		case WHITE_WOOL:
			ShopMaterialColorwool.openGUI(p);
			break;

		case LEGACY_STAINED_CLAY:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case GLASS:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case OAK_STAIRS:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case PURPUR_BLOCK:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case SAND:
			TitleManager.sendActionBar(p, ChatColor.RED + "This is not available in BETA!");
			break;

		case OAK_FENCE:
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
