package org.battlecraft.piesrgr8.kitpvp.challenges;

import java.util.ArrayList;
import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Challenges implements Listener {

	public static ArrayList<Player> list = new ArrayList<Player>();
	public static boolean started = false;
	public static Integer num = 0;
	public static Integer num1 = 0;

	public static int id;
	public static int id2;
	public static int multtask;
	public static int singtask;

	static BattlecraftServer plugin;

	public Challenges(BattlecraftServer p) {
		Challenges.plugin = p;
	}

	@EventHandler
	public void test(PlayerChangedWorldEvent e) {
		Player p = e.getPlayer();
		if (p.getWorld().getName().equals("KitPvP")) {
			list.add(p);
		} else if (e.getFrom().getName().equals("KitPvP")) {
			list.remove(p);
			Bukkit.getServer().getScheduler().cancelTasks(plugin);
		}

		if (list.size() == 1) {
			beginC(p);
		} else if (list.size() >= 2) {
			beginC1(p);
		}
	}

	public static void beginC(final Player p) {
		if (multtask != -1) {
			if (started == true) {
				started = false;
			} else

			if (num >= 1) {
				num = 0;
			} else

			if (num1 >= 1) {
				num1 = 0;
			}
			Bukkit.getServer().getScheduler().cancelTask(multtask);
		}

		singtask = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (list.size() == 1) {
					Random r = new Random();
					Integer rand = r.nextInt(2) + 1;

					if (rand == 1) {
						startChalMessage(p, "Kill 10 mobs in the arena!");

						started = true;
						num = 1;
						challengeFail(p);

						if (!SinglePlayerChal.sp.containsKey(p.getName())) {
							SinglePlayerChal.sp.put(p.getName(), 0);
						}
					}

					if (rand == 2) {
						startChalMessage(p, "Kill 10 Creepers in the arena!");

						started = true;
						num = 2;
						challengeFail(p);

						if (!SinglePlayerChal.sp.containsKey(p.getName())) {
							SinglePlayerChal.sp.put(p.getName(), 0);
						}
					}

					if (rand == 3) {
						startChalMessage(p, "Kill 10 Skeletons in the arena!");
						started = true;
						num = 3;
						challengeFail(p);

						if (!SinglePlayerChal.sp.containsKey(p.getName())) {
							SinglePlayerChal.sp.put(p.getName(), 0);
						}
					}

				}
			}
		}, 2400);
	}

	public static void beginC1(final Player p) {
		if (singtask != -1) {
			if (started == true) {
				started = false;
			} else

			if (num >= 1) {
				num = 0;
			} else

			if (num1 >= 1) {
				num1 = 0;
			}

			Bukkit.getServer().getScheduler().cancelTask(singtask);
		}

		multtask = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if (list.size() > 1) {
					// DO SOMETHING
					Random r = new Random();
					Integer rand = r.nextInt(1) + 1;

					if (rand == 1) {
						startChalMessage(p, "Kill 10 mobs in the arena!");
						started = true;
						num1 = 1;
						challengeFail(p);
						ChalScoreboard.createBoard(p);
					}

					if (rand == 2) {
						startChalMessage(p, "Kill 10 Skeletons in the arena!");
						started = true;
						num1 = 2;
						challengeFail(p);
						ChalScoreboard.createBoard(p);
					}
				}
			}
		}, 2400);
	}

	public static void startChalMessage(Player p, String chal) {
		p.sendMessage(ChatColor.RED + "-----------------------------------------");
		p.sendMessage(Color.c("             &6&lCHALLENGE STARTED!"));
		p.sendMessage("");
		p.sendMessage(Color.c("             &a&o" + chal));
		p.sendMessage("");
		p.sendMessage(ChatColor.RED + "-----------------------------------------");
	}

	public static void challengeFail(final Player p) {
		Challenges.id = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			public void run() {
				p.sendMessage("Challenge ended! Nobody won!");
				SinglePlayerChal.sp.clear();
				Challenges.started = false;
				Challenges.num = 0;
				ChalScoreboard.removeBoard();

				if (singtask != -1) {
					beginC(p);
				}

				if (multtask != -1) {
					beginC1(p);
				}

				Bukkit.getServer().getScheduler().cancelTask(Challenges.id);
			}
		}, 6000);
	}
}
