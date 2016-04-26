package de.htwg.chess.model;

import java.util.List;
import de.htwg.chess.Chess;

public abstract class Chesspiece {

	protected Player player;
	protected Position position;
	protected Chess chess;

	public Chesspiece(Player player, Position position, Chess chess) {
		this.player = player;
		this.setPosition(position);
		this.chess = chess;
	}

	public void move(Position pos) {
		for (Position posMov : possibleMoves()) {
			if (pos.equals(posMov)) {
				position.setPosition(pos.getX(), pos.getY());
				pos.setChesspiece(this);
				break;
			}
		}
	}

	public void setPosition(Position pos) {
		this.position = pos;
		if (pos != null)
			pos.setChesspiece(this);
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

	public Chess getChess() {
		return chess;
	}

	public abstract List<Position> possibleMoves();

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getColor() + " " + position;
	}

}
