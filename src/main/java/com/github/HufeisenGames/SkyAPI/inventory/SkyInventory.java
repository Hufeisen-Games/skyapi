package main.java.com.github.HufeisenGames.SkyAPI.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI;
import main.java.com.github.HufeisenGames.SkyAPI.exceptions.APINotActiveException;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.events.DrawInventoryEvent;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.InventoryFunction;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.ItemFunction;

/**
 * Create an simple to use, API based inventory
 * 
 * @author      Hufeisen <hufeisen@hufeisen-games.de>
 * @version     1.2
 * @since       1.0
 * 
 */

public class SkyInventory{
	/**
	 * The display name of the inventory
	 */
	public String name = "Menü";
	
	/**
	 * The size of an inventory
	 */
	public int slots = 9;
	
	private List<UIItem> items = new ArrayList<UIItem>();
	private ItemStack filler;
	private List<Inventory> inventorys = new ArrayList<Inventory>();
	private List<Player> players = new ArrayList<Player>();
	private InventoryFunction inventoryFunction;
	private SkyAPI skyAPI = SkyAPI.getSkyAPI();
	private HashMap<String, SkyInventory> subInventorys = new HashMap<>();
	
	/**
	 * <p>
	 * Create an simple to use, API based inventory
	 * <p>
	 *
	 * @param  name The display name of the inventory
	 * @param  slots The size of the inventory
	 * @return SkyInventory Class
	 * @since 1.0
	 */
	public SkyInventory(String name, int slots) throws APINotActiveException {
		
		if(skyAPI.getSkyInventoryAPI() == null) {
			
			throw new APINotActiveException("You are trying to acces the InventoryAPI from SkyAPI while it is disabled!");
			
		} else {
			
			this.name = name;
			this.slots = slots;
	
			filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
			ItemMeta fillerMeta = filler.getItemMeta();
	
			fillerMeta.setDisplayName(" ");
	
			filler.setItemMeta(fillerMeta);
			
			skyAPI.getSkyInventoryAPI().inventories.add(this);
			
		}

	}

	/**
	 * <p>
	 * Create an simple to use, API based inventory
	 * <p>
	 *
	 * @param  name The display name of the inventory
	 * @param  slots The size of the inventory
	 * @param  filler The ItemStack that will be used to fill empty slots. Use {@link #nullFiller()} to create empty filler. Can also set using {@link #setFiller(ItemStack item)}
	 * @return SkyInventory Class
	 * @since 1.0
	 */
	public SkyInventory(String name, int slots, ItemStack filler) throws APINotActiveException {
		
		if(skyAPI.getSkyInventoryAPI() == null) {
			
			throw new APINotActiveException("You are trying to acces the InventoryAPI from SkyAPI while it is disabled!");
			
		} else {
			
			this.name = name;
			this.slots = slots;
			this.filler = filler;
			skyAPI.getSkyInventoryAPI().inventories.add(this);
			
		}
	}

	/**
	 * <p>
	 * Add an item to the inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  name The name of the item. You can use color codes
	 * @param  material The material that will be used to create the item
	 * @return UIItem Class, please use {@link #createItem(int position, String name, Material material)} to create an UIItem for this inventory. With this function it will be automaticaly added
	 * @since 1.0
	 */
	public UIItem addItem(int position, String name, Material material) {
		UIItem uiitem = createItem(position, name, material);

		items.add(uiitem);
		return uiitem;
	}

	/**
	 * <p>
	 * Add an item to the inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  item The ItemStack that will be used to create the item. Use it for more customization
	 * @return UIItem Class, please use {@link #createItem(int position, ItemStack item)} to create an UIItem for this inventory. With this function it will be automaticaly added
	 * @since 1.0
	 */
	public UIItem addItem(int position, ItemStack item) {

		UIItem uiitem = createItem(position, item);

		items.add(uiitem);
		return uiitem;
	}
	
	/**
	 * <p>
	 * Add an item to the inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  name The name of the item. You can use color codes
	 * @param  lore The lore that will be added to the ItemStack
	 * @param  material The material that will be used to create the item
	 * @return UIItem Class, please use {@link #createItem(int position, ItemStack item)} to create an UIItem for this inventory. With this function it will be automaticaly added
	 * @since 1.0
	 */
	public UIItem addItem(int position, String name, List<String> lore, Material material) {

		UIItem uiitem = createItem(position, name, lore, material);

		items.add(uiitem);
		return uiitem;
	}
	
