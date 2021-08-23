package main.java.com.github.HufeisenGames.SkyAPI.inventory;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import main.java.com.github.HufeisenGames.SkyAPI.SkyAPIPlugin;
import main.java.com.github.HufeisenGames.SkyAPI.exceptions.APINotActiveException;
import main.java.com.github.HufeisenGames.SkyAPI.inventory.functions.ItemFunction;
import main.java.com.github.HufeisenGames.SkyAPI.particle.SkyParticle;
import main.java.com.github.HufeisenGames.SkyAPI.particle.types.CircleParticle;

public class TestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		/*try {
			SkyInventory inventory = new SkyInventory("Test Inventory", 6 * 9);

			inventory.addItem(3, "Keine Funktion", Material.STONE);
			UIItem item = inventory.addItem(5, "Nachricht", Material.REDSTONE);
			item.setFunction(new ItemFunction() {

				@Override
				public void onClick(UIItem item, SkyInventory inventory, Player player, InventoryClickEvent event) {

					player.sendMessage("Test");

				}
			});
			
			SkyInventory inv2 = new SkyInventory("Test2", 1*9);
			inventory.addSubInventory("test", inv2, inv2.createItem(8, "§cBack", Material.BARRIER));
			inventory.addItem(15, "SubInventory", Material.CHEST).setSubInventory("test");
			
			inventory.open((Player) sender);

			new BukkitRunnable() {
				private int countdown = 11;

				@Override
				public void run() {
					if (countdown != 0) {
						countdown -= 1;
						inventory.changeItem(1, inventory.createItem(1, countdown + "", Material.CLOCK));
						inventory.updateInventory();
					}
				}

			}.runTaskTimer(SkyAPIPlugin.getPlugin(), 0, 20);
		} catch (APINotActiveException e) {
			e.printStackTrace();
		}*/
		
		new SkyParticle().createParticle(new CircleParticle(new Location(player.getWorld(), 0, 70, 0), 1, Particle.REDSTONE, 50, 0.05f, Color.BLUE)).spawn((Player) sender);

		return false;
	}
}
