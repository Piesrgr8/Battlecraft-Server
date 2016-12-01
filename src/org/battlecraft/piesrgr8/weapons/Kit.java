package org.battlecraft.piesrgr8.weapons;

import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kit {

	static String vip = ChatColor.GRAY + "[" + ChatColor.GREEN + "VIP" + ChatColor.GRAY + "] " + ChatColor.WHITE;
	static String vip1 = ChatColor.GRAY + "[" + ChatColor.GREEN + "VIP" + ChatColor.GOLD + "+" + ChatColor.GRAY + "] "
			+ ChatColor.WHITE;
	static String vip2 = ChatColor.GRAY + "[" + ChatColor.GOLD + "+" + ChatColor.GREEN + "VIP" + ChatColor.GOLD + "+"
			+ ChatColor.GRAY + "] " + ChatColor.WHITE;
	static String master = ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "MASTER" + ChatColor.GRAY + "] "
			+ ChatColor.WHITE;
	static String premium = ChatColor.GRAY + "[" + "PREMIUM" + ChatColor.GRAY + "] " + ChatColor.WHITE;
	static String staff = ChatColor.GOLD + "[" + ChatColor.DARK_BLUE + "STAFF" + ChatColor.GOLD + "] "
			+ ChatColor.WHITE;
	static String yt = ChatColor.GRAY + "[" + ChatColor.WHITE + "Y" + ChatColor.RED + "T" + ChatColor.GRAY + "] "
			+ ChatColor.WHITE;
	static String op = ChatColor.GRAY + "[" + ChatColor.RED + "OP" + ChatColor.GRAY + "] " + ChatColor.WHITE;

	public static void starter(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.LEATHER_HELMET), ChatColor.GRAY + "Starter Helmet",
				Arrays.asList("This is a helmet specifically", "for beginners!"));

		ItemStack item2 = setMeta(new ItemStack(Material.LEATHER_CHESTPLATE), ChatColor.GRAY + "Starter Chestplate",
				Arrays.asList("This is a chestplate" + " specifically for beginners!"));

		ItemStack item3 = setMeta(new ItemStack(Material.LEATHER_LEGGINGS), ChatColor.GRAY + "Starter Leggings",
				Arrays.asList("These are leggings" + " specifically for beginners!"));

		ItemStack item4 = setMeta(new ItemStack(Material.LEATHER_BOOTS), ChatColor.GRAY + "Starter Boots",
				Arrays.asList("This is a pair of boots" + " specifically for beginners!"));

		ItemStack item5 = setMeta(new ItemStack(Material.STONE_PICKAXE), ChatColor.GRAY + "Starter Pickaxe",
				Arrays.asList("This is a pickaxe" + " specifically for beginners!"));

		ItemStack item6 = setMeta(new ItemStack(Material.STONE_SWORD), ChatColor.GRAY + "Starter Sword",
				Arrays.asList("This is an axe" + " specifically for beginners!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Starter " + ChatColor.GREEN + "kit!");

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void vip(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), vip + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), vip + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), vip + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), vip + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), vip + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), vip + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "VIP " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		item5.addEnchantment(Enchantment.DIG_SPEED, 3);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 2);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void vip1(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), vip1 + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), vip1 + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), vip1 + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), vip1 + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), vip1 + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), vip1 + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "VIP+ " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item5.addEnchantment(Enchantment.DIG_SPEED, 4);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 3);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void vip2(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), vip2 + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), vip2 + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), vip2 + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), vip2 + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), vip2 + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), vip2 + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "+VIP+ " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item5.addEnchantment(Enchantment.DIG_SPEED, 5);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 4);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void master(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), master + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), master + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), master + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), master + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), master + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), master + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Master " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item1.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		item2.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		item3.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		item4.addEnchantment(Enchantment.PROTECTION_FIRE, 2);

		item5.addEnchantment(Enchantment.DIG_SPEED, 5);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item5.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 5);
		item6.addEnchantment(Enchantment.DAMAGE_UNDEAD, 1);
		item6.addEnchantment(Enchantment.KNOCKBACK, 1);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void premium(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), premium + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), premium + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), premium + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), premium + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), premium + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), premium + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Premium " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item1.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
		item2.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
		item3.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
		item4.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
		item5.addEnchantment(Enchantment.DIG_SPEED, 5);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item5.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 4);
		item6.addEnchantment(Enchantment.DAMAGE_UNDEAD, 1);
		item6.addEnchantment(Enchantment.KNOCKBACK, 1);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void staff(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), staff + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), staff + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), staff + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), staff + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), staff + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), staff + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Staff " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item5.addEnchantment(Enchantment.DIG_SPEED, 5);
		item5.addEnchantment(Enchantment.DURABILITY, 3);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 4);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void yt(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.IRON_HELMET), yt + ChatColor.GREEN + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.IRON_CHESTPLATE), yt + ChatColor.GREEN + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.IRON_LEGGINGS), yt + ChatColor.GREEN + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.IRON_BOOTS), yt + ChatColor.GREEN + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.IRON_PICKAXE), yt + ChatColor.GREEN + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.IRON_SWORD), yt + ChatColor.GREEN + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "YT " + ChatColor.GREEN + "kit!");

		item1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item3.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item4.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		item5.addEnchantment(Enchantment.DIG_SPEED, 5);
		item5.addEnchantment(Enchantment.DURABILITY, 4);
		item6.addEnchantment(Enchantment.DAMAGE_ALL, 3);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
		inv.addItem(item6);
	}

	public static void op(Player p) {
		Inventory inv = p.getInventory();

		ItemStack item1 = setMeta(new ItemStack(Material.DIAMOND_HELMET), op + ChatColor.RED + "Helmet",
				Arrays.asList("This is a helmet", "specifically for buyers of VIP!"));

		ItemStack item2 = setMeta(new ItemStack(Material.DIAMOND_CHESTPLATE), op + ChatColor.RED + "Chestplate",
				Arrays.asList("This is a chestplate", "specifically for buyers of VIP!"));

		ItemStack item3 = setMeta(new ItemStack(Material.DIAMOND_LEGGINGS), op + ChatColor.RED + "Leggings",
				Arrays.asList("These are leggings", "specifically for buyers of VIP!"));

		ItemStack item4 = setMeta(new ItemStack(Material.DIAMOND_BOOTS), op + ChatColor.RED + "Boots",
				Arrays.asList("This is a pair of boots", "specifically for buyers of VIP!"));

		ItemStack item5 = setMeta(new ItemStack(Material.DIAMOND_PICKAXE), op + ChatColor.RED + "Pickaxe",
				Arrays.asList("This is a pickaxe", "specifically for buyers of VIP!"));

		ItemStack item6 = setMeta(new ItemStack(Material.DIAMOND_SWORD), op + ChatColor.RED + "Sword",
				Arrays.asList("This is a sword", "specifically for buyers of VIP!"));

		p.sendMessage(BattlecraftServer.prefixKit + ChatColor.GREEN + "You were given the " + ChatColor.RED + ""
				+ ChatColor.BOLD + "OP " + ChatColor.GREEN + "kit!");

		item1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
		item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
		item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
		item4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
		item5.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1000);
		item5.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
		item6.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);

		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		inv.addItem(item4);
		inv.addItem(item5);
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
