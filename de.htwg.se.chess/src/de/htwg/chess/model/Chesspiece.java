package de.htwg.chess.model;

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
	
	public abstract void move(char x, int y);
	
	public String toString() {
		return name + color + position + "DrawCount:" + drawCount;
	}
}
