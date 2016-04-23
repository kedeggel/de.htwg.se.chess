package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.Chess;

public final class Pawn extends Chesspiece {

	public Pawn(Player player, Position position, Chess chess) {
		super(player, position, chess);
	}

	@Override
	public List<Position> possibleMoves() {
		List<Position> listPossibleMoves = new LinkedList<>();
		return listPossibleMoves;
	}

}
