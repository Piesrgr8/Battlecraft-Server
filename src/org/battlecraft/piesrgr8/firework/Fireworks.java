package org.battlecraft.piesrgr8.firework;

import java.util.Calendar;
import java.util.Random;
import java.util.Set;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.inventory.InvMethods;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;

public class Fireworks implements Listener {

	BattlecraftServer plugin;
	int fi = 1;

	public Fireworks(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void fw(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		PlayerInventory inv = e.getPlayer().getInventory();

		if (p.getWorld().getName().equals("Hub1")) {
			if (p.getItemInHand().getType().equals(Material.FIREWORK_ROCKET) && inv.getItemInHand().getAmount() >= 10) {
				if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
					e.setCancelled(true);
					
					InvMethods.remove(inv, Material.FIREWORK_ROCKET, 10);
					Firework fw = (Firework) p.getWorld()
							.spawn(p.getTargetBlock((Set<Material>) null, 10).getLocation(), Firework.class);
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
				} else {
					return;
				}
			}
		}
	}
	
	@EventHandler
	public void vipFw(PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		PlayerInventory inv = p.getInventory();
		int seconds = Calendar.SECOND;
		
		if (seconds == Calendar.SECOND) {
			return;
		}

		if (!RanksEnum.isAtLeast(p, Ranks.VIP)) {
			return;
		}

		if (p.getLocation().getWorld().getName().equals("Hub1")) {
			if (!inv.contains(new ItemStack(Material.FIREWORK_ROCKET, 64))) {
				inv.addItem(new ItemStack(Material.FIREWORK_ROCKET, 1));
				seconds = Calendar.SECOND;
			}
		} else {
			return;
		}

		/*
		if (!RanksEnum.isAtLeast(p, Ranks.MOD)) {
			return;
		}

		if (fi == 1) {

			Location loc1 = new Location(p.getLocation().getWorld(), 1077, 66, 685);
			Location loc2 = new Location(p.getLocation().getWorld(), 1068, 74, 653);
			Location loc3 = new Location(p.getLocation().getWorld(), 1094, 74, 640);

			Random r = new Random();

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

			int rand = r.nextInt(3) + 1;

			if (rand == 1) {
				Firework f = (Firework) p.getWorld().spawn(loc1, Firework.class);
				FireworkMeta fw = f.getFireworkMeta();
				FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2)
						.with(type).trail(r.nextBoolean()).build();

				fw.addEffect(effect);

				int rp = r.nextInt(2) + 1;
				fw.setPower(rp);

				f.setFireworkMeta(fw);
				fi = 0;
			} else if (rand == 2) {
				Firework f = (Firework) p.getWorld().spawn(loc2, Firework.class);
				FireworkMeta fw = f.getFireworkMeta();
				FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2)
						.with(type).trail(r.nextBoolean()).build();

				fw.addEffect(effect);

				int rp = r.nextInt(2) + 1;
				fw.setPower(rp);

				f.setFireworkMeta(fw);
				fi = 0;

			} else if (rand == 3) {
				Firework f = (Firework) p.getWorld().spawn(loc3, Firework.class);
				FireworkMeta fw = f.getFireworkMeta();
				FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2)
						.with(type).trail(r.nextBoolean()).build();

				fw.addEffect(effect);

				int rp = r.nextInt(2) + 1;
				fw.setPower(rp);

				f.setFireworkMeta(fw);
				fi = 0;

			}

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					fi = 1;
				}
			}, 100);
		} */
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
