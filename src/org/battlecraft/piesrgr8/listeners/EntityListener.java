package org.battlecraft.piesrgr8.listeners;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.Chase.main.API;

public class EntityListener implements Listener {

	BattlecraftServer plugin;

	public EntityListener(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void entityKillAward(EntityDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player p = (Player) e.getEntity().getKiller();

			if (e.getEntity().getType().equals(EntityType.COW)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.CHICKEN)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.BAT)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.CREEPER)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.ENDER_DRAGON)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.ENDERMAN)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.ENDERMITE)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.GHAST)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.GIANT)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.GUARDIAN)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.IRON_GOLEM)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.MAGMA_CUBE)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.MUSHROOM_COW)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.PIG)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.PIG_ZOMBIE)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.PLAYER)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.RABBIT)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.SHEEP)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.SILVERFISH)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.SKELETON)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.SLIME)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.SPIDER)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.WITCH)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.WITHER)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (e.getEntity().getType().equals(EntityType.ZOMBIE)) {
				try {
					API.addBal(p, 25);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
