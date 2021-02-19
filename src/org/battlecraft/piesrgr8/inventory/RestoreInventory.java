package org.battlecraft.piesrgr8.inventory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class RestoreInventory implements Listener {

	BattlecraftServer plugin;

	public RestoreInventory(BattlecraftServer p) {
		this.plugin = p;
	}
	
	public static void saveInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//Saved//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}
	
	public static void loadInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//Saved//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}

	public static void saveFactionInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//Faction//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}

	public static void loadFactionInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//Faction//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}
	
	public static void saveCreativeInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//Creative//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}

	public static void loadCreativeInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//Creative//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}
	
	public static void saveSkyBlockInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//SkyBlock//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}

	public static void loadSkyBlockInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//SkyBlock//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}
	
	public static void saveKitPvPInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//KitPvP//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}

	public static void loadKitPvPInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//KitPvP//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}
	
	public static void loadPrisonInventory(Player p) {
		File file = new File("plugins//BattlecraftServer//inventories//Prison//" + p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = inv.getList("Inventory");

			for (int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
			file.delete();
		}
	}
	
	public static void savePrisonInventory(Player p) {
		checkFolder();
		ArrayList<ItemStack> list = new ArrayList<>();
		File file = new File("plugins//BattlecraftServer//inventories//Prison//" + p.getUniqueId().toString() + ".yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
			ItemStack[] contents = p.getInventory().getContents();
			for (int i = 0; i < contents.length; i++) {
				ItemStack item = contents[i];
				if (!(item == null)) {
					list.add(item);
				}
			}
			inv.set("Inventory", list);
			try {
				inv.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			p.getInventory().clear();
		}
	}
	
	public static void saveInvFor(Player p, World world) {
		if (world == null) {
			return;
		}
		
		if (world.getName().equals("Faction")) {
			saveFactionInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("world")) {
			saveFactionInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("Minigame")) {
			saveFactionInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("ASkyBlock")) {
			saveSkyBlockInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("Creative")) {
			saveCreativeInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("KitPvP")) {
			saveKitPvPInventory(p);
		} else {
			return;
		}
		
		if (world.getName().equals("Prison")) {
			savePrisonInventory(p);
		} else {
			return;
		}
	}

	public static void checkFolder() {
		File file = new File("plugins//BattlecraftServer//inventories");
		File file2 = new File("plugins//BattlecraftServer//inventories//Faction");
		File file3 = new File("plugins//BattlecraftServer//inventories//Creative");
		File file4 = new File("plugins//BattlecraftServer//inventories//SkyBlock");
		File file5 = new File("plugins//BattlecraftServer//inventories//KitPvP");
		File file7 = new File("plugins//BattlecraftServer//inventories//Prison");
		File file6 = new File("plugins//BattlecraftServer//inventories//Saved");
		if (!file.exists()) {
			file.mkdirs();
		}
		if (!file2.exists()) {
			file2.mkdirs();
		}
		if (!file3.exists()) {
			file3.mkdirs();
		}
		if (!file4.exists()) {
			file4.mkdirs();
		}
		if (!file5.exists()) {
			file5.mkdirs();
		}
		if (!file6.exists()) {
			file6.mkdirs();
		}
		if (!file7.exists()) {
			file7.mkdirs();
		}
	}
}
