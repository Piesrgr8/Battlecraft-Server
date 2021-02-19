package org.battlecraft.piesrgr8.signs;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.inventory.InvMethods;
import org.battlecraft.piesrgr8.utils.Debug;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.Chase.main.API;

public class Sell implements Listener {
	
	BattlecraftServer plugin;
	
	public Sell(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("bc.staff")) {
			return;
		}

		if (e.getLine(0).equalsIgnoreCase("sell")) {
			p.sendMessage("Added a sell sign!");
			p.sendMessage(e.getLine(1));
			p.sendMessage(e.getLine(2));
			p.sendMessage(e.getLine(3));
			e.setLine(0, ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "SELL" + ChatColor.GRAY + "]");
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			return;
		}

		if (e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();

			if (!s.getLine(0).contains(ChatColor.stripColor("SELL"))) {
				return;
			}

			ItemStack it = new ItemStack(Material.getMaterial(s.getLine(2)), Integer.parseInt(s.getLine(1)));
			ItemStack inv = InvMethods.getItemInHand(p, false);
			int amount = inv.getAmount();

			if (!inv.equals(it)) {
				Debug.debugBroadcast("You dont have that item in your hand! " + inv);
				return;
			}

			if (amount < Integer.parseInt(s.getLine(1))) {
				Debug.debugBroadcast("You have less of that amount " + amount);
				return;
			}

			if (s.getLine(3).isEmpty()) {
				p.sendMessage("There is no cost on this sign! Must be 0 if its free.");
			} else

			if (s.getLine(1).isEmpty()) {
				try {
					Integer.parseInt(s.getLine(1));
				} catch (Exception e1) {
					p.sendMessage("The second line must be a number!");
					e1.getMessage();
				}
			} else {

				try {
					// p.getInventory().removeItem(
					// new ItemStack(Material.getMaterial(s.getLine(2)),
					// Integer.parseInt(s.getLine(1))));
					InvMethods.removeItemStack(p, it, Integer.parseInt(s.getLine(1)));
					p.updateInventory();
					p.sendMessage("You sold a(n) " + Material.getMaterial(s.getLine(2)));
				} catch (Exception e1) {
					p.sendMessage("Item doesnt exist!");
					e1.printStackTrace();
				}
				try {
					API.addBal(p, Integer.parseInt(s.getLine(3)));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
