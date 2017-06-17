package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Cooldown;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.weapons.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Kits implements CommandExecutor {

	BattlecraftServer plugin;

	public Kits(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(
						Prefix.prefixKit + ChatColor.RED + "You must be a player to do this command!");
				return true;
			}

			final Player p = (Player) sender;
			if (!RanksEnum.isAtLeast(p, Ranks.DEFAULT)) {
				p.sendMessage(Prefix.prefixKit + ChatColor.RED + "You do not have permission to get kits!");
				return true;
			}

			if (args.length <= 0) {
				p.sendMessage(
						Prefix.prefixKit + ChatColor.GREEN + "What kind of kit would you like to use?");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "starter");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "VIP");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "VIP+");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "+VIP+");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "Master");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "Premium");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "Staff");
				p.sendMessage("    " + ChatColor.YELLOW + " - " + ChatColor.WHITE + "Yt");
				return true;
			}

			//So, lets see if they are eligable.
			if (args.length <= 1) {
				if (args[0].equalsIgnoreCase("starter")) {
					if (!RanksEnum.isAtLeast(p, Ranks.DEFAULT)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
						//Looks like they aren't after all.
					}
					
					//If they are part of the cooldown timer list, they will be told how much time they have left.
					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}

					//If everything passed, then give the player the kit, and set the timers for when to remove the player from cooldown.
					Kit.starter(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}
				
				//THE REST IS THE SAAAAME!

				if (args[0].equalsIgnoreCase("vip")) {
					if (!RanksEnum.isAtLeast(p, Ranks.VIP)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.vip(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("vip+")) {
					if (!RanksEnum.isAtLeast(p, Ranks.VIPPLUS)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.vip1(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("+vip+")) {
					if (!RanksEnum.isAtLeast(p, Ranks.PLUSVIPPLUS)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.vip2(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("master")) {
					if (!RanksEnum.isAtLeast(p, Ranks.MASTER)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.master(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("premium")) {
					if (!RanksEnum.isAtLeast(p, Ranks.PREMIUM)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.premium(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("staff")) {
					if (!RanksEnum.isAtLeast(p, Ranks.HELPER)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.staff(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("yt")) {
					if (!p.hasPermission("bc.kit.yt")) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.yt(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}

				if (args[0].equalsIgnoreCase("op")) {
					if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to use this kit!");
						return true;
					}

					if (Cooldown.cooldownTime.containsKey(p)) {
						Cooldown.cooldownMessage(p);
						return true;
					}
					Kit.op(p);
					Cooldown.cooldownTime.put(p, 3600);
					Cooldown.cooldownTask.put(p, new BukkitRunnable() {
						public void run() {
							if (!Cooldown.cooldownTask.containsKey(p) && !Cooldown.cooldownTime.containsKey(p)) {
								cancel();
							}
							Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1);
							if (Cooldown.cooldownTime.get(p) <= 0) {
								Cooldown.cooldownTime.remove(p);
								Cooldown.cooldownTask.remove(p);
								cancel();
							}
						}
					});

					Cooldown.cooldownTask.get(p).runTaskTimer(plugin, 20, 20);

					return true;
				}
				if (args[0].equalsIgnoreCase("reset")) {
					if (!RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
						p.sendMessage(Prefix.prefixKit + ChatColor.RED
								+ "You dont have permission to reset your cooldown!");
						return true;
					}
					
					Cooldown.cooldownTime.put(p, Cooldown.cooldownTime.get(p) - 1000);
					p.sendMessage(Prefix.prefixKit + ChatColor.GREEN + "Cooldown time has been reset!");
					return true;
				}
			}
		}
		return true;
	}
}
