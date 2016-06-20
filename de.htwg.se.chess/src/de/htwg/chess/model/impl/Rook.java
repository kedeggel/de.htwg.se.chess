package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public final class Rook extends Chesspiece {
	public Rook(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkRook(field);
	}

	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2656";
		return "\u265C";

	}

}
