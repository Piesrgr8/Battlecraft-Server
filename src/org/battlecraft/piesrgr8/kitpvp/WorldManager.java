package org.battlecraft.piesrgr8.kitpvp;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.PlayerInventory;

public class WorldManager implements Listener {

	BattlecraftServer plugin;

	public WorldManager(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onSwitch(PlayerChangedWorldEvent e) {
		final Player p = e.getPlayer();
		final PlayerInventory inv = p.getInventory();

		if (p.getWorld().getName().equals("KitPvP")) {

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					if (inv.contains(Material.DIAMOND_CHESTPLATE) || inv.contains(Material.DIAMOND_SWORD)) {
						return;
					} else {
						KitManager.addDefaultKit(p);
					}
				}
			}, 55);
		}
	}
}
