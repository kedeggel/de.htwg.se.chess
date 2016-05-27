package de.htwg.chess.model;

import java.util.List;
import de.htwg.chess.model.Team.Color;

public abstract class Chesspiece {

	protected Color color;
	protected Field field;
	protected boolean wasMoved;
	protected List<Field> possibleMoves;

	public Chesspiece(Color color, Field field) {
		this.color = color;
		this.setField(field);
		this.wasMoved = false;
	}
	
	public List<Field> getPossibleMoves() {
		return possibleMoves;
	}

	public abstract void checkPossibleMoves(MoveChecker mc);

	public void move(Field target) {
		for (Field posMov : possibleMoves) {
			if (target.equals(posMov)) {
				setField(target);
				wasMoved = true;
				break;
			}
		}
	}

	public void setField(Field i) {
		Field old_position = this.field;
		this.field = i;
		if (i != null && this == i.getChesspiece()) // figur steht bereits
													// auf pos
			return;
		if (old_position != null) // alter pos bescheid, dass wir weg sind
			old_position.setChesspiece(null);
		if (i != null)
			i.setChesspiece(this); // neuer Pos sagen, "wir sind neu hier"

	}

	protected Color getColor() {
		return this.color;
	}

	public Field getField() {
		return this.field;
	}

	public boolean getWasMoved() {
		return wasMoved;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getColor() + " " + field;
	}


}
