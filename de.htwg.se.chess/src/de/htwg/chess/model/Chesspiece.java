package de.htwg.chess.model;

import java.util.List;

public abstract class Chesspiece {

	protected Player player; // später -> protected boolean color; //white=true,
								// black=false
	protected Field field;
	protected Chessboard board;
	protected boolean wasMoved;

	public Chesspiece(Player player, Field field, Chessboard board) {
		this.player = player;
		this.setField(field);
		this.board = board;
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

		// if(this.position != pos) {
		// if (this.position != null)
		// this.position.setChesspiece(null);
		// this.position = pos;
		// if (pos != null)
		// pos.setChesspiece(this);
	}

	protected String getColor() {
		return player.getColor();
	}

	public Player getPlayer() {
		return player;
	}

	public Field getField() {
		return this.field;
	}

	public Chessboard getChess() {
		return board;
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
