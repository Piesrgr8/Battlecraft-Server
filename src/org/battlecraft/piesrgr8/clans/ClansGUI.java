package org.battlecraft.piesrgr8.clans;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.battlecraft.piesrgr8.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ClansGUI {
	
	@SuppressWarnings("deprecation")
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Clan Invites");

		// Creating the items and registering them.

		File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

		for (int i = 0; i < yaml.getStringList(p.getName() + ".claninvites").size(); i++) { // Where
																			// players
																			// is
																			// an
																			// array
			// of the players in-game
			String playerName = yaml.getStringList(p.getName() + ".claninvites").get(i);
			OfflinePlayer p1 = Bukkit.getServer().getOfflinePlayer(playerName);
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			SkullMeta meta = (SkullMeta) item.getItemMeta();

		

		// Setting the meta, or names, of all of the blocks that will be added
		// to the inventory.
			File f1 = new File("plugins//BattlecraftServer//clans//" + p1.getName() + ".yml");
			YamlConfiguration yaml1 = YamlConfiguration.loadConfiguration(f1);
			
			String pref = yaml1.getString("Clan");
			List<String> on = yaml1.getStringList("players");
			int me = on.size();

			
			meta.setDisplayName(ChatColor.YELLOW + playerName);
			meta.setLore(Arrays.asList(ChatColor.YELLOW + "Clan:",
					pref, "",
					ChatColor.YELLOW + "Members:", "" + me));
			item.setItemMeta(meta);
		

		// Set the items in their places.

		inv.setItem(i, item);
		}
		p.openInventory(inv);
	}
	
	public static void tpOpenGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.YELLOW + "Clan Teleportation");
		List<String> list = Clans.getPlayerList();

		for (int i = 0; i < list.size(); i++) { // Where players is an array
													// of the players in-game
			String playerName = list.get(i);
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			ItemMeta meta = item.getItemMeta();
			
			if (playerName.equals(p.getName()))
				continue;
			

			meta.setDisplayName(playerName);
			meta.setLore(Arrays.asList("Click to Teleport!"));
			item.setItemMeta(meta);
			inv.setItem(i, item);
		}
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void clanMainGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Clans");
		
		ItemStack q = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta qm = q.getItemMeta();
		
		ItemStack w = new ItemStack(Material.PAPER);
		ItemMeta wm = w.getItemMeta();
		
		ItemStack e = new ItemStack(Material.WOOD_DOOR);
		ItemMeta em = e.getItemMeta();
		
		ItemStack r = new ItemStack(Material.ARROW);
		ItemMeta rm = r.getItemMeta();
		
		ItemStack t = new ItemStack(Material.COMPASS);
		ItemMeta tm = t.getItemMeta();
		
		ItemStack y = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
		ItemMeta ym = y.getItemMeta();
		
		ItemStack u = new ItemStack(Material.BOOK);
		ItemMeta um = u.getItemMeta();
		
		ItemStack i = new ItemStack(Material.PAINTING);
		ItemMeta im = i.getItemMeta();
		
		ItemStack space = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) DyeColor.BLACK.getDyeData());
		ItemMeta spaceM = space.getItemMeta();
		
		
		qm.setDisplayName(Color.c("&a&lCREATE CLAN"));
		qm.setLore(Arrays.asList(Color.c("&eCreate a brand new clan to begin fighting"), Color.c("&eother clans to the death!")));
		q.setItemMeta(qm);
		
		wm.setDisplayName(Color.c("&e&lEDIT CLAN"));
		wm.setLore(Arrays.asList(Color.c("&eEdit your clan details, like the"), Color.c("&ename and the tag!"), Color.c("&c&lMUST BE CLAN LEADER!")));
		w.setItemMeta(wm);
		
		em.setDisplayName(Color.c("&c&lLEAVE CLAN"));
		em.setLore(Arrays.asList(Color.c("&eLeave the clan to begin a new life.")));
		e.setItemMeta(em);
		
		rm.setDisplayName(Color.c("&c&lKICK MEMBER"));
		rm.setLore(Arrays.asList(Color.c("&eKick a player from the clan."), Color.c("&c&lMUST BE CLAN LEADER!")));
		r.setItemMeta(rm);
		
		tm.setDisplayName(Color.c("&d&lTELEPORT"));
		tm.setLore(Arrays.asList(Color.c("&eTeleport to a clan member.")));
		t.setItemMeta(tm);
		
		ym.setDisplayName(Color.c("&e&lINVITE PLAYER"));
		ym.setLore(Arrays.asList(Color.c("&eInvite players to your clan!"), Color.c("&c&lMUST BE CLAN LEADER!")));
		y.setItemMeta(ym);
		
		um.setDisplayName(Color.c("&b&lINVITES"));
		um.setLore(Arrays.asList(Color.c("&eWhen you are invited to join a clan,"), Color.c("&eyou'll see the invites here!")));
		u.setItemMeta(um);
		
		im.setDisplayName(Color.c("&d&lCLAN DETAILS"));
		im.setLore(Arrays.asList(Color.c("&a&lClan: &e") + Clans.getClanName(p), Color.c("&d&lTag: &e") + Clans.getClanTag(p), 
				Color.c("&4&lOwner: &e") + Clans.getOwnerName(p), Color.c("&e&lDescription: &e") + Clans.getDesc(p), 
				Color.c("&6&lMotd: &e") + Clans.getMotd(p), Color.c("&b&lMembers: &e") + Clans.getMembers(p)));
		i.setItemMeta(im);
		
		spaceM.setDisplayName(" ");
		space.setItemMeta(spaceM);
		
		inv.setItem(0, q);
		inv.setItem(1, w);
		inv.setItem(2, y);
		inv.setItem(3, u);
		inv.setItem(4, t);
		inv.setItem(5, r);
		inv.setItem(6, e);
		inv.setItem(7, i);
		inv.setItem(8, space);
		
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static void leaveCancelGui(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Leave Clan");
		
		ItemStack q = new ItemStack(Material.WOOD_DOOR);
		ItemMeta qm = q.getItemMeta();
		
		ItemStack w = new ItemStack(Material.ARROW);
		ItemMeta wm = w.getItemMeta();
		
		ItemStack space = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) DyeColor.BLACK.getDyeData());
		ItemMeta spaceM = space.getItemMeta();
		
		qm.setDisplayName(Color.c("&c&lLEAVE CLAN"));
		qm.setLore(Arrays.asList(Color.c("&eOnce you have &aclicked &ethis door, you will resign from your clan!"), 
				Color.c("&eIf you own a clan, then your clan will be &c&lWIPED!")));
		q.setItemMeta(qm);
		
		wm.setDisplayName(Color.c("&c&lCANCEL"));
		w.setItemMeta(wm);
		
		spaceM.setDisplayName(" ");
		space.setItemMeta(spaceM);
		
		inv.setItem(0, space);
		inv.setItem(1, space);
		inv.setItem(2, q);
		inv.setItem(3, space);
		inv.setItem(4, space);
		inv.setItem(5, space);
		inv.setItem(6, w);
		inv.setItem(7, space);
		inv.setItem(8, space);
		
		p.openInventory(inv);
	}
}
