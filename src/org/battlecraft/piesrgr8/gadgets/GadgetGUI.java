package org.battlecraft.piesrgr8.gadgets;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
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

public class GadgetGUI implements Listener{
	
	BattlecraftServer plugin;
	
	public GadgetGUI(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@SuppressWarnings("deprecation")
	public static void openMainGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Cosmetic Menu");
		
		ItemStack q = new ItemStack(Material.CHEST);
		ItemMeta q1 = q.getItemMeta();
		
		ItemStack w = new ItemStack(Material.DIAMOND_BARDING);
		ItemMeta w1 = w.getItemMeta();
		
		ItemStack custom = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData());
		ItemMeta custom1 = custom.getItemMeta();
		
		q1.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "Weapons");
		q1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Anything that you get from", ChatColor.YELLOW + "chests are saved here!"));
		q.setItemMeta(q1);
		
		w1.setDisplayName(ChatColor.AQUA + "" + ChatColor.ITALIC + "Gadgets");
		w1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Use different items and such", ChatColor.YELLOW + "just for fun!"));
		w.setItemMeta(w1);
		
		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);
		
		// SET 1
		inv.setItem(0, custom);
		inv.setItem(1, custom);
		inv.setItem(2, custom);
		inv.setItem(3, custom);
		inv.setItem(4, custom);
		inv.setItem(5, custom);
		inv.setItem(6, custom);
		inv.setItem(7, custom);
		inv.setItem(8, custom);
		
		// SET 2
		inv.setItem(9, custom);
		inv.setItem(10, q);
		inv.setItem(11, custom);
		inv.setItem(12, custom);
		inv.setItem(13, custom);
		inv.setItem(14, custom);
		inv.setItem(15, custom);
		inv.setItem(16, w);
		inv.setItem(17, custom);
		
		// SET 3
		inv.setItem(18, custom);
		inv.setItem(19, custom);
		inv.setItem(20, custom);
		inv.setItem(21, custom);
		inv.setItem(22, custom);
		inv.setItem(23, custom);
		inv.setItem(24, custom);
		inv.setItem(25, custom);
		inv.setItem(26, custom);
		
		// SET 4
		inv.setItem(27, custom);
		inv.setItem(28, custom);
		inv.setItem(29, custom);
		inv.setItem(30, custom);
		inv.setItem(31, custom);
		inv.setItem(32, custom);
		inv.setItem(33, custom);
		inv.setItem(34, custom);
		inv.setItem(35, custom);
		
		// SET 5
		inv.setItem(36, custom);
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, custom);
		inv.setItem(40, custom);
		inv.setItem(41, custom);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);
		
		// SET 6
		inv.setItem(45, custom);
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
	public void mainGuiListener(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Cosmetic Menu"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		switch(e.getCurrentItem().getType()) {
		
		case CHEST:
			p.sendMessage("Yo1");
			break;
			
		case DIAMOND_BARDING:
			p.sendMessage("Yo2");
			break;
			
		default:
			break;
		}
	}
}
