package main.java.com.github.HufeisenGames.SkyAPI.inventory.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.UIItem;

/**
 * Interface used to create an item function.
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     1.2
 * @since       1.2
 * 
 */

public interface ItemFunction{

	/**
	 * <p>
	 * Methode to that will called when clicking on the item
	 * <p>
	 *
	 * @since 1.2
	 */
	void onClick(UIItem item, SkyInventory inventory, Player player, InventoryClickEvent event);
	
}
