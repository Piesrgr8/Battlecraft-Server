package org.battlecraft.piesrgr8.essentials;

import java.util.ArrayList;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.ErrorUtil;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.server.v1_9_R2.PacketDataSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutCustomPayload;

public class ApplicationForm implements Listener, CommandExecutor{
	
	BattlecraftServer plugin;
	public ArrayList<String> map = new ArrayList<String>();
	
    public ApplicationForm(BattlecraftServer p) {
    	this.plugin = p;
	}

	public void openBook(ItemStack book, Player p) {
        int slot = p.getInventory().getHeldItemSlot();
        ItemStack old = p.getInventory().getItem(slot);
        p.getInventory().setItem(slot, book);

       ByteBuf buf = Unpooled.buffer(256);
       buf.setByte(0, (byte)0);
       buf.writerIndex(1);

        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
        p.getInventory().setItem(slot, old);
    }
    
    public ItemStack app() {
    	ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);
    	BookMeta meta = (BookMeta) book.getItemMeta();
    	meta.setTitle("Application Form");
    	meta.setAuthor("Battlecraft");
    	meta.addPage(Color.c("&9Why do you want to work?:\n"));
    	book.setItemMeta(meta);
    	return book;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void editBook(PlayerEditBookEvent e) {
    	Player p1 = Bukkit.getServer().getPlayer(map.get(1));
    	BookMeta b = e.getNewBookMeta();
    	ItemStack ol = new ItemStack(Material.WRITTEN_BOOK);
    	
    	ol.setItemMeta(b);
    	p1.getInventory().addItem(ol);
    }
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("application")) {
			if (!RanksEnum.isAtLeast(p, Ranks.MOD)) {
				ErrorUtil.noRank(p, RanksEnum.getPrefix(Ranks.MOD));
				return true;
			}
			
			if (args.length == 0) {
				p.sendMessage(Prefix.prefixMain + ChatColor.YELLOW + "You need to specify who is going to get this application.");
				return true;
			}
			
			if (args.length == 1) {
				Player tar = Bukkit.getServer().getPlayer(args[0]);
				
				if (tar == null) {
					p.sendMessage(Prefix.prefixMain + ChatColor.RED + "This player doesnt exist!");
					return true;
				}
				
				map.add(p.getName());
				openBook(app(), tar);
				p.sendMessage(Prefix.prefixMain + ChatColor.YELLOW + "This player has recieved the app. "
						+ "Please standby and do not enter any games until the applicant is done.");
				return true;
			}
		}
		return true;
	}
}
