package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ClansGUI implements Listener{
	
	BattlecraftServer plugin;
	
	public ClansGUI(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Clan Invites");

		// Creating the items and registering them.

		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		for (int i = 0; i < yaml.getStringList(p.getName() + ".claninvites").size(); i++) { // Where
																			// players
																			// is
																			// an
																			// array
			// of the players in-game
			String playerName = yaml.getStringList(p.getName() + ".claninvites").get(i);
			OfflinePlayer p1 = Bukkit.getServer().getOfflinePlayer(playerName);
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) item.getItemMeta();

		

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.
			File f1 = new File("plugins//BattlecraftServer//clans//" + p1.getName() + ".yml");
			YamlConfiguration yaml1 = YamlConfiguration.loadConfiguration(f1);
			
			String pref = yaml1.getString("Clan");
			List<String> on = yaml1.getStringList("players");
			int me = on.size();

			
			meta.setDisplayName(ChatColor.YELLOW + playerName);
			meta.setLore(Arrays.asList(ChatColor.YELLOW + "Clan:",
					pref, "",
					ChatColor.YELLOW + "Members:", "" + me));
			item.setItemMeta(meta);
		

		// Set the items in their places.

		inv.setItem(i, item);
		}
		p.openInventory(inv);
	}
	
	public static void tpOpenGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Clan Teleportation");
		List<String> list = Clans.getPlayerList();

		for (int i = 0; i < list.size(); i++) { // Where players is an array
													// of the players in-game
			String playerName = list.get(i);
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			ItemMeta meta = item.getItemMeta();
			
			if (playerName.equals(p.getName()))
				continue;
			

			meta.setDisplayName(playerName);
			meta.setLore(Arrays.asList("Click to Teleport!"));
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Clan Invites")) {
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
			String c = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			
			if (!RanksEnum.isAtLeast(p, Ranks.VIP)) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, (float) 0.5);
				p.sendMessage(Prefix.prefixClans + RanksEnum.sendErrorMessage(Ranks.VIP));
				e.setCancelled(true);
				return;
			}
			if (!Clans.isInClan(p)) {
				Clans.addPlayerToClan(p, c);
				PlayersYML.setClanInvites(p, null);
				p.closeInventory();
				p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have joined " + ChatColor.YELLOW + c + "'s" + ChatColor.GREEN + " clan!");
				e.setCancelled(true);
				
			}else{
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are already in a clan! You must leave your clan in order to proceed!");
				e.setCancelled(true);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void invTp(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Clan Teleportation")) {
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
			Player pll = Bukkit.getServer().getPlayer(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
			if (pll != null) {
				p.closeInventory();
				p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have teleported to " + ChatColor.YELLOW + pll.getName() + "!");
				p.teleport(pll);
				Admin.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " teleported to " + ChatColor.YELLOW + pll.getName());
			}
			
		}
	}
}
