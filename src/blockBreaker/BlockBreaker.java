package blockBreaker;

import java.util.Scanner;

import blockBreaker.Player;

public class BlockBreaker {
	public static BlockBreaker game;
	public Player player;

	public void GamePanel() {
		// TODO
	}

	// Get user name and level
	public static void startGame() {
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
		
		input.close();
	}

	public static void main(String[] args) {

		// game = new BlockBreaker();

		Scanner input = new Scanner(System.in);

		startGame();
		
		input.close();
	}

}