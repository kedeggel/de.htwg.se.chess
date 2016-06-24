package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.Color;

public class King extends Chesspiece {

	public King(Color color, IField position) {
		super(color, position);
	}

	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkKing(field);
	}
	
	@Override
	public String toSymbole() {
		if (color == Color.WHITE)
			return "\u2654";
		return "\u265A";

	}

}
