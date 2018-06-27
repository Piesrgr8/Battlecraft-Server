package org.battlecraft.piesrgr8.poll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Poll implements CommandExecutor {

	static BattlecraftServer plugin;

	public Poll(BattlecraftServer p) {
		Poll.plugin = p;
	}

	static File f = new File("plugins//BattlecraftServer//polls.yml");
	static YamlConfiguration yaml = new YamlConfiguration();

	public Integer summary() {
		int i = yaml.getInt("responses.ans1") + yaml.getInt("responses.ans2")
				+ yaml.getInt("responses.ans3" + yaml.getInt("responses.ans4"));
		return i;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("poll")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Prefix.prefixPolls + ChatColor.RED + "Must be a player!");
				return true;
			}

			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixPolls + ChatColor.YELLOW + "Your choices are: ");
				p.sendMessage("          " + ChatColor.YELLOW + "1. " + ChatColor.GREEN + "Server List");
				p.sendMessage("          " + ChatColor.YELLOW + "2. " + ChatColor.GREEN + "A friend");
				p.sendMessage("          " + ChatColor.YELLOW + "3. " + ChatColor.GREEN + "A Youtube Vid");
				p.sendMessage("          " + ChatColor.YELLOW + "4. " + ChatColor.GREEN + "I already knew");
				// p.sendMessage(Prefix.prefixPolls + ChatColor.YELLOW + "There
				// are no polls active at this time!");
				return true;
			}

			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("results")) {

					if (!f.exists()) {
						p.sendMessage(Prefix.prefixPolls + ChatColor.RED + "The file doesn't exist, creating...");
						try {
							f.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage(Prefix.prefixPolls + ChatColor.RED + "Try doing the command again now!");
						return true;
					}

					p.sendMessage(Prefix.prefixPolls + ChatColor.GREEN + summary() + " votes in total!");
					return true;
				}

				if (!hasVoted(p)) {
					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("3")
							|| args[0].equalsIgnoreCase("4")) {
						p.sendMessage(Prefix.prefixPolls + ChatColor.GREEN + "You chose " + ChatColor.YELLOW + args[0]
								+ ChatColor.GREEN + "!");
						p.sendMessage(Prefix.prefixPolls + ChatColor.GREEN + "We are thankful for your response!");
						registerYaml(p);
						registerVote(args[0]);
						return true;
					}
				} else {
					p.sendMessage(Prefix.prefixPolls + ChatColor.RED + "You have already voted for this poll!");
					return true;
				}
			}

			if (args.length >= 2) {
				p.sendMessage(Prefix.prefixPolls + ChatColor.RED + "That'll do pig. That'll do.");
				return true;
			}
		}
		return true;
	}

	public void registerVote(String s) {
		if (s.equalsIgnoreCase("1")) {
			yaml.set("responses.ans1", yaml.getInt("responses.ans1") + 1);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (s.equalsIgnoreCase("2")) {
			yaml.set("responses.ans2", yaml.getInt("responses.ans2") + 1);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (s.equalsIgnoreCase("3")) {
			yaml.set("responses.ans3", yaml.getInt("responses.ans3") + 1);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (s.equalsIgnoreCase("4")) {
			yaml.set("responses.ans4", yaml.getInt("responses.ans3") + 1);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void registerYaml(Player p) {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (!yaml.contains(p.getName())) {

			if (!yaml.contains("responses")) {
				yaml.createSection("responses");
				yaml.createSection("responses.ans1");
				yaml.createSection("responses.ans2");
				yaml.createSection("responses.ans3");
				yaml.createSection("responses.ans4");
			}

			yaml.createSection("voters");
			List<String> values = new ArrayList<String>();
			values.add(p.getName());
			yaml.set("voters", values);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean hasVoted(Player p) {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (yaml.getList("voters").contains(p.getName()))
			return true;

		return false;
	}

	public static void addInfoInYml() {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (!yaml.contains("responses") || !yaml.contains("voters")) {
			yaml.createSection("responses");
			yaml.createSection("responses.ans1");
			yaml.createSection("responses.ans2");
			yaml.createSection("responses.ans3");
			yaml.createSection("responses.ans4");
			yaml.createSection("voters");
			List<String> values = new ArrayList<String>();
			yaml.set("voters", values);
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void sendJoinMessage(final Player p) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				p.sendMessage(Prefix.prefixPolls + ChatColor.YELLOW + "There is an available poll currently going on!");
				p.sendMessage(ChatColor.GREEN + "       Q: How did you find our server?");
				p.sendMessage("          " + ChatColor.YELLOW + "1. " + ChatColor.GREEN + "Server List");
				p.sendMessage("          " + ChatColor.YELLOW + "2. " + ChatColor.GREEN + "A friend");
				p.sendMessage("          " + ChatColor.YELLOW + "3. " + ChatColor.GREEN + "A Youtube Vid");
				p.sendMessage("          " + ChatColor.YELLOW + "4. " + ChatColor.GREEN + "I already knew");
				p.sendMessage(ChatColor.YELLOW + "       To vote, do " + ChatColor.GREEN + "/poll" + ChatColor.YELLOW
						+ ", and then the # for your choice.");
			}
		}, 200L);
	}
}
