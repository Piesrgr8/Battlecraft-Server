package org.battlecraft.piesrgr8.essentials;

import java.io.File;
import java.util.UUID;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.iHersh.ranks.RanksEnum.Ranks;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.staff.Admin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Nick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("nick")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Not a player!");
				return true;
			}
			Player p = (Player) sender;
			String uuid = p.getUniqueId().toString();
			Player fromUUID = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

			File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);

			if (!RanksEnum.isAtLeast((Player) sender, Ranks.HELPER)) {
				fromUUID.sendMessage(
						BattlecraftServer.prefixNick + ChatColor.RED + "You dont have permission to set your nickname");
				return true;
			}

			if (args.length == 0) {
				fromUUID.sendMessage(BattlecraftServer.prefixNick + ChatColor.YELLOW + "What will be your nickname?");
				return true;
			}

			if (args.length == 1) {
				String bc = "";
				for (String message : args) {
					bc = (bc + message + "");
				}

				if (args[0].equals("off")) {
					fromUUID.setDisplayName(ChatColor.WHITE + fromUUID.getName());
					fromUUID.sendMessage(BattlecraftServer.prefixNick + "Successfully reset nickname!");
					PlayersYML.setNick(p, null);
					return true;
				}

				fromUUID.setDisplayName(ChatColor.translateAlternateColorCodes('&', yaml.getString(fromUUID.getName() + ".nick")));
				PlayersYML.setNick(p, bc);
				fromUUID.sendMessage(
						BattlecraftServer.prefixNick + ChatColor.GREEN + "Successfully set nick name! Your nick is now "
								+ yaml.getString(fromUUID.getName() + ".nick"));
				fromUUID.sendMessage(ChatColor.YELLOW + "Loggout or do this command again if your nick doesnt appear.");
				Admin.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN
						+ " has changed their nickname to "
						+ ChatColor.translateAlternateColorCodes('&', yaml.getString(fromUUID.getName() + ".nick")));
				return true;
			}
		}
		return true;
	}
}