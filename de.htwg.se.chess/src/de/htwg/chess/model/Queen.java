package de.htwg.chess.model;

import de.htwg.chess.model.Team.Color;

public final class Queen extends Chesspiece {

	public Queen(Color color, Field position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveChecker mc) {
		possibleMoves = mc.checkHorizontal(field);
		possibleMoves.addAll(mc.checkVertikal(field));
		possibleMoves.addAll(mc.checkDiagonal(field));
	}

}
