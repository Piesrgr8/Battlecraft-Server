package org.battlecraft.piesrgr8.listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.essentials.PlayerTp;
import org.battlecraft.piesrgr8.party.Party;
import org.battlecraft.piesrgr8.players.Friends;
import org.battlecraft.piesrgr8.stats.StatsManager;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.battlecraft.piesrgr8.utils.ScoreboardMg;
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
	public static ArrayList<String> defaults = new ArrayList<String>();

	public PlayerListener(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	// Whenever someone enchants an item, they will be told what the enchantment
	// was, and play a soundeffect.
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
		String uuid = p.getUniqueId().toString();
		final Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));
		defaults.add(p.getName());

		// Set the join message for everyone to see.
		e.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + fromUUID.getName()
				+ ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + " joined");

		// Save the friends list and start the daily timer.
		Friends.saveFriends(p);
		TimerDaily.timer(p);

		// For admins only. If dont have this perm, then this wont execute.
		if (RanksEnum.isAtLeast(p, Ranks.ADMIN)) {
			File f = new File("plugins//BattlecraftServer//players//" + fromUUID.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			if (yaml.getBoolean(fromUUID.getName() + ".adminM")) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						fromUUID.sendMessage(Prefix.prefixAdmin + ChatColor.YELLOW
								+ "You have admin messages on. This means when people execute commands"
								+ " like /tp will be displayed to you. To toggle, use the /admin command.");
					}
				}, 150);
			}
		}

		File f = new File("plugins//BattlecraftServer//players//" + fromUUID.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.contains(fromUUID.getName() + ".nick")) {
			fromUUID.setDisplayName(
					"*" + ChatColor.translateAlternateColorCodes('&', yaml.getString(fromUUID.getName() + ".nick")));
		}

		// We will create the stats list for the player IF they dont have one
		// already.
		StatsManager.createStats(p);

		// Add them to a list so that other players can teleport to them.
		PlayerTp.players.add(fromUUID.getName());

		// Lonely motd.
		motd(p);

		if (plugin.getConfig().getBoolean("titleonjoin") == true) {
			PacketUtil.onJoin(plugin, p);
		}

		if (!fromUUID.hasPlayedBefore()) {
			e.setJoinMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + fromUUID.getName()
					+ ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + " joined " + ChatColor.YELLOW + "("
					+ ChatColor.AQUA + "First Login!" + ChatColor.YELLOW + ")");
			PlayersYML.setFirstLogin(fromUUID);
		}

		// If the player isnt in the hub, they will be teleported back to the
		// hub.
		if (!fromUUID.getWorld().getName().equalsIgnoreCase("Hub1")) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					fromUUID.teleport(new Location(Bukkit.getServer().getWorld("Hub1"), 1041, 11, 586));
				}
			}, 25);
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + p.getName()
				+ ChatColor.DARK_RED + "" + ChatColor.ITALIC + " left");
		PlayerTp.players.remove(p.getName());
		ScoreboardMg.removeBoard(p);
		PlayersYML.setLastLogin(p);

		if (Party.isInParty(p)) {
			if (Party.getLeaderName(p).equals(p.getName())) {
				Party.stopParty(p);
			} else {
				Party.removePartyMember(p, Party.getLeaderName(p));
			}
		}
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if (e.getResult() == Result.KICK_FULL && RanksEnum.isAtLeast(e.getPlayer(), Ranks.VIP)) {
			e.allow();
		}
		Player p = e.getPlayer();

		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.contains(p.getName() + ".nick")) {
			p.setDisplayName("*" + ChatColor.translateAlternateColorCodes('&', yaml.getString(p.getName() + ".nick")));
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