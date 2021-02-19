package org.battlecraft.piesrgr8.gadgets;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetGUI implements Listener{
	
	BattlecraftServer plugin;
	
	public GadgetGUI(BattlecraftServer p) {
		this.plugin = p;
	}
	
	@SuppressWarnings("deprecation")
	public static void openMainGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "Cosmetic Menu");
		
		ItemStack q = new ItemStack(Material.CHEST);
		ItemMeta q1 = q.getItemMeta();
		
		ItemStack w = new ItemStack(Material.DIAMOND_HORSE_ARMOR);
		ItemMeta w1 = w.getItemMeta();
		
		ItemStack r = new ItemStack(Material.LEGACY_GOLD_RECORD);
		ItemMeta r1 = r.getItemMeta();
		
		ItemStack custom = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta custom1 = custom.getItemMeta();
		
		q1.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "Weapons");
		q1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Anything that you get from", ChatColor.YELLOW + "chests are saved here!"));
		q.setItemMeta(q1);
		
		w1.setDisplayName(ChatColor.AQUA + "" + ChatColor.ITALIC + "Gadgets");
		w1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Use different items and such", ChatColor.YELLOW + "just for fun!"));
		w.setItemMeta(w1);
		
		r1.setDisplayName(ChatColor.AQUA + "" + ChatColor.ITALIC + "LEGACY_RECORDs");
		r1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Once you've collected LEGACY_RECORDs", ChatColor.YELLOW
				+ "from playing games and", ChatColor.YELLOW + "opened chests, you'll see them here!"));
		r.setItemMeta(r1);
		
		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);
		
		// SET 1
		inv.setItem(0, custom);
		inv.setItem(1, custom);
		inv.setItem(2, custom);
		inv.setItem(3, custom);
		inv.setItem(4, custom);
		inv.setItem(5, custom);
		inv.setItem(6, custom);
		inv.setItem(7, custom);
		inv.setItem(8, custom);
		
		// SET 2
		inv.setItem(9, custom);
		inv.setItem(10, q);
		inv.setItem(11, custom);
		inv.setItem(12, custom);
		inv.setItem(13, r);
		inv.setItem(14, custom);
		inv.setItem(15, custom);
		inv.setItem(16, w);
		inv.setItem(17, custom);
		
		// SET 3
		inv.setItem(18, custom);
		inv.setItem(19, custom);
		inv.setItem(20, custom);
		inv.setItem(21, custom);
		inv.setItem(22, custom);
		inv.setItem(23, custom);
		inv.setItem(24, custom);
		inv.setItem(25, custom);
		inv.setItem(26, custom);
		
		// SET 4
		inv.setItem(27, custom);
		inv.setItem(28, custom);
		inv.setItem(29, custom);
		inv.setItem(30, custom);
		inv.setItem(31, custom);
		inv.setItem(32, custom);
		inv.setItem(33, custom);
		inv.setItem(34, custom);
		inv.setItem(35, custom);
		
		// SET 5
		inv.setItem(36, custom);
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, custom);
		inv.setItem(40, custom);
		inv.setItem(41, custom);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);
		
		// SET 6
		inv.setItem(45, custom);
		inv.setItem(46, custom);
		inv.setItem(47, custom);
		inv.setItem(48, custom);
		inv.setItem(49, custom);
		inv.setItem(50, custom);
		inv.setItem(51, custom);
		inv.setItem(52, custom);
		inv.setItem(53, custom);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void openLEGACY_RECORD(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.AQUA + "LEGACY_RECORDs");
		
		ItemStack LEGACY_RECORD1 = new ItemStack(Material.LEGACY_GOLD_RECORD);
		ItemMeta q = LEGACY_RECORD1.getItemMeta();
		
		ItemStack LEGACY_RECORD2 = new ItemStack(Material.LEGACY_GREEN_RECORD);
		ItemMeta w = LEGACY_RECORD2.getItemMeta();
		
		ItemStack LEGACY_RECORD3 = new ItemStack(Material.LEGACY_RECORD_3);
		ItemMeta e = LEGACY_RECORD3.getItemMeta();
		
		ItemStack LEGACY_RECORD4 = new ItemStack(Material.LEGACY_RECORD_4);
		ItemMeta r = LEGACY_RECORD4.getItemMeta();
		
		ItemStack LEGACY_RECORD5 = new ItemStack(Material.LEGACY_RECORD_5);
		ItemMeta t = LEGACY_RECORD5.getItemMeta();
		
		ItemStack LEGACY_RECORD6 = new ItemStack(Material.LEGACY_RECORD_6);
		ItemMeta y = LEGACY_RECORD6.getItemMeta();
		
		ItemStack LEGACY_RECORD7 = new ItemStack(Material.LEGACY_RECORD_7);
		ItemMeta u = LEGACY_RECORD7.getItemMeta();
		
		ItemStack LEGACY_RECORD8 = new ItemStack(Material.LEGACY_RECORD_8);
		ItemMeta i = LEGACY_RECORD8.getItemMeta();
		
		ItemStack LEGACY_RECORD9 = new ItemStack(Material.LEGACY_RECORD_9);
		ItemMeta o = LEGACY_RECORD9.getItemMeta();
		
		ItemStack LEGACY_RECORD10 = new ItemStack(Material.LEGACY_RECORD_10);
		ItemMeta pot = LEGACY_RECORD10.getItemMeta();
		
		ItemStack LEGACY_RECORD11 = new ItemStack(Material.LEGACY_RECORD_11);
		ItemMeta a = LEGACY_RECORD11.getItemMeta();
		
		ItemStack LEGACY_RECORD12 = new ItemStack(Material.LEGACY_RECORD_12);
		ItemMeta s = LEGACY_RECORD12.getItemMeta();
		
		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta bk = back.getItemMeta();
		
		ItemStack stop = new ItemStack(Material.SLIME_BALL);
		ItemMeta sp = stop.getItemMeta();
		
		ItemStack custom = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta custom1 = custom.getItemMeta();
		
		q.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "13");
		LEGACY_RECORD1.setItemMeta(q);
		
		w.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "cat");
		LEGACY_RECORD2.setItemMeta(w);
		
		e.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "blocks");
		LEGACY_RECORD3.setItemMeta(e);
		
		r.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "chirp");
		LEGACY_RECORD4.setItemMeta(r);
		
		t.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "far");
		LEGACY_RECORD5.setItemMeta(t);
		
		y.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "mall");
		LEGACY_RECORD6.setItemMeta(y);
		
		u.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "mellohi");
		LEGACY_RECORD7.setItemMeta(u);
		
		i.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "stal");
		LEGACY_RECORD8.setItemMeta(i);
		
		o.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "strad");
		LEGACY_RECORD9.setItemMeta(o);
		
		pot.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "ward");
		LEGACY_RECORD10.setItemMeta(pot);
		
		a.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "11");
		LEGACY_RECORD11.setItemMeta(a);
		
		s.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "wait");
		LEGACY_RECORD12.setItemMeta(s);
		
		bk.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "BACK");
		back.setItemMeta(bk);

		sp.setDisplayName(ChatColor.RED + "" + ChatColor.ITALIC + "Stop Song");
		sp.setLore(Arrays.asList(ChatColor.GRAY + "If you are currently playing", 
				ChatColor.GRAY + "a song, stand on top of the", ChatColor.GRAY + "jukebox and press this item!"));
		stop.setItemMeta(sp);
		
		custom1.setDisplayName(" ");
		custom.setItemMeta(custom1);
		
		// SET 1
		inv.setItem(0, custom);
		inv.setItem(1, custom);
		inv.setItem(2, custom);
		inv.setItem(3, custom);
		inv.setItem(4, custom);
		inv.setItem(5, custom);
		inv.setItem(6, custom);
		inv.setItem(7, custom);
		inv.setItem(8, custom);
		
		// SET 2
		inv.setItem(9, custom);
		inv.setItem(10, custom);
		inv.setItem(11, custom);
		inv.setItem(12, custom);
		inv.setItem(13, custom);
		inv.setItem(14, custom);
		inv.setItem(15, custom);
		inv.setItem(16, custom);
		inv.setItem(17, custom);
		
		// SET 3
		inv.setItem(18, custom);
		inv.setItem(19, custom);
		inv.setItem(20, LEGACY_RECORD1);
		inv.setItem(21, LEGACY_RECORD2);
		inv.setItem(22, LEGACY_RECORD3);
		inv.setItem(23, LEGACY_RECORD4);
		inv.setItem(24, LEGACY_RECORD5);
		inv.setItem(25, custom);
		inv.setItem(26, custom);
		
		// SET 4
		inv.setItem(27, custom);
		inv.setItem(28, custom);
		inv.setItem(29, LEGACY_RECORD6);
		inv.setItem(30, LEGACY_RECORD7);
		inv.setItem(31, LEGACY_RECORD8);
		inv.setItem(32, LEGACY_RECORD9);
		inv.setItem(33, LEGACY_RECORD10);
		inv.setItem(34, custom);
		inv.setItem(35, custom);
		
		// SET 5
		inv.setItem(36, custom);
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, LEGACY_RECORD11);
		inv.setItem(40, custom);
		inv.setItem(41, LEGACY_RECORD12);
		inv.setItem(42, custom);
		inv.setItem(43, custom);
		inv.setItem(44, custom);
		
		// SET 6
		inv.setItem(45, back);
		inv.setItem(46, custom);
		inv.setItem(47, custom);
		inv.setItem(48, custom);
		inv.setItem(49, custom);
		inv.setItem(50, custom);
		inv.setItem(51, custom);
		inv.setItem(52, custom);
		inv.setItem(53, stop);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void mainGuiListener(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("Cosmetic Menu"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		switch(e.getCurrentItem().getType()) {
		
		case CHEST:
			p.sendMessage(Prefix.prefixGadget + ChatColor.RED + "This feature isnt ready yet! Come back later when its done!");
			break;
			
		case DIAMOND_HORSE_ARMOR:
			p.sendMessage(Prefix.prefixGadget + ChatColor.RED + "This feature isnt ready yet! Come back later when its done!");
			break;
			
		case LEGACY_GOLD_RECORD:
			openLEGACY_RECORD(p);
			break;
			
		default:
			break;
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void LEGACY_RECORDGuiListener(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase("LEGACY_RECORDs"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		switch(e.getCurrentItem().getType()) {
		
		case LEGACY_GOLD_RECORD:
			Bukkit.dispatchCommand(p, "jukebox 13");
			p.closeInventory();
			break;
			
		case LEGACY_GREEN_RECORD:
			Bukkit.dispatchCommand(p, "jukebox cat");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_3:
			Bukkit.dispatchCommand(p, "jukebox blocks");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_4:
			Bukkit.dispatchCommand(p, "jukebox chirp");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_5:
			Bukkit.dispatchCommand(p, "jukebox far");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_6:
			Bukkit.dispatchCommand(p, "jukebox mall");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_7:
			Bukkit.dispatchCommand(p, "jukebox mellohi");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_8:
			Bukkit.dispatchCommand(p, "jukebox stal");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_9:
			Bukkit.dispatchCommand(p, "jukebox strad");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_10:
			Bukkit.dispatchCommand(p, "jukebox ward");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_11:
			Bukkit.dispatchCommand(p, "jukebox 11");
			p.closeInventory();
			break;
			
		case LEGACY_RECORD_12:
			Bukkit.dispatchCommand(p, "jukebox wait");
			p.closeInventory();
			break;
			
		case ARROW:
			openMainGUI(p);
			break;
			
		case SLIME_BALL:
			Bukkit.dispatchCommand(p, "jukebox stop");
			break;
			
		default:
			break;
		}
	}
	
	@EventHandler
	public void interaction(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();
		Player p = e.getPlayer();

		if (a == Action.PHYSICAL || is == null || is.getType().equals(Material.AIR)) {
			return;
		}

		if (is.getType().equals(Material.CHEST) && is.hasItemMeta()) {
			openMainGUI(p);
		}
	}
}
