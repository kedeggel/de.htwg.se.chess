package de.htwg.chess.model;


public interface IField {

	IChesspiece getChesspiece();

	void setChesspiece(IChesspiece cp);

	char getX();

	int getY();

	boolean isFieldOccupied();

	@Override
	String toString();


}
