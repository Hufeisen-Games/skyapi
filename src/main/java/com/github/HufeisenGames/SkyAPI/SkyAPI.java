package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventoryAPI;
import main.java.com.github.HufeisenGames.SkyAPI.listener.InventoryListener;

/**
 * SkyAPI main class
 * 
 * @author      Hufeisen <hufeisen@hufeisen-games.de>
 * @version     1.2
 * @since       1.2
 * 
 */

public class SkyAPI {
	
	/**
	 * DO NOT CHANGE
	 */
	private SkyInventoryAPI skyInventoryAPI;
	
	/**
	 * DO NOT CHANGE
	 */
	private static SkyAPI skyAPI;
	
	/**
	 * Enum used for the selection with API parts you will use. Here will be added more in future releases
	 */
	public static enum API{
		Inventory,
		None
	}
	
	/**
	 * <p>
	 * Setup the SkyAPI. Without the API will not work
	 * <p>
	 *
	 * @param  plugin The main class of your plugin. Will be used to register events
	 * @param  apis Here you have to add the modules you will use
	 * @return SkyAPI Class
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

}
