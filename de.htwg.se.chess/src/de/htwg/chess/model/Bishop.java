package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.model.Team.Color;

public final class Bishop extends Chesspiece {

	public Bishop(Color color, Field position) {
		super(color, position);
	}

	@Override
	public List<Field> possibleMoves() {
		return checkDiagonal(field);
	}

}
