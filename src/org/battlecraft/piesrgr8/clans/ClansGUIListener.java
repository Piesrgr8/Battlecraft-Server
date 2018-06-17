package org.battlecraft.piesrgr8.clans;

import java.util.HashMap;

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
	public static HashMap<Player, String> selected = new HashMap<Player, String>();
	
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
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() 
				&& e.getCurrentItem().getType().equals(Material.ARROW)) {
			ClansGUI.clanMainGUI(p);
			return;
		}
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			
			if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() 
					&& e.getCurrentItem().getType().equals(Material.ARROW)) {
				return;
			}
			
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
		
		if (e.getCurrentItem().getType().equals(Material.ARROW)) {
			ClansGUI.clanMainGUI(p);
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
			ClansGUI.editGUI(p);
			break;
			
		case WOOD_DOOR:
			if (!Clans.isInClan(p)) {
				e.setCancelled(true);
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are currently not in a clan!");
				break;
			}
			ClansGUI.leaveCancelGui(p);
			break;
			
		case ARROW:
			if (!Clans.isInClan(p)) {
				e.setCancelled(true);
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are currently not in a clan!");
				break;
			}
			
			if (!Clans.getOwnerName(p).equals(p.getName())) {
				e.setCancelled(true);
				p.sendMessage(Prefix.prefixClans + ChatColor.RED + "You are not the leader of the clan!");
				break;
			}
			ClansGUI.kickMembers(p);
			break;
			
		case COMPASS:
			ClansGUI.tpOpenGUI(p);
			break;
			
		case SKULL_ITEM:
			p.sendMessage(Prefix.prefixClans + Color.c("&eType in the chat who you would like to invite."
					+ "If you have clicked the icon by accident, type &cCANCEL &ein chat."));
			ClanCmd.mInv.add(p);
			ClanCmd.resetVal(p);
			p.closeInventory();
			break;
			
		case BOOK:
			ClansGUI.invitesGUI(p);
			break;
			
		case PAINTING:
			break;
			
		default:
			break;
		}
	}
	
	//TODO EDIT
	@EventHandler
	public void editClan(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Edit Clan")) {
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
			
		case PAPER:
			p.closeInventory();
			p.sendMessage(Prefix.prefixClans + Color.c("&eType in the chat what the clan description would be. "
					+ "If you have clicked the icon by accident, type &cCANCEL &ein chat."));
			ClanCmd.mDesc.add(p);
			ClanCmd.resetVal(p);
			break;
			
		case NAME_TAG:
			p.closeInventory();
			p.sendMessage(Prefix.prefixClans + Color.c("&eType in the chat what the clan tag would be. "
					+ "If you have clicked the icon by accident, type &cCANCEL &ein chat."));
			ClanCmd.mTag.add(p);
			ClanCmd.resetVal(p);
			break;
			
		case ARROW:
			ClansGUI.clanMainGUI(p);
			break;
			
		case BOOK:
			p.closeInventory();
			p.sendMessage(Prefix.prefixClans + Color.c("&eType in the chat what the clan name would be. "
					+ "If you have clicked the icon by accident, type &cCANCEL &ein chat."));
			ClanCmd.mName.add(p);
			ClanCmd.resetVal(p);
			break;
			
		case PAINTING:
			p.closeInventory();
			p.sendMessage(Prefix.prefixClans + Color.c("&eType in the chat what the clan motd would be. "
					+ "If you have clicked the icon by accident, type &cCANCEL &ein chat."));
			ClanCmd.mMotd.add(p);
			ClanCmd.resetVal(p);
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
	
	//TODO KICK
	@EventHandler
	public void kickMembersList(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Kick Members")) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		
		e.setCancelled(true);
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && 
				e.getCurrentItem().getType().equals(Material.ARROW)) {
			ClansGUI.clanMainGUI(p);
		}
		
		String c = e.getCurrentItem().getItemMeta().getDisplayName().trim();
		
		if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && 
				!e.getCurrentItem().getType().equals(Material.ARROW)) {
			selected.put(p, c);
			
			if (selected.containsKey(p)) {
			ClansGUI.confirmGUI(p);
			} else {
				return;
			}
		} else {
			return;
		}
		
		switch(e.getCurrentItem().getType()) {
		case NETHER_STAR:
			e.setCancelled(true);
			break;
			
		case WRITTEN_BOOK:
			e.setCancelled(true);
			break;
			
		case STAINED_CLAY:
			e.setCancelled(true);
			break;
			
		case END_CRYSTAL:
			e.setCancelled(true);
			break;
			
		default:
			break;
			
		}
		
	}
	
	//TODO CONFIRMATION
	@EventHandler
	public void confirmList(InventoryClickEvent e) {
		if (!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Confirmation")) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)
				|| !e.getCurrentItem().hasItemMeta()) {
			e.setCancelled(true);
			return;
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("CONFIRM"))) {
			Clans.removeFromClan(selected.get(p).toString(), p.getName());
			p.sendMessage(Prefix.prefixClans + ChatColor.YELLOW + selected.get(p) + ChatColor.GREEN + " has been kicked out of the clan!");
			selected.remove(p);
			ClansGUI.kickMembers(p);
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.stripColor("CANCEL"))) {
			selected.remove(p);
			ClansGUI.kickMembers(p);
		}
	}
	
	//TODO ON CHAT
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String s = e.getMessage();
		
		if (!ClanCmd.val.contains(p) && !ClanCmd.mDesc.contains(p) && !ClanCmd.mInv.contains(p) &&
				!ClanCmd.mMotd.contains(p) && !ClanCmd.mName.contains(p) && !ClanCmd.mTag.contains(p)) {
			return;
		}
		
		if (s.equalsIgnoreCase("cancel")) {
			e.setCancelled(true);
			p.sendMessage(Prefix.prefixClans + Color.c("&aCancelled modification to the clan!"));
			ClanCmd.mTag.remove(p);
			return;
		}
		
		if (ClanCmd.val.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan create " + s);
			ClanCmd.val.remove(p);
			return;
		}
		
		else if (ClanCmd.mTag.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan edit tag " + s);
			ClanCmd.mTag.remove(p);
			return;
		}
		
		else if (ClanCmd.mName.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan edit name " + s);
			ClanCmd.mName.remove(p);
			return;
		}
		
		else if (ClanCmd.mMotd.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan edit motd " + s);
			ClanCmd.mMotd.remove(p);
			return;
		}
		
		else if (ClanCmd.mDesc.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan edit desc " + s);
			ClanCmd.mDesc.remove(p);
			return;
		}
		
		else if (ClanCmd.mInv.contains(p)) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(p, "clan invite " + s);
			ClanCmd.mDesc.remove(p);
			return;
		}
	}
}