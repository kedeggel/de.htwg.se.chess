package de.htwg.chess.controller;

import de.htwg.chess.model.ITeam;
import de.htwg.util.observer.IObservable;

public interface IChessController extends IObservable {

	void nextRound();

	boolean move(char startX, int startY, char targetX, int targetY);

	void setCheck(ITeam team, boolean isInCheck);

	void restart();

	void tranformToQueen();

	void tranformToRook();

	void tranformToBishop();

	void tranformToKnight();

	String printBoard();

	boolean isCheckmate();

	ITeam whoIsOnTurn();

	String printTotalBoard();

	String getStatusMessage();

}
