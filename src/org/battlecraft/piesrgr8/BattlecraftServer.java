package org.battlecraft.piesrgr8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.battlecraft.piesrgr8.essentials.Commands;
import org.battlecraft.piesrgr8.listeners.EventRegistery;
import org.battlecraft.piesrgr8.party.Party;
import org.battlecraft.piesrgr8.utils.Cooldown;
import org.battlecraft.piesrgr8.utils.PlayerCountMessage;
import org.battlecraft.piesrgr8.world.WorldFallingBlocks;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class BattlecraftServer extends JavaPlugin implements CommandExecutor {

	//The main stuff to be added.
	Logger log = Logger.getLogger("Minecraft");
	BattlecraftServer plugin = this;

	public static List<String> message1 = new ArrayList<String>();

	private static JavaPlugin instance;

	@Override
	public void onEnable() {
		//Enabling other classes and saving several ymls.
		
		Cooldown.cooldownTime = new HashMap<Player, Integer>();
		Cooldown.cooldownTask = new HashMap<Player, BukkitRunnable>();
		getLogger().info("The Battlecraft Server Plugin is awake and alive!");
		log = this.getLogger();
		PlayerCountMessage.playerCountMessage(this);
		ConfigMg.saveEverything(this);
		EventRegistery.registerEvents(this);
		//SmartConsole.theNextLogger();
		Commands.registerCommands(this);
		RanksEnum.startRanks(this);
		WorldFallingBlocks.loadYAML();
	}

	@Override
	public void onDisable() {
		//Disable the other classes, plus save everything.
		
		Party.stopEveryParty(this);
		PlayerCountMessage.playerCountMessage(this);
		ConfigMg.saveEverything(this);
		getLogger().info("The Battlecraft Server Plugin is asleep!");
		plugin = null;
	}

	public static JavaPlugin getInstance() {
		return instance;
	}
	
	public static WorldEditPlugin getWE() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if (p instanceof WorldEditPlugin) 
			return (WorldEditPlugin) p;
		else return null;
	}
}