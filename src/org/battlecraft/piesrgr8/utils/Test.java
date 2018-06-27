package org.battlecraft.piesrgr8.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.combat.ForceChoke;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.firework.InstantFw;
import org.battlecraft.piesrgr8.gadgets.GadgetGUI;
import org.battlecraft.piesrgr8.inventory.InvMethods;
import org.battlecraft.piesrgr8.utils.online.TimerDaily;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.Chase.main.API;

public class Test implements Listener, CommandExecutor {

	BattlecraftServer plugin;

	public Test(BattlecraftServer p) {
		this.plugin = p;
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (!p.hasPermission("bc.staff")) {
			return;
		}

		if (e.getLine(0).equalsIgnoreCase("sell")) {
			p.sendMessage("Added a sell sign!");
			p.sendMessage(e.getLine(1));
			p.sendMessage(e.getLine(2));
			p.sendMessage(e.getLine(3));
			e.setLine(0, ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "SELL" + ChatColor.GRAY + "]");
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			return;
		}

		if (e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();

			if (!s.getLine(0).contains(ChatColor.stripColor("SELL"))) {
				return;
			}

			ItemStack it = new ItemStack(Material.getMaterial(s.getLine(2)));
			ItemStack inv = p.getInventory().getItemInHand();
			int amount = inv.getAmount();

			if (!inv.equals(it)) {
				Debug.debugBroadcast("You dont have that item in your hand! " + inv);
				return;
			}

			if (amount < Integer.parseInt(s.getLine(1))) {
				Debug.debugBroadcast("You have less of that amount " + amount);
				return;
			}

			if (s.getLine(3).isEmpty()) {
				p.sendMessage("There is no cost on this sign! Must be 0 if its free.");
			} else

			if (s.getLine(1).isEmpty()) {
				try {
					Integer.parseInt(s.getLine(1));
				} catch (Exception e1) {
					p.sendMessage("The second line must be a number!");
					e1.getMessage();
				}
			} else {

				try {
					// p.getInventory().removeItem(
					// new ItemStack(Material.getMaterial(s.getLine(2)),
					// Integer.parseInt(s.getLine(1))));
					InvMethods.removeItemStack(p, it, Integer.parseInt(s.getLine(1)));
					p.updateInventory();
					p.sendMessage("You sold a(n) " + Material.getMaterial(s.getLine(2)));
				} catch (Exception e1) {
					p.sendMessage("Item doesnt exist!");
					e1.printStackTrace();
				}
				try {
					API.addBal(p, Integer.parseInt(s.getLine(3)));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		// Use this method for UUID switches!

		if (cmd.getName().equalsIgnoreCase("test")) {
			if (!RanksEnum.isStaff(p)) {
				sender.sendMessage("No permission");
				return true;
			}

			if (args.length == 0) {
				long current = System.currentTimeMillis();
				Date currentD = new Date(current);
				long min = System.currentTimeMillis() / 1000L;
				String msg = ChatColor.RED + "-----------------------------------------";
				sender.sendMessage(msg);
				sender.sendMessage("        This class is testing buy signs and sell signs!");
				// sender.sendMessage("" +
				// p.getInventory().getItemInMainHand());
				ClickChat.agreement(p, "Yes", "Agree to nothing!");
				ClickChat.disagreement(p, "No", "Disagree to nothing!");
				InstantFw.instant(p);
				sender.sendMessage(TimerDaily.getCurrentTime());
				sender.sendMessage("" + currentD.getTime());
				sender.sendMessage("" + min);
				sender.sendMessage("" + p.getLocation().getChunk().getX() + ", " + p.getLocation().getChunk().getZ());
				sender.sendMessage(msg);
				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("gui")) {
					GadgetGUI.openMainGUI(p);
					return true;
				}

				if (args[0].equalsIgnoreCase("choke")) {
					ForceChoke.choke(p);
					p.sendMessage("Done!");
					return true;
				}

				if (args[0].equalsIgnoreCase("msg1")) {
					List<String> mon = new ArrayList<String>();
					mon = PlayersYML.getMessageList(p);
					for (int i = 0; i < mon.size(); i++) {
						String s = mon.get(i);
						p.sendMessage(ChatColor.BLUE + "" + i + ".) " + ChatColor.RESET + ""
								+ ChatColor.translateAlternateColorCodes('&', s));
					}
					PlayersYML.clearMessageList(p);
					Debug.debugBroadcast("Clearing list");
					return true;
				}

				if (args[0].equalsIgnoreCase("msg")) {
					p.sendMessage("Please add more to this message.");
					return true;
				}
			}

			if (args.length > 1) {
				StringBuilder sb = new StringBuilder();
				String msg;
				for (int i = 1; i < args.length; i++)
					sb.append(args[i]).append(" ");
				msg = sb.toString();

				p.sendMessage(msg);
				PlayersYML.setMessageList(p, msg);
				return true;
			}
		}
		return true;
	}
}