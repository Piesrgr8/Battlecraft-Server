package org.battlecraft.piesrgr8.shop.material;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
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
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.Chase.main.API;

public class ShopMaterialStone implements Listener {

	BattlecraftServer plugin;

	public ShopMaterialStone(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Shop - Stone");

		// Creating the items and registering them.

		ItemStack block1 = new ItemStack(Material.STONE);
		ItemMeta block_1 = block1.getItemMeta();

		ItemStack block2 = new ItemStack(Material.COBBLESTONE);
		ItemMeta block_2 = block2.getItemMeta();

		ItemStack block3 = new ItemStack(Material.MOSSY_COBBLESTONE);
		ItemMeta block_3 = block3.getItemMeta();

		ItemStack block4 = new ItemStack(Material.BRICK);
		ItemMeta block_4 = block4.getItemMeta();

		ItemStack block5 = new ItemStack(Material.SMOOTH_BRICK);
		ItemMeta block_5 = block5.getItemMeta();

		byte stoneType1 = 1;
		ItemStack block6 = new ItemStack(Material.SMOOTH_BRICK, 1, stoneType1);
		ItemMeta block_6 = block5.getItemMeta();

		byte stoneType2 = 2;
		ItemStack block7 = new ItemStack(Material.SMOOTH_BRICK, 1, stoneType2);
		ItemMeta block_7 = block5.getItemMeta();

		byte stoneType3 = 3;
		ItemStack block8 = new ItemStack(Material.SMOOTH_BRICK, 1, stoneType3);
		ItemMeta block_8 = block5.getItemMeta();

		ItemStack block9 = new ItemStack(Material.SANDSTONE);
		ItemMeta block_9 = block5.getItemMeta();

		ItemStack block10 = new ItemStack(Material.RED_SANDSTONE);
		ItemMeta block_10 = block5.getItemMeta();

		ItemStack custom = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData());
		ItemMeta custom1 = custom.getItemMeta();

		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta back1 = back.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		block_1.setDisplayName("1. " + ChatColor.YELLOW + "Stone");
		block_1.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block1.setItemMeta(block_1);

		block_2.setDisplayName("2. " + ChatColor.YELLOW + "Cobblestone");
		block_2.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block2.setItemMeta(block_2);

		block_3.setDisplayName("3. " + ChatColor.YELLOW + "Mossy Cobblestone");
		block_3.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block3.setItemMeta(block_3);

		block_4.setDisplayName("4. " + ChatColor.YELLOW + "Brick");
		block_4.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block4.setItemMeta(block_4);

		block_5.setDisplayName("5. " + ChatColor.YELLOW + "Stone Bricks");
		block_5.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block5.setItemMeta(block_5);

		block_6.setDisplayName("6. " + ChatColor.YELLOW + "Mossy Stone Bricks");
		block_6.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block6.setItemMeta(block_6);

		block_7.setDisplayName("7. " + ChatColor.YELLOW + "Cracked Stone Bricks");
		block_7.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block7.setItemMeta(block_7);

		block_8.setDisplayName("8. " + ChatColor.YELLOW + "Chiseled Stone Bricks");
		block_8.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block8.setItemMeta(block_8);

		block_9.setDisplayName("9. " + ChatColor.YELLOW + "Sandstone");
		block_9.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block9.setItemMeta(block_9);

		block_10.setDisplayName("10. " + ChatColor.YELLOW + "Red Sandstone");
		block_10.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + ChatColor.GOLD + "$2"));
		block10.setItemMeta(block_10);

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
		inv.setItem(6, block7);
		inv.setItem(7, block8);
		inv.setItem(8, block9);
		inv.setItem(9, block10);

		// RANDOM AIR SLATES
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

	@EventHandler
	public void onInventoryClick1(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Shop - Stone"))
			return;
		e.setCancelled(true);

		Player p = (Player) e.getWhoClicked();
		PlayerInventory inv = p.getInventory();
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("1.")) {
			inv.addItem(new ItemStack(Material.STONE));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Stone"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$3!");
			API.minBal(p, (double) 3);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("2.")) {
			inv.addItem(new ItemStack(Material.COBBLESTONE));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Cobblestone"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$2!");
			API.minBal(p, (double) 2);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("3.")) {
			inv.addItem(new ItemStack(Material.MOSSY_COBBLESTONE));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Mossy Cobblestone"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$3!");
			API.minBal(p, (double) 3);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("4.")) {
			inv.addItem(new ItemStack(Material.BRICK));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Brick"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$3!");
			API.minBal(p, (double) 3);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("5.")) {
			inv.addItem(new ItemStack(Material.SMOOTH_BRICK));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Stone Bricks"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$3!");
			API.minBal(p, (double) 3);
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("6.")) {
			inv.addItem(new ItemStack(Material.SMOOTH_BRICK, 1, (byte) 1));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Mossy Stone Bricks"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$3!");
			API.minBal(p, (double) 3);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("7.")) {
			inv.addItem(new ItemStack(Material.SMOOTH_BRICK, 1, (byte) 2));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Cracked Stone Bricks"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$2!");
			API.minBal(p, (double) 2);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("8.")) {
			inv.addItem(new ItemStack(Material.SMOOTH_BRICK, 1, (byte) 3));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Chiseled Stone Bricks"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$4!");
			API.minBal(p, (double) 4);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("9.")) {
			inv.addItem(new ItemStack(Material.SANDSTONE));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Sandstone"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$2!");
			API.minBal(p, (double) 2);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("10.")) {
			inv.addItem(new ItemStack(Material.RED_SANDSTONE));
			p.sendMessage(Prefix.prefixShop + ChatColor.GREEN + "You bought " + ChatColor.YELLOW + "Red Sandstone"
					+ ChatColor.GREEN + " for " + ChatColor.GOLD + "$2!");
			API.minBal(p, (double) 2);
		}
		
		if (e.getCurrentItem().getType().equals(Material.ARROW)) {
			ShopMaterial.openGUI(p);
		}
	}

}
