package de.htwg.chess.model;

public class Pawn extends Chesspiece {

	public Pawn(String name, String color, Position position) {
		super(name, color, position);
	}

	@Override
	public void move(char x, int y) {
		if (x < 'A' || x > 'H' || y < 1 || y > 8) {
			throw new IllegalArgumentException(x + y + " is not a valid Position to move to.");
		}
		if (this.color == "white") {
			// check draw-rules for White Pawn
			if (y < this.position.getY() || y > this.position.getY() + 2
					|| (y == this.position.getY() + 2 && this.drawCount != 0)) {
				throw new IllegalArgumentException("White Pawn is not allowed to move like this.");
			}

		} else {
			// same for black Pawn
		}
	}

}
