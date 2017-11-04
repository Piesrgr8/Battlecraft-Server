package org.battlecraft.piesrgr8.combat;

import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ForceChoke implements Listener{
	
	static BattlecraftServer plugin;
	public static ArrayList<Player> choke = new ArrayList<Player>();
	public static Location loc = null;
	
	public ForceChoke(BattlecraftServer p) {
		ForceChoke.plugin = p;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (choke.contains(e.getPlayer())) {
			e.setCancelled(true);
		} else {
			return;
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Location ploc = e.getPlayer().getLocation();
		if (choke.contains(e.getPlayer())) {
			if (ploc.getX() != loc.getX()) {
				e.setCancelled(true);
			}
			
			if (ploc.getZ() != loc.getZ()) {
				e.setCancelled(true);
			}
		} else {
			return;
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		if (choke.contains(p)) {
			choke.remove(p);
		} else {
			return;
		}
	}
	
	public static void choke(final Player p) {
		
		if (choke.contains(p)) return;
		
		if (!choke.contains(p)) {
			choke.add(p);
			loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
			p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 80, 1));
		}
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.setHealth(0);
			}
		}, 80);
	}
}
