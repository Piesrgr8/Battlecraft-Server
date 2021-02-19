package org.battlecraft.piesrgr8.inventory;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvMethods implements Listener {

	BattlecraftServer plugin;

	public InvMethods(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void remove(Inventory inv, Material mat, int amount) {
		for (ItemStack item : inv.getContents()) {
			if (item.getType() == mat && item.getAmount() >= amount) {
				item.setAmount(item.getAmount() - amount);
				return;
			}
		}
	}
	
	public static ItemStack getItemInHand(Player p, boolean boo) {
		if (boo == true)
			return p.getInventory().getItemInOffHand();
		
		if (boo == false)
			return p.getInventory().getItemInMainHand();
		return null;
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

/*
	@EventHandler
	public void instaBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		PlayerInventory inv = p.getInventory();

		
		if (p.getLocation().getWorld().getName().equals("Factions")) {
			if (inv.firstEmpty() != -1) {
				for (ItemStack item : e.getBlock().getDrops()) {
					inv.addItem(item);
				}

			} else {
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
			}
		}

		if (p.getLocation().getWorld().getName().equals("Prison")) {

			if (inv.firstEmpty() != -1) {
				for (ItemStack item : e.getBlock().getDrops()) {
					inv.addItem(item);
				}

			} else {
				for (int i = 0; i < 35; i++) {
				for (ItemStack item : e.getBlock().getDrops()) {
						if (inv.getItem(i).getAmount() + item.getAmount() <= 64) {
							if (inv.getItem(i).getType().equals(item.getType())) {

								inv.addItem(item);
								break;
							}
						}
				}
						if (i == 34) {
							TitleManager.sendTitle(p, Color.c("&c&l! INVENTORY FULL !"),
									Color.c("&7&lPress &7&l&nSHIFT &7&lto teleport back to mine spawn!"), 100, 0, 0);
							TitleManager.sendActionBar(p, Color.c("&c&lYOUR INVENTORY IS FULL!"), 100, 0, 0);
						}
					}
				}
			}

			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
		} */
	
}
