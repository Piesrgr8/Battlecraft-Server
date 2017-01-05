package org.battlecraft.piesrgr8.signs;

import java.util.HashMap;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
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

public class Buy implements Listener{
	
	BattlecraftServer plugin;

	public static HashMap<Player, ItemStack> list = new HashMap<Player, ItemStack>();

	public Buy(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("bc.staff")) {
			return;
		}
		
		if (e.getLine(0).equalsIgnoreCase("Buy")) {
			p.sendMessage(Prefix.prefixSigns + ChatColor.GREEN + "Added a buy sign!");
			e.setLine(0, ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BUY" + ChatColor.GRAY + "]");
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
			
			if (!s.getLine(0).contains(ChatColor.stripColor("BUY"))) {
				return ;
			}
			
			if (s.getLine(3).isEmpty()) {
				p.sendMessage(Prefix.prefixSigns + ChatColor.RED + "There is no cost on this sign! Must be 0 if its free.");
			} else
			
			if (s.getLine(1).isEmpty()) {
				try {
					Integer.parseInt(s.getLine(1));
				}catch (Exception e1) {
					p.sendMessage(Prefix.prefixSigns + ChatColor.RED + "The second line must be a number!");
					e1.getMessage();
				}
			}else{
				
			try {
				p.getInventory().addItem(new ItemStack(Material.getMaterial(s.getLine(2)), Integer.parseInt(s.getLine(1))));
				p.sendMessage(Prefix.prefixSigns + ChatColor.GREEN + "You bought a(n) " + ChatColor.YELLOW + s.getLine(2)
						+ ChatColor.GREEN + " for " + ChatColor.YELLOW + "$" + s.getLine(3));
			} catch (Exception e1) {
				p.sendMessage(Prefix.prefixSigns + ChatColor.RED + "Item doesnt exist!");
				e1.getMessage();
			}
			try {
				API.minBal(p, Integer.parseInt(s.getLine(3)));
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			list.put(p, new ItemStack(Material.getMaterial(s.getLine(2))));
		}
		}
	}
}
