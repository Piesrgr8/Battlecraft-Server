package org.battlecraft.piesrgr8.kitpvp.challenges;

import java.util.HashMap;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.firework.InstantFw;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SinglePlayerChal implements Listener {

	public static final HashMap<String, Integer> sp = new HashMap<String, Integer>();
	static BattlecraftServer plugin;

	public SinglePlayerChal(BattlecraftServer p) {
		SinglePlayerChal.plugin = p;
	}

	@EventHandler
	public void chal1(EntityDeathEvent e) {
		Integer chal1 = 1;
		final Player p = (Player) e.getEntity().getKiller();
		if (Challenges.list.size() != 1 && Challenges.started == false && Challenges.num != chal1) {
			return;
		}

		if (Challenges.list.size() == 1) {
			if (Challenges.started == true && Challenges.num == chal1) {

				if (e.getEntity().isDead() && !(e.getEntity() instanceof Player)) {
					sp.put(p.getName(), sp.get(p.getName()) + 1);
				}

				if (sp.get(p.getName()).equals(10)) {
					p.sendMessage(p.getName() + " has won the challenge!");
					InstantFw.instant(p);
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000, 1);
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					sp.clear();
					Challenges.started = false;
					Challenges.num = 0;
					Challenges.beginC(p);
				}
			}
		}
	}
	
	@EventHandler
	public void chal2(EntityDeathEvent e) {
		Integer chal = 2;
		final Player p = (Player) e.getEntity().getKiller();
		if (Challenges.list.size() != 1 && Challenges.started == false && Challenges.num != chal) {
			return;
		}

		if (Challenges.list.size() == 1) {
			if (Challenges.started == true && Challenges.num == chal) {

				if (e.getEntity().isDead() && e.getEntity() instanceof Creeper && !(e.getEntity() instanceof Player)) {
					sp.put(p.getName(), sp.get(p.getName()) + 1);
				}

				if (sp.get(p.getName()).equals(10)) {
					p.sendMessage(p.getName() + " has won the challenge!");
					InstantFw.instant(p);
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000, 1);
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					sp.clear();
					Challenges.started = false;
					Challenges.num = 0;
					Challenges.beginC(p);
				}
			}
		}
	}
	
	@EventHandler
	public void chal3(EntityDeathEvent e) {
		Integer chal = 3;
		final Player p = (Player) e.getEntity().getKiller();
		if (Challenges.list.size() != 1 && Challenges.started == false && Challenges.num != chal) {
			return;
		}

		if (Challenges.list.size() == 1) {
			if (Challenges.started == true && Challenges.num == chal) {

				if (e.getEntity().isDead() && e.getEntity() instanceof Skeleton && !(e.getEntity() instanceof Player)) {
					sp.put(p.getName(), sp.get(p.getName()) + 1);
				}

				if (sp.get(p.getName()).equals(10)) {
					p.sendMessage(p.getName() + " has won the challenge!");
					InstantFw.instant(p);
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000, 1);
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					sp.clear();
					Challenges.started = false;
					Challenges.num = 0;
					Challenges.beginC(p);
				}
			}
		}
	}
}
