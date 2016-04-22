package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.Chess;

public final class Rook extends Chesspiece {
	private MoveChecker checker;

	public Rook(Player player, Position position, Chess chess) {
		super(player, position, chess);
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
