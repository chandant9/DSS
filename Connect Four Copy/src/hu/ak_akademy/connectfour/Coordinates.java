package hu.ak_akademy.connectfour;

public class Coordinates {

	private int row;
	private int column;

	public Coordinates(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

}
