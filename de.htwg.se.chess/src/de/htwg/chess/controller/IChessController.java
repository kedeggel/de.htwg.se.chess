package de.htwg.chess.controller;

import de.htwg.chess.model.ITeam;
import de.htwg.util.observer.IObservable;

public interface IChessController extends IObservable {
	/**
	 * Sets the opponent team on turn.
	 */
	void nextRound();

	/**
	 * Moves a chesspiece.
	 * 
	 * @param startX
	 *            x-value of start field
	 * @param startY
	 *            y-value of start field
	 * @param targetX
	 *            x-value of target field
	 * @param targetY
	 *            x-value of target field
	 */
	void move(char startX, int startY, char targetX, int targetY);

	/**
	 * Sets team in or out check.
	 * 
	 * @param team
	 *            to set in or out check
	 * @param isInCheck
	 *            states if team is in check or not
	 */
	void setCheck(ITeam team, boolean isInCheck);

	/**
	 * Sets chessboard on default values.
	 */
	void restart();

	/**
	 * Transforms a pawn into a queen.
	 */
	void transformToQueen();

	/**
	 * Transforms a pawn into a rook.
	 */
	void transformToRook();

	/**
	 * Transforms a pawn into a bishop.
	 */
	void transformToBishop();

	/**
	 * Transforms a pawn into a knight.
	 */
	void transformToKnight();

	/**
	 * @return not-empty fields with their associating chesspieces
	 */
	String printBoard();

	/**
	 * @return true if any team is checkmate; else false
	 */
	boolean isCheckmate();

	/**
	 * @return the team that is on turn
	 */
	ITeam whoIsOnTurn();

	/**
	 * @return fields with chesspieces or null if empty
	 */
	String printTotalBoard();

	/**
	 * @return statusMessage
	 */
	String getStatusMessage();

	/**
	 * Returns if any pawn has reached the opposite end of the chessboard
	 * 
	 * @return true, if any pawn can be transformed; else false
	 */
	boolean isReadyToTransform();

	/**
	 * Gets the graphical representation of a chesspiece standing on field xy.
	 * 
	 * @param x
	 *            x-value
	 * @param y
	 *            y-value
	 * @return graphical representation of chesspiece
	 */
	String getSymboleByField(char x, int y);

	/**
	 * Notifies observers to exit the game.
	 */
	void quit();

}
