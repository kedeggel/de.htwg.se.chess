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
	 * checks if pos is occupied by a DIFFERENT chesspiece (that is NOT
	 * this.piece)
	 * 
	 * @param pos
	 * @return
	 */
	private boolean isFieldOccupied(Position pos) {
		if (pos.getChesspiece() != null)
			return true;
		return false;
	}

	private boolean isFieldAccessible(Position pos) {
		if (isFieldOccupied(pos) && piece.getPlayer() == pos.getChesspiece().getPlayer())
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
		while (y <= 6 && isFieldAccessible(chessboard[x][++y])) { // up
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
		while (y <= 6 && x <= 6 && isFieldAccessible(chessboard[++x][++y])) { // right
																				// up
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (y <= 6 && x >= 1 && isFieldAccessible(chessboard[--x][++y])) {// left
																				// up
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (y >= 1 && x >= 1 && isFieldAccessible(chessboard[--x][--y])) { // left
																				// down
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		x = pos.getX() - 'A';
		y = pos.getY() - 1;
		while (y >= 1 && x <= 6 && isFieldAccessible(chessboard[++x][--y])) {// right
																				// down
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

}
