package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.com.github.HufeisenGames.SkyAPI.exceptions.APINotActiveException;
import main.java.com.github.HufeisenGames.SkyAPI.teleport.SkyTeleport;

public class Test implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		SkyTeleport.TeleportMessages.COOLDOWN = "Du wirst in %seconds% Sekunden teleportiert!";
		SkyTeleport.TeleportMessages.COOLDOWN_1 = "Du wirst in einer Sekunde teleportiert!";
		SkyTeleport.TeleportMessages.MOVED = "Du hast dich bewegt!";
		
		try {
			
			new SkyTeleport((Player) sender, new Location(Bukkit.getWorld("world"), 100, 100, 100), 7, false, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Effect.ENDER_SIGNAL, Sound.ENTITY_FOX_TELEPORT).teleport();
			
		} catch (APINotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	
}
