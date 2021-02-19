package org.battlecraft.piesrgr8.shop.material;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.shop.Shop;
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

public class ShopMaterialColorwool implements Listener {

	BattlecraftServer plugin;
	
	static byte plankType2 = 1;
	static byte plankType3 = 2;
	static byte plankType4 = 3;
	static byte plankType5 = 4;
	static byte plankType6 = 5;
	static byte plankType7 = 6;
	static byte plankType8 = 7;
	static byte plankType9 = 8;
	static byte plankType10 = 9;
	static byte plankType11 = 10;
	static byte plankType12 = 11;
	static byte plankType13 = 12;
	static byte plankType14 = 13;
	static byte plankType15 = 14;
	static byte plankType16 = 15;

	public ShopMaterialColorwool(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Shop - Colored Wool");

		// Creating the items and registering them.
		

		ItemStack block1 = new ItemStack(Material.LEGACY_WOOL);
		ItemMeta block_1 = block1.getItemMeta();

		ItemStack block2 = new ItemStack(Material.LEGACY_WOOL, 1, plankType2);
		ItemMeta block_2 = block2.getItemMeta();

		ItemStack block3 = new ItemStack(Material.LEGACY_WOOL, 1, plankType3);
		ItemMeta block_3 = block3.getItemMeta();

		ItemStack block4 = new ItemStack(Material.LEGACY_WOOL, 1, plankType4);
		ItemMeta block_4 = block4.getItemMeta();

		ItemStack block5 = new ItemStack(Material.LEGACY_WOOL, 1, plankType5);
		ItemMeta block_5 = block5.getItemMeta();

		ItemStack block6 = new ItemStack(Material.LEGACY_WOOL, 1, plankType6);
		ItemMeta block_6 = block5.getItemMeta();
		
		ItemStack block7 = new ItemStack(Material.LEGACY_WOOL, 1, plankType7);
		ItemMeta block_7 = block7.getItemMeta();
		
		ItemStack block8 = new ItemStack(Material.LEGACY_WOOL, 1, plankType8);
		ItemMeta block_8 = block8.getItemMeta();
		
		ItemStack block9 = new ItemStack(Material.LEGACY_WOOL, 1, plankType9);
		ItemMeta block_9 = block9.getItemMeta();
		
		ItemStack block10 = new ItemStack(Material.LEGACY_WOOL, 1, plankType10);
		ItemMeta block_10 = block10.getItemMeta();
		
		ItemStack block11 = new ItemStack(Material.LEGACY_WOOL, 1, plankType11);
		ItemMeta block_11 = block11.getItemMeta();
		
		ItemStack block12 = new ItemStack(Material.LEGACY_WOOL, 1, plankType12);
		ItemMeta block_12 = block12.getItemMeta();
		
		ItemStack block13 = new ItemStack(Material.LEGACY_WOOL, 1, plankType13);
		ItemMeta block_13 = block13.getItemMeta();
		
		ItemStack block14 = new ItemStack(Material.LEGACY_WOOL, 1, plankType14);
		ItemMeta block_14 = block14.getItemMeta();
		
		ItemStack block15 = new ItemStack(Material.LEGACY_WOOL, 1, plankType15);
		ItemMeta block_15 = block15.getItemMeta();
		
		ItemStack block16 = new ItemStack(Material.LEGACY_WOOL, 1, plankType16);
		ItemMeta block_16 = block16.getItemMeta();

		ItemStack custom = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta custom1 = custom.getItemMeta();

		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta back1 = back.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		block_1.setDisplayName("1. " + ChatColor.YELLOW + "Wool");
		block_1.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block1.setItemMeta(block_1);

		block_2.setDisplayName("2. " + ChatColor.YELLOW + "Orange Wool");
		block_2.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$4"));
		block2.setItemMeta(block_2);

		block_3.setDisplayName("3. " + ChatColor.YELLOW + "Magenta Wool");
		block_3.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$3"));
		block3.setItemMeta(block_3);

		block_4.setDisplayName("4. " + ChatColor.YELLOW + "Light Blue Wool");
		block_4.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$250"));
		block4.setItemMeta(block_4);

		block_5.setDisplayName("5. " + ChatColor.YELLOW + "Yellow Wool");
		block_5.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$100"));
		block5.setItemMeta(block_5);

		block_6.setDisplayName("6. " + ChatColor.YELLOW + "Lime Wool");
		block_6.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$1000"));
		block6.setItemMeta(block_6);
		
		block_7.setDisplayName("7. " + ChatColor.YELLOW + "Pink Wool");
		block_7.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block7.setItemMeta(block_7);
		
		block_8.setDisplayName("8. " + ChatColor.YELLOW + "Gray Wool");
		block_8.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block8.setItemMeta(block_8);
		
		block_9.setDisplayName("9. " + ChatColor.YELLOW + "Light Gray Wool");
		block_9.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block9.setItemMeta(block_9);
		
		block_10.setDisplayName("10. " + ChatColor.YELLOW + "Cyan Wool");
		block_10.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block10.setItemMeta(block_10);
		
		block_11.setDisplayName("11. " + ChatColor.YELLOW + "Purple Wool");
		block_11.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block11.setItemMeta(block_11);
		
		block_12.setDisplayName("12. " + ChatColor.YELLOW + "Blue Wool");
		block_12.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block12.setItemMeta(block_12);
		
		block_13.setDisplayName("13. " + ChatColor.YELLOW + "Brown Wool");
		block_13.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block13.setItemMeta(block_13);
		
		block_14.setDisplayName("14. " + ChatColor.YELLOW + "Green Wool");
		block_14.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block14.setItemMeta(block_14);
		
		block_15.setDisplayName("15. " + ChatColor.YELLOW + "Red Wool");
		block_15.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block15.setItemMeta(block_15);
		
		block_16.setDisplayName("16. " + ChatColor.YELLOW + "Black Wool");
		block_16.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$5000"));
		block16.setItemMeta(block_16);

		back1.setDisplayName(ChatColor.RED + "Back");
		back.setItemMeta(back1);

		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);

