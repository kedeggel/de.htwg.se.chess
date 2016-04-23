package de.htwg.chess.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class MoveChecker {
	private Chesspiece piece;
	private Position[][] chessboard;
	private Position pos;

	public MoveChecker(Chesspiece piece) {
		this.piece = piece;
		this.pos = piece.getPosition();
		this.chessboard = piece.getChess().getChessboard();
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
		posList.addAll(checkLeft());
		posList.addAll(checkRight());
		return posList;
	}

	private List<Position> checkLeft() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (x >= 1 && isFieldAccessible(chessboard[--x][y])) { // left
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	private List<Position> checkRight() {
		List<Position> posList = new LinkedList<>();
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
		return posList;
	}

	public List<Position> checkVertikal() {
		List<Position> posList = new LinkedList<>();
		posList.addAll(checkUp());
		posList.addAll(checkDown());
		return posList;

	}

	private List<Position> checkUp() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && isFieldAccessible(chessboard[x][++y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	private List<Position> checkDown() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && isFieldAccessible(chessboard[x][--y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	public List<Position> checkDiagonal() {
		List<Position> posList = new LinkedList<>();
		posList.addAll(checkRightUp());
		posList.addAll(checkLeftUp());
		posList.addAll(checkLeftDown());
		posList.addAll(checkRightDown());
		return posList;
	}

	private List<Position> checkRightUp() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && x <= 6 && isFieldAccessible(chessboard[++x][++y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	private List<Position> checkLeftUp() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && x >= 1 && isFieldAccessible(chessboard[--x][++y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	private List<Position> checkLeftDown() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && x >= 1 && isFieldAccessible(chessboard[--x][--y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

	private List<Position> checkRightDown() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && x <= 6 && isFieldAccessible(chessboard[++x][--y])) {
			posList.add(chessboard[x][y]);
			if (isFieldOccupied(chessboard[x][y]))
				break;
		}
		return posList;
	}

}
