package org.battlecraft.piesrgr8.shop;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.signs.Buy;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Kiosk implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public Kiosk(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("kiosk")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player!");
				return true;
			}
			Player p = (Player) sender;
			openGUI(p);
			p.sendMessage("Opened Kiosk!");
			return true;
		}
		return true;
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Kiosk");

		// Creating the items and registering them.

		for (int i = 0; i < Buy.list.keySet().size(); i++) {
			if (i == 9) {
				break;
			}
			inv.setItem(i, (ItemStack) Buy.list.get(p));
		}
		
       try {
		p.openInventory(inv);
       }catch (Exception e) {
    	   p.sendMessage(Prefix.prefixShop + "You haven't bought anything!");
       }
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Kiosk"))
			return;

		// Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)) {
			e.setCancelled(true);
			return;
		}
	}
}
