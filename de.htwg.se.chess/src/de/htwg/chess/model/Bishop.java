package de.htwg.chess.model;

import de.htwg.chess.model.Team.Color;

public final class Bishop extends Chesspiece {

	public Bishop(Color color, Field position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveChecker mc) {
		possibleMoves = mc.checkBishop(field);
	}

}
