package org.battlecraft.piesrgr8.stats;

import java.io.File;
import java.io.IOException;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;

public class StatsManager implements Listener {

	BattlecraftServer plugin;

	public StatsManager(BattlecraftServer p) {
		this.plugin = p;
	}

	// TODO BLOCKS BROKEN
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();

		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		yaml.set("stats.blockbreaks", yaml.getInt("stats.blockbreaks") + 1);
		try {
			yaml.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// TODO DAMAGE TO PLAYER
	@EventHandler
	public void onDamageDelt(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			yaml.set("stats.damagedelt", yaml.getInt("stats.damagedelt") + (int) e.getDamage());
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	// TODO DAMAGE TAKEN FROM PLAYER
	@EventHandler
	public void onDamageTaken(EntityDamageByEntityEvent e) {
		Entity en = e.getEntity();
		if (en instanceof Player) {
			Player p = (Player) en;
			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			yaml.set("stats.damagetaken", yaml.getInt("stats.damagetaken") + (int) e.getDamage());
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	// TODO DEATH
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		if (p.isDead()) {
			yaml.set("stats.deaths", yaml.getInt("stats.deaths") + 1);
			try {
				yaml.save(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	// TODO ITEM ENCHANTS
	@EventHandler
	public void onItemEnchant(EnchantItemEvent e) {
		Player p = e.getEnchanter();
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		yaml.set("stats.enchants", yaml.getInt("stats.enchants") + 1);
		try {
			yaml.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// TODO ITEM CREATIONS
	@EventHandler
	public void onCreation(CraftItemEvent e) {

		Player p = (Player) e.getWhoClicked();
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		yaml.set("stats.itemcreations", yaml.getInt("stats.itemcreations") + 1);
		try {
			yaml.save(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// TODO KILLS
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		Entity k = e.getEntity();

		if (k instanceof Player) {
			Player p = (Player) e.getEntity().getKiller();
			File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
			if (e.getEntity().isDead() && f.exists()) {
				yaml.set("stats.kills", yaml.getInt("stats.kills") + 1);
				try {
					yaml.save(f);
				} catch (IOException e1) {
					e1.getMessage();
				}
			}
		}
	}

	public static void createStats(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			yaml.createSection("stats");
			yaml.createSection("stats.kills");
			yaml.createSection("stats.deaths");
			yaml.createSection("stats.itemcreations");
			yaml.createSection("stats.damagetaken");
			yaml.createSection("stats.damagedelt");
			yaml.createSection("stats.blockbreaks");
			yaml.createSection("stats.enchants");
			try {
				yaml.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Integer getKills(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer kills = yaml.getInt("stats.kills");

		return kills;
	}

	public static Integer getDeaths(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer deaths = yaml.getInt("stats.deaths");

		return deaths;
	}

	public static Integer getItemCreations(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer items = yaml.getInt("stats.itemcreations");

		return items;
	}

	public static Integer getDamageTaken(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer damage1 = yaml.getInt("stats.damagetaken");

		return damage1;
	}

	public static Integer getDamageDealt(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer damage2 = yaml.getInt("stats.damagedelt");

		return damage2;
	}

	public static Integer getBlockBreaks(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer blocks = yaml.getInt("stats.blockbreaks");

		return blocks;
	}

	public static Integer getEnchantedItems(Player p) {
		File f = new File("plugins//BattlecraftServer//stats//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		Integer enchants = yaml.getInt("stats.enchants");

		return enchants;
	}
}