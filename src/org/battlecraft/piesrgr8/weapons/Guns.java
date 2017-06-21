package org.battlecraft.piesrgr8.weapons;

import java.util.ArrayList;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.projectiles.ProjectileSource;

import net.minecraft.server.v1_9_R2.EnumParticle;
import net.minecraft.server.v1_9_R2.PacketPlayOutWorldParticles;

public class Guns implements Listener {

	public ArrayList<Projectile> arrows = new ArrayList<Projectile>();

	BattlecraftServer plugin;

	public Guns(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) {
			return;
		}

		if (!(e.getItem().getType() == Material.TNT)) {
			return;
		}

		Player p = (Player) e.getPlayer();
		TNTPrimed t = (TNTPrimed) p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
		t.setVelocity(p.getLocation().getDirection().normalize().multiply(2));
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.getPlayer().getInventory().removeItem(new ItemStack(Material.TNT, 1));
		}
		e.getPlayer().getLocation().getWorld().playSound(e.getPlayer().getLocation(), Sound.ENTITY_PLAYER_BIG_FALL, 10,
				10);
	}

	@EventHandler
	public void onShootBow(EntityShootBowEvent e) {
		try {
			if (!e.getBow().hasItemMeta()) {
				return;
			}

			if (!e.getBow().getItemMeta().getDisplayName().contains(ChatColor.stripColor("RARE"))) {
				return;
			}
			arrows.add((Projectile) e.getProjectile());
			addParticleEffect((Projectile) e.getProjectile());
		} catch (Exception e2) {
			e2.getMessage();
		}
	}

	@EventHandler
	public void onProjectileShoot(ProjectileLaunchEvent event) {
		Projectile projectile = event.getEntity();
		ProjectileSource shooter = projectile.getShooter();
		if (shooter instanceof Player) {
			Player p = (Player) shooter;
			if (RanksEnum.getRank(p).equals(Ranks.OWNER) && (projectile instanceof Arrow || projectile instanceof Egg)) {
				projectile.setMetadata("Explosive",
						new FixedMetadataValue(BattlecraftServer.getPlugin(BattlecraftServer.class), true));
			}
		}
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		Projectile entity = e.getEntity();

		if (e.getEntity() instanceof Arrow) {
			arrows.remove(e.getEntity());
		}

		if (entity.hasMetadata("Explosive")) {
			Location loc = entity.getLocation();
			entity.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 10F, false, false);
			entity.remove();
		}
	}

	public void addParticleEffect(final Projectile entity) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				for (Projectile arrows : arrows) {
					for (Player online : Bukkit.getOnlinePlayers()) {
						Location loc = arrows.getLocation();
						((CraftPlayer) online).getHandle().playerConnection.sendPacket(
								new PacketPlayOutWorldParticles(EnumParticle.DRAGON_BREATH, true, (float) loc.getX(),
										(float) loc.getY(), (float) loc.getZ(), 1, 1, 1, (float) 0, 6));
					}
				}
			}

		}, 0, 1);
	}

}