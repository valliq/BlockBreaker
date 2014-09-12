package blockBreaker;

public class player {
	private String Name;
	private int Score = 0;
	private int Lives = 5;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getScore() {
		return Score;
	}

	public void setScore() {
		this.Score += 1;
	}

	public void addLive() {
		this.Lives += 1;
	}

	public void removeLive() {
		this.Lives -= 1;
	}
}
