package org.battlecraft.piesrgr8.party;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PartyEvents implements Listener {

	BattlecraftServer plugin;

	public PartyEvents(BattlecraftServer p) {
		this.plugin = p;
	}
//TODO FIJHAIGN
	@EventHandler
	public void playerWorldChange(PlayerTeleportEvent e) {
/*
		if (!Party.isInParty(p)) {
			return;
		}
		

		if (Party.isInParty(p) && !Party.getLeaderName(p).equals(p.getName())) {
			e.setCancelled(true);
			p.sendMessage(Prefix.prefixParty + ChatColor.RED + "Waiting for leader...");
			return;
		}

		if (Party.isInParty(p) && Party.getLeaderName(p).equals(p.getName())) {
			e.setCancelled(false);
			final Player pl = Party.getLeader(p);
			for (final String playerName : Party.getMembers(p)) {
				Player player = Bukkit.getServer().getPlayer(playerName);
				if (Party.getLeaderName(player).equals(player.getName())) {
						player.teleport(new Location(pl.getWorld(), pl.getLocation().getX(), pl.getLocation().getY(),
								pl.getLocation().getZ()));
					}
			}
		} */
	}
}
