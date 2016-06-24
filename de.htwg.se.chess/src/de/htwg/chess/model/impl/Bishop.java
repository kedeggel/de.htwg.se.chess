package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.Color;

public final class Bishop extends Chesspiece {

	public Bishop(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkBishop(field);
	}
	
	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2657";
		return "\u265D";

	}

}
