package org.battlecraft.piesrgr8.world;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldSave implements CommandExecutor {

	BattlecraftServer plugin;

	public WorldSave(BattlecraftServer p) {
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("save")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.SRMOD)) {
				sender.sendMessage(
						BattlecraftServer.prefixWorld + ChatColor.RED + "You don't have permission to save worlds!");
			}
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
			sender.sendMessage(BattlecraftServer.prefixWorld + ChatColor.GREEN + "WORLDS SAVED!");
			return true;
		}
		return true;
	}
}