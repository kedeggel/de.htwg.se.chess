package de.htwg.chess.model;

import de.htwg.chess.model.Team.Color;

public class Knight extends Chesspiece {
	public Knight(Color color, Field position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkKnight(field);
	}

}
