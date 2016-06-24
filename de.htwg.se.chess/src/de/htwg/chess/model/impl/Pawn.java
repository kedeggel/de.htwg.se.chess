package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.Color;

public final class Pawn extends Chesspiece {

	public Pawn(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkPawn(field);
	}

	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2659";
		return "\u265F";

	}
}
