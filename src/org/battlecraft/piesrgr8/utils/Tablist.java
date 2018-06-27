package org.battlecraft.piesrgr8.utils;

import java.lang.reflect.Field;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_9_R2.ChatComponentText;
import net.minecraft.server.v1_9_R2.PacketPlayOutPlayerListHeaderFooter;

public class Tablist implements Listener {

	static BattlecraftServer plugin;

	public Tablist(BattlecraftServer p) {
		Tablist.plugin = p;
	}

	public static void setTabList() {
		final PacketPlayOutPlayerListHeaderFooter pack = new PacketPlayOutPlayerListHeaderFooter();
		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					Field a = pack.getClass().getDeclaredField("a");
					a.setAccessible(true);
					Field b = pack.getClass().getDeclaredField("b");
					b.setAccessible(true);
					
					Object header = new ChatComponentText(Color.c("&7&m----[-&r  &cBATTLECRAFT&r  &7&m-]----\n"));
					Object footer = new ChatComponentText(Color.c("\n&eVisit &bwww.bcpvp101.enjin.com &efor ranks and perks!"));
					
					a.set(pack, header);
					b.set(pack, footer);
					
					if (Bukkit.getOnlinePlayers().size() == 0) return;
					for (Player p : Bukkit.getOnlinePlayers()) {
						((CraftPlayer) p).getHandle().playerConnection.sendPacket(pack);
					}
				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}.runTaskTimer(plugin, 0, 20);
	}
/*
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setTabList(p, ChatColor.RED + "Testing!", ChatColor.GRAY + "Development!");
	} */
}