	/**
	 * <p>
	 * Add an item to the inventory
	 * <p>
	 *
	 * @param  item The UIItem that will be added. Please use {@link #createItem()} to create an item.
	 * @return UIItem Class, please use {@link #createItem(int position, ItemStack item)} to create an UIItem for this inventory. With this function it will be automaticaly added
	 * @since 1.2
	 */
	public UIItem addItem(UIItem item) {
		items.add(item);
		return item;
	}
	
	/**
	 * <p>
	 * Create a UIItem. Use {@link #addItem(int position, String name, Material material)} to add it directly to the inventory. The created UIItem can only be used for this inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  name The name of the item. You can use color codes
	 * @param  material The material that will be used to create the item
	 * @return UIItem Class, please use {@link #addItem(UIItem item)} to add it to the inventory
	 * @since 1.2
	 */
	@SuppressWarnings("deprecation")
	public UIItem createItem(int position, String name, Material material) {

		ItemStack item = new ItemStack(material);
		ItemMeta itemMeta = item.getItemMeta();

		itemMeta.setDisplayName(name);

		item.setItemMeta(itemMeta);

		UIItem uiitem = new UIItem(this, item, position);
		
		uiitem.inventory = this;

		return uiitem;
	}

	/**
	 * <p>
	 * Create a UIItem. Use {@link #addItem(int position, String name, Material material)} to add it directly to the inventory. The created UIItem can only be used for this inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  item The ItemStack that will be used to create the item. Use it for more customization
	 * @return UIItem Class, please use {@link #addItem(UIItem item)} to add it to the inventory
	 * @since 1.2
	 */
	@SuppressWarnings("deprecation")
	public UIItem createItem(int position, ItemStack item) {

		UIItem uiitem = new UIItem(this, item, position);
		uiitem.inventory = this;
		
		return uiitem;
	}
	
	/**
	 * <p>
	 * Create a UIItem. Use {@link #addItem(int position, String name, Material material)} to add it directly to the inventory. The created UIItem can only be used for this inventory
	 * <p>
	 *
	 * @param  position The slot where the item will be placed. The first slot from the inventory is 0
	 * @param  name The name of the item. You can use color codes
	 * @param  lore The lore that will be added to the ItemStack
	 * @param  material The material that will be used to create the item
	 * @return UIItem Class, please use {@link #addItem(UIItem item)} to add it to the inventory
	 * @since 1.2
	 */
	@SuppressWarnings("deprecation")
	public UIItem createItem(int position, String name, List<String> lore, Material material) {

		ItemStack item = new ItemStack(material);
		ItemMeta itemMeta = item.getItemMeta();

		itemMeta.setDisplayName(name);
		itemMeta.setLore(lore);

		item.setItemMeta(itemMeta);
		UIItem uiitem = new UIItem(this, item, position);
		uiitem.inventory = this;
		
		return uiitem;
	}
	
	/**
	 * <p>
	 * Remove an item from the inventory. Use {@link SkyInventory#changeItem(int, UIItem)} to change the item
	 * <p>
	 *
	 * @param  position The slot where the item will be remove. The first slot from the inventory is 0
	 * @since 1.2
	 */
	public void removeItem(int position) {
		for(int i = 0; i<items.size(); i++){
			if(items.get(i).position == position) {
				items.remove(i);
			}
		}
	}
	
	/**
	 * <p>
	 * Change an item in the inventory. Use {@link SkyInventory#removeItem(int position)} to remove an item
	 * <p>
	 *
	 * @param  position The slot where the item will be remove. The first slot from the inventory is 0
	 * @since 1.2
	 */
	public void changeItem(int position, UIItem item) {
		removeItem(position);
		addItem(position, item.item);
	}
	
	/**
	 * <p>
	 * Set an InventoryFunction to the inventory. With this you can add code to the inventory
	 * <p>
	 *
	 * @see main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.InventoryFunction
	 * @param inventoryFunction The InventoryFunction that will be set
	 * @since 1.2
	 */
	public void setFunction(InventoryFunction inventoryFunction) {
		this.inventoryFunction = inventoryFunction;
	}
	
	/**
	 * <p>
	 * Add a sub inventory to the main inventory. You can connect an opener item with UIItem.setSubInventory
	 * <p>
	 *
	 * @param id The ID that will be used to identificate the sub inventory
	 * @param inventory The inventory that will be used as the "sub inventory"
	 * @param back The item that will be added on the last position of the sub inventory and will be used to open the main inventory again.
	 * @since 1.2
	 */
	public void addSubInventory(String id, SkyInventory inventory2, ItemStack back) {
		inventory2.addItem(inventory2.slots-1, back).setFunction(new ItemFunction() {
			
			@Override
			public void onClick(UIItem item, SkyInventory inventory, Player player, InventoryClickEvent event) {
				
				open(player);
				
			}
		});
		
		subInventorys.put(id, inventory2);
	}
	
