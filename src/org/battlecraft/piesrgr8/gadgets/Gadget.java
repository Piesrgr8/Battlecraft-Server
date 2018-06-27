package org.battlecraft.piesrgr8.gadgets;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.event.Listener;

public class Gadget implements Listener {

	BattlecraftServer plugin;

	public Gadget(BattlecraftServer p) {
		this.plugin = p;
	}
}
