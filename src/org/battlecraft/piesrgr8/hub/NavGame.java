package org.battlecraft.piesrgr8.hub;

import java.util.Arrays;
import java.util.Random;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NavGame implements Listener {

	BattlecraftServer plugin;

	public NavGame(BattlecraftServer p) {
		this.plugin = p;
	}

	public void teleportInWorld(Player player, World world, double x, double y, double z) {
		player.teleport(new Location(world, x, y, z));

		if (world == null) {
			player.sendMessage(BattlecraftServer.prefixHub + ChatColor.RED + "This world doesnt exist!");
		}
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Quick Game");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.COBBLESTONE);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.SLIME_BALL);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.BOW);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.CHEST);
		ItemMeta hg1 = hg.getItemMeta();

		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta air1 = air.getItemMeta();

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.

		main1.setDisplayName(ChatColor.GOLD + "Main PvP");
		main1.setLore(Arrays.asList(ChatColor.YELLOW + "The heart of Battlecraft.",
				ChatColor.YELLOW + "Play this fast-paced pvp", ChatColor.YELLOW + "with several gamemodes to",
				ChatColor.YELLOW + "choose from!"));
		main.setItemMeta(main1);

		mg1.setDisplayName(ChatColor.DARK_RED + "Minigames");
		mg1.setLore(Arrays.asList(ChatColor.YELLOW + "Basic minigames so fun,",
				ChatColor.YELLOW + "that you will never", ChatColor.YELLOW + "want to leave!"));
		mg.setItemMeta(mg1);

		sw1.setDisplayName(ChatColor.BLUE + "SkyWars");
		sw1.setLore(
				Arrays.asList(ChatColor.YELLOW + "Fight in the sky on a", ChatColor.YELLOW + "square block with a tree",
						ChatColor.YELLOW + "and other resources!", ChatColor.YELLOW + "Dont fall off!"));
		sw.setItemMeta(sw1);

		hg1.setDisplayName(ChatColor.YELLOW + "Survival Games");
		hg1.setLore(Arrays.asList(ChatColor.YELLOW + "A classic game, where survival",
				ChatColor.YELLOW + "is all you have left.", ChatColor.YELLOW + "This pvp game has been seen",
				ChatColor.YELLOW + "everywhere lately!"));
		hg.setItemMeta(hg1);

		air1.setDisplayName(ChatColor.RED + "Click me or the empty spaces to exit!");
		air.setItemMeta(air1);

		// Set the items in their places.

		inv.setItem(1, main);
		inv.setItem(3, mg);
		inv.setItem(5, sw);
		inv.setItem(7, hg);
		// MAINTENANCE FOR CREATIVE
		inv.setItem(0, air);
		inv.setItem(2, air);
		inv.setItem(4, air);
		inv.setItem(6, air);
		inv.setItem(8, air);

		p.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Quick Game"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			p.closeInventory();
			return;
		}

		switch (e.getCurrentItem().getType()) {
		case COBBLESTONE:
			p.closeInventory();
			teleportInWorld(p, Bukkit.getWorld("Waiting"), 0, 4, 0);
			mainpvp(p);
			break;

		case SLIME_BALL:
			p.closeInventory();
			teleportInWorld(p, Bukkit.getWorld("Minigame"), -223, 99, 161);
			mg(p);
			break;

		case BOW:
			p.closeInventory();
			teleportInWorld(p, Bukkit.getWorld("Skywars_1"), -2.5, 99, -4.5);
			sw(p);
			break;

		case CHEST:
			p.closeInventory();
			teleportInWorld(p, Bukkit.getWorld("world"), 2076.5, 4, 783);
            hg(p);
			break;

		case STAINED_GLASS_PANE:
			p.closeInventory();
			break;

		default:
			p.closeInventory();
			break;
		}
	}

	public void mainpvp(final Player p) {
		Random rand = new Random();
		final int random = rand.nextInt(6);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				if(random == 0) {
					Bukkit.getServer().dispatchCommand(p, "mg join Battlecraft");
				}else {
					Bukkit.getServer().dispatchCommand(p, "mg join Battlecraft " + Integer.toString(random + 1)
				}
			}
		}, 40);
		p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Joined a random game in " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Main PvP.");
	}

	public void hg(final Player p) {
		Random rand = new Random();
		final int random1 = rand.nextInt(6);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				
				Bukkit.getServer().dispatchCommand(p, "sg join " + Integer.toString(random1 + 1);
			}
		}, 40);
		p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Joined a random game in " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Survival Games");
	}
	
	public void sw(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				Bukkit.getServer().dispatchCommand(p, "sw join");
			}
			}, 40);
		p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Joined a game in " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "SkyWars");
	}
	
	public void mg(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				Bukkit.getServer().dispatchCommand(p, "oitc join Coliseum");
			}
			}, 40);
		p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Joined a game in " + ChatColor.GREEN + ""
				+ ChatColor.BOLD + "Minigames");
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();

		if (a == Action.PHYSICAL || is == null || is.getType().equals(Material.AIR))
			return;

		if (is.getType().equals(Material.END_CRYSTAL))
			openGUI(e.getPlayer());
	}
}
