package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventoryAPI;
import main.java.com.github.HufeisenGames.SkyAPI.listener.InventoryListener;
import main.java.com.github.HufeisenGames.SkyAPI.scoreboard.SkyBoardAPI;

public class SkyAPI {
	
	public SkyInventoryAPI skyInventoryAPI;
	public SkyBoardAPI skyBoardAPI;
	public static SkyAPI skyAPI;
	
	public static enum API{
		Inventory,
		ScoreBoard,
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
	    		if(skyBoardAPI == null) {
	    			skyBoardAPI = new SkyBoardAPI();
	    		} else {
	    			Bukkit.getLogger().warning("You are trying to activate the ScoreBoardAPI from SkyAPI both!");
	    		}
	    	}
	    }
	}
	
	public static SkyAPI getSkyAPI() {
		return skyAPI;
	}

}
