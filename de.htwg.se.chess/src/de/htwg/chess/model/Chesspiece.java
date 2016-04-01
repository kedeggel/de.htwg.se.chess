package de.htwg.chess.model;

import java.util.List;

public abstract class Chesspiece {

	protected String name;
	protected Player player;
	protected Position position;
	protected int drawCount;

	public Chesspiece(String name, Player player, Position position) {
		this.name = name;
		this.player = player;
		this.position = position;
		this.drawCount = 0;
	}

	public void move(Position pos) {
		for (Position posMov : possibleMoves()) {
			if (pos.equals(posMov)) {
				position.setPosition(pos.getX(), pos.getY());
				drawCount++;
				break;
			}
		}
	};

	public void setPosition(Position pos) {
		if (player == pos.getChesspiece().getPlayer())
			return; // field is occupied by a other-colored piece
		this.position = pos;
		pos.setChesspiece(this);
	}

	public String getColor() {
		return player.getColor();
	}

	public Player getPlayer() {
		return player;
	}

	public Position getPosition() {
		return this.position;
	}

	public abstract List<Position> possibleMoves();

	public String toString() {
		return name + " " + getColor() + " " + position + " " + "DrawCount: " + drawCount;
	}
}
