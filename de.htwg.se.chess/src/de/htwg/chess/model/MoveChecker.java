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
		this.chessboard = piece.getChess().getChessboard();
	}

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

	private boolean isFieldOccupiedByEnemy(Position pos) {
		if (isFieldOccupied(pos) && piece.getPlayer() != pos.getChesspiece().getPlayer())
			return true;
		return false;
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

	public List<Position> checkKnight() {
		List<Position> posList = new LinkedList<>();
		posList.add(checkKnightRightUp());
		posList.add(checkKnightRightDown());
		posList.add(checkKnightUpRight());
		posList.add(checkKnightUpLeft());
		posList.add(checkKnightLeftUp());
		posList.add(checkKnightLeftDown());
		posList.add(checkKnightDownLeft());
		posList.add(checkKnightDownRight());
		return posList;
	}

	private Position checkKnightRightUp() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x <= 5 && y <= 6) {
			pos = chessboard[x + 2][y + 1];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightRightDown() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x <= 5 && y >= 1) {
			pos = chessboard[x + 2][y - 1];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightUpRight() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x <= 6 && y <= 5) {
			pos = chessboard[x + 1][y + 2];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightUpLeft() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x >= 1 && y <= 5) {
			pos = chessboard[x - 1][y + 2];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightLeftUp() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x >= 2 && y <= 6) {
			pos = chessboard[x - 2][y + 1];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightLeftDown() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x >= 2 && y >= 1) {
			pos = chessboard[x - 2][y - 1];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightDownLeft() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x >= 1 && y >= 2) {
			pos = chessboard[x - 1][y - 2];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	private Position checkKnightDownRight() {
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		if (x >= 1 && y >= 2) {
			pos = chessboard[x + 1][y - 2];
			if (isFieldAccessible(pos)) {
				return pos;
			}
		}
		return null;
	}

	public List<Position> checkPawn() {
		if (piece.getColor().equals("white"))
			return checkWhitePawn();
		else
			return checkBlackPawn();

	}

	private List<Position> checkWhitePawn() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Position up = chessboard[x][y + 1];
		Position upleft = chessboard[x - 1][y + 1];
		Position upright = chessboard[x + 1][y + 1];
		Position upup = chessboard[x][y + 2];
		if (isFieldOccupiedByEnemy(upleft))
			posList.add(upleft);
		if (isFieldOccupiedByEnemy(upright))
			posList.add(upright);
		if (!isFieldOccupied(up)) {
			posList.add(up);
			if (y == 1 && !isFieldOccupied(upup))
				posList.add(upup);

		}
		return posList;
	}

	private List<Position> checkBlackPawn() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Position down = chessboard[x][y - 1];
		Position downleft = chessboard[x - 1][y - 1];
		Position downright = chessboard[x + 1][y - 1];
		Position downdown = chessboard[x][y - 2];
		if (isFieldOccupiedByEnemy(downleft))
			posList.add(downleft);
		if (isFieldOccupiedByEnemy(downright))
			posList.add(downright);
		if (!isFieldOccupied(down)) {
			posList.add(down);
			if (y == 6 && !isFieldOccupied(downdown))
				posList.add(downdown);

		}
		return posList;
	}

	public List<Position> checkRochade() {
		List<Position> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Position left1 = chessboard[x - 1][y];
		Position left2 = chessboard[x - 2][y];
		Position left3 = chessboard[x - 3][y];
		Position leftRookPos = chessboard[x - 4][y];
		Position right1 = chessboard[x + 1][y];
		Position right2 = chessboard[x + 2][y];
		Position rightRookPos = chessboard[x + 3][y];
		if (!chessboard[x][y].getChesspiece().getWasMoved())
			if (!isFieldOccupied(left1) && !isFieldOccupied(left2) && !isFieldOccupied(left3)) { // &&
																									// leftRookPos.getChesspiece().getDrawCounter()
																									// ==
																									// 0
				posList.add(left2);
			}
		if (!isFieldOccupied(right1) && !isFieldOccupied(right2)) { // &&
																	// rightRookPos.getChesspiece().getDrawCounter()
																	// == 0
			posList.add(right2);
		}
		// end-if
		return posList;
	}

}
