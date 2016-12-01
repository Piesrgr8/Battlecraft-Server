package org.battlecraft.piesrgr8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.battlecraft.iHersh.ranks.RanksEnum;
import org.battlecraft.piesrgr8.config.ConfigMg;
import org.battlecraft.piesrgr8.config.PlayersYML;
import org.battlecraft.piesrgr8.essentials.AntiSwear;
import org.battlecraft.piesrgr8.essentials.Chat;
import org.battlecraft.piesrgr8.essentials.Commands;
import org.battlecraft.piesrgr8.essentials.PlayerTp;
import org.battlecraft.piesrgr8.fake.SilentJoin;
import org.battlecraft.piesrgr8.fake.Spammer;
import org.battlecraft.piesrgr8.hub.DoubleJump;
import org.battlecraft.piesrgr8.hub.Hub;
import org.battlecraft.piesrgr8.hub.Launchers;
import org.battlecraft.piesrgr8.hub.Menus;
import org.battlecraft.piesrgr8.hub.NavGame;
import org.battlecraft.piesrgr8.inventory.RestoreInventory;
import org.battlecraft.piesrgr8.listeners.BCBlockListener;
import org.battlecraft.piesrgr8.listeners.DeathListener;
import org.battlecraft.piesrgr8.listeners.PlayerListener;
import org.battlecraft.piesrgr8.menu.MainPvP;
import org.battlecraft.piesrgr8.menu.Sg;
import org.battlecraft.piesrgr8.players.Friends;
import org.battlecraft.piesrgr8.players.Piesrgr8;
import org.battlecraft.piesrgr8.poll.Poll;
import org.battlecraft.piesrgr8.shop.Shop;
import org.battlecraft.piesrgr8.shop.ShopMaterial;
import org.battlecraft.piesrgr8.shop.ShopMaterialStone;
import org.battlecraft.piesrgr8.shop.ShopMaterialWood;
import org.battlecraft.piesrgr8.shop.ShopTool;
import org.battlecraft.piesrgr8.signs.Buy;
import org.battlecraft.piesrgr8.stats.BlockBreaks;
import org.battlecraft.piesrgr8.stats.DamageTaken;
import org.battlecraft.piesrgr8.stats.Deaths;
import org.battlecraft.piesrgr8.stats.ItemCreations;
import org.battlecraft.piesrgr8.stats.Kills;
import org.battlecraft.piesrgr8.utils.Cooldown;
import org.battlecraft.piesrgr8.utils.Dynamicmotd;
import org.battlecraft.piesrgr8.utils.PacketUtil;
import org.battlecraft.piesrgr8.utils.PlayerCountMessage;
import org.battlecraft.piesrgr8.utils.RestartCommand;
import org.battlecraft.piesrgr8.utils.ScoreboardMg;
import org.battlecraft.piesrgr8.utils.SignColors;
import org.battlecraft.piesrgr8.utils.SoundEffects;
import org.battlecraft.piesrgr8.utils.Tablist;
import org.battlecraft.piesrgr8.utils.Test;
import org.battlecraft.piesrgr8.utils.online.TimerDaily;
import org.battlecraft.piesrgr8.weapons.Guns;
import org.battlecraft.piesrgr8.world.WorldHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BattlecraftServer extends JavaPlugin implements CommandExecutor {

	Logger log = Logger.getLogger("Minecraft");
	BattlecraftServer plugin = this;

	public static List<String> message1 = new ArrayList<String>();

	private static JavaPlugin instance;

	// ALL PREFIXES FOR SEVERAL CLASSES!

	public static String prefixMain = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.GRAY
			+ "] ";

	public static String prefixHealth = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.GREEN + "" + ChatColor.BOLD + "Health" + ChatColor.GRAY + "] ";

	public static String prefixGamemode = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Gamemode" + ChatColor.GRAY + "] ";

	public static String prefixPunish = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Punish" + ChatColor.GRAY + "] ";

	public static String prefixWorld = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "World" + ChatColor.GRAY + "] ";

	public static String prefixKit = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
			+ "" + ChatColor.BOLD + "Kit" + ChatColor.GRAY + "] ";

	public static String prefixStealth = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Stealth" + ChatColor.GRAY + "] ";

	public static String prefixHub = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
			+ "" + ChatColor.BOLD + "Hub" + ChatColor.GRAY + "] ";

	public static String prefixWeapons = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Weapons" + ChatColor.GRAY + "] ";

	public static String prefixPolls = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Poll" + ChatColor.GRAY + "] ";

	public static String prefixError = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.DARK_RED + "" + ChatColor.BOLD + "Error" + ChatColor.GRAY + "] ";

	public static String prefixStaff = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Staff" + ChatColor.GRAY + "] ";

	public static String prefixShop = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
			+ "" + ChatColor.BOLD + "Shop" + ChatColor.GRAY + "] ";

	public static String prefixReport = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.DARK_RED + "" + ChatColor.BOLD + "Report" + ChatColor.GRAY + "] ";

	public static String prefixWarp = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
			+ "" + ChatColor.BOLD + "Warp" + ChatColor.GRAY + "] ";

	public static String prefixInv = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC" + ChatColor.BLUE
			+ "" + ChatColor.BOLD + "Inv" + ChatColor.GRAY + "] ";

	public static String prefixStats = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Stats" + ChatColor.GRAY + "] ";
	
	public static String prefixEnchant = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Enchant" + ChatColor.GRAY + "] ";
	
	public static String prefixNick = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Nick" + ChatColor.GRAY + "] ";
	
	public static String prefixSigns = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Sign" + ChatColor.GRAY + "] ";
	
	public static String prefixSkull = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Skull" + ChatColor.GRAY + "] ";
	
	public static String prefixFriend = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Friends" + ChatColor.GRAY + "] ";
	
	public static String prefixRanks = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.BLUE + "" + ChatColor.BOLD + "Ranks" + ChatColor.GRAY + "] ";
	
	public static String prefixAdmin = ChatColor.GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "BC"
			+ ChatColor.DARK_RED + "" + ChatColor.BOLD + "Admin" + ChatColor.GRAY + "] ";

	public static String prefixCooldown = ChatColor.GRAY + "[" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "COOLDOWN"
			+ ChatColor.GRAY + "] ";

	@Override
	public void onEnable() {
		Cooldown.cooldownTime = new HashMap<Player, Integer>();
		Cooldown.cooldownTask = new HashMap<Player, BukkitRunnable>();
		getLogger().info("The Battlecraft Server Plugin is awake and alive!");
		log = this.getLogger();
		PlayerCountMessage.playerCountMessage(this);
		ConfigMg.saveEverything(this);
		registerEvents();
		Commands.registerCommands(this);
		RanksEnum.startRanks(this);
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Hub(this), this);
		pm.registerEvents(new SilentJoin(this), this);
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new BCBlockListener(), this);
		pm.registerEvents(new Piesrgr8(this), this);
		pm.registerEvents(new AntiSwear(this), this);
		pm.registerEvents(new WorldHandler(this), this);
		pm.registerEvents(new Guns(this), this);
		pm.registerEvents(new Poll(this), this);
		pm.registerEvents(new PacketUtil(this), this);
		pm.registerEvents(new DeathListener(this), this);
		pm.registerEvents(new Spammer(this), this);
		pm.registerEvents(new Test(this), this);
		pm.registerEvents(new RestoreInventory(this), this);
		pm.registerEvents(new Dynamicmotd(this), this);
		pm.registerEvents(new Menus(this), this);
		pm.registerEvents(new NavGame(this), this);
		pm.registerEvents(new PlayerTp(this), this);
		pm.registerEvents(new Launchers(this), this);
		pm.registerEvents(new Chat(this), this);
		pm.registerEvents(new ScoreboardMg(this), this);
		pm.registerEvents(new SignColors(this), this);
		pm.registerEvents(new DoubleJump(this), this);
		pm.registerEvents(new TimerDaily(this), this);
		pm.registerEvents(new Friends(this), this);
		pm.registerEvents(new RanksEnum(this), this);
		pm.registerEvents(new SoundEffects(this), this);
		pm.registerEvents(new PlayersYML(this), this);
		pm.registerEvents(new Tablist(this), this);
		pm.registerEvents(new RestartCommand(this), this);

		// FOR STATS
		pm.registerEvents(new Kills(this), this);
		pm.registerEvents(new Deaths(this), this);
		pm.registerEvents(new ItemCreations(this), this);
		pm.registerEvents(new DamageTaken(this), this);
		pm.registerEvents(new BlockBreaks(this), this);
		// FOR SHOP
		pm.registerEvents(new Shop(this), this);
		pm.registerEvents(new ShopMaterial(this), this);
		pm.registerEvents(new ShopMaterialWood(this), this);
		pm.registerEvents(new ShopMaterialStone(this), this);
		pm.registerEvents(new ShopTool(this), this);
		
		//FOR SIGNS
		pm.registerEvents(new Buy(this), this);
		
		//FOR MENUS
		pm.registerEvents(new MainPvP(this), this);
		pm.registerEvents(new Sg(this), this);
	}

	@Override
	public void onDisable() {
		PlayerCountMessage.playerCountMessage(this);
		ConfigMg.saveEverything(this);
		getLogger().info("The Battlecraft Server Plugin is asleep!");
		plugin = null;
	}

	public static JavaPlugin getInstance() {
		return instance;
	}
}