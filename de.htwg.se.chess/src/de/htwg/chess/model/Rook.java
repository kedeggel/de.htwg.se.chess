package de.htwg.chess.model;

import de.htwg.chess.model.Team.Color;

public final class Rook extends Chesspiece {
	public Rook(Color color, Field position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkRook(field);
	}

}
