package org.battlecraft.piesrgr8.utils;

import java.util.logging.Logger;

import org.battlecraft.piesrgr8.BattlecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class SmartConsole implements Listener {

	BattlecraftServer plugin;
	static Logger logger = Bukkit.getLogger();

	public SmartConsole(BattlecraftServer p) {
		this.plugin = p;
	}
/*
	static File f = ConfigMg.console;
	static YamlConfiguration yaml = ConfigMg.consoleY;

	public static void theNextLogger() {
		Bukkit.getLogger().addHandler(new Handler() {

			@Override
			public void publish(LogRecord e) {
				if (e.getLevel().equals(Level.FINE)) {
					yaml.createSection(e.getLoggerName());
					yaml.createSection(e.getLoggerName() + "." + e.getSourceMethodName());
					yaml.createSection(e.getLoggerName() + "." + e.getThrown());
					yaml.createSection(e.getLoggerName() + "." + e.getMessage());
					yaml.createSection(e.getLoggerName() + "." + e.getLevel().toString());
					try {
						yaml.save(f);
						Debug.debugConsole("This error has been saved!");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void close() throws SecurityException {
				// TODO Auto-generated method stub

			}

			@Override
			public void flush() {
				// TODO Auto-generated method stub

			}
		});

		logger.setFilter(new Filter() {

			@Override
			public boolean isLoggable(LogRecord r) {
				if (r.getLevel().equals(Level.WARNING)
						|| r.getLevel().equals(Level.SEVERE)) {
					r.setLevel(Level.FINE);
				}
				return true;
			}
		});
	} */
}
