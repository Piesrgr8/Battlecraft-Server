package org.battlecraft.piesrgr8.world;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WorldFallingBlocks implements Listener {

	static String path = "regenSpeed";
	static String path2 = "regenWait";
	static String path3 = "worldWhiteList";

	BattlecraftServer plugin;

	public WorldFallingBlocks(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void loadYAML() {
		File f = new File("plugins//BattlecraftServer//regenblocks.yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
		yaml.createSection(path);
		yaml.createSection(path2);
		yaml.createSection(path3);
		yaml.set(path, 1);
		yaml.set(path2, 10);

		List<String> stuff = new ArrayList<String>();
		stuff.add("");
		yaml.set(path3, stuff);

		try {
			yaml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		File f = new File("plugins//BattlecraftServer//regenblocks.yml");
		final YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		if (yaml.getStringList(path3).contains(e.getLocation().getWorld().getName())) {
			System.out.println("World is in list!");
			return;
		}

		if (!e.blockList().isEmpty()) {
			final List<BlockState> blocks = new ArrayList<BlockState>();
			for (Block b : e.blockList()) {

				float x = (float) -0000.1 + (float) (Math.random() * ((0000.1 - -0000.1)));
				float y = (float) -0000.1 + (float) (Math.random() * ((00.1 - -00.1) + 1));
				float z = (float) -0000.1 + (float) (Math.random() * ((0000.1 - -0000.1)));

				if (b.getType() == Material.REDSTONE || b.getType() == Material.REDSTONE_COMPARATOR
						|| b.getType() == Material.REDSTONE_COMPARATOR_OFF
						|| b.getType() == Material.REDSTONE_COMPARATOR_ON || b.getType() == Material.REDSTONE_LAMP_OFF
						|| b.getType() == Material.REDSTONE_LAMP_ON || b.getType() == Material.REDSTONE_TORCH_OFF
						|| b.getType() == Material.REDSTONE_TORCH_ON || b.getType() == Material.REDSTONE_WIRE
						|| b.getType() == Material.LADDER || b.getType() == Material.VINE)
					continue;

				if (b.getType() != Material.AIR) {
					if (!blocks.contains(b.getState())) {
						blocks.add(b.getState());
						FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());

						fb.setDropItem(false);
						fb.setVelocity(new Vector(x, y, z));
						b.setType(Material.AIR);
					}
				}
			}

			new BukkitRunnable() {
				int i = 5;

				public void run() {
					if (i > 0) {
						i--;
					} else {
						regen(blocks, true, yaml.getInt(path));
						this.cancel();
					}
				}
			}.runTaskTimer(plugin, yaml.getInt(path2), yaml.getInt(path2));

			e.blockList().clear();
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void removeBlocks(EntityChangeBlockEvent e) {
		if (e.getBlock().getType() == Material.GRAVEL || e.getBlock().getType() == Material.SAND) {
			return;
		}
		if (e.getEntityType() == EntityType.FALLING_BLOCK) {
			e.setCancelled(true);
		}
	}

	public void regen(final List<BlockState> blocks, final boolean effect, final int speed) {

		new BukkitRunnable() {
			int i = -1;

			@SuppressWarnings("deprecation")
			public void run() {
				if (i != blocks.size() - 1) {
					i++;
					BlockState bs = blocks.get(i);

					bs.getBlock().setType(bs.getType());
					bs.getBlock().setData(bs.getData().getData());
					if (effect)
						bs.getBlock().getWorld().playEffect(bs.getLocation(), Effect.STEP_SOUND,
								bs.getBlock().getType());
				} else {
					for (BlockState bs : blocks) {
						bs.getBlock().setType(bs.getType());
						bs.getBlock().setData(bs.getData().getData());
					}
					blocks.clear();
					this.cancel();
				}
			}
		}.runTaskTimer(plugin, speed, speed);
	}
}