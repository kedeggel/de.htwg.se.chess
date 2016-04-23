package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.Chess;

public class Knight extends Chesspiece {

	public Knight(Player player, Position position, Chess chess) {
		super(player, position, chess);
	}

	@Override
	public List<Position> possibleMoves() {

		return (new MoveChecker(this)).checkKnight();
	}

}
