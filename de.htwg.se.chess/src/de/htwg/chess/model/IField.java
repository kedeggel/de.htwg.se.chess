package de.htwg.chess.model;

public interface IField {

	/**
	 * Returns the chesspiece which is placed on this field.
	 * 
	 * @return chesspiece on this field. If this field is empty, "null" is
	 *         returned.
	 */
	IChesspiece getChesspiece();

	/**
	 * Places a specified chesspiece on this field, clearing the field, it used
	 * to be placed before and telling the chesspiece its new position.
	 * 
	 * @param cp
	 *            is the chesspiece which will be moved and updated.
	 */
	void setChesspiece(IChesspiece cp);

	/**
	 * Returns the letter-part of this chessfields' coordinates.
	 * 
	 * @return x-Value of this chessfield as a Char.
	 */
	char getX();

	/**
	 * Returns the number-part of this chessfields' coordinates.
	 * 
	 * @return y-Value of this chessfield as an int.
	 */
	int getY();

	/**
	 * Checks whether a field is occupied by a chesspiece or empty.
	 * 
	 * @return true, if the fields' chesspiece is not null. false, if the
	 *         fields' chesspiece is null.
	 */
	boolean isFieldOccupied();

	@Override
	String toString();

}
