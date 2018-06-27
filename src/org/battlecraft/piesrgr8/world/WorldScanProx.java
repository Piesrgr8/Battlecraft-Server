package org.battlecraft.piesrgr8.world;

import java.util.ArrayList;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class WorldScanProx implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("scan")) {
			if (!RanksEnum.isAtLeast((Player) sender, Ranks.MOD)) {
				p.sendMessage(Prefix.prefixWorld + ChatColor.RED
						+ "You dont have permission to scan for entities!");
				return true;
			}

			p.setExp(p.getExp() - 15);
			p.sendMessage("You lost experience from using this command!");

			for (Entity en : getNearbyEntities(p.getLocation(), 10)) {
				if (en == p || en.equals(EntityType.ITEM_FRAME) || en.equals(EntityType.SPECTRAL_ARROW)
						|| en.equals(EntityType.ARROW) || en.equals(EntityType.PLAYER))
					continue;
				p.sendMessage(ChatColor.GOLD + "There is a " + ChatColor.YELLOW
						+ (en instanceof Player ? ((Player) en).getName() : en.getType().name()) + ChatColor.GOLD
						+ " at " + ChatColor.YELLOW + "X: " + ChatColor.YELLOW + en.getLocation().getBlockX() + ", "
						+ ChatColor.YELLOW + "Y: " + ChatColor.YELLOW + en.getLocation().getBlockY() + ", "
						+ ChatColor.YELLOW + "Z: " + ChatColor.YELLOW + en.getLocation().getBlockZ() + "!");
				Arrow a = (Arrow) en.getLocation().getWorld().spawnEntity(en.getLocation().add(0, 4, 0),
						EntityType.SPECTRAL_ARROW);
				a.setShooter(p);
				a.setKnockbackStrength(0);
				a.setCritical(false);
				a.setSilent(true);
			}
		}
		return true;
	}

	public List<Entity> getNearbyEntities(Location l, int size) {
		List<Entity> ent = new ArrayList<Entity>();

		for (Entity e : l.getWorld().getEntities())
			if (l.distance(e.getLocation()) <= size)
				ent.add(e);
		return ent;
	}
}
