package de.htwg.chess.model.impl;

import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;

public final class Field implements IField {
	private char x;
	private int y;
	private IChesspiece cp;

	public Field(char x, int y) {
		if (!setPosition(x, y))
			throw new IllegalArgumentException(x + "" + y + " is not a valid Position");
		cp = null;
	}

	public boolean setPosition(char x, int y) {
		if (x < 'A' || x > 'H' || y < 1 || y > 8) {
			return false;
		}
		this.x = x;
		this.y = y;
		return true;
	}

	@Override
	public char getX() {
		return x;
	}

	public boolean setX(char x) {
		return setPosition(x, this.y);
	}

	@Override
	public int getY() {
		return y;
	}

	public boolean setY(int y) {
		return setPosition(this.x, y);
	}

	@Override
	public IChesspiece getChesspiece() {
		return cp;
	}

	@Override
	public void setChesspiece(IChesspiece cp) {
		IChesspiece oldCp = this.cp;
		this.cp = cp;
		if (cp != null && this == cp.getField()) // figur ist bereits her
			return;
		if (oldCp != null) // altem cp bescheid, dass keine pos mehr hat
			oldCp.setField(null);
		if (cp != null)
			cp.setField(this); // neuem cp sagen, wo es steht

	}

	public boolean samePosition(IField pos) {
		if (pos == null || this.x != pos.getX() || this.y != pos.getY())
			return false;
		return true;
	}

	@Override
	public boolean isFieldOccupied() {
		if (cp != null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(x) + y;
	}
}