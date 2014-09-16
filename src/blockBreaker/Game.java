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

	public static Dimension dim;
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Player player = new Player(this);
	private static double speed = 1.5; // connected with levels
	ArrayList<Bricks> bricks = Bricks.CreateBricks(49);
	
	public Game() {
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

	public void gameOver() {
		if (this.player.getLives() == 0)
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
		JLabel scoreLabel = new JLabel("SCORE: "+game.player.getScore()+" LIVES: "+game.player.getLives());
		statsPanel.add(scoreLabel);
		statsPanel.setSize(new Dimension(600, 30));
		statsPanel.setBackground(Color.decode("#1691D9"));
		frame.getContentPane().add(statsPanel, BorderLayout.SOUTH);
		
		while (true) {
			game.move();
			game.repaint();
			scoreLabel.setText("SCORE: "+game.player.getScore()+" LIVES: "+game.player.getLives());
			Thread.sleep((long) (10.0 / speed));
		}
	}

}
