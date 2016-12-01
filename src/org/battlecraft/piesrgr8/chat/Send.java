package org.battlecraft.piesrgr8.chat;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Send implements CommandExecutor {

	BattlecraftServer plugin;

	public Send(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("send")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.MOD)) {
				sender.sendMessage("You dont have permission to send different messages!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage("What would you like to send? /send <title : am : bc>");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("title")) {
					sender.sendMessage("What's the message?");
					return true;
				}
				if (args[0].equalsIgnoreCase("am")) {
					sender.sendMessage("What's the message?");
					return true;
				}
				if (args[0].equalsIgnoreCase("bc")) {
					sender.sendMessage("What's the message?");
					return true;
				}
			}
			if (args.length >= 2) {
				String bc = "";
				for (String message : args) {
					bc = (bc + message + " ");
				}
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (args[0].equalsIgnoreCase("title")) {
						PacketUtil.sendTitle(plugin, on, bc, "");
						return true;
					}
					if (args[0].equalsIgnoreCase("am")) {
						PacketUtil.sendActionMsg(plugin, on, bc);
						return true;
					}
					if (args[0].equalsIgnoreCase("bc")) {
						Bukkit.broadcastMessage(
								BattlecraftServer.prefixMain + ChatColor.translateAlternateColorCodes('&', bc));
						return true;
					}
				}
			}
		}
		return true;
	}
}
