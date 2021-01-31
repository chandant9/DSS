package hu.ak_akademy.connectfour.validator;

import hu.ak_akademy.connectfour.Board;
import hu.ak_akademy.connectfour.Coordinates;

public class EmptyFieldValidator implements UserInputValidator {
	private final Coordinates coordinates;
	private final Board board;

	public EmptyFieldValidator(Coordinates coordinates, Board board) {
		this.coordinates = coordinates;
		this.board = board;
	}

	@Override
	public boolean isValid() {
		int row = coordinates.getRow() - 1;
		boolean isEmpty = false;
		while (row >= 0) {
			isEmpty = board.getMark(new Coordinates(row, coordinates.getColumn()))
					.equals(" ");
			row--;
		}
		return isEmpty;
	}

	@Override
	public String getErrorMessage() {
		return "The column is not empty!";
	}

}
