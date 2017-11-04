package org.battlecraft.piesrgr8.clans;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.staff.Admin;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ClansGUIListener implements Listener{
	
	BattlecraftServer plugin;
	
	public ClansGUIListener(BattlecraftServer p) {
		this.plugin = p;
	}
	
	//TODO INVITES
	@EventHandler
	public void invClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Clan Invites")) {
			return;
		}

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			String c = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
			
			if (!RanksEnum.isAtLeast(p, Ranks.VIP)) {
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, (float) 0.5);
				p.sendMessage(Prefix.prefixClans + RanksEnum.sendErrorMessage(Ranks.VIP));
				e.setCancelled(true);
				return;
			}
			if (!Clans.isInClan(p)) {
				Clans.addPlayerToClan(p, c);
				PlayersYML.setClanInvites(p, null);
				p.closeInventory();
				p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have joined " + ChatColor.YELLOW + c + "'s" + ChatColor.GREEN + " clan!");
				e.setCancelled(true);
				
			}else{
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are already in a clan! You must leave your clan in order to proceed!");
				e.setCancelled(true);
			}
		}
	}
	
	//TODO TELEPORT
	@SuppressWarnings("deprecation")
	@EventHandler
	public void invTp(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Clan Teleportation")) {
			return;
		}

		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			Player pll = Bukkit.getServer().getPlayer(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
			if (pll != null) {
				p.closeInventory();
				p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have teleported to " + ChatColor.YELLOW + pll.getName() + "!");
				p.teleport(pll);
				Admin.sendMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " teleported to " + ChatColor.YELLOW + pll.getName());
			}
			
		}
	}
	
	//TODO MAIN
	@EventHandler
	public void clansMainInv(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Clans")) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
        switch(e.getCurrentItem().getType()) {
		
		case BOOK_AND_QUILL:
			Bukkit.dispatchCommand(p, "clan create");
			p.closeInventory();
			break;
			
		case PAPER:
			p.sendMessage("Yo2");
			break;
			
		case WOOD_DOOR:
			ClansGUI.leaveCancelGui(p);
			break;
			
		case ARROW:
			p.sendMessage("Yo4");
			break;
			
		case COMPASS:
			p.sendMessage("Yo5");
			break;
			
		case SKULL_ITEM:
			p.sendMessage("Yo6");
			break;
			
		case BOOK:
			p.sendMessage("Yo7");
			break;
			
		case PAINTING:
			p.sendMessage("Yo8");
			break;
			
		default:
			break;
		}
	}
	
	//TODO LEAVE CLAN
	@EventHandler
	public void leaveClanClick(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Leave Clan")) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
        switch(e.getCurrentItem().getType()) {
        
		case WOOD_DOOR:
			p.closeInventory();
			p.sendMessage(Prefix.prefixClans + ChatColor.GREEN + "You have removed yourself from the "
					+ ChatColor.YELLOW + Clans.getClanName(p) + ChatColor.GREEN + " clan!");
			Clans.removePlayerFromClan(p, Clans.getOwnerName(p));
			break;
			
		case ARROW:
			ClansGUI.clanMainGUI(p);
			break;
			
		default:
			break;
		}
	}
	
	//TODO ON CHAT
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String s = e.getMessage();
		
		if (!ClanCmd.val.contains(p)) {
			return;
		}
		
		if (ClanCmd.val.contains(p) && s.equalsIgnoreCase("cancel")) {
			e.setCancelled(true);
			p.sendMessage(Prefix.prefixClans + Color.c("&aCancelled creation of new clan!"));
			ClanCmd.val.remove(p);
			return;
		}
		
		if (ClanCmd.val.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan create " + s);
		}
	}
}