package org.battlecraft.piesrgr8.listeners;

import java.util.Random;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BCBlockListener implements Listener {

	public static BattlecraftServer plugin;
	public static Material[] blacklist = { Material.TNT, Material.LAVA };

	Random random = new Random();

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Material block = e.getBlock().getType();
		Player player = e.getPlayer();

		for (Material blocked : blacklist) {
			if (blocked == block) {
				if (player.hasPermission("bc.placeblocked")) {
					continue;
				} else {
					e.setCancelled(true);
					player.sendMessage(ChatColor.RED + "You cannot place this block!");
				}
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(BlockPlaceEvent event) {
		if (!(event.getBlock().getType() == Material.TNT))
			return;
		event.getBlock().setType(Material.AIR);
		event.getBlock().getWorld().spawn(event.getBlock().getLocation().add(0.5, 0, 0.5), TNTPrimed.class);
	}
}