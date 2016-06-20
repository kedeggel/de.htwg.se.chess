package de.htwg.chess.model.impl;

import java.util.LinkedList;
import java.util.List;
import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public final class MoveChecker implements MoveCheckerVisitor {
	private IChessboard chessboard;

	public MoveChecker(IChessboard chessboard) {
		this.chessboard = chessboard;
	}

	private boolean isFieldAccessible(IChesspiece piece, IField field) {
		if (field.isFieldOccupied() && piece.getColor() == field.getChesspiece().getColor())
			return false;
		return true;
	}

	private boolean isFieldOccupiedByEnemy(IChesspiece piece, IField field) {
		if (field.isFieldOccupied() && piece.getColor() != field.getChesspiece().getColor())
			return true;
		return false;
	}

	@Override
	public List<IField> checkQueen(IField field) {
		List<IField> moveList = new LinkedList<>();
		moveList = checkHorizontal(field);
		moveList.addAll(checkVertikal(field));
		moveList.addAll(checkDiagonal(field));
		return moveList;
	}

	@Override
	public List<IField> checkKing(IField field) {
		return checkNeighbourFields(field);
	}

	@Override
	public List<IField> checkRook(IField field) {
		List<IField> moveList = new LinkedList<>();
		moveList = checkHorizontal(field);
		moveList.addAll(checkVertikal(field));
		return moveList;
	}

	@Override
	public List<IField> checkBishop(IField field) {
		return checkDiagonal(field);
	}

	@Override
	public List<IField> checkKnight(IField field) {
		List<IField> posList = new LinkedList<>();
		checkKnightRightUp(field, posList);
		checkKnightRightDown(field, posList);
		checkKnightUpRight(field, posList);
		checkKnightUpLeft(field, posList);
		checkKnightLeftUp(field, posList);
		checkKnightLeftDown(field, posList);
		checkKnightDownLeft(field, posList);
		checkKnightDownRight(field, posList);
		return posList;
	}

	@Override
	public List<IField> checkPawn(IField field) {
		if (field.getChesspiece().getColor().equals(Color.WHITE))
			return checkWhitePawn(field);
		else
			return checkBlackPawn(field);

	}

	private List<IField> checkHorizontal(IField field) {
		List<IField> posList = new LinkedList<>();
		posList.addAll(checkLeft(field));
		posList.addAll(checkRight(field));
		return posList;
	}

	private List<IField> checkLeft(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, y))) { // left
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkRight(IField field) {
		List<IField> posList = new LinkedList<>();
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

	private List<IField> checkVertikal(IField field) {
		List<IField> posList = new LinkedList<>();
		posList.addAll(checkUp(field));
		posList.addAll(checkDown(field));
		return posList;

	}

	private List<IField> checkUp(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkDown(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkDiagonal(IField field) {
		List<IField> posList = new LinkedList<>();
		posList.addAll(checkRightUp(field));
		posList.addAll(checkLeftUp(field));
		posList.addAll(checkLeftDown(field));
		posList.addAll(checkRightDown(field));
		return posList;
	}

	private List<IField> checkRightUp(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && x <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(++x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkLeftUp(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y <= 6 && x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, ++y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkLeftDown(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && x >= 1 && isFieldAccessible(field.getChesspiece(), chessboard.getField(--x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private List<IField> checkRightDown(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		while (y >= 1 && x <= 6 && isFieldAccessible(field.getChesspiece(), chessboard.getField(++x, --y))) {
			posList.add(chessboard.getField(x, y));
			if (chessboard.getField(x, y).isFieldOccupied())
				break;
		}
		return posList;
	}

	private void checkKnightRightUp(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 5 && y <= 6) {
			IField fieldToTest = chessboard.getField(x + 2, y + 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightRightDown(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 5 && y >= 1) {
			IField fieldToTest = chessboard.getField(x + 2, y - 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightUpRight(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 6 && y <= 5) {
			IField fieldToTest = chessboard.getField(x + 1, y + 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightUpLeft(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 1 && y <= 5) {
			IField fieldToTest = chessboard.getField(x - 1, y + 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightLeftUp(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 2 && y <= 6) {
			IField fieldToTest = chessboard.getField(x - 2, y + 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightLeftDown(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 2 && y >= 1) {
			IField fieldToTest = chessboard.getField(x - 2, y - 1);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightDownLeft(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x >= 1 && y >= 2) {
			IField fieldToTest = chessboard.getField(x - 1, y - 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private void checkKnightDownRight(IField field, List<IField> posList) {
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		if (x <= 6 && y >= 2) {
			IField fieldToTest = chessboard.getField(x + 1, y - 2);
			if (isFieldAccessible(field.getChesspiece(), fieldToTest)) {
				posList.add(fieldToTest);
			}
		}
	}

	private List<IField> checkWhitePawn(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		IField up = chessboard.getField(x, y + 1);
		if (y < 7) {
			if (x > 0) {
				IField upleft = chessboard.getField(x - 1, y + 1);
				if (isFieldOccupiedByEnemy(field.getChesspiece(), upleft))
					posList.add(upleft);
			}
			if (x < 7) {
				IField upright = chessboard.getField(x + 1, y + 1);
				if (isFieldOccupiedByEnemy(field.getChesspiece(), upright))
					posList.add(upright);
			}
			IField upup = chessboard.getField(x, y + 2);
			if (!up.isFieldOccupied()) {
				posList.add(up);
				if (y == 1 && !upup.isFieldOccupied())
					posList.add(upup);

			}
		}
		return posList;
	}

	private List<IField> checkBlackPawn(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		IField down = chessboard.getField(x, y - 1);
		if (y > 0) {
			if (x > 0) {
				IField downleft = chessboard.getField(x - 1, y - 1);
				if (isFieldOccupiedByEnemy(field.getChesspiece(), downleft))
					posList.add(downleft);
			}
			if (x < 7) {
				IField downright = chessboard.getField(x + 1, y - 1);
				if (isFieldOccupiedByEnemy(field.getChesspiece(), downright))
					posList.add(downright);
			}
			IField downdown = chessboard.getField(x, y - 2);
			if (!down.isFieldOccupied()) {
				posList.add(down);
				if (y == 6 && !downdown.isFieldOccupied())
					posList.add(downdown);
			}
		}
		return posList;
	}

	private List<IField> checkNeighbourFields(IField field) {
		List<IField> posList = new LinkedList<>();
		List<IField> testList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		testList.add(chessboard.getField(x, y - 1));
		testList.add(chessboard.getField(x, y + 1));
		testList.add(chessboard.getField(x - 1, y));
		testList.add(chessboard.getField(x + 1, y));
		testList.add(chessboard.getField(x + 1, y + 1));
		testList.add(chessboard.getField(x + 1, y - 1));
		testList.add(chessboard.getField(x - 1, y + 1));
		testList.add(chessboard.getField(x - 1, y - 1));
		for (IField f : testList) {
			if (f != null && isFieldAccessible(field.getChesspiece(), f))
				posList.add(f);
		}
		return posList;
	}

	private List<IField> checkRochade(IField field) {
		List<IField> posList = new LinkedList<>();
		int x = field.getX() - 'A';
		int y = field.getY() - 1;
		IField left1 = chessboard.getField(x - 1, y);
		IField left2 = chessboard.getField(x - 2, y);
		IField left3 = chessboard.getField(x - 3, y);
		IField leftRookPos = chessboard.getField(x - 4, y);
		IField right1 = chessboard.getField(x + 1, y);
		IField right2 = chessboard.getField(x + 2, y);
		IField rightRookPos = chessboard.getField(x + 3, y);
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
