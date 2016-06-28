package de.htwg.chess.model;

import java.util.List;

/**
 * All the rules for move-validations in this interfaces' implementations are
 * defined by the official chess-rules.
 */
public interface MoveCheckerVisitor {

	/**
	 * @param field
	 *            is the initial position of the queen.
	 * @return List of IFields the queen can move to.
	 */
	public List<IField> checkQueen(IField field);

	/**
	 * @param field
	 *            is the initial position of the king.
	 * @return List of IFields the king can move to.
	 */
	public List<IField> checkKing(IField field);

	/**
	 * @param field
	 *            is the initial position of the rook.
	 * @return List of IFields the rook can move to.
	 */
	public List<IField> checkRook(IField field);

	/**
	 * @param field
	 *            is the initial position of the bishop.
	 * @return List of IFields the bishop can move to.
	 */
	public List<IField> checkBishop(IField field);

	/**
	 * @param field
	 *            is the initial position of the knight.
	 * @return List of IFields the knight can move to.
	 */
	public List<IField> checkKnight(IField field);

	/**
	 * @param field
	 *            is the initial position of the pawn.
	 * @return List of IFields the pawn can move to.
	 */
	public List<IField> checkPawn(IField field);

}
