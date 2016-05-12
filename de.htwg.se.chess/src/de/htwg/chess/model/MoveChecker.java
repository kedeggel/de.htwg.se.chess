package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public final class MoveChecker {
	private Chesspiece piece;
	private Field[][] chessboard;
	private Field pos;

	public MoveChecker(Chesspiece piece) {
		this.piece = piece;
		this.pos = piece.getField();
		this.chessboard = piece.getChess().getChessboard();
	}



	private boolean isFieldAccessible(Field pos) {
		if (pos.isFieldOccupied() && piece.getPlayer() == pos.getChesspiece().getPlayer())
			return false;
		return true;
	}

	private boolean isFieldOccupiedByEnemy(Field pos) {
		if (pos.isFieldOccupied() && piece.getPlayer() != pos.getChesspiece().getPlayer())
			return true;
		return false;
	}

	public List<Field> checkHorizontal() {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkLeft());
		posList.addAll(checkRight());
		return posList;
	}

	private List<Field> checkLeft() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (x >= 1 && isFieldAccessible(chessboard[--x][y])) { // left
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkRight() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (x <= 6 && isFieldAccessible(chessboard[++x][y])) { // right
			posList.add(chessboard[x][y]);
			/**
			 * if field is occupied by the other player's chesspiece: this field
			 * is accessible; then break.
			 */
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkVertikal() {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkUp());
		posList.addAll(checkDown());
		return posList;

	}

	private List<Field> checkUp() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && isFieldAccessible(chessboard[x][++y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkDown() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && isFieldAccessible(chessboard[x][--y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkDiagonal() {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkRightUp());
		posList.addAll(checkLeftUp());
		posList.addAll(checkLeftDown());
		posList.addAll(checkRightDown());
		return posList;
	}

	private List<Field> checkRightUp() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && x <= 6 && isFieldAccessible(chessboard[++x][++y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkLeftUp() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y <= 6 && x >= 1 && isFieldAccessible(chessboard[--x][++y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkLeftDown() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && x >= 1 && isFieldAccessible(chessboard[--x][--y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkRightDown() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		while (y >= 1 && x <= 6 && isFieldAccessible(chessboard[++x][--y])) {
			posList.add(chessboard[x][y]);
			if (chessboard[x][y].isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkKnight() {
		List<Field> posList = new LinkedList<>();
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

	private Field checkKnightRightUp() {
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

	private Field checkKnightRightDown() {
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

	private Field checkKnightUpRight() {
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

	private Field checkKnightUpLeft() {
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

	private Field checkKnightLeftUp() {
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

	private Field checkKnightLeftDown() {
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

	private Field checkKnightDownLeft() {
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

	private Field checkKnightDownRight() {
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

	public List<Field> checkPawn() {
		if (piece.getColor().equals("white"))
			return checkWhitePawn();
		else
			return checkBlackPawn();

	}

	private List<Field> checkWhitePawn() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Field up = chessboard[x][y + 1];
		Field upleft = chessboard[x - 1][y + 1];
		Field upright = chessboard[x + 1][y + 1];
		Field upup = chessboard[x][y + 2];
		if (isFieldOccupiedByEnemy(upleft))
			posList.add(upleft);
		if (isFieldOccupiedByEnemy(upright))
			posList.add(upright);
		if (!up.isFieldOccupied()) {
			posList.add(up);
			if (y == 1 && !upup.isFieldOccupied())
				posList.add(upup);

		}
		return posList;
	}

	private List<Field> checkBlackPawn() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Field down = chessboard[x][y - 1];
		Field downleft = chessboard[x - 1][y - 1];
		Field downright = chessboard[x + 1][y - 1];
		Field downdown = chessboard[x][y - 2];
		if (isFieldOccupiedByEnemy(downleft))
			posList.add(downleft);
		if (isFieldOccupiedByEnemy(downright))
			posList.add(downright);
		if (!down.isFieldOccupied()) {
			posList.add(down);
			if (y == 6 && !downdown.isFieldOccupied())
				posList.add(downdown);

		}
		return posList;
	}

	public List<Field> checkRochade() {
		List<Field> posList = new LinkedList<>();
		int x = pos.getX() - 'A';
		int y = pos.getY() - 1;
		Field left1 = chessboard[x - 1][y];
		Field left2 = chessboard[x - 2][y];
		Field left3 = chessboard[x - 3][y];
		Field leftRookPos = chessboard[x - 4][y];
		Field right1 = chessboard[x + 1][y];
		Field right2 = chessboard[x + 2][y];
		Field rightRookPos = chessboard[x + 3][y];
		if (!chessboard[x][y].getChesspiece().getWasMoved()) {
			if (!leftRookPos.getChesspiece().getWasMoved() && !left1.isFieldOccupied() && !left2.isFieldOccupied()
					&& !left3.isFieldOccupied()) {
				posList.add(left2);
			}
			if (!rightRookPos.getChesspiece().getWasMoved() && !right1.isFieldOccupied() && !right2.isFieldOccupied()) {
				posList.add(right2);
			}
		}
		return posList;
	}

}
