package de.htwg.chess.model;

import java.util.List;
import de.htwg.chess.model.Team.Color;

public abstract class Chesspiece {

	// protected Team team; // später -> protected boolean color; //white=true,
	// black=false
	protected Color color;
	protected Field field;
	protected boolean wasMoved;
	protected MoveChecker moveChecker;

	public Chesspiece(Color color, Field field) {
		this.moveChecker = new MoveChecker(chessboard);
		this.color = color;
		this.setField(field);
		this.wasMoved = false;
	}

	public void move(Field f) {
		for (Field posMov : possibleMoves()) {
			if (f.equals(posMov)) {
				field.setPosition(f.getX(), f.getY());
				f.setChesspiece(this);
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

	// public Team getTeam() {
	// return team;
	// }

	public Field getField() {
		return this.field;
	}

	public boolean getWasMoved() {
		return wasMoved;
	}

	public abstract List<Field> possibleMoves();

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getColor() + " " + field;
	}

}
