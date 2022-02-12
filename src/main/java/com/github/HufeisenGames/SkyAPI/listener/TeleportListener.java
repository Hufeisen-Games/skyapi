package main.java.com.github.HufeisenGames.SkyAPI.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI;
import main.java.com.github.HufeisenGames.SkyAPI.teleport.SkyTeleport;

/**
 * Listener class used for teleport checks for the TeleportAPI
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     2.0
 * @since       2.0
 * 
 */

public class TeleportListener implements Listener{

	@EventHandler
	private void onPlayerMove(PlayerMoveEvent event) {
		
        if(SkyAPI.getSkyAPI().getSkyTeleportAPI() != null) {
        	
        	for(SkyTeleport t : SkyAPI.getSkyAPI().getSkyTeleportAPI().teleports) {
        		t.checkMove(event.getPlayer());
        	}
        	
        }  	
	}
	
}
