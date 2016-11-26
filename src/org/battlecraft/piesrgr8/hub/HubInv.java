package org.battlecraft.piesrgr8.hub;

import org.battlecraft.piesrgr8.essentials.Rulebook;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HubInv {

	public static void hubInv(final Player p) {
		final Inventory inv = p.getInventory();

		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

		final ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = ns.getItemMeta();

		final ItemStack ns1 = new ItemStack(Material.END_CRYSTAL);
		ItemMeta meta1 = ns1.getItemMeta();

		meta.setDisplayName(ChatColor.YELLOW + "Game Selector");
		ns.setItemMeta(meta);

		meta1.setDisplayName(ChatColor.BLUE + "Quick Game");
		ns1.setItemMeta(meta1);

		if (!inv.contains(ns1) && !inv.contains(ns) && !inv.contains(book)) {
		inv.setItem(0, ns);
		inv.setItem(4, Rulebook.rulebook(p));
		inv.setItem(8, ns1);
		}
	}
}
