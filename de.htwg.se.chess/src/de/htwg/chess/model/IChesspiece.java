package de.htwg.chess.model;

import java.util.List;

public interface IChesspiece {

	/**
	 * Calls the validation Method of the specific chesspiece-type and fills the chesspieces' "possibleMoves"-list with valid IFields to move to.
	 * @param mc
	 *            is our Implementation of a MoveCheckerVisitor. MoveChecker is
	 *            following the rules of the official chess-game.
	 */
	void checkPossibleMoves(MoveCheckerVisitor mc);

	/**
	 * @param target
	 */
	void move(IField target);

	/**
	 * Returns a List of IFields which contains all the IFields to which this
	 * chesspiece can move to. (considering check and "move-over-units"-rules).
	 * This Method returns the List, which is filed by the
	 * "checkPossibleMoves"-Method.
	 * 
	 * @return List with all possible IFields to move to.
	 */
	List<IField> getPossibleMoves();

	/**
	 * Returns the teams' Color of this chesspiece.
	 * 
	 * @return Color of this chesspiece.
	 */
	Color getColor();

	/**
	 * Returns the IField on which this cheespiece is currently located.
	 * 
	 * @return IField of this chesspiece.
	 */
	IField getField();

	/**
	 * On a valid draw, sets the chesspieces' location to the targeted Field and
	 * removes the chesspiece from the old location.
	 * 
	 * @param target
	 *            specifies the targeted Field.
	 */
	void setField(IField target);

	/**
	 * Checks whether a chesspiece has already been drawn in this match.
	 * 
	 * @return false, if the chesspiece never moved. true, if the chesspiece has
	 *         been moved atleast once.
	 */
	boolean getWasMoved();

	/**
	 * Sets the variable wasMoved to indicate, if a chesspiece has already been
	 * drawn in this match.
	 * 
	 * @param wasMoved
	 *            is set to "false" upon initialisation, "true" as soon as the
	 *            chesspiece does a valid move.
	 */
	void setWasMoved(boolean wasMoved);

	/**
	 * @return Unicode (Image) of this Chesspiece as String.
	 */
	String toSymbole();

}
