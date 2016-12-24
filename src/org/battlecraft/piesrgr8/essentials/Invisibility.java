package org.battlecraft.piesrgr8.essentials;

import java.util.ArrayList;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invisibility implements CommandExecutor {

	String prefix = BattlecraftServer.prefixStealth;

	List<Player> vanish = new ArrayList<Player>();

	
	//This is for vanishing players that are seen on the server by the player.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getLabel().equalsIgnoreCase("vs")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Use this in-game to vanish!");
				return false;
			}
			Player p = (Player) sender;

			if (!RanksEnum.isAtLeast((Player) sender, Ranks.MOD)) {
				sender.sendMessage(prefix + ChatColor.RED + "You don't have permission to vanish!");
				return false;
			}
			if (vanish.contains(p)) {
				showAllPlayers(p);
				p.sendMessage(prefix + ChatColor.GREEN + "All players are now visible!");
				vanish.remove(p);
				return true;

			} else if (!vanish.contains(p)) {
				hideAllPlayers(p);
				p.sendMessage(prefix + ChatColor.GREEN + "All players are now hidden!");
				vanish.add(p);
				return true;

			} else {
				return false;
			}
		}
		return false;
	}

	public void showAllPlayers(Player player) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			player.showPlayer(pl);
		}
	}

	public void hideAllPlayers(Player player) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			player.hidePlayer(pl);
		}
	}
}