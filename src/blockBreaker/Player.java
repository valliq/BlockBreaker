package blockBreaker;

public class Player {
	
	private String name="unnamed";
	private int score = 0;
	private int lives = 3;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Integer getLives() {
		return this.lives;
	}

	public int getScore() {
		return this.score;
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

}
