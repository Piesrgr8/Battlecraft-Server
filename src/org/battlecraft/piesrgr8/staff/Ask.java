package org.battlecraft.piesrgr8.staff;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.SoundEffects;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ask implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ask")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + "Please continue your question so we can help you!");
				return true;
			}
			if (args.length >= 1) {

				String bc = "";
				for (String message : args) {
					bc = (bc + message + " ");
				}
				
				p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + p.getName() + ": "
								+ ChatColor.GREEN + bc);
				for (Player on : Bukkit.getOnlinePlayers()) {
					if (on.hasPermission("bc.staff")) {
						on.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + p.getName() + ": "
								+ ChatColor.GREEN + bc);
						SoundEffects.alertS(p);
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("answer")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			
			if (!RanksEnum.isStaff(p)) {
				p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + "You are not part of our staff team!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.YELLOW + "Please continue your question so we can help you!");
				return true;
			}
			
			if (args.length == 1) {
				Player p1 = Bukkit.getServer().getPlayer(args[0]);
				if (p1 == null) {
					p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.RED + "That player is either offline or is not a player at all!");
					return true;
				}
			}
			if (args.length >= 2) {
				Player p1 = Bukkit.getServer().getPlayer(args[0]);
				StringBuilder sb = new StringBuilder();
				String msg;
				for(int i = 1; i < args.length; i++)
    					sb.append(args[i]).append(" ");
				msg = sb.toString();
				
				p.sendMessage(BattlecraftServer.prefixStaff + ChatColor.LIGHT_PURPLE + "Your Answer" + ": " + ChatColor.GREEN + msg);
				p1.sendMessage(BattlecraftServer.prefixStaff + ChatColor.LIGHT_PURPLE + p.getName() + ": " + ChatColor.GREEN + msg);
				SoundEffects.alertS(p1);
		}
	}
		return true;
	}
}
