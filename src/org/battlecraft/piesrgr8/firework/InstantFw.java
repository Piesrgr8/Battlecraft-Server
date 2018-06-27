package org.battlecraft.piesrgr8.firework;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class InstantFw implements Listener {
	
	static BattlecraftServer plugin;
	
	public InstantFw(BattlecraftServer p) {
		InstantFw.plugin = p;
	}
	
	public static void instant(Player p) {
		final Firework fw = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
		FireworkEffect effect = FireworkEffect.builder().flicker(true).trail(true).with(Type.BURST).withColor(Color.ORANGE).build();
		FireworkMeta fwm = fw.getFireworkMeta();
		fwm.addEffect(effect);
		fwm.setPower(0);
		fw.setFireworkMeta(fwm);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				fw.detonate();
			}
		}, 5);
	}
}
