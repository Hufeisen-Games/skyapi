package main.java.com.github.HufeisenGames.SkyAPI.teleport;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPI;
import main.java.com.github.HufeisenGames.SkyAPI.callbacks.TeleportCallback;
import main.java.com.github.HufeisenGames.SkyAPI.callbacks.TeleportCallback.CallbackState;
import main.java.com.github.HufeisenGames.SkyAPI.exceptions.APINotActiveException;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class SkyTeleport {

	/**
	 * Create an simple to use, API based teleport
	 * 
	 * @author Hufeisen hufeisen@hufeisen-games.de
	 * @version 2.0
	 * @since 2.0
	 * 
	 */

	private Location targetLocation;
	private Player p;
	private Sound countdownSound;
	private Sound teleportSound;
	private Effect countdownEffect;

	private int seconds;
	private boolean movementIsCanceling;
	private boolean hasMoved;
	private boolean isCanceled;

	public SkyTeleport(Player p, Location targetLocation, int seconds, boolean movementIsCanceling) throws APINotActiveException {

		if(SkyAPI.getSkyAPI().getSkyInventoryAPI() == null) {
			
			throw new APINotActiveException("You are trying to acces the InventoryAPI from SkyAPI while it is disabled!");
			
		} else {
			
			this.targetLocation = targetLocation;
			this.seconds = seconds;
			this.movementIsCanceling = movementIsCanceling;
			this.p = p;
			
			SkyAPI.getSkyAPI().getSkyTeleportAPI().teleports.add(this);
		}

	}

	public SkyTeleport(Player p, Location targetLocation, int seconds, boolean movementIsCanceling,
			Sound countdownSound, Effect countdownEffect, Sound teleportSound) throws APINotActiveException {

		if(SkyAPI.getSkyAPI().getSkyInventoryAPI() == null) {
			
			throw new APINotActiveException("You are trying to acces the InventoryAPI from SkyAPI while it is disabled!");
			
		} else {
			
			this.targetLocation = targetLocation;
			this.seconds = seconds;
			this.movementIsCanceling = movementIsCanceling;
			this.countdownEffect = countdownEffect;
			this.countdownSound = countdownSound;
			this.teleportSound = teleportSound;
			this.p = p;
	
			SkyAPI.getSkyAPI().getSkyTeleportAPI().teleports.add(this);
		}
	}

	public SkyTeleport(Player p, Location targetLocation, int seconds) throws APINotActiveException {

		if(SkyAPI.getSkyAPI().getSkyInventoryAPI() == null) {
			
			throw new APINotActiveException("You are trying to acces the InventoryAPI from SkyAPI while it is disabled!");
			
		} else {

			this.targetLocation = targetLocation;
			this.seconds = seconds;
			this.movementIsCanceling = false;
			this.p = p;
	
			SkyAPI.getSkyAPI().getSkyTeleportAPI().teleports.add(this);
		}
	}

	public void teleport() {

		teleport((Player p, Location l, CallbackState state) -> {
		});

	}

	public void teleport(TeleportCallback callback) {

		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					if ((!hasMoved || !movementIsCanceling) && !isCanceled) {

						if (seconds > 0) {

							seconds--;

							if (countdownSound != null)
								p.playSound(p.getLocation(), countdownSound, 1, 1);

							if (countdownSound != null) {
								p.getLocation().getWorld().playEffect(p.getLocation(), countdownEffect, 3);
							}

							if (seconds > 1)
								p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
										new TextComponent(TeleportMessages.COOLDOWN.replace("%seconds%", seconds + "")));
							if (seconds == 1)
								p.spigot().sendMessage(ChatMessageType.ACTION_BAR,
										new TextComponent(TeleportMessages.COOLDOWN_1));
						}
						if (seconds == 0) {

							p.teleport(targetLocation);
							if (teleportSound != null)
								p.playSound(targetLocation, teleportSound, 1, 1);

							callback.onTeleport(p, targetLocation, CallbackState.TELEPORTED);

							this.cancel();

						}
					} else {

						p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(TeleportMessages.MOVED));
						p.sendMessage(TeleportMessages.MOVED);

						callback.onTeleport(p, targetLocation, CallbackState.CANCELED);

						this.cancel();

					}

				} catch (Exception e) {

					callback.onTeleport(p, targetLocation, CallbackState.ERROR);

				}
			}

		}.runTaskTimer(SkyAPI.getSkyAPI().getPlugin(), 0, 20);

	}

	public void setCanceled() {
		
		isCanceled = true;
		
	}

	public void checkMove(Player p) {
		
		if(this.p.getName().equals(p.getName())) {
			hasMoved = true;
		}
	}
	
	public int getSeconds() {
		return seconds;
	}

	public static class TeleportMessages {

		public static String COOLDOWN = "Missing Message: COOLDWON", 
							 COOLDOWN_1 = "Missing Message: COOLDWON_1",
							 MOVED = "Missing Message: MOVED";

	}

}
