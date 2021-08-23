package main.java.com.github.HufeisenGames.SkyAPI.inventory.events;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import main.java.com.github.HufeisenGames.SkyAPI.inventory.SkyInventory;

public class DrawInventoryEvent {

	private SkyInventory skyInventory;
	private Inventory inventory;
	private Player player;
	private int size;
	private String name;
	
	public boolean isCancelled = false;
	
	public void setCancelled(boolean value) {
		isCancelled = value;
	}
	
	public SkyInventory getSkyInventory() {
		return skyInventory;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getSize() {
		return size;
	}
	
	public String getName() {
		return name;
	}
	
	public DrawInventoryEvent(SkyInventory skyInventory, Inventory inventory, Player player, int size, String name) {
		this.skyInventory = skyInventory;
		this.inventory = inventory;
		this.player = player;
		this.size = size;
		this.name = name;
	}
	
}
