package org.battlecraft.piesrgr8.kitpvp;

import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitManager {
	
	BattlecraftServer plugin;
	
	public KitManager(BattlecraftServer p) {
		this.plugin = p;
	}
	
	static String op = ChatColor.GRAY + "[" + ChatColor.RED + "Kit" + ChatColor.BLUE + "PvP" + ChatColor.GRAY + "] " + ChatColor.WHITE;
	
	public static void addDefaultKit(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.DIAMOND_HELMET), op + ChatColor.RED + "Helmet",
				Arrays.asList("This is a helmet", "specifically for KitPvP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.DIAMOND_CHESTPLATE), op + ChatColor.RED + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for KitPvP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.DIAMOND_LEGGINGS), op + ChatColor.RED + "Leggings",
				Arrays.asList("These are leggings", "specifically for KitPvP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.DIAMOND_BOOTS), op + ChatColor.RED + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for KitPvP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.DIAMOND_SWORD), op + ChatColor.RED + "Sword",
				Arrays.asList("This is a sword", "specifically for KitPvP!"));

		p.sendMessage(Prefix.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.RED + ""
				+ ChatColor.BOLD + "KitPvP " + ChatColor.GREEN + "kit!");

		item1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		item6.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item6);
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
