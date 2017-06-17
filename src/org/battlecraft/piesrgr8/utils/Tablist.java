package org.battlecraft.piesrgr8.utils;

import java.lang.reflect.Field;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_9_R2.PlayerConnection;

public class Tablist implements Listener {

	BattlecraftServer plugin;

	public Tablist(BattlecraftServer p) {
		this.plugin = p;
	}

	public static void setTabList(Player p, String header, String footer) {
		CraftPlayer cp = (CraftPlayer) p;
		PlayerConnection con = cp.getHandle().playerConnection;
		
		if (header == null)
			header = "";
		if (footer == null)
		    footer = "";

		IChatBaseComponent top = ChatSerializer.a(
				"{\"text\": \"" + header + "\"}");
		IChatBaseComponent bottom = ChatSerializer.a(
				"{\"text\": \"" + footer + "\"}");
		

		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(top);

		try {
			Field headerField = packet.getClass().getDeclaredField("a");
			headerField.setAccessible(true);
			headerField.set(packet, bottom);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		con.sendPacket(packet);
		}
	}
/*
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setTabList(p, ChatColor.RED + "Testing!", ChatColor.GRAY + "Development!");
	} */
}