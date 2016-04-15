package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class Rook extends Chesspiece {
	private MoveChecker checker;

	public Rook(String name, Player player, Position position) {
		super(name, player, position);
	}

	@Override
	public List<Position> possibleMoves() {
		List<Position> listPossibleMoves = new LinkedList<>();
		checker = new MoveChecker(this);
		listPossibleMoves.addAll(checker.checkHorizontal());
		listPossibleMoves.addAll(checker.checkVertikal());
		return listPossibleMoves;
	}

}
