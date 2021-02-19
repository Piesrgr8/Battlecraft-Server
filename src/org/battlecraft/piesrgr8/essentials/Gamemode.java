package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Debug;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	String prefix = Prefix.prefixGamemode;
	
	//Everything said here is for gamemodes, and each particular gamemode has a method for targeting players too.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("g0")) {
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
				p.sendMessage(prefix + ChatColor.RED + "You don't have permission to change your gamemode!");
				return true;
			}
			if (args.length == 0) {
				p.setGameMode(GameMode.SURVIVAL);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
				p.sendMessage(prefix + ChatColor.GREEN + "" + ChatColor.BOLD + "SUCCESS");
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
						+ " has changed their gamemode to Survival!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (args.length == 1) {
				if (target == null) {
					p.sendMessage(prefix + ChatColor.RED + "That player isn't on the server!");
					return true;
				}
				if (target.getName().equalsIgnoreCase(args[0])) {
					target.setGameMode(GameMode.SURVIVAL);
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					p.sendMessage(
							prefix + ChatColor.GREEN + target.getName() + ChatColor.GREEN + " is now in survival!");
					target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					target.sendMessage(prefix + ChatColor.GREEN + p.getName() + " has changed your gamemode to "
							+ ChatColor.GREEN + "" + ChatColor.BOLD + "SURVIVAL!");
						Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " has changed " + ChatColor.YELLOW
							+ target.getName() + ChatColor.GREEN + "'s gamemode to Survival!");
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("g1")) {
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
				p.sendMessage(prefix + ChatColor.RED + "You don't have permission to change your gamemode!");
				return true;
			}
			if (args.length == 0) {
				p.setGameMode(GameMode.CREATIVE);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
				p.sendMessage(prefix + ChatColor.GREEN + "" + ChatColor.BOLD + "SUCCESS");
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
						+ " has changed their gamemode to Creative!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (args.length == 1) {
				if (target == null) {
					p.sendMessage(prefix + ChatColor.RED + "That player isn't on the server!");
					return true;
				}
				if (target.getName().equalsIgnoreCase(args[0])) {
					target.setGameMode(GameMode.CREATIVE);
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					p.sendMessage(
							prefix + ChatColor.GREEN + target.getName() + ChatColor.GREEN + " is now in creative!");
					target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					target.sendMessage(prefix + ChatColor.GREEN + p.getName() + " has changed your gamemode to "
							+ ChatColor.GREEN + "" + ChatColor.BOLD + "CREATIVE!");
						Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " has changed " + ChatColor.YELLOW
							+ target.getName() + ChatColor.GREEN + "'s gamemode to Creative!");
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("g2")) {
			Player p = (Player) sender;
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
				p.sendMessage(prefix + ChatColor.RED + "You don't have permission to change your gamemode!");
				return true;
			}
			if (args.length == 0) {
				p.setGameMode(GameMode.ADVENTURE);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
				p.sendMessage(prefix + ChatColor.GREEN + "" + ChatColor.BOLD + "SUCCESS");
					Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
						+ " has changed their gamemode to Adventure!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (args.length == 1) {
				if (target == null) {
					p.sendMessage(prefix + ChatColor.RED + "That player isn't on the server!");
					return true;
				}
				if (target.getName().equalsIgnoreCase(args[0])) {
					target.setGameMode(GameMode.ADVENTURE);
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					p.sendMessage(
							prefix + ChatColor.GREEN + target.getName() + ChatColor.GREEN + " is now in adventure!");
					target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
					target.sendMessage(prefix + ChatColor.GREEN + p.getName() + " has changed your gamemode to "
							+ ChatColor.GREEN + "" + ChatColor.BOLD + "ADVENTURE!");
						Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + " has changed " + ChatColor.YELLOW
							+ target.getName() + ChatColor.GREEN + "'s gamemode to Adventure!");
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("g3")) {
			Debug.debugBroadcast("Player executed Spectator!");
			Player p = (Player) sender;
			if (!RanksEnum.getRank((Player) sender).equals(Ranks.SRMOD)) {
				p.sendMessage(prefix + ChatColor.RED + "You don't have permission to change your gamemode!");
				return true;
			}
			p.setGameMode(GameMode.SPECTATOR);
			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
			p.sendMessage(prefix + ChatColor.GREEN + "" + ChatColor.BOLD + "SUCCESS" + ChatColor.RESET + "-" + " "
					+ ChatColor.GOLD + "Welcome to spectator mode!");
			return true;
		}
		return true;
	}
}