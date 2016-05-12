package de.htwg.chess.model;

import java.util.List;

public final class Bishop extends Chesspiece {

	public Bishop(Player player, Field position, Chessboard chess) {
		super(player, position, chess);
	}

	@Override
	public List<Field> possibleMoves() {
		return (new MoveChecker(this)).checkDiagonal();
	}

}
