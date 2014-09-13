package blockBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

import blockBreaker.Player;

public class BlockBreaker implements ActionListener, KeyListener 
{
	public static BlockBreaker game;
	public Player player;
	public JFrame jframe;
	public Dimension dim;
	
	public void GamePanel()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		player = new Player();
		
		jframe = new JFrame("BlockBreaker by Team Huckleberry");
		
		jframe.setVisible(true);
		jframe.setSize(640, 480);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		
		JPanel scorePanel = new JPanel();
		JLabel scoreLabel = new JLabel("SCORE: "+player.getScore());
		JLabel livesLabel = new JLabel("USERNAME: "+player.getName()+" LIVES: "+player.getLives());
		
		scorePanel.setPreferredSize(new Dimension(640, 30));
		scorePanel.setBackground(Color.decode("#1691D9"));
		
		scorePanel.add(scoreLabel,BorderLayout.WEST);
		scorePanel.add(livesLabel,BorderLayout.EAST);

		jframe.getContentPane().add(scorePanel, BorderLayout.SOUTH);
		
		jframe.getContentPane().setBackground( Color.BLUE);
		
	}

	//Get user name and level
	public static void startGame()
	{
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		System.out.print("Write your user name:");
		player.setName(input.nextLine());
		System.out.println("Type number: (Level)");
		System.out.println("1 - easy");
		System.out.println("2 - medium");
		System.out.println("3 - hard");
		int levelNumber = input.nextInt();
		player.setLevel(levelNumber);

		
	}
	
	public static void main(String[] args) 
	{

		game = new BlockBreaker();
		
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	game.GamePanel();
            }
        });

		// TODO
		
		//Scanner input = new Scanner(System.in);
		
		//startGame();
		

	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {}
	
}