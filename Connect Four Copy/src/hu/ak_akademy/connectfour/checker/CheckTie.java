package hu.ak_akademy.connectfour.checker;

import hu.ak_akademy.connectfour.Board;
import hu.ak_akademy.connectfour.Coordinates;

public class CheckTie implements Checker {
	private final Board board;

	public CheckTie(Board board) {
		this.board = board;
	}

	@Override
	public boolean check() {
		Board forRedMark = new Board(board);
		Board forYellowMark = new Board(board);
		inserMarkIfItsNotEmpty(forRedMark, "R");
		inserMarkIfItsNotEmpty(forYellowMark, "Y");
		CheckWinner bestCheckWinnerForRed = new CheckWinner(forRedMark, "R");
		CheckWinner bestCheckWinnerForYellow = new CheckWinner(forYellowMark, "Y");
		return !bestCheckWinnerForYellow.check() && !bestCheckWinnerForRed.check();
	}

	private void inserMarkIfItsNotEmpty(Board board, String mark) {
		for (int row = 0; row < board.getTableDimension()
				.getHeight(); row++) {
			for (int column = 0; column < board.getTableDimension()
					.getWidth(); column++) {
				Coordinates coordinates = new Coordinates(row, column);
				if (board.getMark(coordinates)
						.equals(" ")) {
					board.setMark(coordinates, mark);
				}
			}
		}
	}

}
