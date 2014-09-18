package blockBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	private static Dimension dim;
	private double speed = 1.5;
	protected int currentLevel = 1;
	protected boolean paused = false;
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Player player = new Player();
	ArrayList<Bricks> bricks = Bricks.CreateBricks(49);
	
	protected Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					pause();
				}
			}
		});
		setFocusable(true);
		setBackground(Color.BLUE);

	}

	private void move() {
			ball.move();
			racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);

		for (int i = 0; i < bricks.size(); i++) {
				bricks.get(i).paint(g2d);
		}
	
	}
	
	private void pause()
	{   this.paused = true;
		JOptionPane.showMessageDialog(this, "Press SPACE (or ENTER) to continue playing..", "PAUSED", JOptionPane.YES_NO_OPTION);
		this.paused = false;
	}

	protected void gameOver() {
		if (this.player.getLives() == 1)
		{
			JOptionPane.showMessageDialog(this, "Your score: "+this.player.getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
		} else {
			// remove players live
			this.player.removeLive();
			
			JOptionPane.showMessageDialog(this, "Extra lives left: "+this.player.getLives(), "You lost a live", JOptionPane.YES_NO_OPTION);
			// reset the ball
			ball.reset();
		}
	}
	
	protected void winning()
	{
		JOptionPane.showMessageDialog(this, "Your score: "+this.player.getScore(), "You WIN !!!", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	protected void nextLevel()
	{
		JOptionPane.showMessageDialog(this, "Get ready for level: "+(this.currentLevel+1), "You completed level "+this.currentLevel, JOptionPane.YES_NO_OPTION);
		this.currentLevel++;
		this.ball.DIAMETER-=5;
		this.racquet.WIDTH-=15;
		this.speed+=0.5;
		player.addLive();
		bricks = Bricks.CreateBricks(49);
		ball.reset();
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("BlockBreaker by Team Huckleberry");
		Game game = new Game();
		
		frame.add(game);
		frame.setSize(480, 640);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel statsPanel = new JPanel();
		JLabel statsLabel = new JLabel("SCORE: "+game.player.getScore()+" LIVES: "+game.player.getLives());
		statsPanel.add(statsLabel);
		statsPanel.setSize(new Dimension(600, 30));
		statsPanel.setBackground(Color.decode("#1691D9"));
		frame.getContentPane().add(statsPanel, BorderLayout.SOUTH);
		
		while (true)
		{
			game.move();
			game.repaint();
			statsLabel.setText("LEVEL: "+game.currentLevel+" <==> SCORE: "+game.player.getScore()+" <==> LIVES: "+game.player.getLives());
			Thread.sleep((long) (10.0 / game.speed));
		}
		
	}
	
}
