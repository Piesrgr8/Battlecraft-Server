package org.battlecraft.piesrgr8.hub;

import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Launchers implements Listener {

	public static ArrayList<Player> jumpers = new ArrayList<Player>();

	BattlecraftServer plugin;

	public Launchers(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if (e.getTo().getBlock().getRelative(BlockFace.SELF).getType() == Material.STONE_PRESSURE_PLATE
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(6));
			e.getPlayer().setVelocity(
					new Vector(e.getPlayer().getVelocity().getX(), 3.0D, e.getPlayer().getVelocity().getZ()));
			jumpers.add(e.getPlayer());
			e.getPlayer().playSound(e.getTo(), Sound.ENTITY_GENERIC_EXPLODE, 10000, 1);
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getCause() == DamageCause.FALL && jumpers.contains(p)) {
				e.setDamage(0.0);
				jumpers.remove(p);
			}
		}
	}
}
