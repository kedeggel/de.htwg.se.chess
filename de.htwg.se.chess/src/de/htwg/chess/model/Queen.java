package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.Chess;

public final class Queen extends Chesspiece{

	public Queen(Player player, Position position, Chess chess) {
		super(player, position, chess);
	}

	@Override
	public List<Position> possibleMoves() {
		List<Position> listPossibleMoves = new LinkedList<>();
		MoveChecker checker = new MoveChecker(this);
		listPossibleMoves.addAll(checker.checkHorizontal());
		listPossibleMoves.addAll(checker.checkVertikal());
		listPossibleMoves.addAll(checker.checkDiagonal());
		return listPossibleMoves;
	}

}
