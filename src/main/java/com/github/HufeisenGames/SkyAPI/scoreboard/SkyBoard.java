package main.java.com.github.HufeisenGames.SkyAPI.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class SkyBoard {

	private Objective objective;
	private Scoreboard board;
	private int currentscore = 0;
	private List<SkyText> texts = new ArrayList<SkyText>();
	
	public SkyBoard(String id, String display) {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		objective = board.registerNewObjective(id, "dummy", display);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	}
	
	public SkyBoard(String id, String display, int startscore) {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		objective = board.registerNewObjective(id, "dummy", display);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		currentscore = startscore;
	}
	
	public void setText(SkyText text) {
		Score score = objective.getScore(text.text);
		score.setScore(text.score);
		texts.add(text);
	}
}
