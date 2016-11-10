package org.battlecraft.piesrgr8.hub;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener{
	
	BattlecraftServer plugin;
	
	public DoubleJump(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onDoubleJump(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals("Hub1")) {
			if(p.getGameMode() == GameMode.CREATIVE) return;
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
			p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 10000, 1);
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getWorld().getName().equals("Hub1")) {
			if((p.getGameMode() != GameMode.CREATIVE) && (p.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) && (!p.isFlying())) {
				p.setAllowFlight(true);
			}
		}
	}
}