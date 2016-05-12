package de.htwg.chess.model;

import java.util.List;

public class Knight extends Chesspiece {

	public Knight(Player player, Field position, Chessboard chess) {
		super(player, position, chess);
	}

	@Override
	public List<Field> possibleMoves() {

		return (new MoveChecker(this)).checkKnight();
	}

}
