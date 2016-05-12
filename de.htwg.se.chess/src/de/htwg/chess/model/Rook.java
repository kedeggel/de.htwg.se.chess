package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class Rook extends Chesspiece {
	public Rook(Player player, Field position, Chessboard chess) {
		super(player, position, chess);
	}

	@Override
	public List<Field> possibleMoves() {
		List<Field> listPossibleMoves = new LinkedList<>();
		MoveChecker checker = new MoveChecker(this);
		listPossibleMoves.addAll(checker.checkHorizontal());
		listPossibleMoves.addAll(checker.checkVertikal());
		return listPossibleMoves;
	}

}
