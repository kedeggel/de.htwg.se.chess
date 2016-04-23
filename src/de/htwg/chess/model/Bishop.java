package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.Chess;

public final class Bishop extends Chesspiece {

	public Bishop(Player player, Position position, Chess chess) {
		super(player, position, chess);
	}

	@Override
	public List<Position> possibleMoves() {
		MoveChecker mc = new MoveChecker(this);
		return mc.checkDiagonal();
	}

}
