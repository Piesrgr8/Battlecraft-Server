package org.battlecraft.piesrgr8.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Test implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public Test(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (e.getLine(0).equalsIgnoreCase("Buy")) {
			p.sendMessage("Added a buy sign!");
			e.setLine(0, ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BUY" + ChatColor.GRAY + "]");
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		File f = new File("plugins//BattlecraftServer//Kiosk//" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		ArrayList<ItemStack> list = new ArrayList<>();
		Player p = e.getPlayer();
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			return;
		if (e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();
			try {
				p.getInventory().addItem(new ItemStack(Material.getMaterial(s.getLine(1))));
				p.sendMessage("You bought a(n) " + Material.getMaterial(s.getLine(1)));
			} catch (Exception e1) {
				p.sendMessage("Item doesnt exist!");
				e1.printStackTrace();
			}
			try {
				list.add(new ItemStack(Material.getMaterial(s.getLine(1))));
				yaml.set("Bought", list);
				yaml.save(f);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) {
			if (!sender.hasPermission("bc.test")) {
				sender.sendMessage("No permission");
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage("This class is testing buy signs and sell signs!");
				return true;
			}
		}
		return true;
	}
}