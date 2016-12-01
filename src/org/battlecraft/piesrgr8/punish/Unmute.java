package org.battlecraft.piesrgr8.punish;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unmute implements CommandExecutor {

	String prefix = BattlecraftServer.prefixPunish;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getLabel().equalsIgnoreCase("unmute")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				sender.sendMessage(prefix + ChatColor.RED + "You don't have permission to mute people!");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(prefix + ChatColor.RED + "Please specify a player!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(prefix + ChatColor.RED + "Could not find player " + args[0] + "!");
			} else {
				Mute.muted.remove(target);
				Bukkit.getServer().broadcastMessage(prefix + ChatColor.YELLOW + "Player " + target.getName()
						+ " has been unmuted by " + sender.getName() + "!");

			}
		}
		return false;
	}
}
