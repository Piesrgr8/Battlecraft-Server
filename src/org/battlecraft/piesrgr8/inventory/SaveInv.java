package org.battlecraft.piesrgr8.inventory;

import java.io.File;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveInv implements CommandExecutor {

	//TODO IMPLEMENT

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		File f = new File("plugins//BattlecraftServer//inventories//Saved//" + p.getUniqueId().toString() + ".yml");
		
		if (RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
			if (cmd.getName().equalsIgnoreCase("inv")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("load")) {
						if (!f.exists()) {
							RestoreInventory.saveInvFor(p, p.getWorld());
							RestoreInventory.loadInventory(p);
						} else {
							p.sendMessage("You already have your saved inventory.");
							return true;
						}
					}
					
					if (args[0].equalsIgnoreCase("save")) {
						if (f.exists()) {
							RestoreInventory.saveInventory(p);
							return true;
						}
					}
				}
			}
		}
		return true;
	}
}
