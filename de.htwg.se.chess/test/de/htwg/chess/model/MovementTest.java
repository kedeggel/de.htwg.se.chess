package de.htwg.chess.model;

import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;
import junit.framework.TestCase;

public final class MovementTest extends TestCase {

	Chessboard chess;
	Chesspiece pieceTest;
	Chesspiece pieceFriendly;
	Chesspiece pieceEnemy;
	List<Position> checklist;

	@Before
	public void setUp() {
		chess = new Chessboard();
		pieceTest = new Rook(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		pieceFriendly = new Pawn(chess.getWhite(), chess.getChessboard()[G][FIVE], chess);
		pieceEnemy = new Pawn(chess.getBlack(), chess.getChessboard()[B][FIVE], chess);
		checklist = new LinkedList<>();
	}

	@Test
	public void testHorizontalVertikalMoves() {
		/**
		 * right friendly, left enemy
		 */
		checklist.add(chess.getChessboard()[C][FIVE]);
		checklist.add(chess.getChessboard()[B][FIVE]);
		checklist.add(chess.getChessboard()[E][FIVE]);
		checklist.add(chess.getChessboard()[F][FIVE]);
		checklist.add(chess.getChessboard()[D][SIX]);
		checklist.add(chess.getChessboard()[D][SEVEN]);
		checklist.add(chess.getChessboard()[D][FOUR]);
		checklist.add(chess.getChessboard()[D][THREE]);

		assertTrue(
				checklist.containsAll(pieceTest.possibleMoves()) && pieceTest.possibleMoves().containsAll(checklist));

		/**
		 * left friendly, right enemy
		 */
		pieceFriendly.setPosition(chess.getChessboard()[B][FIVE]);
		pieceEnemy.setPosition(chess.getChessboard()[G][FIVE]);
		checklist.add(chess.getChessboard()[G][FIVE]);
		checklist.remove(chess.getChessboard()[B][FIVE]);
		assertTrue(
				checklist.containsAll(pieceTest.possibleMoves()) && pieceTest.possibleMoves().containsAll(checklist));

		/**
		 * down enemy, up friendly
		 */
		pieceFriendly.setPosition(chess.getChessboard()[D][SIX]);
		pieceEnemy.setPosition(chess.getChessboard()[D][THREE]);
		checklist.add(chess.getChessboard()[A][FIVE]);
		checklist.add(chess.getChessboard()[B][FIVE]);
		checklist.add(chess.getChessboard()[H][FIVE]);
		checklist.remove(chess.getChessboard()[D][SIX]);
		checklist.remove(chess.getChessboard()[D][SEVEN]);
		assertTrue(
				checklist.containsAll(pieceTest.possibleMoves()) && pieceTest.possibleMoves().containsAll(checklist));

		assertTrue(chess.getChessboard()[A][ONE].getChesspiece().possibleMoves().isEmpty());
		assertTrue(chess.getChessboard()[A][EIGHT].getChesspiece().possibleMoves().isEmpty());

	}

	@Test
	public void testDiagonalMoves() {
		pieceTest = new Bishop(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		checklist = new LinkedList<>();
		checklist.add(chess.getChessboard()[C][SIX]);
		checklist.add(chess.getChessboard()[B][SEVEN]);
		checklist.add(chess.getChessboard()[F][SEVEN]);
		checklist.add(chess.getChessboard()[E][SIX]);
		checklist.add(chess.getChessboard()[C][FOUR]);
		checklist.add(chess.getChessboard()[E][FOUR]);
		checklist.add(chess.getChessboard()[B][THREE]);
		checklist.add(chess.getChessboard()[F][THREE]);
		assertTrue(
				checklist.containsAll(pieceTest.possibleMoves()) && pieceTest.possibleMoves().containsAll(checklist));
		pieceEnemy.setPosition(chess.getChessboard()[B][THREE]);
		pieceFriendly.setPosition(chess.getChessboard()[C][SIX]);
		checklist.remove(chess.getChessboard()[C][SIX]);
		checklist.remove(chess.getChessboard()[B][SEVEN]);
		assertTrue(
				checklist.containsAll(pieceTest.possibleMoves()) && pieceTest.possibleMoves().containsAll(checklist));

		pieceTest.setPosition(chess.getChessboard()[A][EIGHT]);
		checklist = new LinkedList<>();
		checklist.add(chess.getChessboard()[B][SEVEN]);
		assertTrue(pieceTest.possibleMoves().equals(checklist));
		pieceTest.setPosition(chess.getChessboard()[A][ONE]);
		assertTrue(pieceTest.possibleMoves().isEmpty());
	}

}

// @Test
// public void testMove() {
// Chesspiece pieceTest = new Rook(chess.getWhite(),
// chess.getChessboard()[D][FIVE], chess);
// assertTrue(pieceTest.getPosition().toString().equals("D5"));
// pieceTest.possibleMoves();
//
// // right
// Chesspiece rook_1 = new Rook(chess.getWhite(),
// chess.getChessboard()[F][FIVE], chess);
// pieceTest.possibleMoves();
// Chesspiece rookEnemy_1 = new Rook(chess.getBlack(),
// chess.getChessboard()[F][FIVE], chess);
// pieceTest.possibleMoves();
// // left
// rook_1.setPosition(chess.getChessboard()[A][FIVE]);
// pieceTest.possibleMoves();
// rookEnemy_1.setPosition(chess.getChessboard()[A][FIVE]);
// pieceTest.possibleMoves();
//
// // up
// pieceTest.setPosition(chess.getChessboard()[D][EIGHT]);
// pieceTest.possibleMoves();
// pieceTest.setPosition(chess.getChessboard()[D][FIVE]);
// rook_1.setPosition(chess.getChessboard()[D][SIX]);
// pieceTest.possibleMoves();
// // down
// pieceTest.setPosition(chess.getChessboard()[D][ONE]);
// pieceTest.possibleMoves();
//
// Chesspiece bishopTest = new Bishop(chess.getWhite(),
// chess.getChessboard()[D][FIVE], chess);
// bishopTest.possibleMoves();
// // rook_1.setPosition(chess.getChessboard()[C][SIX]);
// // rookEnemy_1.setPosition(chess.getChessboard()[E][SIX]);
//
// LinkedList<Position> poslist = new LinkedList<>();
// poslist.add(chess.getChessboard()[A][EIGHT]);
// poslist.add(chess.getChessboard()[H][EIGHT]);
// poslist.add(chess.getChessboard()[A][ONE]);
// poslist.add(chess.getChessboard()[H][ONE]);
//
// for (Position pos : poslist) {
// bishopTest.setPosition(pos);
// bishopTest.possibleMoves();
// }
//
// for (Position pos : poslist) {
// bishopTest.setPosition(pos);
// bishopTest.possibleMoves();
// }
//
// Chesspiece queen = new Queen(chess.getWhite(), chess.getChessboard()[A][SIX],
// chess);
// queen.possibleMoves();
//
// Chesspiece pferdchen = new Knight(chess.getWhite(),
// chess.getChessboard()[B][FIVE], chess);
// pferdchen.possibleMoves();
//
// }
