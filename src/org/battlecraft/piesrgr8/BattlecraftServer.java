package org.battlecraft.piesrgr8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.battlecraft.piesrgr8.essentials.Commands;
import org.battlecraft.piesrgr8.listeners.EventRegistery;
import org.battlecraft.piesrgr8.utils.Cooldown;
import org.battlecraft.piesrgr8.utils.PlayerCountMessage;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
	}

	@Override
	public void onDisable() {
		//Disable the other classes, plus save everything.
		
		PlayerCountMessage.playerCountMessage(this);
		ConfigMg.saveEverything(this);
		getLogger().info("The Battlecraft Server Plugin is asleep!");
		plugin = null;
	}

	public static JavaPlugin getInstance() {
		return instance;
	}
}