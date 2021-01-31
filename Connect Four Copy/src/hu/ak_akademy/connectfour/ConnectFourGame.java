package hu.ak_akademy.connectfour;

import hu.ak_akademy.connectfour.checker.CheckTie;
import hu.ak_akademy.connectfour.checker.CheckWinner;
import hu.ak_akademy.connectfour.checker.Checker;
import hu.ak_akademy.connectfour.validator.BoardBoundValidator;
import hu.ak_akademy.connectfour.validator.EmptyFieldValidator;
import hu.ak_akademy.connectfour.validator.UserInputValidator;

public class ConnectFourGame {

	private final Player[] players;
	private Player current;
	private int turnCounter;
	private final Board board;
	private final UserInputHandler userInputHandler;
	private TableDimension tableDimension;

	public ConnectFourGame(Player[] players, TableDimension tableDimension, UserInputHandler userInputHandler) {
		this.userInputHandler = userInputHandler;
		this.players = players;
		current = getNextPlayer();
		board = new Board(tableDimension);
		this.tableDimension = tableDimension;
	}

	public Player getNextPlayer() {
		return players[turnCounter % players.length];
	}

	public void run() {
		Checker checkTie = new CheckTie(board);
		System.out.println(board);
		Checker checkWinner;
		gameLoop: do {
			current = getNextPlayer();
			String nameOfPlayer = current.getName()
					.endsWith("s") ? current.getName() + "'" : current.getName() + "'s";
			System.out.println("It's " + nameOfPlayer + " turn.");
			checkWinner = new CheckWinner(board, current.getMark());
			Coordinates coordinates = userInputHandler.readCoordinates(tableDimension);
			UserInputValidator[] validators = { new BoardBoundValidator(board.getTableDimension(), coordinates), new EmptyFieldValidator(coordinates, board) };
			for (UserInputValidator validator : validators) {
				if (!validator.isValid()) {
					System.out.println(validator.getErrorMessage());
					continue gameLoop;
				}
			}
			board.setMark(coordinates, current.getMark());
			System.out.println(board);
			turnCounter++;
		} while (!checkWinner.check() && !checkTie.check());
		if (checkWinner.check()) {
			System.out.println("We have winner, winner is " + current.getName());
		}
		if (checkTie.check()) {
			System.out.println("We have a tie!");
		}
		System.out.println("Good Bye!");

	}

}
