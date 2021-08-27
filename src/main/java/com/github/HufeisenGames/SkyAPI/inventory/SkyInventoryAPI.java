package main.java.com.github.HufeisenGames.SkyAPI.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for activating the SkyInventoryAPI. Do not create this
 * 
 * @author      Hufeisen <hufeisen@hufeisen-games.de>
 * @version     1.2
 * @since       1.2
 * 
 */

public class SkyInventoryAPI {

	/**
	 * List of all created inventories. Created to check the inventory click event with only one listener
	 */
	public List<SkyInventory> inventories = new ArrayList<SkyInventory>();
	
}
