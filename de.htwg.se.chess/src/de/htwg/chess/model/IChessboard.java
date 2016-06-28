package de.htwg.chess.model;

public interface IChessboard {

	/**
	 * Returns the ITeam representation of the color specified by the parameter
	 * "color". It can be (ITeam) "BLACK" or (ITeam) "WHITE".
	 * 
	 * @param color
	 *            of the Team you want to have returned.
	 * @return ITeam of the specified parameter "color".
	 */
	ITeam getTeam(Color color);

	/**
	 * Returns the IField with the specified x and y Values or null if indices
	 * are out of chessboard-bounds.
	 * 
	 * @param x
	 *            coordinate as int [0-7]
	 * @param y
	 *            coordinate as int [0-7]
	 * @return the IField for the specified coordinates, returns null if either
	 *         x or y aren't indexing to 0-7
	 */
	IField getField(int x, int y);

	/**
	 * Returns a text-listed representation of the current chessboard-state.
	 * Each chessfield, which is not empty gets written in a new line, followed
	 * by the chesspiece (type and color).
	 * 
	 * @return multiple lines, representing non-empty chessfields.
	 */
	String toSimpleString();

	/**
	 * For both of the 2 Teams, all the possible Moves of each chesspiece are refreshed.
	 */
	void updateTeams();

}
