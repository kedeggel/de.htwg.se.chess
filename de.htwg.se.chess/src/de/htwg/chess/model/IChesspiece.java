package de.htwg.chess.model;

import java.util.List;

public interface IChesspiece {

	void checkPossibleMoves(MoveCheckerVisitor mc);

	void move(IField target);

	List<IField> getPossibleMoves();

	Color getColor();

	IField getField();

	void setField(IField target);

	boolean getWasMoved();

	void setWasMoved(boolean wasMoved);

	String toSymbole();

}
