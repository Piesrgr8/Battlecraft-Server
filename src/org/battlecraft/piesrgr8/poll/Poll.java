package org.battlecraft.piesrgr8.poll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Debug;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Poll implements CommandExecutor, Listener {

	BattlecraftServer plugin;

	public static HashMap<String, Integer> votes = new HashMap<String, Integer>();
	public static ArrayList<Player> player = new ArrayList<Player>();

	public Poll(BattlecraftServer p) {
		this.plugin = p;
	}

	YamlConfiguration yaml = new YamlConfiguration();

	public static void savePollYaml(BattlecraftServer plugin) {
		if (!new File(plugin.getDataFolder(), "polls.yml").exists()) {
			try {
				new File(plugin.getDataFolder(), "polls.yml").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		plugin.saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		votes.put("yes", 0);
		votes.put("no", 0);

		if (cmd.getName().equalsIgnoreCase("poll")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(BattlecraftServer.prefixPolls + ChatColor.RED + "Must be a player!");
				return true;
			}

			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.YELLOW + "There are no polls to vote for!");
				/*
				p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.YELLOW + "Your choices are: " + ChatColor.GREEN
						+ "Yes" + ChatColor.YELLOW + " or " + ChatColor.GREEN + "No.");
						*/
				return true;
			}
/*
			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("results")) {
					p.sendMessage(
							BattlecraftServer.prefixPolls + ChatColor.GREEN + votes.values() + " votes in total!");
					return true;
				}

				if (!player.contains(p)) {
					if (args[0].equalsIgnoreCase("yes")) {
						votes.put("yes", votes.get("yes") + 1);
						p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.GREEN + "You chose to "
								+ ChatColor.YELLOW + "agree" + ChatColor.GREEN + " with this change!");
						p.sendMessage(
								BattlecraftServer.prefixPolls + ChatColor.GREEN + "We are thankful for your response!");
						player.add(p);
						registerYaml1(p);
						return true;
					}

					if (args[0].equalsIgnoreCase("no")) {
						votes.put("no", votes.get("no") + 1);
						p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.GREEN + "You chose to "
								+ ChatColor.YELLOW + "disagree" + ChatColor.GREEN + " with this change!");
						p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.GREEN
								+ "We would love to know exactly what is wrong"
								+ " with our plugin. Please report it to a staff member or on our website!");
						player.add(p);
						registerYaml2(p);
						return true;
					}
				} else {
					Debug.debugConsole(
							"Player has successfully passed command, but according to the arraylist, they cant vote.");
					p.sendMessage(
							BattlecraftServer.prefixPolls + ChatColor.RED + "You have already voted for this poll!");
				}
			} */
		} 
		return true;
	}

	public void registerYaml1(Player p) {
		if (!yaml.contains(p.getName())) {
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".response");
			List<String> values = new ArrayList<String>();
			values.add("yes");
			yaml.set(p.getName() + ".response", values);
			try {
				yaml.save("plugins/BattlecraftServer/polls.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Debug.debugConsole("Player has successfully passed command, but according to the yaml, they cant vote.");
			p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.RED
					+ "But it appears that your vote has already been registered as "
					+ yaml.getStringList(p.getName()));
		}
	}

	public void registerYaml2(Player p) {
		if (!yaml.contains(p.getName())) {
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".response");
			List<String> values = new ArrayList<String>();
			values.add("no");
			yaml.set(p.getName() + ".response", values);
			try {
				yaml.save("plugins/BattlecraftServer/polls.yml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Debug.debugConsole("Player has successfully passed command, but according to the yaml, they cant vote.");
			p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.RED
					+ "But it appears that your vote has already been registered as "
					+ yaml.getStringList(p.getName()));
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		@SuppressWarnings("unused")
		final Player p = e.getPlayer();
/*
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(BattlecraftServer.prefixPolls + ChatColor.YELLOW
						+ "There is an available poll currently going on!");
				p.sendMessage(ChatColor.GREEN + "       Q: Should we expand our creative world?");
				p.sendMessage(ChatColor.YELLOW + "       Choices are " + ChatColor.GREEN + "Yes" + ChatColor.YELLOW
						+ " or " + ChatColor.GREEN + "No.");
				p.sendMessage(ChatColor.YELLOW + "       To vote, do " + ChatColor.GREEN + "/poll" + ChatColor.YELLOW
						+ ", and then your choice of yes or no.");
			}
		}, 200L); */
	} 
}
