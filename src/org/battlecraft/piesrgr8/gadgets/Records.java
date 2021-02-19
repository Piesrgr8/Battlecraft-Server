package org.battlecraft.piesrgr8.gadgets;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.ErrorUtil;
import org.battlecraft.piesrgr8.utils.JukeboxUtil;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Records implements CommandExecutor {

	BattlecraftServer plugin;

	public Records(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("jukebox")) {
			if (!RanksEnum.isAtLeast(p, Ranks.VIP)) {
				RanksEnum.sendErrorMessage(Ranks.VIP);
				return true;
			}
			
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixGadget + ChatColor.RED + "You must include the name of the song!");
				p.sendMessage("- " + ChatColor.YELLOW + "13");
				p.sendMessage("- " + ChatColor.YELLOW + "cat");
				p.sendMessage("- " + ChatColor.YELLOW + "blocks");
				p.sendMessage("- " + ChatColor.YELLOW + "chirp");
				p.sendMessage("- " + ChatColor.YELLOW + "far");
				p.sendMessage("- " + ChatColor.YELLOW + "mall");
				p.sendMessage("- " + ChatColor.YELLOW + "mellohi");
				p.sendMessage("- " + ChatColor.YELLOW + "stal");
				p.sendMessage("- " + ChatColor.YELLOW + "strad");
				p.sendMessage("- " + ChatColor.YELLOW + "ward");
				p.sendMessage("- " + ChatColor.YELLOW + "11");
				p.sendMessage("- " + ChatColor.YELLOW + "wait");
				return true;
			}

			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("stop")) {
					try {
						JukeboxUtil.stopRecord(p);
						p.sendMessage(Prefix.prefixGadget + ChatColor.GREEN + "Stopped!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (JukeboxUtil.isPlaying(p)) {
					p.sendMessage(Prefix.prefixGadget + ChatColor.RED
							+ "You cannot play any records until the current song is over!");
					return true;
				}
				
				if (!p.getWorld().getName().equals("Hub1")) {
					p.sendMessage(Prefix.prefixGadget + ChatColor.RED + "You must be in the HUB in order to do this!");
					return true;
				}

				if (args[0].equalsIgnoreCase("chirp")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_4);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "chirp!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("13")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_GOLD_RECORD);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "13!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("cat")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_GREEN_RECORD);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "cat!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("blocks")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_3);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "blocks!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("far")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_5);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "far!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("mall")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_6);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "mall!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("mellohi")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_7);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "mellohi!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("stal")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_8);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "stal!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("strad")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_9);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "strad!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("ward")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_10);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "ward!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("11")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_11);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "11!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}

				if (args[0].equalsIgnoreCase("wait")) {
					try {
						JukeboxUtil.playRecord(p, Material.LEGACY_RECORD_12);
						p.sendMessage(
								Prefix.prefixGadget + ChatColor.GREEN + "Now playing " + ChatColor.YELLOW + "wait!");
					} catch (Exception e) {
						ErrorUtil.generalError(p, e);
					}
				}
			} else {
				ErrorUtil.noRank(p, RanksEnum.getPrefix(Ranks.VIPPLUS));
				return true;
			}
		}
		return true;
	}

}
