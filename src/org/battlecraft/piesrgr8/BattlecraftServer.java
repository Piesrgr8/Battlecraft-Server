package org.battlecraft.piesrgr8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.battlecraft.iHersh.ranks.Permissions;
import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.battlecraft.piesrgr8.essentials.Commands;
import org.battlecraft.piesrgr8.listeners.EventRegistery;
import org.battlecraft.piesrgr8.party.Party;
import org.battlecraft.piesrgr8.poll.Poll;
import org.battlecraft.piesrgr8.utils.Cooldown;
import org.battlecraft.piesrgr8.world.WorldFallingBlocks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BattlecraftServer extends JavaPlugin {

	//The main stuff to be added.
	Logger log = Logger.getLogger("Minecraft");
	private static BattlecraftServer plugin;
	Permissions perms = new Permissions(this);
	
	
	public static List<String> message1 = new ArrayList<String>();

	@Override
	public void onEnable() {
		//Enabling other classes and saving several ymls.
		plugin = this;
		Cooldown.cooldownTime = new HashMap<Player, Integer>();
		Cooldown.cooldownTask = new HashMap<Player, BukkitRunnable>();
		getLogger().info("The Battlecraft Server Plugin is awake and alive!");
		ConfigMg.saveEverything(this);
		EventRegistery.registerEvents(this);
		Commands.registerCommands(this);
		RanksEnum.startRanks(this);
		WorldFallingBlocks.loadYAML();
		Poll.addInfoInYml();
		perms.createPermissions();
	}

	@Override
	public void onDisable() {
		//Disable the other classes, plus save everything.
		
		Party.stopEveryParty(this);
		ConfigMg.saveEverything(this);
		//claims.restartProtections();
		getLogger().info("The Battlecraft Server Plugin is asleep!");
		plugin = null;
	}
	
	public boolean pluginAvailable() {
		if (Bukkit.getPluginManager().getPlugin("Clans") != null) {
			return true;
		}
		return false;
	}
	
	public BattlecraftServer getInstance() {
		return plugin;
	}
}