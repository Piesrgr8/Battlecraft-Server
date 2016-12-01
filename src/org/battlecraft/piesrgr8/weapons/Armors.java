package org.battlecraft.piesrgr8.weapons;

import java.util.Arrays;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

public class Armors implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// THE BEGINNING OF THE COMMAND!

		if (cmd.getName().equalsIgnoreCase("armor")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixWeapons + ChatColor.RED + "Must be a player.");
				return true;
			}

			if (!RanksEnum.isAtLeast((Player) sender, Ranks.ADMIN)) {
				sender.sendMessage(BattlecraftServer.prefixWeapons + ChatColor.RED
						+ "You dont have permission to recieve this armor!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixWeapons + ChatColor.RED + "Please specify an armor #.");
				return true;
			}

			if (args.length == 1) {

				// ##########################################
				// ############# LEGENDARY ##############
				// ##########################################

				if (args[0].equalsIgnoreCase("leg1")) {
					Player p = (Player) sender;
					PlayerInventory pi = p.getInventory();
					ItemStack one = setMeta(new ItemStack(Material.DIAMOND_CHESTPLATE),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
									+ "Man of Steel",
							Arrays.asList("Its a bird!", "Its a plane", "Its the Man of Steel!"));
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "LEGENDARY" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + ""
							+ ChatColor.BOLD + "Man of Steel");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " recieved the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "LEGENDARY" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
							+ "Man of Steel");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(
								new PacketPlayOutCustomSoundEffect("gotitem.legendary", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
					}
					pi.addItem(one);
				}

				if (args[0].equalsIgnoreCase("leg2")) {
					Player p = (Player) sender;
					PlayerInventory pi = p.getInventory();
					ItemStack two = setMeta(new ItemStack(Material.DIAMOND_CHESTPLATE),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
									+ "Black Diamond",
							Arrays.asList("Expensive metal, that can", "protect a single person",
									"from fear and death itself."));
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "LEGENDARY" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + ""
							+ ChatColor.BOLD + "Black Diamond");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " recieved the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "LEGENDARY" + ChatColor.DARK_PURPLE + "] " + ChatColor.RED + "" + ChatColor.BOLD
							+ "Black Diamond");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection.sendPacket(
								new PacketPlayOutCustomSoundEffect("gotitem.legendary", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
					}
					pi.addItem(two);
				}

				// ##########################################
				// ############### RARE #################
				// ##########################################

				if (args[0].equalsIgnoreCase("r1")) {
					Player p = (Player) sender;
					PlayerInventory pi = p.getInventory();
					ItemStack three = setMeta(new ItemStack(Material.IRON_CHESTPLATE),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
									+ "Iron Jacket",
							Arrays.asList("Used in wars that are so", "dangerous, that some players",
									"will experience nightmares", "from wearing them."));
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + ""
							+ ChatColor.BOLD + "Iron Jacket");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " recieved the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "Iron Jacket");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection
								.sendPacket(new PacketPlayOutCustomSoundEffect("gotitem.rare", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
					}
					pi.addItem(three);
				}

				if (args[0].equalsIgnoreCase("r2")) {
					Player p = (Player) sender;
					PlayerInventory pi = p.getInventory();
					ItemStack four = setMeta(new ItemStack(Material.IRON_HELMET),
							ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD + "RARE"
									+ ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Boche",
							Arrays.asList("A helmet with just a little", "bit of power in it, that",
									"most players would have to", "be tested to see if they are safe."));
					four.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
					four.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
					p.sendMessage(ChatColor.BOLD + "You now have the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD
							+ "" + ChatColor.BOLD + "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + ""
							+ ChatColor.BOLD + "Boche");
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + p.getName() + ChatColor.GOLD
							+ " recieved the " + ChatColor.DARK_PURPLE + "[" + ChatColor.GOLD + "" + ChatColor.BOLD
							+ "RARE" + ChatColor.DARK_PURPLE + "] " + ChatColor.GOLD + "" + ChatColor.BOLD + "Boche");
					for (Player player : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) player).getHandle().playerConnection
								.sendPacket(new PacketPlayOutCustomSoundEffect("gotitem.rare", SoundCategory.MASTER,
										player.getLocation().getBlockX(), player.getLocation().getBlockY(),
										player.getLocation().getBlockZ(), 100000.0F, 1.0F));
					}
					pi.addItem(four);
				}
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
