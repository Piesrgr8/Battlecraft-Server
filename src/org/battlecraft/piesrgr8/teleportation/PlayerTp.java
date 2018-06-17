package org.battlecraft.piesrgr8.teleportation;

import java.util.ArrayList;
import java.util.Arrays;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerTp implements Listener {

	public static ArrayList<String> players = new ArrayList<String>();

	BattlecraftServer plugin;

	public PlayerTp(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Player Teleportation");

		for (int i = 0; i < players.size(); i++) { // Where players is an array
													// of the players in-game
			String playerName = players.get(i);
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			ItemMeta meta = item.getItemMeta();

			meta.setDisplayName(playerName);
			meta.setLore(Arrays.asList("Click to Teleport!"));
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}

		p.openInventory(inv);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Player Teleportation")) {
			return;
		}

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			Player c = Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName().trim());
			if (RanksEnum.isAtLeast(p, Ranks.HELPER)) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, (float) 0.5);
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport!");
				e.setCancelled(true);
			}
			if (c != null) {
				p.teleport(c);
				Admin.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " teleported to " + ChatColor.YELLOW + c.getName());
			}
		}
		
		
	}
}
