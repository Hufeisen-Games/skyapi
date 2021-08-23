package main.java.com.github.HufeisenGames.SkyAPI.inventory.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.events.DrawInventoryEvent;

public interface InventoryFunction {

	void onClose(SkyInventory inventory, Player player, InventoryCloseEvent event);
	void onDraw(SkyInventory inventory, Player player, DrawInventoryEvent event);
	
}
