package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class MoveChecker {
	private Chesspiece piece;
	private Position pos;

	public MoveChecker(Chesspiece piece) {
		this.piece = piece;
		this.pos = piece.getPosition();
	}

	public boolean isFieldAccessible(Position pos) {
		if (pos.getChesspiece() != null)
			if (piece.getColor().equals(pos.getChesspiece().getColor()))
				return false;
		return true;
	}

	public List<Position> checkHorizontal() {
		List<Position> posList = new LinkedList<>();

		return posList;
	}

	public List<Position> checkVertikal() {
		List<Position> posList = new LinkedList<>();

		return posList;
	}

}
