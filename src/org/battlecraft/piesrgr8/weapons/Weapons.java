package org.battlecraft.piesrgr8.weapons;

import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_9_R2.PacketPlayOutCustomSoundEffect;
import net.minecraft.server.v1_9_R2.SoundCategory;

public class Weapons implements CommandExecutor {

	BattlecraftServer plugin;

	public Weapons(BattlecraftServer p) {
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// THE BEGGINING OF THE COMMAND!

		if (cmd.getName().equalsIgnoreCase("sword")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "You must be a player!");
				return true;
			}

			if (!sender.hasPermission("bc.sword")) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED
						+ "You dont have permission to recieve swords!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "Please specify a sword #.");
				return true;
			}

			if (args.length == 1) {
				Player p = (Player) sender;
				PlayerInventory pi = p.getInventory();
				
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
						+ " has recieved a sword from the /sword command!");
				

				// ************************************************************
				// ***************** THE SWORDS OF THE WORTHY *****************
				// ************************************************************

				if (args[0].equalsIgnoreCase("leg1")) {
					ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
									+ "Death Dealer",
							Arrays.asList("This sword is", "for the worthy!"));
					int level = 5;
					newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
					newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
					newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
					p.sendMessage(ChatColor.GOLD + "Right here, master.");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " has the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
							+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD + "Death Dealer");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(
								new PacketPlayOutCustomSoundEffect("gotitem.legendary", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));

					}
					pi.addItem(newItem);
				}

				if (args[0].equalsIgnoreCase("leg2")) {
					ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
									+ "The Black Blade",
							Arrays.asList("Death is NOT", "an option!"));
					int level = 5;
					newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
					newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
					newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
					p.sendMessage(ChatColor.GOLD + "Right here, master.");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " has the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
							+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD + "The Black Blade");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(
								new PacketPlayOutCustomSoundEffect("gotitem.legendary", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
					}
					pi.addItem(newItem);
				}

				if (args[0].equalsIgnoreCase("ex1")) {
					ItemStack newItem = setMeta(new ItemStack(Material.DIAMOND_SWORD),
							ChatColor.YELLOW + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "EXOTIC" + ChatColor.YELLOW
									+ "] " + ChatColor.RED + "" + ChatColor.BOLD + "Bread & Butter",
							Arrays.asList("Death is NOT", "an option!"));
					int level = 5;
					newItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
					newItem.addUnsafeEnchantment(Enchantment.DURABILITY, level);
					newItem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " has the " + ChatColor.YELLOW + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "EXOTIC"
							+ ChatColor.YELLOW + "] " + ChatColor.RED + "" + ChatColor.BOLD + "Bread and Butter");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection
								.sendPacket(new PacketPlayOutCustomSoundEffect("gotitem.rank", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
						PacketUtil.sendTitle(plugin, player,
								ChatColor.DARK_RED + "" + ChatColor.BOLD + p.getName() + ChatColor.RED
										+ " earned an EXOTIC item!",
								ChatColor.YELLOW + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "EXOTIC"
										+ ChatColor.YELLOW + "] " + ChatColor.RED + "" + ChatColor.BOLD
										+ "Bread and Butter");
					}
					pi.addItem(newItem);
				}

				// ************************************************************
				// ********************* RARE TYPE ITEMS **********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("r1")) {
					ItemStack karaBela = setMeta(new ItemStack(Material.IRON_SWORD),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Karabela",
							Arrays.asList("Great is the guilt of", "an unecessary war."));
					int level = 3;
					int level2 = 2;
					karaBela.addUnsafeEnchantment(Enchantment.DURABILITY, level2);
					karaBela.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, level);
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + ""
							+ ChatColor.BOLD + "Karabela");
					Bukkit.broadcastMessage(
							ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
									+ ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Karabela");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection
								.sendPacket(new PacketPlayOutCustomSoundEffect("gotitem.rare", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));

					}
					pi.addItem(karaBela);
				}

				if (args[0].equalsIgnoreCase("rb")) {
					ItemStack sharpShooter = setMeta(new ItemStack(Material.BOW),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
									+ "Sharpshooter",
							Arrays.asList("One arrow will equal", "a death wish."));
					int level = 3;
					int level2 = 2;
					sharpShooter.addUnsafeEnchantment(Enchantment.ARROW_FIRE, level);
					sharpShooter.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, level2);
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + ""
							+ ChatColor.BOLD + "Sharpshooter");
					Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN
							+ " recieved the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "Sharpshooter");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection
								.sendPacket(new PacketPlayOutCustomSoundEffect("gotitem.rare", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));

					}
					pi.addItem(sharpShooter);
				}
				// ************************************************************
				// ******************** COMMON TYPE ITEMS *********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("uc1")) {
					ItemStack magnitudeSword = setMeta(new ItemStack(Material.STONE_SWORD),
							ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA
									+ "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Magnitude",
							Arrays.asList("The supreme art of", "war is to subdue", "the enemy without", "fighting."));
					int level2 = 1;
					magnitudeSword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, level2);
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.AQUA + "[" + ChatColor.GREEN + ""
							+ ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] " + ChatColor.GREEN + ""
							+ ChatColor.BOLD + "Magnitude");
					Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN
							+ " recieved the " + ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD
							+ "UNCOMMON" + ChatColor.AQUA + "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Magnitude");
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

					}
					pi.addItem(magnitudeSword);
				}

				if (args[0].equalsIgnoreCase("uc2")) {
					ItemStack coreGreen = setMeta(new ItemStack(Material.STONE_SWORD),
							ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA
									+ "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Core Green",
							Arrays.asList("Sometimes by losing", "a battle you find", "a new way to", "win the war."));
					int level2 = 1;
					coreGreen.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level2);
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.AQUA + "[" + ChatColor.GREEN + ""
							+ ChatColor.BOLD + "UNCOMMON" + ChatColor.AQUA + "] " + ChatColor.GREEN + ""
							+ ChatColor.BOLD + "Core Green");
					Bukkit.broadcastMessage(
							ChatColor.GREEN + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " recieved the "
									+ ChatColor.AQUA + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON"
									+ ChatColor.AQUA + "] " + ChatColor.GREEN + "" + ChatColor.BOLD + "Core Green");
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

					}
					pi.addItem(coreGreen);
				}

				// ************************************************************
				// ******************* COMMON TYPE ITEMS **********************
				// ************************************************************

				if (args[0].equalsIgnoreCase("c1")) {
					ItemStack vikingSword = setMeta(new ItemStack(Material.STONE_SWORD),
							ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON"
									+ ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD
									+ "Viking Sword",
							Arrays.asList("The best weapon against", "an enemy is another", "enemy."));
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + ""
							+ ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "Viking Sword");
					Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY
							+ " recieved the " + ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD
							+ "COMMON" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD
							+ "Viking Sword");
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

					}
					pi.addItem(vikingSword);
				}

				if (args[0].equalsIgnoreCase("c2")) {
					ItemStack longSword = setMeta(new ItemStack(Material.STONE_SWORD),
							ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON"
									+ ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "Longsword",
							Arrays.asList("The object of war is", "not die for your country,", "but to make the other",
									"bastard die for his."));
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + ""
							+ ChatColor.BOLD + "COMMON" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "Longsword");
					Bukkit.broadcastMessage(
							ChatColor.GRAY + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY + " recieved the "
									+ ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + "COMMON"
									+ ChatColor.DARK_AQUA + "] " + ChatColor.GRAY + "" + ChatColor.BOLD + "Longsword");
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100000.0F, 1.0F);

					}
					pi.addItem(longSword);
				}
			} else {
				Player p = (Player) sender;
				p.sendMessage(Prefix.prefixWeapons + ChatColor.RED + "That weapon doesn't exist!");
			}
		}
		return true;
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