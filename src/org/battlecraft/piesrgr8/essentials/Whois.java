package org.battlecraft.piesrgr8.essentials;

import java.io.File;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Whois implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("whois")) {
			if (args.length == 0) {
				sender.sendMessage(BattlecraftServer.prefixNick + ChatColor.YELLOW + "Please type in a nickname that you saw on the server!");
				return true;
			}
			
			Player p = (Player) sender;
			File f = new File("plugins//BattlecraftServer//players//" + p.getUniqueId().toString() + ".yml");
	        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
	        
			if (args.length == 1) {
                p.sendMessage("Looking for player with nickname: " + ChatColor.GREEN + args[0]);
                
                int i = 1;
                boolean b = false;
                
                for(String key : yaml.getKeys(false)){
                    
                    if(yaml.getString(key + ".nick") != null)
                    {
                        String uncolored = ChatColor.stripColor(RanksEnum.c(yaml.getString(key + ".nick")));
                        
                        if(uncolored == args[0])
                        {
                            b = true;
                            //Do whatever you want here with the variable. The player's name is variable key.
                            p.sendMessage(key);
                            return true;
                        }
                        
                        if(i++ >= yaml.getKeys(false).size() && b == false) 
                        {
                            p.sendMessage("We were unable to find a player with that Nickname.");
                            return true;
                        }
                    }
                    else
                    {
                        p.sendMessage("Nickname Not Found.");
                        return true;
                    }
                }
			} 
		}
		return true;
	}
}
