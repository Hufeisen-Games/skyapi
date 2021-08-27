package main.java.com.github.HufeisenGames.SkyAPI.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;

/**
 * Listener class used for inventory checks for the InventoryAPI
 * 
 * @author      Hufeisen <hufeisen@hufeisen-games.de>
 * @version     1.2
 * @since       1.2
 * 
 */

public class InventoryListener implements Listener{
	
	private SkyAPI skyAPI = SkyAPI.getSkyAPI();
	
	@EventHandler
	private void onInventoryClick(InventoryClickEvent event) {
		
        if(skyAPI.getSkyInventoryAPI() != null) {
        	
        	for(SkyInventory inventory : skyAPI.getSkyInventoryAPI().inventories) {
        		
        		inventory.onInventoryClick(event);
        		
        	}
        	
        }  	
	}
	
	@EventHandler
    private void onInventoryClose(InventoryCloseEvent event) {
		
        if(skyAPI.getSkyInventoryAPI() != null) {
        	
        	for(SkyInventory inventory : skyAPI.getSkyInventoryAPI().inventories) {
        		
        		inventory.onInventoryClose(event);
        		
        	}
        	
        }
    }

}