	/**
	 * <p>
	 * Add a sub inventory to the main inventory. You can connect an opener item with UIItem.setSubInventory
	 * <p>
	 *
	 * @param id The ID that will be used to identificate the sub inventory
	 * @param inventory The inventory that will be used as the "sub inventory"
	 * @param back The item that will be added on the last position of the sub inventory and will be used to open the main inventory again. Use {@link #createItem()} to create the UIItem
	 * @since 1.2
	 */
	public void addSubInventory(String id, SkyInventory inventory2, UIItem back) {
		inventory2.addItem(inventory2.slots-1, back.item).setFunction(new ItemFunction() {
			
			@Override
			public void onClick(UIItem item, SkyInventory inventory, Player player, InventoryClickEvent event) {
				
				open(player);
				
			}
		});
		
		subInventorys.put(id, inventory2);
	}
	
	/**
	 * <p>
	 * Open a sub inventory manually
	 * <p>
	 *
	 * @param player The player whose inventory will opened
	 * @param id The ID that will be used to identificate the sub inventory
	 * @since 1.2
	 */
	public void openSubInventory(Player player, String id) {
		subInventorys.get(id).open(player);
	}

	/**
	 * <p>
	 * Set or change the filler item of the inventory. Use {@link #nullFiller()} to create empty filler
	 * <p>
	 *
	 * @param item Set or change the filler item of the inventory. Use
	 * @since 1.0
	 */
	public void setFiller(ItemStack item) {

		filler = item;

	}
	
	/**
	 * <p>
	 * Set the filler to empty. Can be set to an item again with {@link #setFiller(ItemStack item)}
	 * <p>
	 *
	 * @param item Set or change the filler item of the inventory. Use
	 * @since 1.1
	 */
	public void nullFiller() {
		
		filler = null;	
		
	}
	
	/**
	 * <p>
	 * Update the inventory when items have changed.
	 * <p>
	 *
	 * @since 1.0
	 */
	public void updateInventory() {
		List<Player> p = new ArrayList<Player>();
		for(Player player : players) {
			p.add(player);
		}
		players.clear();
		inventorys.clear();
		
		for(Player player : p) {
			open(player);
		}
	}

	/**
	 * <p>
	 * Open the inventory to a player
	 * <p>
	 *
	 * @param player The player which inventory will be opened
	 * @return The normal bukkit inventory for special customization.
	 * @since 1.0
	 */
	public Inventory open(Player player) {
		
		Inventory inv = Bukkit.createInventory(player, slots, name);
		
		if(filler != null) {
			for (int slot = 0; slot < inv.getSize(); slot++) {
	
				inv.setItem(slot, filler);
	
			}
		}

		for (UIItem uiitem : items) {

			inv.setItem(uiitem.position, uiitem.item);

		}
		DrawInventoryEvent invEvent = new DrawInventoryEvent(this, inv, player, slots, name);
		if(inventoryFunction != null) {
			inventoryFunction.onDraw(this, player, invEvent);
		}
		if(invEvent.isCancelled != true) {
			player.openInventory(inv);
			players.add(player);
			inventorys.add(inv);
			return inv;
		}
		
		return Bukkit.createInventory(player, slots, name);
	}
	
	/**
	 * <p>
	 * Manually run an InventoryClickEvent. Normaly it will be called automaticaly
	 * <p>
	 *
	 * @param event The InventoryClickEvent
	 * @since 1.0
	 * @deprecated
	 */
	public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if(inventorys.contains(event.getInventory())) {
	        	for(UIItem uiitem : items) {
	        		if(uiitem.position == event.getSlot()) {
        				uiitem.trigger(player, event);
        				return;
	        		}
	        		
	        	}
	        	
	        	event.setCancelled(true);
            }
        }
	}
	
	/**
	 * <p>
	 * Manually run an InventoryCloseEvent. Normaly it will be called automaticaly
	 * <p>
	 *
	 * @param event The InventoryCloseEvent
	 * @since 1.0
	 * @deprecated
	 */
    public void onInventoryClose(InventoryCloseEvent event) {
    	if(players.contains(event.getPlayer())) {
    		if(inventoryFunction != null) {
    			inventoryFunction.onClose(this, (Player) event.getPlayer(), event);
    		}
            inventorys.remove(event.getInventory());
            players.remove(event.getPlayer());
    	}
    }
	
}
