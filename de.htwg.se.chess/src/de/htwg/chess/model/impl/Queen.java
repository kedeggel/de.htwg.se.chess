package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.Color;

public final class Queen extends Chesspiece {

	public Queen(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkQueen(field);
	}

	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2655";
		return "\u265B";

	}
}
