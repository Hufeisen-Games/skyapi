package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventoryAPI;
import main.java.com.github.HufeisenGames.SkyAPI.listener.InventoryListener;
import main.java.com.github.HufeisenGames.SkyAPI.particle.SkyParticleAPI;

public class SkyAPI {
	
	public SkyInventoryAPI skyInventoryAPI;
	public SkyParticleAPI skyParticleAPI;
	public static SkyAPI skyAPI;
	
	public static enum API{
		Inventory,
		Particle,
		None
	}
	
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
	    		if(skyParticleAPI == null) {
	    			skyParticleAPI = new SkyParticleAPI();
	    		} else {
	    			Bukkit.getLogger().warning("You are trying to activate the InventoryAPI from SkyAPI both!");
	    		}
	    	}
	    }
	}
	
	public static SkyAPI getSkyAPI() {
		return skyAPI;
	}

}
