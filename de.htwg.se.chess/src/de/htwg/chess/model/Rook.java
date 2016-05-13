package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;
import de.htwg.chess.model.Team.Color;

public final class Rook extends Chesspiece {
	public Rook(Color color, Field position) {
		super(color, position);
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
