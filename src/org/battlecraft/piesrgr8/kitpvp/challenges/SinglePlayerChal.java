package org.battlecraft.piesrgr8.kitpvp.challenges;

import java.util.HashMap;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
					Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
					sp.clear();
					Challenges.started = false;
					Challenges.num = 0;
					Challenges.beginC(p);
				}
			}
		}
	}

	public static void challengeFail(final Player p) {
		Challenges.id = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage("Challenge ended! Nobody won!");
				Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
				sp.clear();
				Challenges.started = false;
				Challenges.num = 0;
				Challenges.beginC(p);
			}
		}, 6000);
	}
}
