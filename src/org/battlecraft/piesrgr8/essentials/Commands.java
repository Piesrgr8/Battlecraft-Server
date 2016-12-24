package org.battlecraft.piesrgr8.essentials;

import java.util.ArrayList;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.chat.Send;
import org.battlecraft.piesrgr8.chat.Tell;
import org.battlecraft.piesrgr8.fake.FakeBan;
import org.battlecraft.piesrgr8.fake.FakeJoin;
import org.battlecraft.piesrgr8.fake.FakeKick;
import org.battlecraft.piesrgr8.fake.ForceOp;
import org.battlecraft.piesrgr8.fake.Spammer;
import org.battlecraft.piesrgr8.hub.Hub;
import org.battlecraft.piesrgr8.hub.Menus;
import org.battlecraft.piesrgr8.inventory.Clear;
import org.battlecraft.piesrgr8.inventory.Enderchest;
import org.battlecraft.piesrgr8.inventory.Invsee;
import org.battlecraft.piesrgr8.particles.Particles;
import org.battlecraft.piesrgr8.players.Friends;
import org.battlecraft.piesrgr8.players.ListPlayer;
import org.battlecraft.piesrgr8.poll.Poll;
import org.battlecraft.piesrgr8.punish.Punish;
import org.battlecraft.piesrgr8.shop.Kiosk;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.staff.Ask;
import org.battlecraft.piesrgr8.staff.StaffCommand;
import org.battlecraft.piesrgr8.stats.StatsManager;
import org.battlecraft.piesrgr8.support.Issue;
import org.battlecraft.piesrgr8.support.Report;
import org.battlecraft.piesrgr8.utils.ClickChat;
import org.battlecraft.piesrgr8.utils.MaintenanceCommand;
import org.battlecraft.piesrgr8.utils.Skulls;
import org.battlecraft.piesrgr8.utils.Test;
import org.battlecraft.piesrgr8.weapons.Armors;
import org.battlecraft.piesrgr8.weapons.CommandEnchant;
import org.battlecraft.piesrgr8.weapons.Weapons;
import org.battlecraft.piesrgr8.world.WorldHandler;
import org.battlecraft.piesrgr8.world.WorldSave;
import org.battlecraft.piesrgr8.world.WorldScanProx;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	BattlecraftServer plugin;

	public Commands(BattlecraftServer p) {
		this.plugin = p;
	}

	//Any command that is in this plugin is registered here.
	public static void registerCommands(BattlecraftServer plugin) {
		plugin.getCommand("admin").setExecutor(new Admin(plugin));
		plugin.getCommand("armor").setExecutor(new Armors());
		plugin.getCommand("answer").setExecutor(new Ask());
		plugin.getCommand("ask").setExecutor(new Ask());
		plugin.getCommand("bc").setExecutor(new Commands(plugin));
		plugin.getCommand("clear").setExecutor(new Clear());
		plugin.getCommand("death").setExecutor(new Health());
		plugin.getCommand("enchant").setExecutor(new CommandEnchant(plugin));
		plugin.getCommand("enderchest").setExecutor(new Enderchest());
		plugin.getCommand("fakej").setExecutor(new FakeJoin());
		plugin.getCommand("fakel").setExecutor(new FakeJoin());
		plugin.getCommand("fakeb").setExecutor(new FakeBan());
		plugin.getCommand("fakek").setExecutor(new FakeKick());
		plugin.getCommand("fly").setExecutor(new Fly());
		plugin.getCommand("forceop").setExecutor(new ForceOp(plugin));
		plugin.getCommand("friend").setExecutor(new Friends(plugin));
		plugin.getCommand("g0").setExecutor(new Gamemode());
		plugin.getCommand("g1").setExecutor(new Gamemode());
		plugin.getCommand("g2").setExecutor(new Gamemode());
		plugin.getCommand("heal").setExecutor(new Health());
		plugin.getCommand("hub").setExecutor(new Hub(plugin));
		plugin.getCommand("information").setExecutor(new Commands(plugin));
		plugin.getCommand("invsee").setExecutor(new Invsee());
		plugin.getCommand("issue").setExecutor(new Issue());
		plugin.getCommand("kit").setExecutor(new Kits(plugin));
		plugin.getCommand("kiosk").setExecutor(new Kiosk(plugin));
		plugin.getCommand("maintenance").setExecutor(new MaintenanceCommand(plugin));
		plugin.getCommand("menu").setExecutor(new Menus(plugin));
		plugin.getCommand("nick").setExecutor(new Nick());
		plugin.getCommand("particle").setExecutor(new Particles(plugin));
		plugin.getCommand("player").setExecutor(new ListPlayer(plugin));
		plugin.getCommand("poll").setExecutor(new Poll(plugin));
		plugin.getCommand("punish").setExecutor(new Punish(plugin));
		plugin.getCommand("report").setExecutor(new Report());
		plugin.getCommand("save").setExecutor(new WorldSave(plugin));
		plugin.getCommand("scan").setExecutor(new WorldScanProx());
		plugin.getCommand("send").setExecutor(new Send(plugin));
		plugin.getCommand("sethub").setExecutor(new Hub(plugin));
		plugin.getCommand("setwarp").setExecutor(new Teleportation());
		plugin.getCommand("skull").setExecutor(new Skulls(plugin));
		plugin.getCommand("spam").setExecutor(new Spammer(plugin));
		plugin.getCommand("spawn").setExecutor(new Hub(plugin));
		plugin.getCommand("staff").setExecutor(new StaffCommand());
		plugin.getCommand("stats").setExecutor(new StatsManager(plugin));
		plugin.getCommand("sword").setExecutor(new Weapons(plugin));
		plugin.getCommand("tell").setExecutor(new Tell());
		plugin.getCommand("test").setExecutor(new Test(plugin));
		plugin.getCommand("tp").setExecutor(new Teleportation());
		plugin.getCommand("tpc").setExecutor(new Teleportation());
		plugin.getCommand("tphere").setExecutor(new Teleportation());
		plugin.getCommand("updaterank").setExecutor(new RanksEnum(plugin));
		plugin.getCommand("vs").setExecutor(new Invisibility());
		plugin.getCommand("website").setExecutor(new ClickChat(plugin));
		plugin.getCommand("warp").setExecutor(new Teleportation());
		plugin.getCommand("whois").setExecutor(new Whois());
		plugin.getCommand("world").setExecutor(new WorldHandler(plugin));
	}

	// THIS IS THE RELOAD COMMAND & MAIN COMMAND
	//heckin memes boi
	
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("bc")) {
			if (!sender.hasPermission("bc.main")) {
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.RED + "You don't have permission to use "
						+ ChatColor.YELLOW + "/bc!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Version: "
						+ plugin.getDescription().getVersion());
				sender.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + "Creator: " + ChatColor.GOLD
						+ plugin.getDescription().getAuthors());
				return true;
			}

			// Reloading the configuration

			if (args[0].equalsIgnoreCase("reload")) {
				if (args.length == 1) {
					plugin.reloadConfig();
					sender.sendMessage(
							BattlecraftServer.prefixMain + ChatColor.GREEN + "This has been passed successfully!");
					return true;
				}
			}

			// Broadcasting

			if (args.length > 0) {
				if (cmd.getName().equalsIgnoreCase("addp") || cmd.getName().equalsIgnoreCase("reload")) {
					return false;
				}

				String bc = "";
				for (String message : args) {
					bc = (bc + ChatColor.translateAlternateColorCodes('&', message) + " ");
				}
				Bukkit.getServer().broadcastMessage(BattlecraftServer.prefixMain + ChatColor.GREEN + bc);
			}
		}

		List<String> info = new ArrayList<String>();
		info = plugin.getConfig().getStringList("helpblockmessages");

		if (cmd.getName().equalsIgnoreCase("information")) {
			for (int i = 0; i < info.size(); i++) {
				String s = info.get(i);
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
				return true;
			}
		}
		return true;
	}
}
