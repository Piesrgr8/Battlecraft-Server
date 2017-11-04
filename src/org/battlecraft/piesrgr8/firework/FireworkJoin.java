package org.battlecraft.piesrgr8.firework;

import java.util.ArrayList;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class FireworkJoin implements CommandExecutor, Listener {

	BattlecraftServer plugin;

	public FireworkJoin(BattlecraftServer p) {
		this.plugin = p;
	}
/*
	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
		
		Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder().with(FireworkEffect.Type.BALL_LARGE)
				.withColor(Color.RED, Color.WHITE, Color.BLUE).withFlicker().withTrail().withFade(Color.BLUE, Color.RED)
				.build());
		fm.setPower(2);
		f.setFireworkMeta(fm);
		e.getPlayer().sendMessage(Prefix.prefixMain + org.battlecraft.piesrgr8.utils.Color.c("&lHAPPY &9&l4TH&r &lOF &c&lJULY!"));
			}
		}, 40);
	} */

	ArrayList<Player> cooldown = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("fw")) {
			if (cooldown.contains(p)) {
				p.sendMessage(ChatColor.RED + "You cannot get fireworks yet!");
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("fw")) {
			PlayerInventory pi = p.getInventory();
			p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
			pi.addItem(new ItemStack(Material.FIREWORK, 64));
			p.sendMessage(ChatColor.GREEN + "You have recieved your " + ChatColor.YELLOW + "fireworks!");
			p.sendMessage(ChatColor.GREEN + "Use " + ChatColor.YELLOW + "in hub " + ChatColor.GREEN + "to launch!");
			cooldown.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					cooldown.remove(p);
					p.sendMessage(Prefix.prefixMain + ChatColor.GREEN + "You can now recieve fireworks with "
							+ ChatColor.YELLOW + "/fw!");
				}
			}, 3000);

			return true;
		}
		return false;
	}

}
