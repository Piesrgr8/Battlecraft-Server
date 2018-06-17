package org.battlecraft.piesrgr8.perks;

import java.util.Arrays;

import org.battlecraft.piesrgr8.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PerkMenu {
	
	
	//TODO
	//***********************************************************
	//**********          FOR GUI CREATION           ************
	//***********************************************************
	//***********************************************************
	
	@SuppressWarnings("deprecation")
	public static void perkMain(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Perks");

		ItemStack q = new ItemStack(Material.POTION);
		ItemMeta qm = q.getItemMeta();

		ItemStack w = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta wm = w.getItemMeta();
		
		ItemStack e = new ItemStack(Material.ANVIL);
		ItemMeta em = w.getItemMeta();

		ItemStack space = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) DyeColor.BLACK.getDyeData());
		ItemMeta spaceM = space.getItemMeta();

		qm.setDisplayName(Color.c("&a&lTier 1"));
		qm.setLore(Arrays.asList(Color.c("&eContains potion effects!")));
		q.setItemMeta(qm);

		wm.setDisplayName(Color.c("&e&lTier 2"));
		wm.setLore(Arrays.asList(Color.c("&eContains defense perks!")));
		w.setItemMeta(wm);
		
		em.setDisplayName(Color.c("&c&lTier 3"));
		em.setLore(Arrays.asList(Color.c("&eContains strength perks!")));
		e.setItemMeta(em);
		
		spaceM.setDisplayName(" ");
		space.setItemMeta(spaceM);

		inv.setItem(0, space);
		inv.setItem(1, space);
		inv.setItem(2, q);
		inv.setItem(3, space);
		inv.setItem(4, w);
		inv.setItem(5, space);
		inv.setItem(6, e);
		inv.setItem(7, space);
		inv.setItem(8, space);

		p.openInventory(inv);
	}
	
	//TODO
	//***********************************************************
	//**********          FOR GUI LISTENING          ************
	//***********************************************************
	//***********************************************************

}
