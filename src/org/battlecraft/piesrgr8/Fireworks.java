package org.battlecraft.piesrgr8;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;

public class Fireworks implements Listener {

	BattlecraftServer plugin;

	public Fireworks(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void fw(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		PlayerInventory inv = e.getPlayer().getInventory();

		if (p.getWorld().getName().equals("Hub1")) {
			if (p.getItemInHand().getType().equals(Material.FIREWORK)) {
				if(e.getPlayer().getLocation().getBlock().getRelative(BlockFace.SELF).getType() != Material.STONE_PLATE) {
			e.setCancelled(true);
			
			Firework fw = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
			FireworkMeta fwm = fw.getFireworkMeta();

			// Our random generator
			Random r = new Random();

			// Get the type
			int rt = r.nextInt(4) + 1;
			Type type = Type.BALL;
			if (rt == 1)
				type = Type.BALL;
			if (rt == 2)
				type = Type.BALL_LARGE;
			if (rt == 3)
				type = Type.BURST;
			if (rt == 4)
				type = Type.CREEPER;
			if (rt == 5)
				type = Type.STAR;

			// Get our random colours
			int r1i = r.nextInt(17) + 1;
			int r2i = r.nextInt(17) + 1;
			Color c1 = getColor(r1i);
			Color c2 = getColor(r2i);

			// Create our effect with this
			FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2)
					.with(type).trail(r.nextBoolean()).build();

			// Then apply the effect to the meta
			fwm.addEffect(effect);

			// Generate some random power and set it
			int rp = r.nextInt(2) + 1;
			fwm.setPower(rp);

			// Then apply this to our rocket
			fw.setFireworkMeta(fwm);
			inv.setItem(1, new ItemStack(Material.FIREWORK, 64));
		}else{
			return;
		}
			}
		}
	}

	private Color getColor(int i) {
		Color c = null;
		if (i == 1) {
			c = Color.AQUA;
		}
		if (i == 2) {
			c = Color.BLACK;
		}
		if (i == 3) {
			c = Color.BLUE;
		}
		if (i == 4) {
			c = Color.FUCHSIA;
		}
		if (i == 5) {
			c = Color.GRAY;
		}
		if (i == 6) {
			c = Color.GREEN;
		}
		if (i == 7) {
			c = Color.LIME;
		}
		if (i == 8) {
			c = Color.MAROON;
		}
		if (i == 9) {
			c = Color.NAVY;
		}
		if (i == 10) {
			c = Color.OLIVE;
		}
		if (i == 11) {
			c = Color.ORANGE;
		}
		if (i == 12) {
			c = Color.PURPLE;
		}
		if (i == 13) {
			c = Color.RED;
		}
		if (i == 14) {
			c = Color.SILVER;
		}
		if (i == 15) {
			c = Color.TEAL;
		}
		if (i == 16) {
			c = Color.WHITE;
		}
		if (i == 17) {
			c = Color.YELLOW;
		}

		return c;
	}
}
