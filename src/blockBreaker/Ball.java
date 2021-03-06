package blockBreaker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	protected int DIAMETER = 25;
	private int x = 400;
	private int y = 200;
	private int xa = 1;
	private int ya = 1;
	private Game game;

	protected Ball(Game game) {
		this.game = game;
	}
	
	protected void reset()
	{
		this.x = 400;
		this.y = 200;
	}

	protected void move() {
		
		if (!game.paused)
		{
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
			
			// check if the ball hits a brick
			if (game.bricks.size() > 1)
			{
				for (int i=0; i<game.bricks.size(); i++)
				{
					if (game.bricks.get(i).getBounds().intersects(x,y,game.ball.DIAMETER,game.ball.DIAMETER))
					{
						// remove the brick hit by the ball
						game.bricks.remove(i);
						// add score points ???
						game.player.scorePlus();
					}
				}
			}
			else
			{
				// all bricks are destroyed
				if (game.currentLevel < 5)
				{	// go to the next level
					game.nextLevel();
				} else {
					// win the game!!!
					game.winning();
				}
				
			}
		}
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(Color.BLACK);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
