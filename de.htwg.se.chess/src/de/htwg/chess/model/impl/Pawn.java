package de.htwg.chess.model.impl;

import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public final class Pawn extends Chesspiece {

	public Pawn(Color color, Field position) {
		super(color, position);
	}

	// public Chesspiece transformer(String cp) {
	// if (cp.equals("Queen")) {
	// return new Queen(this.team, this.field, this.board);
	// }
	// if (cp.equals("Rook")) {
	// return new Rook(this.team, this.field, this.board);
	// }
	// if (cp.equals("Knight")) {
	// return new Knight(this.team, this.field, this.board);
	// }
	// if (cp.equals("Bishop")) {
	// return new Bishop(this.team, this.field, this.board);
	// }
	// return this;
	// }


	@Override
	public void checkPossibleMoves(MoveCheckerVisitor mc) {
		possibleMoves = mc.checkPawn(field);
	}

}