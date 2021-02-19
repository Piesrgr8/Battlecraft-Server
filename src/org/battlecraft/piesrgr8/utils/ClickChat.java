package org.battlecraft.piesrgr8.utils;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import net.minecraft.server.v1_16_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_16_R2.PacketPlayOutChat;
import net.minecraft.server.v1_16_R2.PlayerConnection;

public class ClickChat implements CommandExecutor {

	BattlecraftServer plugin;

	public ClickChat(BattlecraftServer p) {
		this.plugin = p;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("website")) {

			Player p = (Player) sender;

			PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
			PacketPlayOutChat packet = new PacketPlayOutChat(
					ChatSerializer.a("{\"text\":\"CLICK HERE TO OPEN THE WEBSITE!\",\"color\":\"aqua\",\"bold\":true,"
							+ "\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://bcpvp101.enjin.com/\"},"
							+ "\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"Click here to open the website!\",\"color\":\"gold\"}]}}}"),
					null, null);

			connection.sendPacket(packet);
		}
		return true;
	}

	public static void textChatHover(Player p, String arg1, String arg2) {
		PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + arg1
				+ "\",\"color\":\"yellow\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\""
				+ arg2 + "\",\"color\":\"green\"}]}}}"), null, null);

		connection.sendPacket(packet);
	}

	public static void agreement(Player p, String arg1, String arg2) {
		PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + arg1
				+ "\",\"color\":\"green\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\""
				+ arg2 + "\",\"color\":\"yellow\"}]}}}"), null, null);

		connection.sendPacket(packet);
	}

	public static void disagreement(Player p, String arg1, String arg2) {
		PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + arg1
				+ "\",\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\""
				+ arg2 + "\",\"color\":\"yellow\"}]}}}"), null, null);

		connection.sendPacket(packet);
	}

	public static void test(Player p) {
		PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
		PacketPlayOutChat packet = new PacketPlayOutChat(
				ChatSerializer
						.a("{\"text\":\"gg\",\"color\":\"gold\",\"bold\":true,\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/help\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"Get the help menu!\",\"color\":\"yellow\"}]}}}"),
				null, null);

		connection.sendPacket(packet);
	}

}
