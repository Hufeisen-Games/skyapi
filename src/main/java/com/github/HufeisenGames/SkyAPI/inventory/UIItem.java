package main.java.com.github.HufeisenGames.SkyAPI.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.ItemFunction;

/**
 * The UIItem object that will be used in SkyInventories
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     1.2
 * @since       1.0
 * 
 */
public class UIItem {
	
	/**
	 * DO NOT CHANGE
	 */
	ItemStack item;
	
	/**
	 * DO NOT CHANGE
	 */
	int position;
	
	/**
	 * DO NOT CHANGE
	 */
	ItemFunction itemFunction;
	
	/**
	 * DO NOT CHANGE
	 */
	SkyInventory inventory;
	
	/**
	 * DO NOT CHANGE
	 */
	String subInventory;
	
	private boolean canGet = false;
	
	/**
	 * <p>
	 * This Methode is only for the API acces. DO USE THE CREATEITEM METHODE OF THE INVENTORY INSTEAD OF THIS
	 * <p>
	 *
	 * @since 1.0
	 * @deprecated
	 */
	public UIItem(SkyInventory inventory, ItemStack item, int position) {
		this.item = item;
		this.position = position;
	}
	
	/**
	 * <p>
	 * Set an ItemFunction to the item. With this you can add code to the item
	 * <p>
	 *
	 * @see main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.ItemFunction
	 * @param itemFunction The InventoryFunction that will be set
	 * @since 1.0
	 */
	public void setFunction(ItemFunction itemFunction) {
		this.itemFunction = itemFunction;
	}
	
	/**
	 * <p>
	 * This function will be used to trigger all item actions.
	 * <p>
	 *
	 * @param player The player who has clicked
	 * @param event The InventoryClickEvent
	 * @since 1.0
	 */
	public void trigger(Player player, InventoryClickEvent event) {
		if(subInventory != null) {
			inventory.openSubInventory(player, subInventory);
			return;
		}
		if(itemFunction != null) {
			itemFunction.onClick(this, inventory, player, event);
		}

		if(!canGet) {
			event.setCancelled(true);
		}
	}
	
	/**
	 * <p>
	 * Change if the item can be pick up out of the inventory
	 * <p>
	 *
	 * @param canGet true if you can get the item, false if the event will be cancelled
	 * @since 1.1
	 */
	public void canGet(boolean canGet) {
		this.canGet = canGet;
	}
	
	/**
	 * <p>
	 * Set a sub inventory to the Item. If this will be used, no code action will be performed
	 * <p>
	 *
	 * @param id The id of the sub inventory. You can create a sub inventory with the createSubInventory function of your inventory
	 * @since 1.2
	 */
	public void setSubInventory(String id) {
		subInventory = id;
	}
}
