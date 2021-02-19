package org.battlecraft.piesrgr8.particles;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Particles implements CommandExecutor {

	BattlecraftServer plugin;

	public Particles(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("particle")) {
			if (args.length == 0) {
				sender.sendMessage(Prefix.prefixMain + ChatColor.RED + "Please specify a particle #");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					sender.sendMessage("Played!");
					sphere(p, true);
					return true;
				}
				if (args[0].equalsIgnoreCase("2")) {
					sender.sendMessage("Playing!");
					//trace1(p, true);
					return true;
				}
				if (args[0].equalsIgnoreCase("stop")) {
					sender.sendMessage("Stopped!");
					//trace1(p, false);
					return true;
				}
			}
		}
		return true;
	}

	public void sphere(Player p, boolean b) {
		if (b) {
			final Location loc = p.getLocation();
				double phi = 0;

					phi += Math.PI / 10;
					for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 40) {
						double r = 1.5;
						double x = r * Math.cos(theta) * Math.sin(phi);
						double y = r;
						double z = r * Math.sin(theta) * Math.sin(phi);
						loc.add(x, y, z);
						p.spawnParticle(Particle.FLAME, x, y, z, 10);
			}
		}
	}
/*
	public void trace1(Player p, boolean b) {
		if (b) {
			final Location loc = p.getLocation();
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				public void run() {
					for (Player online : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) online).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(
								EnumParticle.ENCHANTMENT_TABLE, true, (float) loc.getX(), (float) loc.getY(),
								(float) loc.getZ(), 0, 0, 0, (float) 1, 1, null));
					}
				}
			}, 1, 10);
		}
	}*/
}