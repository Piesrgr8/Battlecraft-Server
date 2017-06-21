package org.battlecraft.piesrgr8.kitpvp.challenges;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.firework.InstantFw;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
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
		Integer chal = 1;
		
		if (Challenges.list.size() <= 1 && Challenges.started == false && Challenges.num1 != chal) {
			return;
		}
		
		if (Challenges.list.size() >= 2) {
			if (Challenges.started == true && Challenges.num1 == chal) {

				if (e.getEntity().isDead() && !(e.getEntity() instanceof Player)) {
					ChalScoreboard.setScore(p, 1); // adds one
				}

				if (ChalScoreboard.getScore(p).getScore() == 10) {
					p.sendMessage(p.getName() + " has won the challenge!");
					InstantFw.instant(p);
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000, 1);
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					ChalScoreboard.removeBoard();
					Challenges.started = false;
					Challenges.num1 = 0;
					Challenges.beginC(p);
				}
			}
		}
	}
	
	@EventHandler
	public void chal2(EntityDeathEvent e) {
		final Player p = (Player) e.getEntity().getKiller();
		Integer chal = 2;
		
		if (Challenges.list.size() <= 1 && Challenges.started == false && Challenges.num1 != chal) {
			return;
		}
		
		if (Challenges.list.size() >= 2) {
			if (Challenges.started == true && Challenges.num1 == chal) {

				if (e.getEntity().isDead() && e.getEntity() instanceof Skeleton && !(e.getEntity() instanceof Player)) {
					ChalScoreboard.setScore(p, 1); // adds one
				}

				if (ChalScoreboard.getScore(p).getScore() == 10) {
					p.sendMessage(p.getName() + " has won the challenge!");
					InstantFw.instant(p);
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1000, 1);
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					ChalScoreboard.removeBoard();
					Challenges.started = false;
					Challenges.num1 = 0;
					Challenges.beginC(p);
				}
			}
		}
	}
}
