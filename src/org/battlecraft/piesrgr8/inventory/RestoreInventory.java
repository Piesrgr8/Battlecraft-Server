package org.battlecraft.piesrgr8.inventory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.battlecraft.piesrgr8.BattlecraftServer;
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
		File file = new File("plugins//BattlecraftServer//inventories//" + p.getUniqueId().toString() + ".yml");

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
		File file = new File("plugins//BattlecraftServer//inventories//" + p.getUniqueId().toString() + ".yml");
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

	public static void checkFolder() {
		File file = new File("plugins//BattlecraftServer//inventories");
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
