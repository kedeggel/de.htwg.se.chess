package de.htwg.chess.model;

import java.util.List;

public abstract class Chesspiece {

	protected Player player;
	protected Position position;
	protected Chessboard chess;
	protected boolean wasMoved;

	public Chesspiece(Player player, Position position, Chessboard chess) {
		this.player = player;
		this.setPosition(position);
		this.chess = chess;
		wasMoved = false;
	}

	public void move(Position pos) {
		for (Position posMov : possibleMoves()) {
			if (pos.equals(posMov)) {
				position.setPosition(pos.getX(), pos.getY());
				pos.setChesspiece(this);
				wasMoved = true;
				break;
			}
		}
	}

	public void setPosition(Position pos) {
		Position old_position = this.position;
		this.position = pos;
		if (pos != null && this == pos.getChesspiece()) // figur steht bereits
														// auf pos
			return;
		if (old_position != null) // alter pos bescheid, dass wir weg sind
			old_position.setChesspiece(null);
		if (pos != null)
			pos.setChesspiece(this); // neuer Pos sagen, "wir sind neu hier"

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

	public Position getPosition() {
		return this.position;
	}

	public Chessboard getChess() {
		return chess;
	}
	
	public boolean getWasMoved() {
		return wasMoved;
	}

	public abstract List<Position> possibleMoves();

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getColor() + " " + position;
	}

}
