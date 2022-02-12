package main.java.com.github.HufeisenGames.SkyAPI.teleport;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for activating the SkyTeleportAPI. Do not create this
 * 
 * @author      Hufeisen hufeisen@hufeisen-games.de
 * @version     2.0
 * @since       2.0
 * 
 */

public class SkyTeleportAPI {

	/**
	 * List of all created teleports. Created to check the player movement event with only one listener
	 */
	public List<SkyTeleport> teleports = new ArrayList<SkyTeleport>();
	
}