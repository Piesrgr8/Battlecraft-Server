package org.battlecraft.piesrgr8.party;

import java.io.File;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PartyCmd implements CommandExecutor {

	BattlecraftServer plugin;

	public PartyCmd(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		File f1 = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration py = YamlConfiguration.loadConfiguration(f1);

		if (cmd.getName().equalsIgnoreCase("party")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixParty + ChatColor.RED + "Missing Arguments!:");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party start");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party stop");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party leave");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party roster");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party invite");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party invites");
				p.sendMessage(ChatColor.YELLOW + "            " + "/party kick");
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("start")) {
					if (Party.isInParty(p)) {
						Party.startParty(p);
						p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW
								+ "You have reset your current party! Everyone that was in your party has now left!");
						
					} else {

					Party.startParty(p);
					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN
							+ "You have successfully created a party! Now use " + ChatColor.YELLOW
							+ "/party invite <name>" + ChatColor.GREEN + " to invite people to your party!");
					return true;
				}
				}

				if (args[0].equalsIgnoreCase("stop")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party!");
						return true;
					}
					
					if (!Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW + "The neccessary command for this is /party leave!");
						return true;
					}
					
					Party.stopParty(p);
					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN + "You have successfully stopped the party!");
					return true;
				}

				if (args[0].equalsIgnoreCase("leave")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party!");
						return true;
					}

					if (Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW
								+ "The neccessary command for this is /party stop.");
						return true;
					}

					Party.removePartyMember(p, Party.getLeaderName(p));
					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN + "You have left the party!");
					//TODO
					return true;
				}

				if (args[0].equalsIgnoreCase("roster")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party!");
						return true;
					}

					if (Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW + Party.getMembers(p));
						return true;
					}
				}

				if (args[0].equalsIgnoreCase("invite")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party yet! You must do "
								+ ChatColor.YELLOW + "/party start" + ChatColor.RED + " in order to invite players!");
						return true;
					}

					if (!Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not the leader of the party!");
						return true;
					}
					p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW + "What is the players name?");
					return true;
				}
				
				if (args[0].equalsIgnoreCase("kick")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party!");
						return true;
					}
					
					if (!Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not the leader of the party!");
						return true;
					}
					
					p.sendMessage(Prefix.prefixParty + ChatColor.YELLOW + "Who do you want to kick?");
					return true;
				}

				if (args[0].equalsIgnoreCase("invites")) {
					PartyGUI.openGUI(p);
					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN + "Opened!");
					return true;
				}
			}

			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("invite")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party yet! You must do "
								+ ChatColor.YELLOW + "/party start" + ChatColor.RED + " in order to invite players!");
						return true;
					}

					if (!Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not the leader of the party!");
						return true;
					}

					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 1; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					Player off = Bukkit.getServer().getPlayer(msg);
					List<String> l = py.getStringList(p.getName() + ".partyinvites");
					l.add(p.getName());
					PlayersYML.setPartyInvites(off, l);

					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN + "You have invited " + ChatColor.YELLOW + msg
							+ ChatColor.GREEN + " to be in your party!");

					if (off.isOnline()) {
						// ADD MORE TO THIS LATER!!
						off.getPlayer().sendMessage(Prefix.prefixParty + ChatColor.YELLOW + p.getName()
								+ ChatColor.GREEN + " has invited you to be in their party!");
					}
				}
				
				if (args[0].equalsIgnoreCase("kick")) {
					if (!Party.isInParty(p)) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not in a party yet! You must do "
								+ ChatColor.YELLOW + "/party start" + ChatColor.RED + " in order to invite players!");
						return true;
					}

					if (!Party.getLeaderName(p).equals(p.getName())) {
						p.sendMessage(Prefix.prefixParty + ChatColor.RED + "You are not the leader of the party!");
						return true;
					}
					
					StringBuilder sb = new StringBuilder();
					String msg;
					for (int i = 1; i < args.length; i++)
						sb.append(args[i]).append("");
					msg = sb.toString();

					Player off = Bukkit.getServer().getPlayer(msg);
					Party.removePartyMember(off, p.getName());

					p.sendMessage(Prefix.prefixParty + ChatColor.GREEN + "You have kicked " + ChatColor.YELLOW + msg
							+ ChatColor.GREEN + " from your party!");
					
					if (off.isOnline()) {
						// ADD MORE TO THIS LATER!!
						off.getPlayer().sendMessage(Prefix.prefixParty + ChatColor.YELLOW + p.getName()
								+ ChatColor.YELLOW + " has kicked you from their party!");
					}
				}
			}
		}
		return true;
	}
}
