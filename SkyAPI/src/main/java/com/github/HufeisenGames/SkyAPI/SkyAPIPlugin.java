package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI.API;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.TestCommand;

public class SkyAPIPlugin extends JavaPlugin {

	// Plugin Instance
	public static SkyAPIPlugin plugin;

	// Start Methode

	public void onEnable() {

		// setzt die Plugin Instance
		plugin = this;

		Bukkit.getConsoleSender().sendMessage("§6Initialisiere InventoryAPI...");

		// führt die Initialisirungsmethode aus
		init(Bukkit.getPluginManager());

		Bukkit.getConsoleSender().sendMessage("§aInventoryAPI geladen!");

	}

	// Initialisierungsmethode(Befehle, Listener und Configs)

	private void init(PluginManager pluginManager) {

		new SkyAPI(this, API.Inventory);

		// Befehle
		getCommand("testgui").setExecutor(new TestCommand());
		
		// Listener

	}

	// Returnt die Plugin Instance

	public static SkyAPIPlugin getPlugin() {
		return plugin;
	}

}
