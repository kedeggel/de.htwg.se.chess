package de.htwg.chess.model;

public final class Field {
	private char x;
	private int y;
	private Chesspiece cp;

	public Field(char x, int y) {
		if (!setPosition(x, y))
			throw new IllegalArgumentException(x + "" + y + " is not a valid Position");
		cp = null;
	}

	public boolean setPosition(char x, int y) {
		if (x < 'A' || x > 'H' || y < 1 || y > 8) {
			return false;
		}
		this.x = x;
		this.y = y;
		return true;
	}

	public char getX() {
		return x;
	}

	public boolean setX(char x) {
		return setPosition(x, this.y);
	}

	public int getY() {
		return y;
	}

	public boolean setY(int y) {
		return setPosition(this.x, y);
	}

	public Chesspiece getChesspiece() {
		return cp;
	}

	public void setChesspiece(Chesspiece cp) {
		Chesspiece old_cp = this.cp;
		this.cp = cp;
		if (cp != null && this == cp.getField()) // figur ist bereits her
			return;
		if (old_cp != null) // altem cp bescheid, dass keine pos mehr hat
			old_cp.setField(null);
		if (cp != null)
			cp.setField(this); // neuem cp sagen, wo es steht

	}

	public boolean samePosition(Field pos) {
		if (pos == null || this.x != pos.x || this.y != pos.y)
			return false;
		return true;
	}
	
	public boolean isFieldOccupied() {
		if (cp != null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(x) + y;
	}
}