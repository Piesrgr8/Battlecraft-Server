package org.battlecraft.piesrgr8.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class JukeboxUtil {

	static HashMap<Block, Material> col = new HashMap<Block, Material>();
	public static ArrayList<Player> pl = new ArrayList<Player>();
	public static ArrayList<Location> loc = new ArrayList<Location>();

	public static void playRecord(Player p, Material record) {
		Block block = p.getLocation().getBlock();
		p.playEffect(p.getLocation().add(0, 1, 0), Effect.RECORD_PLAY, record);
		
		if (!pl.contains(p)) {
			pl.add(p);
		}

		if (!col.containsKey(block)) {
			col.put(block, block.getType());
		}
		
		loc.add(p.getLocation().add(0, 1, 0));
		block.setType(Material.JUKEBOX);
	}

	@SuppressWarnings("deprecation")
	public static void stopRecord(Player p) {
		Block block = p.getLocation().subtract(0, 1, 0).getBlock();
		p.playEffect(p.getLocation(), Effect.RECORD_PLAY, (short) 0);

		if (pl.contains(p)) {
			pl.remove(p);
			loc.clear();
		}
		
		if (!col.containsKey(block)) {
			return;
		} else {
			block.setType(col.get(block));
		}
	}
	
	public static boolean isPlaying(Player p) {
		if (pl.contains(p)) {
			return true;
		} else {
		return false;
		}
	}
}
