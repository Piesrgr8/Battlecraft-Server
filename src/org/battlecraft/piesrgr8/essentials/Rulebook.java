package org.battlecraft.piesrgr8.essentials;

import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Rulebook {

	public static ItemStack rulebook(Player p) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) book.getItemMeta();

		meta.setTitle(ChatColor.GREEN + "Server Rules " + ChatColor.GRAY + "(Right-Click)");
		meta.setAuthor(Prefix.prefixStaff);
		meta.addPage("          " + ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
				+ "" + ChatColor.BOLD + "Rules" + ChatColor.GRAY + "]\n" + "\n" + ChatColor.BLACK
				+ "Welcome to the Battlecraft Server!\n" + "\n"
				+ "In this book, you will learn all of the rules of what NOT to do on the server.\n"
				+ "This ensures that you play safe and have fun on the sevrer.");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#1\n" + "\n" + ChatColor.BLACK
				+ "Do NOT impersonate a member of staff! Disrespect to a staff member could result in a ban!");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#2\n" + "\n" + ChatColor.BLACK
				+ "Hacked clients or any modded clients of any kind is strictly forbidden! We ban any hackers or cheaters who"
				+ " join the server!");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#3\n" + "\n" + ChatColor.BLACK
				+ "Profane language is NOT permitted! This is something that is not to be worried about, since the anti-swear on "
				+ "the server will take care of the issue. Bypassing it will result in a kick.");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#4\n" + "\n" + ChatColor.BLACK
				+ "Do NOT disrespect anyone on the server! If you are to make fun of them because of color, medical condition, "
				+ "or injuries, then you will be banned permanently!");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#5\n" + "\n" + ChatColor.BLACK
				+ "Advertising is NOT allowed! Any links or server ips that are shared in chat will be bannable!");
		meta.addPage(ChatColor.RED + "Rule " + ChatColor.GOLD + "#6\n" + "\n" + ChatColor.BLACK
				+ "Do NOT ask for OP or a free rank! Literally, this is where its gone too far. We dont accept this kind of fate.");
		meta.addPage(ChatColor.LIGHT_PURPLE + "Any issues?" + "\n" + "\n" + ChatColor.BLACK
				+ "If you see any issues with teleportation, anti-swear words, or games in general. Report them on our website! "
				+ "We recommend the website more then telling staff members, because we pay more attention to the website than the game itself.");
		meta.addPage(ChatColor.BLUE + "Any suggestions?" + "\n" + "\n" + ChatColor.BLACK
				+ "If you want something added to the server, then please dont hesitate to ask. Most of our games are from the internet, and we give credit to those who made it. "
				+ "If you want to send in a map for a game, then send it to us in the forums on our website!");
		meta.addPage(ChatColor.LIGHT_PURPLE + "Website!" + "\n" + "\n" + ChatColor.BLACK
				+ "Our website will contain about everything that you want to do. From forums, to the shop. Have at it!"
				+ "\n" + "\n" + "www.bcpvp101.enjin.com");

		book.setItemMeta(meta);

		return book;
	}
}
