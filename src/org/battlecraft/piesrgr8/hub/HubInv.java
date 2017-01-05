package org.battlecraft.piesrgr8.hub;

import org.battlecraft.piesrgr8.essentials.Rulebook;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HubInv {

	@SuppressWarnings("deprecation")
	public static void hubInv(final Player p) {
		
		String right = ChatColor.GRAY + "(Right-Click)";
		
		final Inventory inv = p.getInventory();

		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

		final ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = ns.getItemMeta();

		final ItemStack ns1 = new ItemStack(Material.END_CRYSTAL);
		ItemMeta meta1 = ns1.getItemMeta();
		
		final ItemStack ns2 = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
		ItemMeta meta2 = ns2.getItemMeta();

		meta.setDisplayName(ChatColor.YELLOW + "Game Selector " + right);
		ns.setItemMeta(meta);

		meta1.setDisplayName(ChatColor.BLUE + "Quick Game " + right);
		ns1.setItemMeta(meta1);
		
		meta2.setDisplayName(ChatColor.GREEN + "Vanish Players " + right);
		ns2.setItemMeta(meta2);

		if (!inv.contains(ns1) && !inv.contains(ns) && !inv.contains(book) && !inv.contains(ns2)) {
		inv.setItem(0, ns);
		inv.setItem(4, Rulebook.rulebook(p));
		inv.setItem(7, ns2);
		inv.setItem(8, ns1);
		}
	}
}
