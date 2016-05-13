package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;
import de.htwg.chess.model.Team.Color;

public final class Queen extends Chesspiece {

	public Queen(Color color, Field position) {
		super(color, position);
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
