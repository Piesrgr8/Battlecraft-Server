package org.battlecraft.piesrgr8.fake;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ForceOp implements CommandExecutor {

	BattlecraftServer plugin;

	public ForceOp(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("forceop")) {
			sender.sendMessage("Opped " + sender.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					Bukkit.broadcastMessage(Prefix.prefixMain + ChatColor.YELLOW + "" + ChatColor.BOLD
							+ "OMFG SOMEONE JUST USED /FORCEOP AND THEY DONT EVEN KNOW THAT IT ISNT A REAL COMMAND!!! xD xD");
				}
			}, 200);
			return true;
		} else {
			sender.sendMessage("Haha. You actually thought that force op worked :D");
		}
		return true;
	}
}
