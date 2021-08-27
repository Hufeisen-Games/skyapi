package main.java.com.github.HufeisenGames.SkyAPI.inventory.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.events.DrawInventoryEvent;

/**
 * Interface used to create an inventory function.
 * 
 * @author      Hufeisen <hufeisen@hufeisen-games.de>
 * @version     1.2
 * @since       1.2
 * 
 */

public interface InventoryFunction {
	
	/**
	 * <p>
	 * Methode to that will called when closing the inventory
	 * <p>
	 *
	 * @since 1.2
	 */
	void onClose(SkyInventory inventory, Player player, InventoryCloseEvent event);
	
	/**
	 * <p>
	 * Methode to that will called when drawing the inventory
	 * <p>
	 *
	 * @since 1.2
	 */
	void onDraw(SkyInventory inventory, Player player, DrawInventoryEvent event);
	
}
