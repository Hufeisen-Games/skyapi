package main.java.com.github.HufeisenGames.SkyAPI.inventory.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.UIItem;

public interface ItemFunction{

	void onClick(UIItem item, SkyInventory inventory, Player player, InventoryClickEvent event);
	
}
