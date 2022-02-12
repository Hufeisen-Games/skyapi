package main.java.com.github.HufeisenGames.SkyAPI.callbacks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface TeleportCallback {

	public enum CallbackState{
		
		TELEPORTED,
		CANCELED,
		ERROR
		
	}
	
	void onTeleport(Player p, Location l, CallbackState state);
	
}
