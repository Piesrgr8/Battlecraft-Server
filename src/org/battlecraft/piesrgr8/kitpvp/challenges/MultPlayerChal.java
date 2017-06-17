package org.battlecraft.piesrgr8.kitpvp.challenges;

import java.util.HashMap;
import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MultPlayerChal implements Listener {

	BattlecraftServer plugin;

	public MultPlayerChal(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void chal1(EntityDeathEvent e) {
		final Player p = (Player) e.getEntity().getKiller();
		Random rand = new Random();
		int random = rand.nextInt(Challenges.list.size());
		if (Challenges.list.size() >= 1) {
			if (random == 1) {
				p.sendMessage("Kill 10 mobs in the arena!");
				HashMap<Player, Integer> sp = new HashMap<Player, Integer>();
				if (e.getEntity().isDead() && !e.getEntity().getType().equals(EntityType.PLAYER)) {
					sp.put(p, sp.get(p) + 1);
				}
				if (sp.get(p) == 10) {
					p.sendMessage(p.getName() + " has won the challenge!");
					Bukkit.getServer().getScheduler().cancelTasks(plugin);
					Challenges.beginC(p);
				}
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						p.sendMessage("Challenge ended! Nobody won!");
						Bukkit.getServer().getScheduler().cancelTasks(plugin);
						Challenges.beginC(p);
					}
				}, 6000);
			}

			if (random == 2) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Bukkit.getServer().getScheduler().cancelTasks(plugin);
						Challenges.beginC(p);
					}
				}, 6000);
			}
		}
	}
}
