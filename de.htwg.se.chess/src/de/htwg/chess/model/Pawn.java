package de.htwg.chess.model;

import java.util.List;

public final class Pawn extends Chesspiece {

	public Pawn(Player player, Position position, Chessboard board) {
		super(player, position, board);
	}

	public Chesspiece transformer(String cp) {
		if (cp.equals("Queen")) {
			return new Queen(this.player, this.position, this.board);
		}
		if (cp.equals("Rook")) {
			return new Rook(this.player, this.position, this.board);
		}
		if (cp.equals("Knight")) {
			return new Knight(this.player, this.position, this.board);
		}
		if (cp.equals("Bishop")) {
			return new Bishop(this.player, this.position, this.board);
		}
		return this;
	}

	@Override
	public List<Position> possibleMoves() {
		return (new MoveChecker(this)).checkPawn();
	}

}
