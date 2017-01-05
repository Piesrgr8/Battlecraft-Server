package org.battlecraft.piesrgr8.players;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Friends implements CommandExecutor, Listener {

	BattlecraftServer plugin;

	public Friends(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void saveFriends(Player p) {
		File f = new File("plugins//BattlecraftServer//friends//" + p.getName() + ".yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		File f = new File("plugins//BattlecraftServer//friends//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (cmd.getName().equalsIgnoreCase("friend")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You are not a player.");
				return true;
			}

			if (args.length == 0) {
				p.sendMessage(Prefix.prefixFriend + ChatColor.YELLOW + "Arguments: <add : remove : list>");
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("add")) {
					p.sendMessage(Prefix.prefixFriend + ChatColor.YELLOW + "Now the player's name.");
					return true;
				}

				if (args[0].equalsIgnoreCase("remove")) {
					p.sendMessage(Prefix.prefixFriend + ChatColor.YELLOW + "Now the player's name.");
					return true;
				}

				if (args[0].equalsIgnoreCase("list")) {
					p.sendMessage(Prefix.prefixFriend + ChatColor.GREEN + "Opened!");
					openGUI(p);
				}
			}

			if (args.length == 2) {
				OfflinePlayer p1 = Bukkit.getServer().getOfflinePlayer(args[1]);
				if (args[0].equalsIgnoreCase("add")) {
					if (yaml.contains(args[1])) {
						p.sendMessage(Prefix.prefixFriend + ChatColor.YELLOW
								+ "You are already friends with this player!");
						return true;
					}
					p.sendMessage(Prefix.prefixFriend + ChatColor.GREEN + "You are now friends with "
							+ p1.getName());
					List<String> list = yaml.getStringList("friends");
					list.add(p1.getName());
					yaml.set("friends", list);
					try {
						yaml.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (args[0].equalsIgnoreCase("remove")) {
					if (!yaml.contains(p1.getName())) {
						p.sendMessage(Prefix.prefixFriend + ChatColor.YELLOW
								+ "You dont have that player in your friends list!");
						return true;
					}
					p.sendMessage(Prefix.prefixFriend + ChatColor.GREEN + "You have removed " + p1.getName()
							+ " from your friends list!");
					List<String> list = yaml.getStringList("friends");
					list.remove(p1.getName());
					yaml.set("friends", list);
					try {
						yaml.save(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Friends List");

		File f = new File("plugins//BattlecraftServer//friends//" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		for (int i = 0; i < yaml.getStringList("friends").size(); i++) { // Where
																			// players
																			// is
																			// an
																			// array
			// of the players in-game
			String playerName = yaml.getStringList("friends").get(i);
			Player p1 = Bukkit.getServer().getPlayer(playerName);
			ItemStack item = new ItemStack(Material.SKULL_ITEM);
			ItemMeta meta = item.getItemMeta();

			String on = null;
			String pref = null;

			if (p1 == null) {
				on = ChatColor.RED + "OFFLINE";
				pref = "Cant Recieve";
			} else {
				on = ChatColor.GREEN + "ONLINE";
				pref = RanksEnum.getPrefix(RanksEnum.getRank(p1));
			}

			meta.setDisplayName(ChatColor.YELLOW + playerName);
			meta.setLore(Arrays.asList(ChatColor.YELLOW + "They are rank:",
					pref, "",
					ChatColor.YELLOW + "They are currently:", on));
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}

		try {
			p.openInventory(inv);
		} catch (Exception e) {
			p.sendMessage(Prefix.prefixFriend + ChatColor.RED
					+ "There appears to be an error with the list. Maybe you added a player that hasnt joined the server before?");
			e.getMessage();
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Friends List"))
			return;

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			Player c = Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName().trim());
			if (!p.hasPermission("bc.teleport")) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, (float) 0.5);
				p.sendMessage(Prefix.prefixWarp + ChatColor.RED + "You dont have permission to teleport!");
				e.setCancelled(true);
			}
			if (c != null) {
				p.teleport(c.getLocation());
				Admin.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " teleported to "
						+ ChatColor.YELLOW + c.getName());
			}else{
				p.sendMessage(Prefix.prefixFriend + ChatColor.RED + "That player is offline!");
			}
		}
	}
}
