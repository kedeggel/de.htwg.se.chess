package de.htwg.chess.model;

import java.util.List;
import de.htwg.chess.model.Team.Color;

public class Knight extends Chesspiece {

	public Knight(Color color, Field position) {
		super(color, position);
	}

	@Override
	public List<Field> possibleMoves() {

		return (new MoveChecker(this)).checkKnight();
	}

}
