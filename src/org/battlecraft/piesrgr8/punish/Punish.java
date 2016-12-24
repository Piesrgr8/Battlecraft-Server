package org.battlecraft.piesrgr8.punish;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Punish implements Listener, CommandExecutor {
	BattlecraftServer plugin;

	public Punish(BattlecraftServer p) {
		this.plugin = p;
	}

	public enum Punishments {
		WARNING, KICK, MUTE, BAN
	}

	final String prefix = BattlecraftServer.prefixPunish;
	String exline = "\n";
	String website = ChatColor.GREEN + "www.bcpvp101.enjin.com/forum";

	public static String color(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		return msg;
	}

	public static ItemStack getSkull(String s) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta metaskull = (SkullMeta) skull.getItemMeta();
		metaskull.setOwner(s);
		skull.setItemMeta(metaskull);
		return skull;
	}

	public static ItemStack chatOffense(int i) {
		/*
		 * i = 0; the book i = 1; sev 1 i = 2; sev 2 i = 3; sev 3 i = 4; perm
		 * mute
		 */

		if (i == 0) {
			ItemStack book = new ItemStack(Material.BOOK_AND_QUILL, 1);
			ItemMeta bookmeta = book.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			bookmeta.setDisplayName(color("&a&lChat Offense"));
			lore.add(color("&7Verbal Abuse, Spam, Harrassment, Trolling, etc"));
			bookmeta.setLore(lore);
			book.setItemMeta(bookmeta);
			return book;
		} else if (i == 1) {
			ItemStack sev1 = new ItemStack(Material.INK_SACK, 1, (short) 2);

			ItemMeta meta = sev1.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&a&lSeverity 1"));
			lore.add(color("&fMute Duration: " + ChatColor.YELLOW + "10.0 Hours"));
			lore.add(color(" "));
			lore.add(color("&7Light Spam"));
			lore.add(color("&f   Sending the same message 2-5 times"));
			lore.add(color(" "));
			lore.add(color("&7Light Advertising"));
			lore.add(color("&f   'anyone want to play on mineplex?'"));
			lore.add(color(" "));
			lore.add(color("&7Light Abuse/Harassment"));
			lore.add(color("&f   'you suck at this game'"));
			lore.add(color(" "));
			lore.add(color("&7Hackusations"));
			lore.add(color("&f   'you're hacking!'"));
			lore.add(color(" "));
			lore.add(color("&7Trolling"));
			lore.add(color(" "));
			lore.add(color("&2Give Warning if 0 Past Offences and 0 Warnings."));

			meta.setLore(lore);
			sev1.setItemMeta(meta);
			return sev1;
		} else if (i == 2) {
			ItemStack sev2 = new ItemStack(Material.INK_SACK, 1, (short) 11);

			ItemMeta meta = sev2.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&e&lSeverity 2"));
			lore.add(color("&fMute Duration: " + ChatColor.YELLOW + "1.0 Days"));
			lore.add(color(" "));
			lore.add(color("&7Medium Spam"));
			lore.add(color("&f   Sending the same message 6-20 times"));
			lore.add(color(" "));
			lore.add(color("&7Medium Advertising"));
			lore.add(color("&f   Sending a specific IP in the chat"));
			lore.add(color(" "));
			lore.add(color("&7Medium Abuse/Harassment"));
			lore.add(color("&f   'piss of you stupid noob'"));
			lore.add(color("&f   'ALL THESE ADMINS ARE SHIT'"));
			lore.add(color("&f   'you're terrible, learn to play loser'"));
			lore.add(color(" "));
			lore.add(color("&7Avoiding Chat Filter"));
			lore.add(color("&f   'F|_|CK YOU'"));

			meta.setLore(lore);
			sev2.setItemMeta(meta);
			return sev2;
		} else if (i == 3) {
			ItemStack sev3 = new ItemStack(Material.INK_SACK, 1, (short) 1);

			ItemMeta meta = sev3.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&4&lSeverity 3"));
			lore.add(color("&fMute Duration: " + ChatColor.YELLOW + "30.0 Days"));
			lore.add(color(" "));
			lore.add(color("&7Severe Spam"));
			lore.add(color("&f   Sending the same message 20+ times"));
			lore.add(color("&f   Only really use this punishment for a spam bot"));
			lore.add(color(" "));
			lore.add(color("&7Severe Abuse/Harassment"));
			lore.add(color("&f   'go fucking die in a fire you fucking sack of shit'"));

			meta.setLore(lore);
			sev3.setItemMeta(meta);
			return sev3;
		} else if (i == 4) {
			ItemStack perm = new ItemStack(Material.BOOK_AND_QUILL, 1);

			ItemMeta meta = perm.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&4&l&nPermanent Mute"));
			lore.add(color("&fMute Duration: " + ChatColor.YELLOW + "Permanent"));
			lore.add(color(" "));
			lore.add(color("&7Severe Advertising:"));
			lore.add(color("&f   'JOIN MINEPLEX! THIS SUCKS!"));
			lore.add(color("&f   'join <random ip>! FREE STAFF!'"));
			lore.add(color(" "));
			lore.add(color("&2Must supply a detailed reason for Mute."));

			meta.setLore(lore);
			perm.setItemMeta(meta);
			return perm;
		}
		return null;
	}

	public static ItemStack genOffense(int i) {
		/*
		 * i = 0; the hopper i = 1; sev 1
		 */

		if (i == 0) {
			ItemStack hopper = new ItemStack(Material.HOPPER, 1);

			ItemMeta meta = hopper.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&a&lGeneral Offense"));
			lore.add(color("&7Command/Map exploits, etc"));

			meta.setLore(lore);
			hopper.setItemMeta(meta);
			return hopper;
		} else if (i == 1) {
			ItemStack sev1 = new ItemStack(Material.INK_SACK, 1, (short) 2);

			ItemMeta meta = sev1.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&a&lSeverity 1"));
			lore.add(color("&fBan Duration: " + ChatColor.YELLOW + "4.0 Hours"));
			lore.add(color(" "));
			lore.add(color("&fAbusing an exploit to gain an advantage"));
			lore.add(color("&fAbusing /a while muted to spam admins"));

			meta.setLore(lore);
			sev1.setItemMeta(meta);
			return sev1;
		}

		return null;
	}

	public static ItemStack gameOffense(int i) {
		/*
		 * i = 0; the sword i = 1; sev 1 i = 2; sev 2 i = 3; sev 3 i = 4; perm
		 * ban
		 */

		if (i == 0) {
			ItemStack book = new ItemStack(Material.IRON_SWORD, 1);
			ItemMeta bookmeta = book.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			bookmeta.setDisplayName(color("&a&lGameplay Offense"));
			lore.add(color("&7Hacking, Client Modifications"));
			bookmeta.setLore(lore);
			book.setItemMeta(bookmeta);
			return book;
		} else if (i == 1) {
			ItemStack sev1 = new ItemStack(Material.INK_SACK, 1, (short) 2);

			ItemMeta meta = sev1.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&a&lSeverity 1"));
			lore.add(color("&fBan Duration: " + ChatColor.YELLOW + "1.0 Days"));
			lore.add(color(" "));
			lore.add(color("&7Examples:"));
			lore.add(color("&f   Damage Indicators"));
			lore.add(color("&f   Player Radar"));

			meta.setLore(lore);
			sev1.setItemMeta(meta);
			return sev1;
		} else if (i == 2) {
			ItemStack sev2 = new ItemStack(Material.INK_SACK, 1, (short) 11);

			ItemMeta meta = sev2.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&e&lSeverity 2"));
			lore.add(color("&fBan Duration: " + ChatColor.YELLOW + "30.0 Days"));
			lore.add(color(" "));
			lore.add(color("&7Hacks:"));
			lore.add(color("&f   Forcefield"));
			lore.add(color("&f   Speed Hacks"));
			lore.add(color("&f   Reach Hacks"));
			lore.add(color("&f   Other Hacks"));

			meta.setLore(lore);
			sev2.setItemMeta(meta);
			return sev2;
		} else if (i == 3) {
			ItemStack sev3 = new ItemStack(Material.INK_SACK, 1, (short) 1);

			ItemMeta meta = sev3.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&4&lSeverity 3"));
			lore.add(color("&fBan Duration: " + ChatColor.YELLOW + "30.0 Days"));
			lore.add(color(" "));
			lore.add(color("&7Hacks:"));
			lore.add(color("&f   Fly Hacks"));

			meta.setLore(lore);
			sev3.setItemMeta(meta);
			return sev3;
		} else if (i == 4) {
			ItemStack perm = new ItemStack(Material.REDSTONE_BLOCK, 1);

			ItemMeta meta = perm.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName(color("&4&l&nPermanent Ban"));
			lore.add(color("&fBan Duration: " + ChatColor.YELLOW + "Permanent"));
			lore.add(color(" "));
			lore.add(color("&2Must supply a detailed reason for Ban."));

			meta.setLore(lore);
			perm.setItemMeta(meta);
			return perm;
		}
		return null;
	}

	public static ItemStack warning() {
		ItemStack perm = new ItemStack(Material.PAPER, 1);

		ItemMeta meta = perm.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		meta.setDisplayName(color("&a&lWarning"));
		lore.add(color(" "));
		lore.add(color("&7Example Warning Input: "));
		lore.add(color("&f   Spam - Repeated writing MEOW"));
		lore.add(color("&f   Swearing - Saying 'fuck' and 'shit'"));
		lore.add(color("&f   Hackusation - Accused Tomp13 of hacking"));
		lore.add(color("&f   Trolling - was trying to make bob angry in chat"));

		meta.setLore(lore);
		perm.setItemMeta(meta);
		return perm;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {

		if (commandLable.equalsIgnoreCase("punish")) {
			// TODO: Change to Ranks.WHATEVER
			if (sender.hasPermission("punish.helper")) {
				if (args.length > 1) {
					OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
					if (target != null) {
						Inventory inv = Bukkit.createInventory(null, 54, color("&4&lPunish " + target.getName()));

						inv.setItem(4, getSkull(target.getName()));
						inv.setItem(10, chatOffense(0));
						inv.setItem(19, chatOffense(1));

						inv.setItem(12, genOffense(0));
						inv.setItem(21, genOffense(1));

						inv.setItem(14, gameOffense(0));
						inv.setItem(23, gameOffense(1));

						inv.setItem(25, warning());

						Player send = (Player) sender;

						StringBuilder sb = new StringBuilder("");
						for (int i = 1; i < args.length; i++) {

							if (i == args.length - 1) {
								sb.append(args[i]);
							} else
								sb.append(args[i]).append(" ");
						}
						String s = sb.toString();

						File f = new File("plugins/BattlecraftServer/Punishments/" + target.getName() + ".yml");
						YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
						String numPunishment = Integer.toString(yaml.getKeys(false).size() + 1);
						yaml.set(numPunishment + ".reason", s);
						try {
							yaml.save(f);
						} catch (IOException e) {

							e.printStackTrace();
						}

						send.openInventory(inv);
					}
				}
			}
			// TODO: Change to Ranks.WHATEVER
			if (sender.hasPermission("punish.mod")) {
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				if (target != null) {
					Inventory inv = Bukkit.createInventory(null, 54, color("&4&lPunish " + target.getName()));

					inv.setItem(4, getSkull(target.getName()));
					inv.setItem(10, chatOffense(0));
					inv.setItem(19, chatOffense(1));
					inv.setItem(28, chatOffense(2));
					inv.setItem(37, chatOffense(3));

					inv.setItem(12, genOffense(0));
					inv.setItem(21, genOffense(1));

					inv.setItem(14, gameOffense(0));
					inv.setItem(23, gameOffense(1));
					inv.setItem(32, gameOffense(2));
					inv.setItem(41, gameOffense(3));

					inv.setItem(25, warning());
					inv.setItem(34, chatOffense(4));
					inv.setItem(43, gameOffense(4));

					Player send = (Player) sender;

					StringBuilder sb = new StringBuilder("");
					for (int i = 1; i < args.length; i++) {

						if (i == args.length - 1) {
							sb.append(args[i]);
						} else
							sb.append(args[i]).append(" ");
					}
					String s = sb.toString();

					File f = new File("plugins/BattlecraftServer/Punishments/" + target.getName() + ".yml");
					YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
					String numPunishment = Integer.toString(yaml.getKeys(false).size());
					yaml.set(numPunishment + ".reason", s);
					try {
						yaml.save(f);
					} catch (IOException e) {

						e.printStackTrace();
					}

					send.openInventory(inv);
				}
			}

		}
		return true;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player punisher = (Player) e.getWhoClicked();
		if (inv != null) {
			if (inv.getName().contains(color("&4&lPunish"))) {

				OfflinePlayer punished;
				YamlConfiguration yaml;

				String Invname = ChatColor.stripColor(inv.getName());
				String Playername = Invname.replaceAll("Punish ", "");
				punished = Bukkit.getOfflinePlayer(Playername);

				File f = new File("plugins/BattlecraftServer/Punishments/" + punished.getName() + ".yml");
				yaml = YamlConfiguration.loadConfiguration(f);

				e.setCancelled(true);

				if (e.getSlot() == 19) {
					int seconds = 36000;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "mute");
					yaml.set(numPunishment + ".severity", 1);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {

						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer()
								.sendMessage(prefix + ChatColor.YELLOW + "You have been muted for 10.0 Hours for "
										+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + ".");
					}

					// TODO: Punish sev1 Chat
				} else if (e.getSlot() == 21) {
					int seconds = 86400;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "ban");
					yaml.set(numPunishment + ".severity", 1);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer()
								.kickPlayer(prefix + exline + ChatColor.YELLOW + "You have been banned for 1 Day for "
										+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + "." + exline
										+ ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
					}
					// TODO: Punish sev1 Gen
				} else if (e.getSlot() == 23) {
					int seconds = 86400;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "ban");
					yaml.set(numPunishment + ".severity", 1);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer().kickPlayer(prefix + exline + ChatColor.YELLOW + "You have been banned for 1.0 Day for "
								+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + "." + exline
								+ ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
					}
					// TODO: Punish sev1 Game
				} else if (e.getSlot() == 25) {

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "warning");
					yaml.set(numPunishment + ".punisher", punisher.getName());
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer().sendMessage(prefix + ChatColor.YELLOW + "You have been warned for "
								+ ChatColor.RED + yaml.getString(numPunishment + ".reason") + ".");
					}
					// TODO: Punish warning
				} else if (e.getSlot() == 28) {
					int seconds = 86400;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "mute");
					yaml.set(numPunishment + ".severity", 2);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer()
								.sendMessage(prefix + ChatColor.YELLOW + "You have been muted for 1.0 Day for "
										+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + ".");
					}
					// TODO: Punish sev2 Chat
				} else if (e.getSlot() == 32) {
					int seconds = 2592000;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "ban");
					yaml.set(numPunishment + ".severity", 2);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer().kickPlayer(prefix + exline + ChatColor.YELLOW + "You have been banned for 30.0 Days for "
								+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + "." + exline
								+ ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
					}
					// TODO: Punish sev2 Game
				} else if (e.getSlot() == 34) {

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "mute");
					yaml.set(numPunishment + ".severity", 4);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".duration", -1);
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer()
								.sendMessage(prefix + ChatColor.YELLOW + "You have been muted permanently for "
										+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + ".");
					}
					// TODO: Perm mute
				} else if (e.getSlot() == 37) {
					int seconds = 2592000;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "mute");
					yaml.set(numPunishment + ".severity", 3);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (punished.isOnline()) {
						punished.getPlayer()
								.sendMessage(prefix + ChatColor.YELLOW + "You have been muted for 30.0 Days for "
										+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + ".");
					}
					// TODO Punish sev3 Chat
				} else if (e.getSlot() == 41) {
					int seconds = 2592000;
					long currentTime = System.currentTimeMillis() / 1000L;
					long finished = currentTime + seconds;

					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "ban");
					yaml.set(numPunishment + ".severity", 3);
					yaml.set(numPunishment + ".duration", finished);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
					}

					if (punished.isOnline()) {
						punished.getPlayer().kickPlayer(prefix + exline + ChatColor.YELLOW + "You have been banned for 30.0 Days for "
								+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + "."  + exline
								+ ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
					}
					// TODO Punish sev3 Game
				} else if (e.getSlot() == 43) {
					String numPunishment = Integer.toString(yaml.getKeys(false).size());

					yaml.set(numPunishment + ".punishment", "ban");
					yaml.set(numPunishment + ".severity", 4);
					yaml.set(numPunishment + ".punisher", punisher.getName());
					yaml.set(numPunishment + ".duration", -1);
					yaml.set(numPunishment + ".active", true);
					try {
						yaml.save(f);
					} catch (IOException e1) {
					}

					if (punished.isOnline()) {
						punished.getPlayer().kickPlayer(prefix + exline + ChatColor.YELLOW + "You have been banned permanently for "
								+ ChatColor.GOLD + yaml.getString(numPunishment + ".reason") + "."  + exline
								+ ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
					}
					// TODO Perm ban
				} else {
					String numPunishment = Integer.toString(yaml.getKeys(false).size());
					yaml.set(numPunishment, null);
					try {
						yaml.save(f);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					punisher.closeInventory();
					punisher.sendMessage(prefix + ChatColor.YELLOW + "Cancelled punishment");
				}

				punisher.closeInventory();
			}

		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent e) {
		File f = new File("plugins/BattlecraftServer/Punishments/" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		checkToUnpunish(e.getPlayer());
		if (this.isPlayerCurrentlyPunished(e.getPlayer(), Punishments.BAN)) {
			for (String s : yaml.getKeys(false)) {
				if (yaml.getBoolean(s + ".active") && yaml.get(s + ".punishment").equals("ban")) {
					if (!yaml.get(s + ".duration").equals(-1)) {
						long remaining = (yaml.getLong(s + ".duration") - System.currentTimeMillis() / 1000L);
						String type = " more seconds";
						if (remaining > 59) {
							remaining = remaining / 60;
							if (remaining != 1)
								type = " more minutes!";
							else
								type = " more minute";

							if (remaining > 59) {
								remaining = remaining / 60;

								if (remaining != 1)
									type = " more hours!";
								else
									type = " more hour";

								if (remaining > 23) {
									remaining = remaining / 24;

									if (remaining != 1)
										type = " more days!";
									else
										type = " more day";
								}
							}

							e.disallow(Result.KICK_BANNED,
									prefix + exline + ChatColor.YELLOW + "You have been banned for " + ChatColor.GOLD + remaining + ChatColor.GOLD
											+ type + exline + ChatColor.YELLOW + "Reason for this is because of " + ChatColor.GREEN + yaml.get(s + ".reason")
											+ exline + ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);
						}
					} else {
						e.disallow(Result.KICK_BANNED, prefix + "You have been banned permanently!" + exline + ChatColor.YELLOW + "Reason for this is because of " + ChatColor.GREEN + yaml.get(s + ".reason")
						+ exline + ChatColor.YELLOW + "If you believe that this is a mistake, submit an appeal!" + exline + website);

					}
				}

			}
		}

	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		File f = new File("plugins/BattlecraftServer/Punishments/" + e.getPlayer().getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		checkToUnpunish(e.getPlayer());
		if (this.isPlayerCurrentlyPunished(e.getPlayer(), Punishments.MUTE)) {
			e.setCancelled(true);
			for (String s : yaml.getKeys(false)) {
				if (!yaml.get(s + ".duration").equals(-1)) {
					long remaining = (yaml.getLong(s + ".duration") - System.currentTimeMillis() / 1000L);
					String type = " more seconds!";
					if (remaining > 59) {
						remaining = remaining / 60;
						if (remaining != 1)
							type = " more minutes!";
						else
							type = " more minute!";

						if (remaining > 59) {
							remaining = remaining / 60;

							if (remaining != 1)
								type = " more hours!";
							else
								type = " more hour!";

							if (remaining > 23) {
								remaining = remaining / 24;

								if (remaining != 1)
									type = " more days!";
								else
									type = " more day!";
							}
						}

					}

					if (remaining < 61) {
						e.getPlayer().sendMessage(prefix + ChatColor.RED + "" + ChatColor.BOLD + "MUTED! " + ChatColor.YELLOW + "You must wait for "
								+ ChatColor.GOLD + remaining + ChatColor.GRAY + type);
					}
				} else {
					e.getPlayer().sendMessage(prefix + ChatColor.RED + "" + ChatColor.BOLD + "MUTED! " + ChatColor.YELLOW + "This effect is permanent!");
				}

			}

		}
	}

	public void checkToUnpunish(OfflinePlayer p) {
		File f = new File("plugins/BattlecraftServer/Punishments/" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		for (String s : yaml.getKeys(false)) {
			if (yaml.get(s + ".active") != null) {
				if (yaml.getBoolean(s + ".active")) {
					if (yaml.get(s + ".duration").equals(-1)) {
						break;
					}

					if ((System.currentTimeMillis() / 1000L) >= yaml.getLong(s + ".duration")) {
						yaml.set(s + ".duration", "");
						yaml.set(s + ".active", "false");
						try {
							yaml.save(f);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public boolean isPlayerCurrentlyPunished(OfflinePlayer p, Punishments punish) {
		File f = new File("plugins/BattlecraftServer/Punishments/" + p.getName() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (punish.equals(Punishments.MUTE)) {
			for (String s : yaml.getKeys(false)) {
				if (yaml.getBoolean(s + ".active") && yaml.get(s + ".punishment").equals("mute")) {
					return true;
				}
			}
		} else if (punish.equals(Punishments.BAN)) {
			for (String s : yaml.getKeys(false)) {
				if (yaml.getBoolean(s + ".active") && yaml.get(s + ".punishment").equals("ban")) {
					return true;
				}
			}
		}

		return false;
	}
}
