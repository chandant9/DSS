package hu.ak_akademy.connectfour;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputHandler userInputHandler = new UserInputHandler(scanner);
			System.out.println("Welcome to Connect 4 game!");
			String playerRedName = userInputHandler.getPlayerName("Player Red, Please provide your name: ");
			String playerYellowName = userInputHandler.getPlayerName("Player Yellow, Please provide your name: ");
			Player playerRed = new Player(playerRedName, "R");
			Player playerYellow = new Player(playerYellowName, "Y");
			TableDimension tableDimension = userInputHandler.readTableDimension();
			Player[] players = { playerRed, playerYellow };
			ConnectFourGame connectFourGame = new ConnectFourGame(players, tableDimension, userInputHandler);
			connectFourGame.run();
		}

	}

}