		// Set the items in their places.
		// THEY WILL BE SET IN SETS OF 9's!

		// ITEMS BEING SET
		inv.setItem(0, block1);
		inv.setItem(1, block2);
		inv.setItem(2, block3);
		inv.setItem(3, block4);
		inv.setItem(4, block5);
		inv.setItem(5, block6);

		// RANDOM AIR SLATES
		inv.setItem(6, block7);
		inv.setItem(7, block8);
		inv.setItem(8, block9);
		inv.setItem(9, block10);
		inv.setItem(10, block11);
		inv.setItem(11, block12);
		inv.setItem(12, block13);
		inv.setItem(13, block14);
		inv.setItem(14, block15);
		inv.setItem(15, block16);
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
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, custom);
		inv.setItem(40, custom);
		inv.setItem(41, custom);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);

		// LINE 6 (ITEMS REMOVED FROM THIS LIST)
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
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Shop - Colored Wool"))
			return;
		e.setCancelled(true);

		Player p = (Player) e.getWhoClicked();

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}

		if (e.getCurrentItem().getType().equals(Material.ARROW)) {
			ShopMaterial.openGUI(p);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("1. Wool")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL));
			p.sendMessage(Shop.successfulMessage(p, "Wool", 10));
			Shop.sub(p, 10);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("2.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType2));
			p.sendMessage(Shop.successfulMessage(p, "Orange Wool", 20));
			Shop.sub(p, 20);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("3.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType3));
			p.sendMessage(Shop.successfulMessage(p, "Magenta Wool", 20));
			Shop.sub(p, 20);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("4.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType4));
			p.sendMessage(Shop.successfulMessage(p, "Light Blue Wool", 20));
			Shop.sub(p, 20);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("5.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType5));
			p.sendMessage(Shop.successfulMessage(p, "Yellow Wool", 20));
			Shop.sub(p, 20);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("6.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType6));
			p.sendMessage(Shop.successfulMessage(p, "Lime Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("7.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType7));
			p.sendMessage(Shop.successfulMessage(p, "Pink Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("8.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType8));
			p.sendMessage(Shop.successfulMessage(p, "Gray Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("9.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType9));
			p.sendMessage(Shop.successfulMessage(p, "Light Gray Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("10.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType10));
			p.sendMessage(Shop.successfulMessage(p, "Cyan Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("11.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType11));
			p.sendMessage(Shop.successfulMessage(p, "Purple Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("12.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType12));
			p.sendMessage(Shop.successfulMessage(p, "Blue Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("13.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType13));
			p.sendMessage(Shop.successfulMessage(p, "Brown Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("14.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType14));
			p.sendMessage(Shop.successfulMessage(p, "Green Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("15.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType15));
			p.sendMessage(Shop.successfulMessage(p, "Red Wool", 20));
			Shop.sub(p, 20);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("16.")) {
			Shop.addItem(p, new ItemStack(Material.LEGACY_WOOL, 1, plankType16));
			p.sendMessage(Shop.successfulMessage(p, "Black Wool", 20));
			Shop.sub(p, 20);
		}
	}
}