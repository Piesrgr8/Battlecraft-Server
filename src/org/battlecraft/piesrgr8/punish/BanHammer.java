package org.battlecraft.piesrgr8.punish;

import java.util.ArrayList;
import java.util.Arrays;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.utils.Color;
import org.battlecraft.piesrgr8.utils.Debug;
import org.battlecraft.piesrgr8.utils.ErrorUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class BanHammer implements Listener, CommandExecutor {

	BattlecraftServer plugin;
	public static ArrayList<String> st = new ArrayList<String>();

	public BanHammer(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			
			Player p = (Player) e.getDamager();
			Player tar = (Player) e.getEntity();

			if (!st.contains(p.getName())) {
				return;
			}

			if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.DIAMOND_AXE))) {
				Debug.debugBroadcast("Has diamond axe");
			}
			
		    if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.stripColor("BAN HAMMER"))) {
		    	Debug.debugBroadcast("Has itemmeta");
		    }
					tar.kickPlayer("The Ban Hammer Has Spoken!");
					tar.setBanned(true);
					p.sendMessage("The ban hammer has killed " + tar.getName());
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("banhammer")) {
			if (RanksEnum.isStaff(p)) {
				st.add(p.getName());
				banhammer(p);
				p.sendMessage("You now have the ban hammer!");
				return true;
			} else {
				ErrorUtil.noRank(p, RanksEnum.getPrefix(Ranks.HELPER));
				return true;
			}
		}

		return true;
	}

	public void banhammer(Player p) {
		PlayerInventory inv = p.getInventory();
		ItemStack ham = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = ham.getItemMeta();

		meta.setDisplayName(Color.c("&b&lBAN HAMMER"));
		meta.setLore(Arrays.asList("Once this hammer touches", "a player, it will send them", "to the gates of hell!"));

		ham.setItemMeta(meta);

		ham.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10000);
		ham.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10000);
		ham.addUnsafeEnchantment(Enchantment.DURABILITY, 10000);

		inv.addItem(ham);
	}
}
