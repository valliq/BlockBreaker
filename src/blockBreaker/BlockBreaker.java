package blockBreaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class BlockBreaker implements ActionListener, KeyListener 
{
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
		// TODO
		
		Scanner input = new Scanner(System.in);
		
		startGame();
		
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