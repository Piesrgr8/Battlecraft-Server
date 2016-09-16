package org.battlecraft.piesrgr8.hub;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.ErrorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hub implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	static File f = new File("plugins/BattlecraftServer/spawns.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	public Hub(BattlecraftServer p) {
		this.plugin = p;
	}

	public void teleportInWorld(Player player, World world, double x, double y, double z) {
		player.teleport(new Location(world, x, y, z));

		if (world == null) {
			player.sendMessage(BattlecraftServer.prefixHub + ChatColor.RED + "This world doesnt exist!");
		}
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Game Selector");

		// Creating the items and registering them.

		ItemStack main = new ItemStack(Material.COBBLESTONE);
		ItemMeta main1 = main.getItemMeta();

		ItemStack mg = new ItemStack(Material.SLIME_BALL);
		ItemMeta mg1 = mg.getItemMeta();

		ItemStack sw = new ItemStack(Material.BOW);
		ItemMeta sw1 = sw.getItemMeta();

		ItemStack hg = new ItemStack(Material.CHEST);
		ItemMeta hg1 = hg.getItemMeta();

		ItemStack fc = new ItemStack(Material.IRON_SWORD);
		ItemMeta fc1 = fc.getItemMeta();

		ItemStack gm = new ItemStack(Material.WOOD_AXE);
		ItemMeta gm1 = gm.getItemMeta();

		ItemStack sb = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta sb1 = sb.getItemMeta();

		ItemStack hub = new ItemStack(Material.ENDER_PEARL);
		ItemMeta hub1 = hub.getItemMeta();

		ItemStack shop = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta shop1 = shop.getItemMeta();

		ItemStack air = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta air1 = air.getItemMeta();

		ItemStack work = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta work1 = work.getItemMeta();

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

		fc1.setDisplayName(ChatColor.GREEN + "Factions");
		fc1.setLore(Arrays.asList(ChatColor.YELLOW + "A survival game that",
				ChatColor.YELLOW + "puts you in an open world,", ChatColor.YELLOW + "surrounded by trees, and the",
				ChatColor.YELLOW + "wild!"));
		fc.setItemMeta(fc1);

		gm1.setDisplayName(ChatColor.LIGHT_PURPLE + "Creative");
		gm1.setLore(Arrays.asList(ChatColor.YELLOW + "Sit back and relax!",
				ChatColor.YELLOW + "Join here to build whatever", ChatColor.YELLOW + "pops up in your head!"));
		gm.setItemMeta(gm1);

		sb1.setDisplayName(ChatColor.AQUA + "SkyBlock");
		sb1.setLore(Arrays.asList(ChatColor.YELLOW + "You are stranded on a",
				ChatColor.YELLOW + "floating block, with resources", ChatColor.YELLOW + "that will help you live",
				ChatColor.YELLOW + ".....for a while."));
		sb.setItemMeta(sb1);

		hub1.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "RETURN TO HUB");
		hub1.setLore(Arrays.asList(ChatColor.YELLOW + "Return to the main hub!"));
		hub.setItemMeta(hub1);

		shop1.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "SHOP");
		shop1.setLore(Arrays.asList(ChatColor.YELLOW + "Go to the shop and",
				ChatColor.YELLOW + "buy some resources for", ChatColor.YELLOW + "your trip!"));
		shop.setItemMeta(shop1);

		air1.setDisplayName(ChatColor.RED + "Click me or the empty spaces to exit!");
		air.setItemMeta(air1);

		work1.setDisplayName(ChatColor.LIGHT_PURPLE + "Creative");
		work1.setLore(Arrays.asList(ChatColor.RED + "" + ChatColor.BOLD + "THIS MODE IS CURRENTLY",
				ChatColor.RED + "" + ChatColor.BOLD + "IN MAINTENANCE!"));
		work.setItemMeta(work1);

		// Set the items in their places.

		inv.setItem(1, main);
		inv.setItem(2, mg);
		inv.setItem(3, sw);
		inv.setItem(4, hg);
		inv.setItem(5, fc);
		// MAINTENANCE FOR CREATIVE
		inv.setItem(6, work);
		inv.setItem(7, sb);
		inv.setItem(10, hub);
		inv.setItem(16, shop);

		inv.setItem(0, air);
		inv.setItem(8, air);
		inv.setItem(9, air);
		inv.setItem(11, air);
		inv.setItem(12, air);
		inv.setItem(13, air);
		inv.setItem(14, air);
		inv.setItem(15, air);
		inv.setItem(17, air);

		p.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Game Selector"))
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
			teleportInWorld(p, Bukkit.getWorld("world"), 843, 2, 541);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Main PvP.");
			break;

		case SLIME_BALL:
			teleportInWorld(p, Bukkit.getWorld("Minigame"), -266.5, 114, 284.5);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Minigames.");
			break;

		case BOW:
			teleportInWorld(p, Bukkit.getWorld("Skywars_1"), -2.5, 99, -4.5);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "SkyWars.");
			break;

		case CHEST:
			teleportInWorld(p, Bukkit.getWorld("world"), 2076.5, 4, 783);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Survival Games.");
			break;

		case IRON_SWORD:
			teleportInWorld(p, Bukkit.getWorld("Factions"), -110.5, 67, -236.5);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Factions.");
			break;

		// CHANGE TO WOOD_AXE LATER!
		case IRON_PICKAXE:
			// teleportInWorld(p, Bukkit.getWorld("Creative"), -350.5, 245,
			// 663.5);
			p.closeInventory();
			/*
			 * p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN +
			 * "Teleported to " + ChatColor.GREEN + "" + ChatColor.BOLD +
			 * "Creative.");
			 */
			ErrorUtil.cantTeleport(p, "Creative");
			break;

		case LAVA_BUCKET:
			teleportInWorld(p, Bukkit.getWorld("Hub1"), 1082, 5, 618.5);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "SkyBlock.");
			break;

		case ENDER_PEARL:
			teleportInWorld(p, Bukkit.getWorld("Hub1"), 1041, 11, 586);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Hub.");
			break;

		case EXP_BOTTLE:
			teleportInWorld(p, Bukkit.getWorld("world"), 1816, 4, 577);
			p.closeInventory();
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Shop.");
			break;

		case STAINED_GLASS_PANE:
			p.closeInventory();
			break;

		default:
			p.closeInventory();
			break;
		}

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();

		if (a == Action.PHYSICAL || is == null || is.getType().equals(Material.AIR))
			return;

		if (is.getType().equals(Material.NETHER_STAR) && is.hasItemMeta())
			openGUI(e.getPlayer());
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sethub")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixHub + "Cant set spawn as a computer.");
				return true;
			}

			Player p = (Player) sender;
			if (!p.hasPermission("bc.sethub")) {
				p.sendMessage(BattlecraftServer.prefixHub + ChatColor.RED + "You are not allowed to set the hub!");
				return true;
			}

			yaml.createSection("hub");
			yaml.createSection("hub.world");
			yaml.createSection("hub.x");
			yaml.createSection("hub.y");
			yaml.createSection("hub.z");
			yaml.set("hub.world", p.getWorld().getName());
			yaml.set("hub.x", p.getLocation().getX());
			yaml.set("hub.y", p.getLocation().getY());
			yaml.set("hub.z", p.getLocation().getZ());
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Spawn set for the hub!");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("hub") || cmd.getName().equalsIgnoreCase("spawn")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixHub + ChatColor.RED + "Cant spawn in as a computer.");
				return true;
			}
			if (yaml.get("hub.world") == null && yaml.get("hub.x") == null && yaml.get("hub.y") == null
					&& yaml.get("hub.z") == null) {
				sender.sendMessage(BattlecraftServer.prefixHub + ChatColor.RED + "The hub hasnt been set yet!");
				return true;
			}

			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(yaml.getString("hub.world"));
			double x = yaml.getDouble("hub.x");
			double y = yaml.getDouble("hub.y");
			double z = yaml.getDouble("hub.z");
			p.teleport(new Location(w, x, y, z));
			p.sendMessage(BattlecraftServer.prefixHub + ChatColor.GREEN + "Teleported to " + ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Hub.");
			return true;
		}
		return true;
	}
}
