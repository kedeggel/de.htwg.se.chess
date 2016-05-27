package de.htwg.chess.model;

import java.util.List;

public interface MoveCheckerVisitor {

	public List<Field> checkQueen(Field field);

	public List<Field> checkKing(Field field);

	public List<Field> checkRook(Field field);

	public List<Field> checkBishop(Field field);

	public List<Field> checkKnight(Field field);

	public List<Field> checkPawn(Field field);

}
