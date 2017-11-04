package org.battlecraft.piesrgr8.weapons;

import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Upgrade implements CommandExecutor{
	
	BattlecraftServer plugin;
	
	public Upgrade(BattlecraftServer p) {
		this.plugin = p;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("upgrade")) {
			if (args.length == 0) {
				upgrade(p, p.getInventory().getItemInMainHand());
				return true;
			}
			
			if (args.length >= 1) {
				p.sendMessage("Dont need that many arguments! There is actually only 1!");
				return true;
			}
		}
		return true;
	}
	
	private static void upgrade(Player p, ItemStack item) {
		Random r = new Random();
		int rand = r.nextInt(2) + 1;
		if (rand == 1) {
		}
	}
}
