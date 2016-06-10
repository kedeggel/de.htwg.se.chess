package de.htwg.chess.model.impl;

import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public final class Queen extends Chesspiece {

	public Queen(Color color, Field position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkQueen(field);
	}

}
