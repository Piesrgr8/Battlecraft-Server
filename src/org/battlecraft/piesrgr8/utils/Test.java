package org.battlecraft.piesrgr8.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.chat.Notifications.NotifType;
import org.battlecraft.piesrgr8.combat.ForceChoke;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.firework.InstantFw;
import org.battlecraft.piesrgr8.gadgets.GadgetGUI;
import org.battlecraft.piesrgr8.utils.online.TimerDaily;
import org.battlecraft.piesrgr8.world.WorldTime;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {

	BattlecraftServer plugin;

	public Test(BattlecraftServer p) {
		this.plugin = p;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		// Use this method for UUID switches!

		if (cmd.getName().equalsIgnoreCase("test")) {
			if (!RanksEnum.isStaff(p)) {
				sender.sendMessage("No permission");
				return true;
			}

			if (args.length == 0) {
				long min = System.currentTimeMillis() / 1000L;
				String msg = ChatColor.RED + "-----------------------------------------";
				WorldTime.onTimeChange();
				sender.sendMessage(msg);
				sender.sendMessage("        This class is testing buy signs and sell signs!");
				// sender.sendMessage("" +
				// p.getInventory().getItemInMainHand());
				ClickChat.agreement(p, "Yes", "Agree to nothing!");
				ClickChat.disagreement(p, "No", "Disagree to nothing!");
				InstantFw.instant(p);
				sender.sendMessage(TimerDaily.getCurrentTime());
				sender.sendMessage("" + Calendar.getInstance().getTime().getHours());
				sender.sendMessage("" + min);
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
				PlayersYML.setMessageList(p, msg, NotifType.MSG);
				return true;
			}
		}
		return true;
	}
}