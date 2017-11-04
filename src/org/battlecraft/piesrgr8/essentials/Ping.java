package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_9_R2.EntityPlayer;

public class Ping implements CommandExecutor {

	BattlecraftServer plugin;

	public Ping(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ping")) {
			if (RanksEnum.isStaff(p)) {
				if (args.length == 0) {
					p.sendMessage(Prefix.prefixMain + ChatColor.RED + "Must include a player that is online!");
					return true;
				}

				if (args.length == 1) {
					Player tar = Bukkit.getServer().getPlayer(args[0]);
					if (tar == null) {
						p.sendMessage(Prefix.prefixMain + ChatColor.RED + "This player is not online!");
						return true;
					}
					p.sendMessage(Prefix.prefixMain + Color.c(
							"&e" + tar.getName() + "&a's ping is currently " + "&e" + Integer.toString(getPing(tar))));
					return true;
				}
			}
		}
		return true;
	}

	public static int getPing(Player p) {
		CraftPlayer cp = (CraftPlayer) p;
		EntityPlayer ep = cp.getHandle();
		return ep.ping;
	}
}
