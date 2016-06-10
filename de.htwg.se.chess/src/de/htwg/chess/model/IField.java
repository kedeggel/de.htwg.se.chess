package de.htwg.chess.model;

import de.htwg.chess.model.impl.Chesspiece;

public interface IField {

	Chesspiece getChesspiece();

	void setChesspiece(Chesspiece chesspiece);

	char getX();

	int getY();

	boolean isFieldOccupied();

}
