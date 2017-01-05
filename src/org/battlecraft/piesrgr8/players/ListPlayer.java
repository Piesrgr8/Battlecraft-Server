package org.battlecraft.piesrgr8.players;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListPlayer implements CommandExecutor {

	BattlecraftServer plugin;

	public ListPlayer(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("player")) {
			if (!sender.hasPermission("bc.player")) {
				sender.sendMessage(Prefix.prefixMain + "You don't have permission to use this command!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixMain + "Now, you can do /player (add:remove) <name>");
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("add")) {
					sender.sendMessage(Prefix.prefixMain + "Now the name of the player.");
				}

				if (args[0].equalsIgnoreCase("remove")) {
					sender.sendMessage(Prefix.prefixMain + "Now the name of the player.");
					return true;
				}

				if (args.length == 2) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage("Player not online!");
						return true;
					}
					if (args[0].equalsIgnoreCase("add")) {
						if (plugin.getConfig().getStringList("players").contains(target)) {
							sender.sendMessage(
									Prefix.prefixMain + "That player is already added to the list!");
							return true;
						}
						plugin.getConfig().getStringList("players").add(target.getName());
						sender.sendMessage(Prefix.prefixMain + "Target " + target.getName()
								+ " has been added to the list!");
					}
					if (args[1].equalsIgnoreCase("remove")) {
						if (!plugin.getConfig().getStringList("players").contains(target)) {
							sender.sendMessage(
									Prefix.prefixMain + "That player hasn't been added to the list yet!");
							return true;
						}
						plugin.getConfig().getStringList("players").remove(target.getName());
						sender.sendMessage(Prefix.prefixMain + "Target " + target.getName()
								+ " has been removed from the list!");
					}
				}
			}

		}
		return true;
	}
}