package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.io.IOException;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import me.Chase.main.API;

public class ClanClaim implements Listener {

	BattlecraftServer plugin;

	public ClanClaim(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void testClaim(Player p) {
		String cn = Clans.getClanName(p);
		File f = new File("plugins//BattlecraftServer//clans//claims//" + cn + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		String number = Integer.toString(yaml.getKeys(false).size() + 1);
		World w = p.getWorld();
		Chunk c = w.getChunkAt(p.getLocation());

		Integer fj = c.getX();
		Integer fj1 = c.getZ();

		if (fj == getClaimX(yaml) && fj1 == getClaimZ(yaml)) {
			p.sendMessage(Prefix.prefixClans + ChatColor.RED + "This claim already exists!");
			return;
		}

		yaml.createSection(number + ".clan");
		yaml.createSection(number + ".world");
		yaml.createSection(number + ".width");
		yaml.createSection(number + ".height");
		yaml.set(number + ".clan", cn);
		yaml.set(number + ".world", c.getWorld().getName());
		yaml.set(number + ".width", fj);
		yaml.set(number + ".height", fj1);

		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		API.minBal(p, 1000);
		p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "Claim set! Use " + ChatColor.YELLOW
				+ "/clan claim modify <claim#>" + ChatColor.GREEN + " to modify your claims!" + ChatColor.RED
				+ " THIS FEATURE NOT YET ADDED!");
	}
	
	//TODO FIX
	
	/*

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		List<Player> mes = new ArrayList<Player>();
		String path = "plugins//BattlecraftServer//clans//claims//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(p1);

			Chunk l = p.getLocation().getWorld().getChunkAt(getClaimX(yaml), getClaimZ(yaml));

			if (p.getLocation().getChunk() != l) {
				mes.remove(p);
				return;
			}

			if (p.getLocation().getChunk() == l && p.getLocation().getWorld().getName().equals(getClaimWorld(yaml))
					&& !Clans.getClanName(p).equals(getClaimClan(yaml))) {
				e.setCancelled(true);
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You cannot build in this area!");
				return;
			}

			if (p.getLocation().getChunk() == l && p.getLocation().getWorld().getName().equals(getClaimWorld(yaml))
					&& Clans.getClanName(p).equals(getClaimClan(yaml))) {
				return;
			}
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		List<Player> mes = new ArrayList<Player>();
		String path = "plugins//BattlecraftServer//clans//claims//";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File p1 : listOfFiles) {
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(p1);

			Chunk l = p.getLocation().getWorld().getChunkAt(getClaimX(yaml), getClaimZ(yaml));

			if (p.getLocation().getChunk() != l) {
				mes.remove(p);
				return;
			}

			if (p.getLocation().getChunk() == l && p.getLocation().getWorld().getName().equals(getClaimWorld(yaml))
					&& !Clans.getClanName(p).equals(getClaimClan(yaml))) {
				e.setCancelled(true);
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You cannot break blocks in this area!");
				return;
			}

			if (p.getLocation().getChunk() == l && p.getLocation().getWorld().getName().equals(getClaimWorld(yaml))
					&& Clans.getClanName(p).equals(getClaimClan(yaml))) {
				return;
			}
		}
	} */

	public String numberOfClaims(YamlConfiguration yaml) {
		String keys = "";
		for (String key : yaml.getKeys(true)) {
			keys = key;
		}
		return keys;
	}

	public static int getClaimX(YamlConfiguration yaml) {
		int keys = 0;
		for (String key : yaml.getKeys(false)) {
			keys = yaml.getInt(key + ".width");
		}
		return keys;
	}

	public static int getClaimZ(YamlConfiguration yaml) {
		int keys = 0;
		for (String key : yaml.getKeys(false)) {
			keys = yaml.getInt(key + ".height");
		}
		return keys;
	}

	public String getClaimWorld(YamlConfiguration yaml) {
		String keys = "";
		for (String key : yaml.getKeys(false)) {
			keys = yaml.getString(key + ".world");
		}
		return keys;
	}

	public String getClaimClan(YamlConfiguration yaml) {
		String keys = "";
		for (String key : yaml.getKeys(false)) {
			keys = yaml.getString(key + ".clan");
		}
		return keys;
	}
}
