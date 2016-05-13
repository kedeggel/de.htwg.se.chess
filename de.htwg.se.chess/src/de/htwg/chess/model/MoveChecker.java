package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.model.Team.Color;

public final class MoveChecker {
	private Chessboard chessboard;

	public MoveChecker(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	private boolean isFieldAccessible(Chesspiece piece, Field field) {
		if (field.isFieldOccupied() && piece.getColor() == field.getChesspiece().getColor())
			return false;
		return true;
	}

	private boolean isFieldOccupiedByEnemy(Chesspiece piece, Field field) {
		if (field.isFieldOccupied() && piece.getColor() != field.getChesspiece().getColor())
			return true;
		return false;
	}

	public List<Field> checkHorizontal(Field field) {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkLeft(field));
		posList.addAll(checkRight(field));
		return posList;
	}

	private List<Field> checkLeft(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, y))) { // left
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkRight(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (x <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(++x, y))) { // right
			posList.add(chessboard.getField(x, y));
			/**
			 * if field is occupied by the other player's chesspiece: this field
			 * is accessible; then break.
			 */
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkVertikal(Field field) {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkUp(field));
		posList.addAll(checkDown(field));
		return posList;

	}

	private List<Field> checkUp(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkDown(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkDiagonal(Field field) {
		List<Field> posList = new LinkedList<>();
		posList.addAll(checkRightUp(field));
		posList.addAll(checkLeftUp(field));
		posList.addAll(checkLeftDown(field));
		posList.addAll(checkRightDown(field));
		return posList;
	}

	private List<Field> checkRightUp(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && x <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(++x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkLeftUp(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkLeftDown(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<Field> checkRightDown(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && x <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(++x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	public List<Field> checkKnight(Field field) {
		List<Field> posList = new LinkedList<>();
		posList.add(checkKnightRightUp(field));
		posList.add(checkKnightRightDown(field));
		posList.add(checkKnightUpRight(field));
		posList.add(checkKnightUpLeft(field));
		posList.add(checkKnightLeftUp(field));
		posList.add(checkKnightLeftDown(field));
		posList.add(checkKnightDownLeft(field));
		posList.add(checkKnightDownRight(field));
		return posList;
	}

	private Field checkKnightRightUp(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 5 && y <= 6) {
			Field fieldToTest = chessboard.getField(x + 2, y + 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightRightDown(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 5 && y >= 1) {
			Field fieldToTest = chessboard.getField(x + 2, y - 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightUpRight(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 6 && y <= 5) {
			Field fieldToTest = chessboard.getField(x + 1, y + 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightUpLeft(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 1 && y <= 5) {
			Field fieldToTest = chessboard.getField(x - 1, y + 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightLeftUp(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 2 && y <= 6) {
			Field fieldToTest = chessboard.getField(x - 2, y + 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightLeftDown(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 2 && y >= 1) {
			Field fieldToTest = chessboard.getField(x - 2, y - 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightDownLeft(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 1 && y >= 2) {
			Field fieldToTest = chessboard.getField(x - 1, y - 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	private Field checkKnightDownRight(Field field) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 1 && y >= 2) {
			Field fieldToTest = chessboard.getField(x + 1, y - 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				return fieldToTest;
			}
		}
		return null;
	}

	public List<Field> checkPawn(Field field) {
		if (field.getChesspiece().getColor().equals(Color.WHITE))
			return checkWhitePawn(field);
		else
			return checkBlackPawn(field);

	}

	private List<Field> checkWhitePawn(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		Field up = chessboard.getField(x, y + 1);
		Field upleft = chessboard.getField(x - 1, y + 1);
		Field upright = chessboard.getField(x + 1, y + 1);
		Field upup = chessboard.getField(x, y + 2);
		if (isFieldOccupiedByEnemy(field.getChesspiece(), upleft))
			posList.add(upleft);
		if (isFieldOccupiedByEnemy(field.getChesspiece(), upright))
			posList.add(upright);
		if (!up.isFieldOccupied()) {
			posList.add(up);
			if (y == 1 && !upup.isFieldOccupied())
				posList.add(upup);

		}
		return posList;
	}

	private List<Field> checkBlackPawn(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		Field down = chessboard.getField(x, y - 1);
		Field downleft = chessboard.getField(x - 1, y - 1);
		Field downright = chessboard.getField(x + 1, y - 1);
		Field downdown = chessboard.getField(x, y - 2);
		if (isFieldOccupiedByEnemy(field.getChesspiece(), downleft))
			posList.add(downleft);
		if (isFieldOccupiedByEnemy(field.getChesspiece(), downright))
			posList.add(downright);
		if (!down.isFieldOccupied()) {
			posList.add(down);
			if (y == 6 && !downdown.isFieldOccupied())
				posList.add(downdown);

		}
		return posList;
	}

	public List<Field> checkRochade(Field field) {
		List<Field> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		Field left1 = chessboard.getField(x - 1, y);
		Field left2 = chessboard.getField(x - 2, y);
		Field left3 = chessboard.getField(x - 3, y);
		Field leftRookPos = chessboard.getField(x - 4, y);
		Field right1 = chessboard.getField(x + 1, y);
		Field right2 = chessboard.getField(x + 2, y);
		Field rightRookPos = chessboard.getField(x + 3, y);
		if (!chessboard.getField(x, y).getChesspiece().getWasMoved()) {
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
