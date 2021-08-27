package main.java.com.github.HufeisenGames.SkyAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import main.java.com.github.HufeisenGames.SkyAPI.scoreboard.SkyBoard;

public class TestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		SkyBoard skyBoard = new SkyBoard("test", "§cTest");
		
		skyBoard.setText();
		
		return false;
	}
}
