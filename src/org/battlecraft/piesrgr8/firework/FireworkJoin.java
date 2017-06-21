package org.battlecraft.piesrgr8.firework;

public class FireworkJoin {

	/*
	 * BattlecraftServer plugin;
	 * 
	 * public FireworkJoin(BattlecraftServer p) { this.plugin = p; }
	 * 
	 * 
	 * @EventHandler public void onPlayerJoin(final PlayerJoinEvent e) {
	 * Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new
	 * Runnable() { public void run() { Firework f = (Firework)
	 * e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(),
	 * Firework.class); FireworkMeta fm = f.getFireworkMeta();
	 * fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(Type
	 * .BALL_LARGE).withColor(Color.BLUE, Color.RED, Color.WHITE).build());
	 * fm.setPower(3); f.setFireworkMeta(fm); } }, 20);
	 * 
	 * }
	 * 
	 * ArrayList<Player> cooldown = new ArrayList<Player>();
	 * 
	 * public boolean onCommand(CommandSender sender, Command cmd, String label,
	 * String[] args) { final Player p = (Player) sender; if
	 * (cmd.getName().equalsIgnoreCase("fw")) { if (cooldown.contains(p)) {
	 * p.sendMessage(ChatColor.RED + "You cannot get fireworks yet!");
	 * p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1); return true;
	 * } } if (cmd.getName().equalsIgnoreCase("fw")) { PlayerInventory pi =
	 * p.getInventory(); p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 1);
	 * pi.addItem(new ItemStack(Material.FIREWORK, 64));
	 * p.sendMessage(ChatColor.GREEN + "You have recieved your " +
	 * ChatColor.YELLOW + "fireworks!"); p.sendMessage(ChatColor.GREEN + "Use "
	 * +ChatColor.YELLOW + "/firework " + ChatColor.GREEN + "to customize!");
	 * cooldown.add(p);
	 * Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new
	 * Runnable() { public void run() { cooldown.remove(p);
	 * p.sendMessage(BattlecraftServer.prefixMain + ChatColor.GREEN +
	 * "You can now recieve fireworks with " + ChatColor.YELLOW + "/fw!"); } },
	 * 3000);
	 * 
	 * return true; } return false; }
	 */
}
