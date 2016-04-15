package de.htwg.chess.model;

public final class Position {
	private char x;
	private int y;
	private Chesspiece cp;

	public Position(char x, int y) {
		if (!setPosition(x, y))
			throw new IllegalArgumentException(x + y + " is not a valid Position");
		setPosition(x, y);
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
		if (this.cp != null && this.cp.getColor().equals(cp.getColor()))
			return;
		this.cp = cp;
		cp.setPosition(this);
	}

	public boolean equals(Position pos) {
		if (this.x == pos.x && this.y == pos.y)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(x) + y;
	}
}