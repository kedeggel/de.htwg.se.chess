package de.htwg.chess.controller;

import de.htwg.chess.model.ITeam;
import de.htwg.util.observer.IObservable;

public interface IChessController extends IObservable {

	void nextRound();

	void move(char startX, int startY, char targetX, int targetY);

	void setCheck(ITeam team, boolean isInCheck);

	void restart();

	void transformToQueen();

	void transformToRook();

	void transformToBishop();

	void transformToKnight();

	String printBoard();

	boolean isCheckmate();

	ITeam whoIsOnTurn();

	String printTotalBoard();

	String getStatusMessage();

	boolean isReadyToTransform();

	String getSymboleByField(char x, int y);

	boolean isQuit();

	void setQuit(boolean quit);

}
