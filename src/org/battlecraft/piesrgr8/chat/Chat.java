package org.battlecraft.piesrgr8.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.clans.Clans;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.battlecraft.piesrgr8.essentials.Nick;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public Chat(BattlecraftServer p) {
		this.plugin = p;
	}

	static File fl = ConfigMg.chat;
	static YamlConfiguration yamlc = ConfigMg.chatY;
	static ArrayList<Player> cd = new ArrayList<Player>();

	public void addVal() {
		if (fl.exists()) {
			yamlc.createSection("muted");
			yamlc.createSection("cooldown");
			yamlc.createSection("muted.active");
			yamlc.createSection("cooldown.sec");

			yamlc.set("muted.active", false);
			yamlc.set("cooldown.sec", 0);

			try {
				yamlc.save(fl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("chat")) {
			addVal();

			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					p.sendMessage(Prefix.prefixChat + ChatColor.RED + "Arguments not met:");
					p.sendMessage("             " + ChatColor.YELLOW + "/chat mute <yes:no>");
					p.sendMessage("             " + ChatColor.YELLOW + "/chat cooldown <sec>");
					return true;
				}

				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("mute")) {
						p.sendMessage(Prefix.prefixChat + ChatColor.YELLOW + "Yes or No?");
						return true;
					}

					if (args[0].equalsIgnoreCase("cooldown")) {
						p.sendMessage(
								Prefix.prefixChat + ChatColor.YELLOW + "How long would you like the cooldown to be?");
						return true;
					}
				}

				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("mute") && args[1].equalsIgnoreCase("true")) {
						if (yamlc.getBoolean("muted.active") == false) {
							yamlc.set("muted.active", true);
							try {
								yamlc.save(fl);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(Prefix.prefixChat + ChatColor.GREEN + "Chat has been muted!");
							return true;
						}
					}

					if (args[0].equalsIgnoreCase("mute") && args[1].equalsIgnoreCase("false")) {
						if (yamlc.getBoolean("muted.active") == true) {
							yamlc.set("muted.active", false);
							try {
								yamlc.save(fl);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						p.sendMessage(Prefix.prefixChat + ChatColor.GREEN + "Chat has been unmuted!");
						return true;
					}

					if (args[0].equalsIgnoreCase("cooldown")) {
						int in = Integer.parseInt(args[1]);
						if (in > 59) {
							p.sendMessage(Prefix.prefixChat + ChatColor.RED
									+ "You cannot set a cooldown higher than 60 seconds!");
							return true;
						}
						yamlc.set("cooldown.sec", in);
						p.sendMessage(Prefix.prefixChat + ChatColor.GREEN + "Cooldown set to " + in + " seconds!");
						try {
							yamlc.save(fl);
						} catch (IOException e) {
							e.printStackTrace();
						}
						return true;
					}
				}
			} else {

				if (label.equalsIgnoreCase("chat")) {
					ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();

					if (args.length == 0) {
						con.sendMessage(Prefix.prefixChat + ChatColor.RED + "Arguments not met:");
						con.sendMessage(ChatColor.YELLOW + "/chat mute <true:false>");
						con.sendMessage(ChatColor.YELLOW + "/chat cooldown <sec>");
						return true;
					}

					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("mute")) {
							con.sendMessage(Prefix.prefixChat + ChatColor.YELLOW + "True or False?");
							return true;
						}

						if (args[0].equalsIgnoreCase("cooldown")) {
							con.sendMessage(Prefix.prefixChat + ChatColor.YELLOW
									+ "How long would you like the cooldown to be?");
							return true;
						}
					}

					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("mute") && args[1].equalsIgnoreCase("true")) {
							if (yamlc.getBoolean("muted.active") == false) {
								yamlc.set("muted.active", true);
								try {
									yamlc.save(fl);
								} catch (IOException e) {
									e.printStackTrace();
								}
								con.sendMessage(Prefix.prefixChat + ChatColor.GREEN + "Chat has been muted!");
								return true;
							}
						}

						if (args[0].equalsIgnoreCase("mute") && args[1].equalsIgnoreCase("false")) {
							if (yamlc.getBoolean("muted.active") == true) {
								yamlc.set("muted.active", false);
								try {
									yamlc.save(fl);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							con.sendMessage(Prefix.prefixChat + ChatColor.GREEN + "Chat has been unmuted!");
							return true;
						}

						if (args[0].equalsIgnoreCase("cooldown")) {
							int in = Integer.parseInt(args[1]);
							if (in > 59) {
								con.sendMessage(Prefix.prefixChat + ChatColor.RED
										+ "You cannot set a cooldown higher than 60 seconds!");
								return true;
							}
							yamlc.set("cooldown.sec", in);
							con.sendMessage(
									Prefix.prefixChat + ChatColor.GREEN + "Cooldown set to " + in + " seconds!");
							try {
								yamlc.save(fl);
							} catch (IOException e) {
								e.printStackTrace();
							}
							return true;
						}
					}
				}
			}
		}
		return true;
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();

		if (yamlc.getBoolean("muted.active") == true) {
			p.sendMessage(Prefix.prefixChat + ChatColor.RED + "The chat has been muted by a staff member!");
			e.setCancelled(true);
			return;
		}

		if (cd.contains(p)) {
			p.sendMessage(Prefix.prefixChat + ChatColor.RED + "There is currently a cooldown of "
					+ yamlc.getInt("cooldown.sec") + " seconds!");
			e.setCancelled(true);
			return;
		}

		addToList(p);

		// Using the new UUID system!!
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		String nick = Nick.getNick(fromUUID);

		// This was just to avoid any errors when making a message. Had
		// something to do with ChatColor.
		if (e.getMessage().contains("%")) {
			e.setMessage(e.getMessage().replaceAll("%", "percent"));
		}

		// If the rank is existent, then use the format for that specific rank.
		if (RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			e.setFormat(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY
							+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));

			// If a player has a nickname in their play info yml, use it as
			// their message format.
			if (yaml.contains(fromUUID.getName() + ".nick")
					&& !yaml.getString(fromUUID.getName() + ".nick").equals(fromUUID.getName())) {
				try {
					e.setFormat(ChatColor.translateAlternateColorCodes('&',
							RanksEnum.getPrefix(RanksEnum.getRank(p)) + " *" + nick + " " + ChatColor.GRAY + ""
									+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
				} catch (Exception e1) {
					e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "ERR " + ChatColor.GRAY
							+ fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
							+ ChatColor.GRAY + e.getMessage());
					e1.getMessage();
				}
			}

			if (Clans.isInClan(fromUUID)) {
				try {
					e.setFormat(ChatColor.translateAlternateColorCodes('&',
							RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " "
									+ ChatColor.GRAY + "[" + Clans.getClanTag(p) + "] " + ChatColor.GRAY + ""
									+ ChatColor.BOLD + "> " + ChatColor.RESET + e.getMessage()));
				} catch (Exception e1) {
					e.setFormat(ChatColor.RED + "" + ChatColor.BOLD + "ERR " + ChatColor.GRAY
							+ fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
							+ ChatColor.GRAY + e.getMessage());
					e1.getMessage();
				}
			}
		} else {
			// Otherwise, use the default format.
			e.setFormat(ChatColor.GRAY + fromUUID.getDisplayName() + " " + ChatColor.GRAY + "" + ChatColor.BOLD + "> "
					+ ChatColor.GRAY + e.getMessage());
		}
	}

	public static void sendFormattedMessage(Player p, String msg) {
		String uuid = p.getUniqueId().toString();
		Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
		if (RanksEnum.getPrefix(RanksEnum.getRank(p)) != "") {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p)) + " " + fromUUID.getDisplayName() + " " + ChatColor.GRAY
							+ "" + ChatColor.BOLD + "> " + ChatColor.RESET + msg));
		}
	}

	public static void sendFormattedStaffMessage(Player p, String msg) {
		if (!RanksEnum.staff.contains(p)) {
			return;
		}

		// LOOK AT THIS LATER!!

		int rand = new Random().nextInt(RanksEnum.staff.size());
		Player p1 = RanksEnum.staff.get(rand);

		if (RanksEnum.getPrefix(RanksEnum.getRank(p1)) != "") {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p1)) + " " + p1.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + msg));
		}
	}

	public static void sendFormattedAdminMessage(Player p, String msg) {
		if (!RanksEnum.admin.contains(p)) {
			return;
		}

		// LOOK AT THIS LATER!!

		int rand = new Random().nextInt(RanksEnum.admin.size());
		Player p1 = RanksEnum.admin.get(rand);

		if (RanksEnum.getPrefix(RanksEnum.getRank(p1)) != "") {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
					RanksEnum.getPrefix(RanksEnum.getRank(p1)) + " " + p1.getDisplayName() + " " + ChatColor.GRAY + ""
							+ ChatColor.BOLD + "> " + ChatColor.RESET + msg));
		}
	}

	public void addToList(final Player p) {
		int i = yamlc.getInt("cooldown.sec");
		if (i == 0) {
			return;
		}

		cd.add(p);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				cd.remove(p);
			}
		}, i * 20);
	}
}
