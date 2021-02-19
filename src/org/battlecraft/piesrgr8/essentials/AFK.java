package org.battlecraft.piesrgr8.essentials;

import java.util.ArrayList;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class AFK implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public AFK(BattlecraftServer p) {
		this.plugin = p;
	}
	
	public static ArrayList<Player> afk = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("afk")) {
			if (!afk.contains(p)) {
				afk.add(p);
				Bukkit.getServer().broadcastMessage(
						Prefix.prefixMain + ChatColor.GOLD + p.getName() + ChatColor.YELLOW + " is now AFK!");
				return true;
			} else

			if (afk.contains(p)) {
				afk.remove(p);
				Bukkit.getServer().broadcastMessage(
						Prefix.prefixMain + ChatColor.GOLD + p.getName() + ChatColor.YELLOW + " is now available!");
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	@EventHandler
	public void interaction(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (afk.contains(p)) {
			afk.remove(p);
			Bukkit.getServer().broadcastMessage(
					Prefix.prefixMain + ChatColor.GOLD + p.getName() + ChatColor.YELLOW + " is now available!");
		}
	}

	@EventHandler
	public void moveEvent(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (afk.contains(p)) {
			afk.remove(p);
			Bukkit.getServer().broadcastMessage(
					Prefix.prefixMain + ChatColor.GOLD + p.getName() + ChatColor.YELLOW + " is now available!");
		}
	}
}
