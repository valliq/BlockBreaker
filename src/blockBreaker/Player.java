package blockBreaker;

import blockBreaker.Level;

public class Player {
	private String name="unnamed";
	private int score = 0;
	private int lives = 3;
	private Level level = Level.Easy;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Integer getLives() {
		return lives;
	}

	public int getScore() {
		return score;
	}

	public void scorePlus() {
		this.score += 1;
	}

	public void addLive() {
		this.lives += 1;
	}

	public void removeLive() {
		this.lives -= 1;
	}
	
	public void setLevel(Integer levelNumber)
	{
		switch(levelNumber)
		{
			case 1 : level = level.Easy; 
				break;
			case 2 : level = level.Medium;
				break;
			case 3 : level = level.Hard;
				break;
			default : System.out.println("Wrong input");
				break;
		}
	}
	public Level getLevel()
	{
		return level;
	}
}
