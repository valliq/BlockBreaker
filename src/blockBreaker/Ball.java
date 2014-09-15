package blockBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 25;
	int x = 400;
	int y = 200;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		if (collision()){
			ya = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
		
		for (int i=0; i<game.bricks.size(); i++)
		{
			if (game.bricks.get(i).getBounds().intersects(x,y,25,25))
			{
				game.bricks.remove(i);
			}
		}
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(Color.BLACK);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}