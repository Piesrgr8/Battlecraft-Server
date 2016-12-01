package org.battlecraft.piesrgr8.listeners;

import java.util.HashMap;
import java.util.Map;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.event.Listener;

public class DeathListener implements Listener {

	
	public Map<String, Integer> ks = new HashMap<String, Integer>();
	
	 BattlecraftServer plugin;
	 
	 public DeathListener (BattlecraftServer p) { 
		 this.plugin = p; 
   }
	 /* 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @EventHandler(priority = EventPriority.HIGH) public void
	 * onDeath(PlayerDeathEvent e) { Player p = e.getEntity().getPlayer();
	 * Player k = e.getEntity().getKiller();
	 * 
	 * if (p.getLastDamageCause().getCause() == DamageCause.FALL) {
	 * e.setDeathMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW +
	 * " took too much fall damage!"); }
	 * 
	 * if (p.getLastDamageCause().getCause() == DamageCause.DROWNING) {
	 * e.setDeathMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW +
	 * " suffocated in water!"); }
	 * 
	 * if (p.getLastDamageCause().getCause() == DamageCause.FIRE ||
	 * p.getLastDamageCause().getCause() == DamageCause.FIRE_TICK ||
	 * p.getLastDamageCause().getCause() == DamageCause.LAVA) {
	 * e.setDeathMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW +
	 * " was burned alive!"); }
	 * 
	 * if (p.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK) {
	 * e.setDeathMessage(ChatColor.RED + k.getName() + ChatColor.YELLOW +
	 * " killed " + ChatColor.BLUE + p.getName() + ChatColor.YELLOW + " with a "
	 * + k.getItemInHand().getType()); }
	 * 
	 * if (p.getLastDamageCause().getCause() == DamageCause.VOID) {
	 * e.setDeathMessage(ChatColor.BLUE + p.getName() + ChatColor.YELLOW +
	 * " entered a black hole in space!"); } }
	 */
	/*
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity().getKiller();
		Player d = (Player) e.getEntity();
		int kills = ks.get(((Player) d.getKiller()).getName() + 1);
		
		if (!ks.containsKey(p.getName())) {
            ks.put(((Player) d.getKiller()).getName(), 0);
		}
		
		ks.put(((Player) d.getKiller()).getName(), ks.get(((Player) d.getKiller()).getName() + 1));
		
		if (kills == 2) {
			p.sendMessage("Double!");
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(
					new PacketPlayOutCustomSoundEffect("streak.double", SoundCategory.MASTER,
							p.getLocation().getBlockX(), p.getLocation().getBlockY(),
							p.getLocation().getBlockZ(), 100000.0F, 1.0F));
		}
		
		if (kills == 3) {
			p.sendMessage("Triple!");
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(
					new PacketPlayOutCustomSoundEffect("streak.triple", SoundCategory.MASTER,
							p.getLocation().getBlockX(), p.getLocation().getBlockY(),
							p.getLocation().getBlockZ(), 100000.0F, 1.0F));
		}
		
		if (kills == 4) {
			p.sendMessage("Multi!");
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(
					new PacketPlayOutCustomSoundEffect("streak.multi", SoundCategory.MASTER,
							p.getLocation().getBlockX(), p.getLocation().getBlockY(),
							p.getLocation().getBlockZ(), 100000.0F, 1.0F));
		}
		
		if (kills == 5) {
			p.sendMessage("Overkill!");
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(
					new PacketPlayOutCustomSoundEffect("streak.overk", SoundCategory.MASTER,
							p.getLocation().getBlockX(), p.getLocation().getBlockY(),
							p.getLocation().getBlockZ(), 100000.0F, 1.0F));
		}
	} */
}
