package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class Queen extends Chesspiece{

	public Queen(Player player, Field position, Chessboard chess) {
		super(player, position, chess);
	}

	@Override
	public List<Field> possibleMoves() {
		List<Field> listPossibleMoves = new LinkedList<>();
		MoveChecker checker = new MoveChecker(this);
		listPossibleMoves.addAll(checker.checkHorizontal());
		listPossibleMoves.addAll(checker.checkVertikal());
		listPossibleMoves.addAll(checker.checkDiagonal());
		return listPossibleMoves;
	}

}
