package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventoryAPI;
import main.java.com.github.HufeisenGames.SkyAPI.listener.InventoryListener;
import main.java.com.github.HufeisenGames.SkyAPI.listener.TeleportListener;
import main.java.com.github.HufeisenGames.SkyAPI.teleport.SkyTeleportAPI;

/**
 * SkyAPI main class
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     1.2
 * @since       1.2
 * 
 */

public class SkyAPI {
	
	/**
	 * DO NOT CHANGE
	 */
	private SkyInventoryAPI skyInventoryAPI;
	private SkyTeleportAPI skyTeleportAPI;
	private JavaPlugin plugin;
	
	/**
	 * DO NOT CHANGE
	 */
	private static SkyAPI skyAPI;
	
	/**
	 * Enum used for the selection with API parts you will use. Here will be added more in future releases
	 */
	public static enum API{
		Inventory,
		Teleport,
		None
	}
	
	/**
	 * <p>
	 * Setup the SkyAPI. Without the API will not work
	 * <p>
	 *
	 * @param  plugin The main class of your plugin. Will be used to register events
	 * @param  apis Here you have to add the modules you will use
	 * @since 1.2
	 */
	public SkyAPI(JavaPlugin plugin, API...apis) {
		skyAPI = this;
	    for (API api : apis) { 
	    	if(api == API.Inventory) {
	    		if(skyInventoryAPI == null) {
		    		skyInventoryAPI = new SkyInventoryAPI();
		    		Bukkit.getPluginManager().registerEvents(new InventoryListener(), plugin);
	    		} else {
	    			Bukkit.getLogger().warning("You are trying to activate the InventoryAPI from SkyAPI both!");
	    		}
	    	}
	    	
	    	if(api == API.Teleport) {
	    		if(skyTeleportAPI == null) {
		    		skyTeleportAPI = new SkyTeleportAPI();
		    		Bukkit.getPluginManager().registerEvents(new TeleportListener(), plugin);
	    		} else {
	    			Bukkit.getLogger().warning("You are trying to activate the TeleportAPI from SkyAPI both!");
	    		}
	    	}
	    	
	    	this.plugin = plugin;
	    }
	}
	
	/**
	 *
	 * @return SkyAPI Class
	 * @since 1.2
	 */
	public static SkyAPI getSkyAPI() {
		return skyAPI;
	}
	
	/**
	 * 
	 * @return SkyInventoryAPI Class
	 * @since 1.2
	 */
	public SkyInventoryAPI getSkyInventoryAPI() {
		return skyInventoryAPI;
	}
	
	/**
	 * 
	 * @return SkyTeleportAPI Class
	 * @since 2.0
	 */
	public SkyTeleportAPI getSkyTeleportAPI() {
		return skyTeleportAPI;
	}
	
	/**
	 * 
	 * @return JavaPlugin Class
	 * @since 2.0
	 */
	public JavaPlugin getPlugin() {
		return plugin;
	}

}
