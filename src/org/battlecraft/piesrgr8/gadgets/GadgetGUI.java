package org.battlecraft.piesrgr8.gadgets;

import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
		
		ItemStack w = new ItemStack(Material.DIAMOND_BARDING);
		ItemMeta w1 = w.getItemMeta();
		
		ItemStack r = new ItemStack(Material.GOLD_RECORD);
		ItemMeta r1 = r.getItemMeta();
		
		ItemStack custom = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData());
		ItemMeta custom1 = custom.getItemMeta();
		
		q1.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "Weapons");
		q1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Anything that you get from", ChatColor.YELLOW + "chests are saved here!"));
		q.setItemMeta(q1);
		
		w1.setDisplayName(ChatColor.AQUA + "" + ChatColor.ITALIC + "Gadgets");
		w1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Use different items and such", ChatColor.YELLOW + "just for fun!"));
		w.setItemMeta(w1);
		
		r1.setDisplayName(ChatColor.AQUA + "" + ChatColor.ITALIC + "Records");
		r1.setLore(Arrays.asList(" ", ChatColor.YELLOW + "Once you've collected records", ChatColor.YELLOW
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
	public static void openRecord(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Records");
		
		ItemStack record1 = new ItemStack(Material.GOLD_RECORD);
		ItemMeta q = record1.getItemMeta();
		
		ItemStack record2 = new ItemStack(Material.GREEN_RECORD);
		ItemMeta w = record2.getItemMeta();
		
		ItemStack record3 = new ItemStack(Material.RECORD_3);
		ItemMeta e = record3.getItemMeta();
		
		ItemStack record4 = new ItemStack(Material.RECORD_4);
		ItemMeta r = record4.getItemMeta();
		
		ItemStack record5 = new ItemStack(Material.RECORD_5);
		ItemMeta t = record5.getItemMeta();
		
		ItemStack record6 = new ItemStack(Material.RECORD_6);
		ItemMeta y = record6.getItemMeta();
		
		ItemStack record7 = new ItemStack(Material.RECORD_7);
		ItemMeta u = record7.getItemMeta();
		
		ItemStack record8 = new ItemStack(Material.RECORD_8);
		ItemMeta i = record8.getItemMeta();
		
		ItemStack record9 = new ItemStack(Material.RECORD_9);
		ItemMeta o = record9.getItemMeta();
		
		ItemStack record10 = new ItemStack(Material.RECORD_10);
		ItemMeta pot = record10.getItemMeta();
		
		ItemStack record11 = new ItemStack(Material.RECORD_11);
		ItemMeta a = record11.getItemMeta();
		
		ItemStack record12 = new ItemStack(Material.RECORD_12);
		ItemMeta s = record12.getItemMeta();
		
		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta bk = back.getItemMeta();
		
		ItemStack stop = new ItemStack(Material.SLIME_BALL);
		ItemMeta sp = stop.getItemMeta();
		
		ItemStack custom = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getDyeData());
		ItemMeta custom1 = custom.getItemMeta();
		
		q.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "13");
		record1.setItemMeta(q);
		
		w.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "cat");
		record2.setItemMeta(w);
		
		e.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "blocks");
		record3.setItemMeta(e);
		
		r.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "chirp");
		record4.setItemMeta(r);
		
		t.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "far");
		record5.setItemMeta(t);
		
		y.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "mall");
		record6.setItemMeta(y);
		
		u.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "mellohi");
		record7.setItemMeta(u);
		
		i.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "stal");
		record8.setItemMeta(i);
		
		o.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "strad");
		record9.setItemMeta(o);
		
		pot.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "ward");
		record10.setItemMeta(pot);
		
		a.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "11");
		record11.setItemMeta(a);
		
		s.setDisplayName(ChatColor.GOLD + "" + ChatColor.ITALIC + "wait");
		record12.setItemMeta(s);
		
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
		inv.setItem(20, record1);
		inv.setItem(21, record2);
		inv.setItem(22, record3);
		inv.setItem(23, record4);
		inv.setItem(24, record5);
		inv.setItem(25, custom);
		inv.setItem(26, custom);
		
		// SET 4
		inv.setItem(27, custom);
		inv.setItem(28, custom);
		inv.setItem(29, record6);
		inv.setItem(30, record7);
		inv.setItem(31, record8);
		inv.setItem(32, record9);
		inv.setItem(33, record10);
		inv.setItem(34, custom);
		inv.setItem(35, custom);
		
		// SET 5
		inv.setItem(36, custom);
		inv.setItem(37, custom);
		inv.setItem(38, custom);
		inv.setItem(39, record11);
		inv.setItem(40, custom);
		inv.setItem(41, record12);
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
	
	@EventHandler
	public void mainGuiListener(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Cosmetic Menu"))
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
			p.sendMessage("Yo1");
			break;
			
		case DIAMOND_BARDING:
			p.sendMessage("Yo2");
			break;
			
		case GOLD_RECORD:
			openRecord(p);
			break;
			
		default:
			break;
		}
	}
	
	@EventHandler
	public void recordGuiListener(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Records"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		switch(e.getCurrentItem().getType()) {
		
		case GOLD_RECORD:
			Bukkit.dispatchCommand(p, "jukebox 13");
			p.closeInventory();
			break;
			
		case GREEN_RECORD:
			Bukkit.dispatchCommand(p, "jukebox cat");
			p.closeInventory();
			break;
			
		case RECORD_3:
			Bukkit.dispatchCommand(p, "jukebox blocks");
			p.closeInventory();
			break;
			
		case RECORD_4:
			Bukkit.dispatchCommand(p, "jukebox chirp");
			p.closeInventory();
			break;
			
		case RECORD_5:
			Bukkit.dispatchCommand(p, "jukebox far");
			p.closeInventory();
			break;
			
		case RECORD_6:
			Bukkit.dispatchCommand(p, "jukebox mall");
			p.closeInventory();
			break;
			
		case RECORD_7:
			Bukkit.dispatchCommand(p, "jukebox mellohi");
			p.closeInventory();
			break;
			
		case RECORD_8:
			Bukkit.dispatchCommand(p, "jukebox stal");
			p.closeInventory();
			break;
			
		case RECORD_9:
			Bukkit.dispatchCommand(p, "jukebox strad");
			p.closeInventory();
			break;
			
		case RECORD_10:
			Bukkit.dispatchCommand(p, "jukebox ward");
			p.closeInventory();
			break;
			
		case RECORD_11:
			Bukkit.dispatchCommand(p, "jukebox 11");
			p.closeInventory();
			break;
			
		case RECORD_12:
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
}
