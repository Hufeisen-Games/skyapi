package main.java.com.github.HufeisenGames.SkyAPI.callbacks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Interface for creating a callback
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     2.0
 * @since       2.0
 * 
 */
public interface TeleportCallback {

	/**
	 * <p>
	 * Callback after teleport
	 * <p>
	 *
	 * @since 2.0
	 */
	public enum CallbackState{
		
		TELEPORTED,
		CANCELED,
		ERROR
		
	}
	
	void onTeleport(Player p, Location l, CallbackState state);
	
}
