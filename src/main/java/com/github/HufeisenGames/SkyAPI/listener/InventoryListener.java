package main.java.com.github.HufeisenGames.SkyAPI.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;

public class InventoryListener implements Listener{
	
	SkyAPI skyAPI = SkyAPI.getSkyAPI();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
        if(skyAPI.skyInventoryAPI != null) {
        	
        	for(SkyInventory inventory : skyAPI.skyInventoryAPI.inventories) {
        		
        		inventory.onInventoryClick(event);
        		
        	}
        	
        }  	
	}
	
	@EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
		
        if(skyAPI.skyInventoryAPI != null) {
        	
        	for(SkyInventory inventory : skyAPI.skyInventoryAPI.inventories) {
        		
        		inventory.onInventoryClose(event);
        		
        	}
        	
        }
    }

}
