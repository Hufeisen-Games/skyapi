package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI.API;

public class SkyAPIPlugin extends JavaPlugin {

	// Plugin Instance
	public static SkyAPIPlugin plugin;

	// Start Methode

	public void onEnable() {

		// setzt die Plugin Instance
		plugin = this;

		Bukkit.getConsoleSender().sendMessage("§6Initialisiere SkyAPI...");

		// führt die Initialisirungsmethode aus
		init(Bukkit.getPluginManager());

		Bukkit.getConsoleSender().sendMessage("§aSkyAPI geladen!");

	}

	// Initialisierungsmethode(Befehle, Listener und Configs)

	private void init(PluginManager pluginManager) {
		new SkyAPI(plugin, API.Inventory, API.Teleport);
		// Befehle
		getCommand("test").setExecutor(new Test());
		// Listener

	}

	// Returnt die Plugin Instance

	public static SkyAPIPlugin getPlugin() {
		return plugin;
	}

}
