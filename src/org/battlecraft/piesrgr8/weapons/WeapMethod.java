package org.battlecraft.piesrgr8.weapons;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class WeapMethod {

	public static void legendary1(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
				ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
						+ "] " + ChatColor.RED + "" + ChatColor.BOLD + "Death Dealer",
				Arrays.asList("This sword is", "for the worthy!"));
		int level = 5;
		newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
		newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
		newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
		p.sendMessage(ChatColor.GOLD + "Right here, master.");
		Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD + " has the "
				+ ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
				+ "] " + ChatColor.RED + "" + ChatColor.BOLD + "Death Dealer");
		
		pi.addItem(newItem);
	}

	public static void legendary2(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
				ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
						+ "] " + ChatColor.RED + "" + ChatColor.BOLD + "The Black Blade",
				Arrays.asList("Death is NOT", "an option!"));
		int level = 5;
		newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
		newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
		newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
		p.sendMessage(ChatColor.GOLD + "Right here, master.");
		Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD + " has the "
				+ ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
				+ "] " + ChatColor.RED + "" + ChatColor.BOLD + "The Black Blade");
		
		pi.addItem(newItem);
	}

	public static void ex1(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
				ChatColor.YELLOW + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "EXOTIC" + ChatColor.YELLOW + "] "
						+ ChatColor.RED + "" + ChatColor.BOLD + "Bread & Butter",
				Arrays.asList("Death is NOT", "an option!"));
		int level = 5;
		newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
		newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
		newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
		Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD + " has the "
				+ ChatColor.YELLOW + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "EXOTIC" + ChatColor.YELLOW + "] "
				+ ChatColor.RED + "" + ChatColor.BOLD + "Bread and Butter");
		
		pi.addItem(newItem);
	}

	public static void rare1(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack karaBela = setMeta(new ItemStack(Material.IRON_SWORD),
				ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
						+ "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Karabela",
				Arrays.asList("Great is the guilt of", "an unecessary war."));
		int level = 3;
		int level2 = 2;
		karaBela.addUnsafeEnchantment(Enchantment.DURABILITY, level2);
		karaBela.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, level);
		p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + ""
				+ ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
				+ "Karabela");
		Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
				+ ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
				+ "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Karabela");
		
		pi.addItem(karaBela);
	}

	public static void rarebow(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack sharpShooter = setMeta(new ItemStack(Material.BOW),
				ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
						+ "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Sharpshooter",
				Arrays.asList("One arrow will equal", "a death wish."));
		int level = 3;
		int level2 = 2;
		sharpShooter.addUnsafeEnchantment(Enchantment.ARROW_FIRE, level);
		sharpShooter.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, level2);
		p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + ""
				+ ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
				+ "Sharpshooter");
		Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
				+ ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE
				+ "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Sharpshooter");
		
		pi.addItem(sharpShooter);
	}

	public static void uc1(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack magnitudeSword = setMeta(new ItemStack(Material.STONE_SWORD),
				ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] "
						+ ChatColor.GREEN + "" + ChatColor.BOLD + "Magnitude",
				Arrays.asList("The supreme art of", "war is to subdue", "the enemy without", "fighting."));
		int level2 = 1;
		magnitudeSword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, level2);
		p.sendMessage(
				ChatColor.BOLD + "You now have the " + ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD
						+ "UNCOMMON" + ChatColor.AQUA + "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Magnitude");
		Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
				+ ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] "
				+ ChatColor.GREEN + "" + ChatColor.BOLD + "Magnitude");
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

		}
		pi.addItem(magnitudeSword);
	}

	public static void uc2(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack coreGreen = setMeta(new ItemStack(Material.STONE_SWORD),
				ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] "
						+ ChatColor.GREEN + "" + ChatColor.BOLD + "Core Green",
				Arrays.asList("Sometimes by losing", "a battle you find", "a new way to", "win the war."));
		int level2 = 1;
		coreGreen.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level2);
		p.sendMessage(
				ChatColor.BOLD + "You now have the " + ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD
						+ "UNCOMMON" + ChatColor.AQUA + "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Core Green");
		Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
				+ ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] "
				+ ChatColor.GREEN + "" + ChatColor.BOLD + "Core Green");
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

		}
		pi.addItem(coreGreen);
	}

	public static void c1(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack vikingSword = setMeta(new ItemStack(Material.STONE_SWORD),
				ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA + "] "
						+ ChatColor.GRAY + "" + ChatColor.BOLD + "Viking Sword",
				Arrays.asList("The best weapon against", "an enemy is another", "enemy."));
		p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + ""
				+ ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD
				+ "Viking Sword");
		Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " recieved the "
				+ ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA
				+ "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "Viking Sword");
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

		}
		pi.addItem(vikingSword);
	}

	public static void c2(Player p) {
		PlayerInventory pi = p.getInventory();
		ItemStack longSword = setMeta(new ItemStack(Material.STONE_SWORD),
				ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA + "] "
						+ ChatColor.GRAY + "" + ChatColor.BOLD + "Longsword",
				Arrays.asList("The object of war is", "not die for your country,", "but to make the other",
						"bastard die for his."));
		p.sendMessage(
				ChatColor.BOLD + "You now have the " + ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD
						+ "COMMON" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "Longsword");
		Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " recieved the "
				+ ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA
				+ "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "Longsword");
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

		}
		pi.addItem(longSword);
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
