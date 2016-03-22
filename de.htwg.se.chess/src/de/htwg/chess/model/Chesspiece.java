package de.htwg.chess.model;

import java.util.List;

public abstract class Chesspiece {

	protected String name;
	protected String color;
	protected Position position;
	protected int drawCount;

	public Chesspiece(String name, String color, Position position) {
		this.name = name;
		this.color = color;
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
		if (color.equals(pos.getChesspiece().getColor()))
			return; // field is occupied by a other-colored piece
		this.position = pos;
		pos.setChesspiece(this);
	}

	public String getColor() {
		return color;
	}

	public Position getPosition() {
		return this.position;
	}

	public abstract List<Position> possibleMoves();

	public String toString() {
		return name + " " + color + " " + position + " " + "DrawCount: " + drawCount;
	}
}
