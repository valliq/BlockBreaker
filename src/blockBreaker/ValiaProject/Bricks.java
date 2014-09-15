package blockBreaker;

import java.awt.Graphics2D;

public class Bricks {

	private int X;
	private int Y;
	private final int WIDTH = 35;
	private final int HEIGHT = 10;

	public static Bricks[] CreateBricks(int numOfBricks) {
		int rowOfBricks = 0;
		int j = 0;
		Bricks[] bricks = new Bricks[numOfBricks];

		for (int i = 0; i < bricks.length; i++) {

			bricks[i] = new Bricks(40 * j + 5, rowOfBricks);
			j++;
			
			if (i % 8 == 0 && i != 0) {
				j = 0;
				rowOfBricks += 20;
			}
		}

		return bricks;
	}

	Bricks(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public void paint(Graphics2D g) {
		g.fillRect(X, Y, WIDTH, HEIGHT);
	}

	public void createBricks(int numOfBricks) {

	}

}
