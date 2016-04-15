package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class MoveChecker {
	private Chesspiece piece;
	private Position[][] chessboard;
	private Position pos;

	public MoveChecker(Chesspiece piece) {
		this.piece = piece;
		this.pos = piece.getPosition();
	}

	/**
	 * checks if pos is occupied by a DIFFERENT chesspiece (that is NOT "piece")
	 * 
	 * @param pos
	 * @return
	 */
	public boolean isFieldOccupied(Position pos) {
		if (pos.getChesspiece() != null && pos.getChesspiece() != piece)
			return true;
		return false;
	}

	public boolean isFieldAccessible(Position pos) {
		if (isFieldOccupied(pos))
			if (piece.getPlayer() == pos.getChesspiece().getPlayer())
				return false;
		return true;
	}

	public List<Position> checkHorizontal() {
		List<Position> posList = new LinkedList<>();
		chessboard = piece.getChess().getChessboard();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;

		while (x <= 6 && isFieldAccessible(chessboard[++x][y])) { // right
			posList.add(chessboard[x][y]);
			/**
			 * if field is occupied by the other player's chesspiece: this field
			 * is accessible; then break.
			 */
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		while (x >= 1 && isFieldAccessible(chessboard[--x][y])) { // left
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	public List<Position> checkVertikal() {
		List<Position> posList = new LinkedList<>();
		chessboard = piece.getChess().getChessboard();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && isFieldAccessible(chessboard[x][y])) { // up
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}

		y = pos.getY() - 1;
		while (y >= 1 && isFieldAccessible(chessboard[x][--y])) {// down
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	public List<Position> checkDiagonal() {
		List<Position> posList = new LinkedList<>();
		chessboard = piece.getChess().getChessboard();

		// clockwise, starting right up
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (isFieldAccessible(chessboard[x][y]) && y <= 6 && x <= 8) { // right
																			// up
			posList.add(chessboard[++x][++y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (isFieldAccessible(chessboard[x][y]) && y >= 1 && x >= 1) {// left
																			// up
			posList.add(chessboard[--x][++y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (isFieldAccessible(chessboard[x][y]) && y <= 6 && x <= 8) { // left
																			// down
			posList.add(chessboard[--x][--y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (isFieldAccessible(chessboard[x][y]) && y >= 1 && x >= 1) {// right
																			// down
			posList.add(chessboard[++x][--y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

}
