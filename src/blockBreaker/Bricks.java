package blockBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bricks {

	private int X;
	private int Y;
	private final int WIDTH = 50;
	private final int HEIGHT = 10;

	public static ArrayList<Bricks> CreateBricks(int numOfBricks) {
		int rowOfBricks = 0;
		int j = 0;
		ArrayList<Bricks> bricks = new ArrayList<Bricks>();

		for (int i = 0; i < numOfBricks; i++) {

			bricks.add(new Bricks(j, rowOfBricks));
			j+=60;
			
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
	
	public Rectangle getBounds() {
		return new Rectangle(this.X,this.Y,WIDTH,HEIGHT);
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(X, Y, WIDTH, HEIGHT);
	}	

}
