package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public class Knight extends Chesspiece {
	public Knight(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkKnight(field);
	}
	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2658";
		return "\u265E";

	}
}
