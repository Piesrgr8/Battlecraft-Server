package org.battlecraft.piesrgr8.utils;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class JukeboxUtil {

	static HashMap<Block, Material> col = new HashMap<Block, Material>();
	public static int enabled = 0;

	public static void playRecord(Player p, Material record) {
		Block block = p.getLocation().getBlock();
		p.playEffect(p.getLocation().add(0, 1, 0), Effect.RECORD_PLAY, record);
		
		if (enabled == 0) {
			enabled = 1;
		}

		if (!col.containsKey(block)) {
			col.put(block, block.getType());
		}
		
		block.setType(Material.JUKEBOX);
	}

	@SuppressWarnings("deprecation")
	public static void stopRecord(Player p) {
		Block block = p.getLocation().subtract(0, 1, 0).getBlock();
		p.playEffect(p.getLocation(), Effect.RECORD_PLAY, (short) 0);

		if (enabled == 1) {
			enabled = 0;
		}
		
		if (!col.containsKey(block)) {
			return;
		} else {
			block.setType(col.get(block));
		}
	}
	
	public static boolean isPlaying() {
		if (enabled == 1) {
			return true;
		} else {
		return false;
		}
	}
}
