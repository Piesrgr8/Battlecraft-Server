package org.battlecraft.piesrgr8.kitpvp.challenges;

import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Challenges implements Listener {

	public static ArrayList<Player> list = new ArrayList<Player>();
	public static boolean started = false;
	public static Integer num = 0;
	
	public static int id;
	public static int id2;

	static BattlecraftServer plugin;

	public Challenges(BattlecraftServer p) {
		Challenges.plugin = p;
	}

	@EventHandler
	public void test(PlayerChangedWorldEvent e) {
		Player p = e.getPlayer();
		if (p.getWorld().getName().equals("KitPvP")) {
			list.add(p);
			beginC(p);
		} else if (e.getFrom().getName().equals("KitPvP")) {
			list.remove(p);
			Bukkit.getServer().getScheduler().cancelTasks(plugin);
		}
	}
	
	public static void beginC(final Player p) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (list.size() == 1) {
					p.sendMessage("A challenge has started!");
					p.sendMessage("Kill 10 mobs in the arena!");
					started = true;
					num = 1;
					SinglePlayerChal.challengeFail(p);
					
					if (!SinglePlayerChal.sp.containsKey(p.getName())) {
						SinglePlayerChal.sp.put(p.getName(), 0);
					}
					
					/*
					Random r = new Random();
					Integer rand = r.nextInt(0) + 1;
					
					if (rand == 1) {
						num = 1;
						p.sendMessage("Kill 10 mobs in the arena!");
					}
					
					if (rand == 2) {
						num = 2;
					}
					*/
				}
				if (list.size() > 1) {
					//DO SOMETHING
				}
			}
		}, 2400);
	}
}
