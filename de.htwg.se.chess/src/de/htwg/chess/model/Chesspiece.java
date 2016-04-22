package de.htwg.chess.model;

import java.util.List;
import de.htwg.chess.Chess;

public abstract class Chesspiece {

	protected Player player;
	protected Position position;
	protected int drawCount;
	protected Chess chess;

	public Chesspiece(Player player, Position position, Chess chess) {
		this.player = player;
		this.setPosition(position);
		this.drawCount = 0;
		this.chess = chess;
	}

	public void move(Position pos) {
		for (Position posMov : possibleMoves()) {
			if (pos.equals(posMov)) {
				position.setPosition(pos.getX(), pos.getY());
				drawCount++;
				break;
			}
		}
	}

	public void setPosition(Position pos) {
		if (pos.getChesspiece() != null && player.equals(pos.getChesspiece().getPlayer()))
			return; // field is occupied by an different-colored piece
		this.position = pos;
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

	public String toString() {
		return getClass().getSimpleName().toString() + " " + getColor() + " " + position;
	}

}
