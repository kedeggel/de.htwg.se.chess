package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.model.impl.Team.Color;

public interface ITeam {

	/**
	 * Returns the opposing teams color, represented by a enum with 2
	 * Color-Entries.
	 * 
	 * @return Color of the opponent team.
	 */
	Color opponent();

	/**
	 * Returns a List of all the chesspieces on the current Teams' side.
	 * 
	 * @return List of chesspieces.
	 */
	List<IChesspiece> getPieceList();

	/**
	 * Moves a chesspiece to a designated field on the board.
	 * 
	 * @param cp
	 *            is the chesspiece which is about to be moved.
	 * @param target
	 *            is the target field location.
	 */
	void move(IChesspiece cp, IField target);

	/**
	 * Return the "King"-chesspiece.
	 * 
	 * @return Chesspiece "King"
	 */
	IChesspiece getKing();

	/**
	 * Returns the teams color, represented by a enum with 2 Color-Entries.
	 * 
	 * @return Color of the Team
	 */
	Color getColor();

	/**
	 * Removes a chesspiece on the board, settting its position to null and
	 * deleting it from the List of Chesspieces for the corresponding team.
	 * 
	 * @param cp
	 *            is the chesspiece which gets deleted.
	 */
	void removeChesspiece(IChesspiece cp);

	/**
	 * Adds a specified chesspiece to the team, adding it to the pieceList and
	 * placing it on a free field on the board
	 * 
	 * @param cp
	 *            is the chesspiece, which will be added.
	 */
	void addChesspiece(IChesspiece cp);

	/**
	 * Updates the possible moves of each chesspiece in this team. Allowed
	 * moving-paterns are defined by the official chess-rules and can be checked
	 * at "https://help.gnome.org/users/glchess/stable/chess-rules.html.en"
	 */
	void updatePosMoves();

}
