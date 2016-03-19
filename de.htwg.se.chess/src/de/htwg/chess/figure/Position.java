package de.htwg.chess.figure;

public final class Position {
	char x;
	int y;
	
	public Position(char x, int y) {
		setPosition(x, y);
	}
	
	public void setPosition(char x, int y) {
		if (x < 'A' || x > 'H' || y < 1 || y > 8) {
			throw new IllegalArgumentException(x + y + " is not a valid position.");
		}
		this.x = x;
		this.y = y;
	}
	
	public Position getPosition() {
		return this;
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override 
	public String toString() {
		return String.valueOf(x) + y;
	}
}