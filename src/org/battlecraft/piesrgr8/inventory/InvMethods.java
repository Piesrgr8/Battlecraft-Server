package org.battlecraft.piesrgr8.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvMethods {
	
	public static void remove(Inventory inv, Material mat, int amount) {
	for (ItemStack item : inv.getContents()) {
	if (item.getType() == mat && item.getAmount() >= amount) {
	item.setAmount(item.getAmount() - amount);
	return;
	}
	}
	}
	
	@SuppressWarnings("deprecation")
	public static void removeItemStack(Player p, ItemStack it, int amount) {
		it = p.getItemInHand();
		amount = it.getAmount();
		
		if (amount > 1) {
			it.setAmount(amount - 1);
			p.setItemInHand(it);
		}
		
		if (amount == 1) {
			p.setItemInHand(null);
		}
	}
}
