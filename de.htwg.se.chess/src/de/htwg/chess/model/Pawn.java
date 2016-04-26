package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.Chess;

public final class Pawn extends Chesspiece {

	public Pawn(Player player, Position position, Chess chess) {
		super(player, position, chess);
	}

	public Chesspiece transformer(String cp) {
		if (cp.equals("Queen")) {
			return new Queen(this.player, this.position, this.chess);
		}
		if (cp.equals("Rook")) {
			return new Rook(this.player, this.position, this.chess);
		}
		if (cp.equals("Knight")) {
			return new Knight(this.player, this.position, this.chess);
		}
		if (cp.equals("Bishop")) {
			return new Bishop(this.player, this.position, this.chess);
		}
		return this;
	}

	@Override
	public List<Position> possibleMoves() {
		return (new MoveChecker(this)).checkPawn();
	}

}
