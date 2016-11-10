package org.battlecraft.piesrgr8.listeners;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.essentials.PlayerTp;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.staff.StaffList;
import org.battlecraft.piesrgr8.stats.StatsManager;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.battlecraft.piesrgr8.utils.online.TimerDaily;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

import net.minecraft.server.v1_9_R2.PacketPlayOutCustomSoundEffect;
import net.minecraft.server.v1_9_R2.SoundCategory;

public class PlayerListener implements Listener {

	BattlecraftServer plugin;

	public PlayerListener(BattlecraftServer p) {
		this.plugin = p;
	}

	static File f = new File("plugins/BattlecraftServer/players.yml");
	static YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

	@EventHandler
	public void onItemEnchant(EnchantItemEvent e) {
		Player p = e.getEnchanter();
		p.sendMessage(ChatColor.GOLD + "" + "You have the " + ChatColor.GOLD + "" + ChatColor.ITALIC
				+ e.getEnchantsToAdd().toString() + ChatColor.GOLD + " enchantment!");
		for (Player player : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutCustomSoundEffect(
					"notify.notifyitemenchant", SoundCategory.MASTER, p.getLocation().getBlockX(),
					p.getLocation().getBlockY(), p.getLocation().getBlockZ(), 100000.0F, 1.0F));
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();

		e.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + p.getName()
				+ ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + " joined");

		if (p.hasPermission("bc.staff")) {
			StaffList.player.add(p);
		}

		TimerDaily.timer(p);

		if (p.hasPermission("bc.admin")) {
			Admin.setupAdmin(p);
			if (yaml.getBoolean(p.getName() + ".adminM") == true) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
				p.sendMessage(BattlecraftServer.prefixAdmin + ChatColor.YELLOW
						+ "You have admin messages on. This means when people execute commands"
						+ " like /tp will be displayed to you. To toggle, use the /admin command.");
					}
			}, 150);
			}
		}

		if (yaml.contains(p.getName() + ".nick")) {
			p.setDisplayName("*" + ChatColor.translateAlternateColorCodes('&', yaml.getString(p.getName() + ".nick")));
		}

		StatsManager.createStats(p);

		PlayerTp.players.add(p.getName());
		motd(p);

		if (plugin.getConfig().getBoolean("titleonjoin") == true) {
			PacketUtil.onJoin(plugin, p);
		}

		if (!p.getWorld().getName().equalsIgnoreCase("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.teleport(new Location(Bukkit.getServer().getWorld("Hub1"), 1041, 11, 586));
				}
			}, 25);
		}
		if (!yaml.contains(p.getName())) {
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".muted");
			yaml.createSection(p.getName() + ".banned");
			yaml.createSection(p.getName() + ".logins");
			yaml.addDefault(p.getName() + ".muted", false);
			yaml.addDefault(p.getName() + ".banned", false);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (p.hasPlayedBefore() == false) {
			Bukkit.broadcastMessage(
					ChatColor.AQUA + p.getName() + ChatColor.YELLOW + " has joined for the first time!");
			yaml.createSection(p.getName());
			yaml.createSection(p.getName() + ".muted");
			yaml.createSection(p.getName() + ".banned");
			yaml.createSection(p.getName() + ".logins");
			yaml.addDefault(p.getName() + ".muted", false);
			yaml.addDefault(p.getName() + ".banned", false);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + p.getName()
				+ ChatColor.DARK_RED + "" + ChatColor.ITALIC + " left");
		PlayerTp.players.remove(p.getName());
		if (p.hasPermission("bc.staff")) {
			StaffList.player.remove(p);
		}
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if (e.getResult() == Result.KICK_FULL && e.getPlayer().hasPermission("bc.full")) {
			e.allow();
		}
		Player p = e.getPlayer();

		if (yaml.contains(p.getName() + ".nick")) {
			p.setDisplayName("*" + ChatColor.translateAlternateColorCodes('&', yaml.getString(p.getName() + ".nick")));
		}

		if (p.hasPermission("bc.admin")) {
			Admin.setupAdmin(p);
		}
	}

	public void motd(Player p) {
		int on = Bukkit.getServer().getOnlinePlayers().size();
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7&l&m>&c&m--------&7&m&l[&6&m--------&7&m&l[&f &c&lBATTLECRAFT &7&m&l]&6&m--------&7&l&m]&c&m---------&7&l&m<"));
		p.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "             &lWelcome, " + p.getDisplayName() + "!"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "             &6&lGo to a portal to get started!"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"             &lType &a&l/help&r&l for a list of commands."));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"             &lType &a&l/list&r&l to see who else is online."));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "             &lPlayers online:&a&l " + on + "&r"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "             &lEnjoy your stay!"));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7&l&m>&c&m--------&7&m&l[&6&m--------&7&m&l[&f &c&lBATTLECRAFT &7&m&l]&6&m--------&7&l&m]&c&m---------&7&l&m<"));
	}
}