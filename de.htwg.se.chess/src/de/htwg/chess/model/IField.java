package de.htwg.chess.model;

import de.htwg.chess.model.impl.Chesspiece;

public interface IField {

	IChesspiece getChesspiece();

	void setChesspiece(Chesspiece chesspiece);

	char getX();

	int getY();

	boolean isFieldOccupied();

}
