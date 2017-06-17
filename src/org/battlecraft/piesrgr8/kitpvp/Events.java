package org.battlecraft.piesrgr8.kitpvp;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.minecraft.server.v1_9_R2.EnumParticle;
import net.minecraft.server.v1_9_R2.PacketPlayOutWorldParticles;

public class Events implements Listener{
	
	BattlecraftServer plugin;
	
	public Events(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		final Player p = (Player) e.getEntity();
		final Location loc = p.getLocation();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (p.isDead() && loc.getWorld().getName().equals("KitPvP")) {
					p.setHealth(20);
					p.teleport(loc.getWorld().getSpawnLocation());
				}
			}
		});
		
		if (e.getEntity().isDead() && loc.getWorld().getName().equals("KitPvP")) {
			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
						EnumParticle.FLAME, true, (float) loc.getX(), (float) loc.getY(),
						(float) loc.getZ(), 0, 0, 0, (float) 1, 1, null));
			}
		}
	}

}
