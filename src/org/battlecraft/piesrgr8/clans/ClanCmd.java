package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ClanCmd implements CommandExecutor {

	BattlecraftServer plugin;

	static ArrayList<Player> val = new ArrayList<Player>();

	public ClanCmd(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		File f1 = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration py = YamlConfiguration.loadConfiguration(f1);

		if (cmd.getName().equalsIgnoreCase("clan")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not a player!");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "Missing Arguments:");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan create <name>");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan edit <tag : name : motd : desc>");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan leave");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan kick <player>");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan tp");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan invite <player>");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan invites");
				p.sendMessage("         " + ChatColor.YELLOW + "/clan details");
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("create")) {
					if (Clans.isInClan(p)) {
						p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW
								+ "You will be renaming your clan to something else if you "
								+ "proceed, we will note how many times you have changed your clan name.");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW
							+ "Now, you must type in a name for your clan! BUT, please make it at least "
							+ ChatColor.GREEN + "10 characters" + ChatColor.YELLOW + " long and not less than "
							+ ChatColor.GREEN + "3 characters!");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What would you like to edit? <tag : name>");
					return true;
				}

				if (args[0].equalsIgnoreCase("kick")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(
							Prefix.prefixClans + ChatColor.YELLOW + "Who are you wanting to kick out of your clan?");
					return true;
				}

				if (args[0].equalsIgnoreCase("leave")) {
					if (!Clans.isInClan(p)) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not in a clan yet!");
						return true;
					}

					if (Clans.isInClan(p)) {
						if (!val.contains(p)) {
							p.sendMessage(
									Prefix.prefixClans + ChatColor.YELLOW + "You are about remove yourself from the "
											+ ChatColor.GREEN + Clans.getClanName(p) + ChatColor.YELLOW
											+ " clan! If you are the owner of this clan, the clan will be completely wiped! You have "
											+ ChatColor.GREEN + "15 seconds" + ChatColor.YELLOW + " to decide!");
							val.add(p);
							resetVal(p);
							return true;
						}

						if (val.contains(p)) {
							p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have removed yourself from the "
									+ ChatColor.YELLOW + Clans.getClanName(p) + ChatColor.GREEN + " clan!");
							Clans.removePlayerFromClan(p, Clans.getOwnerName(p));
							return true;
						}
					}
				}

				if (args[0].equalsIgnoreCase("details")) {
					if (!Clans.isInClan(p)) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not in a clan yet!");
						return true;
					}
					if (Clans.isInClan(p)) {
						p.sendMessage(
								Prefix.prefixClans + ChatColor.YELLOW + "The details of your clan are as follows:");
						p.sendMessage("        " + ChatColor.GREEN + "" + ChatColor.BOLD + "Clan: " + ChatColor.YELLOW
								+ Clans.getClanName(p));
						p.sendMessage("        " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Tag: "
								+ ChatColor.YELLOW + Clans.getClanTag(p));
						p.sendMessage("        " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Owner: "
								+ ChatColor.YELLOW + Clans.getOwnerName(p));
						p.sendMessage("        " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Description: "
								+ ChatColor.YELLOW + Clans.getDesc(p));
						p.sendMessage("        " + ChatColor.GOLD + "" + ChatColor.BOLD + "Motd: " + ChatColor.YELLOW
								+ Clans.getMotd(p));
						p.sendMessage("        " + ChatColor.AQUA + "" + ChatColor.BOLD + "Members: " + ChatColor.YELLOW
								+ Clans.getMembers(p));
						return true;
					}
				}

				if (args[0].equalsIgnoreCase("invite")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}
					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What is the players name?");
					return true;
				}

				if (args[0].equalsIgnoreCase("invites")) {
					ClansGUI.openGUI(p);
					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "Opened!");
					return true;
				}

				if (args[0].equalsIgnoreCase("tp")) {
					if (!Clans.isInClan(p)) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not in a clan yet!");
						return true;
					}
					if (Clans.isInClan(p)) {
						ClansGUI.tpOpenGUI(p);
						p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "Opened!");
						return true;
					}
				}

				if (args[0].equalsIgnoreCase("claimland")) {
					ClanClaim.testClaim(p);
					return true;
				}
			}

			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("create")) {
					if (!Clans.getOwnerName(p).equals(p.getName()) && Clans.isInClan(p)) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED
								+ "You must leave your current clan in order to proceed with this process!");
						return true;
					}

					if (!Clans.isInClan(p)) {

						StringBuilder sb = new StringBuilder();
						String msg;
						for (int i = 1; i < args.length; i++)
							sb.append(args[i]).append("");
						msg = sb.toString();

						if (msg.length() <= 3) {
							p.sendMessage(Prefix.prefixClans + ChatColor.RED
									+ "Your clan name must be at least 10 characters, but no less than 4!");
							return true;
						}

						if (msg.length() > 10) {
							p.sendMessage(Prefix.prefixClans + ChatColor.RED
									+ "Your clan name must be at least 10 characters, but no less than 4!");
							return true;
						}

						/*
						 * if (!yaml.getString("Clan").isEmpty() &&
						 * yaml.getString("Clan").contains(msg)) {
						 * p.sendMessage(Prefix.prefixClans + ChatColor.RED +
						 * "This clan already exists!"); return true; }
						 */

						p.sendMessage(Prefix.prefixClans + ChatColor.GREEN
								+ "You have successfuly created a new clan called " + ChatColor.YELLOW + msg + "!");

						Clans.createYamlClan(p, msg);
						return true;
					}
				}

				if (args[0].equalsIgnoreCase("invite")) {

					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 1; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					OfflinePlayer off = Bukkit.getServer().getOfflinePlayer(msg);
					List<String> l = py.getStringList(p.getName() + ".claninvites");
					l.add(p.getName());
					PlayersYML.setClanInvites(off, l);

					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have invited " + ChatColor.YELLOW + msg
							+ ChatColor.GREEN + " to be in your clan!");

					if (off.isOnline()) {
						// ADD MORE TO THIS LATER!!
						off.getPlayer().sendMessage(Prefix.prefixClans + ChatColor.YELLOW + p.getName()
								+ ChatColor.GREEN + " has invited you to be in their clan!");
					}
				}

				if (args[0].equalsIgnoreCase("kick")) {

					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 1; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					Player pl = Bukkit.getServer().getPlayer(msg);
					if (Clans.isInClan(pl)) {

						Clans.removePlayerFromClan(pl, p.getName());
						p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have kicked " + ChatColor.YELLOW + msg
								+ ChatColor.GREEN + " from your clan!");

						if (pl.isOnline()) {
							// ADD MORE TO THIS LATER!!
							pl.getPlayer().sendMessage(Prefix.prefixClans + ChatColor.YELLOW + p.getName()
									+ ChatColor.RED + " has kicked you from their clan!");
						}
					}
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("tag")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What will the tag be?");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("name")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What will the name be?");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("desc")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What will the description of your clan be?");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("motd")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + "What will the message of the day be?");
					return true;
				}
			}

			if (args.length >= 3) {
				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("tag")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 2; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					if (msg.length() <= 3) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED
								+ "Your clan tag must be at least 10 characters, but no less than 4!");
						return true;
					}

					if (msg.length() > 10) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED
								+ "Your clan tag must be at least 10 characters, but no less than 4!");
						return true;
					}

					Clans.setClanTag(msg);
					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have changed the tag to: "
							+ ChatColor.GRAY + "[" + msg + "]");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("name")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 2; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					if (msg.length() <= 3) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED
								+ "Your clan name must be at least 10 characters, but no less than 4!");
						return true;
					}

					if (msg.length() > 10) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED
								+ "Your clan name must be at least 10 characters, but no less than 4!");
						return true;
					}

					Clans.setClanName(msg);
					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have changed the name of the clan to "
							+ ChatColor.YELLOW + msg + "!");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("desc")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 2; i < args.length; i++)
						sb.append(args[i]).append(" ");
					msg = sb.toString();

					Clans.setDesc(msg);
					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have set the description of the clan to "
							+ ChatColor.YELLOW + msg + "!");
					return true;
				}

				if (args[0].equalsIgnoreCase("edit") && args[1].equalsIgnoreCase("motd")) {
					if (!Clans.getOwnerName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not an owner of a clan! Do "
								+ ChatColor.YELLOW + "/clan create" + ChatColor.RED + " to make one!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 2; i < args.length; i++)
						sb.append(args[i]).append(" ");
					msg = sb.toString();

					Clans.setMotd(msg);
					p.sendMessage(Prefix.prefixClans + ChatColor.GREEN
							+ "You have set the message of the day for the clan to " + ChatColor.YELLOW + msg + "!");
					return true;
				}
			}

		}
		return true;
	}

	public void resetVal(final Player p) {
		if (!val.contains(p)) {
			return;
		}

		if (val.contains(p)) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					try {
						val.remove(p);
					} catch (Exception e) {
						e.getMessage();
					}
				}
			}, 300);
		}
	}
}
