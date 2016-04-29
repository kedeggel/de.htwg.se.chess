package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;
import junit.framework.TestCase;

public final class MovementTest extends TestCase {

	Chess chess;
	Chesspiece piece_test;
	Chesspiece piece_friendly;
	Chesspiece piece_enemy;
	List<Position> checklist;

	@Before
	public void setUp() {
		chess = new Chess();
		piece_test = new Rook(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		piece_friendly = new Pawn(chess.getWhite(), chess.getChessboard()[G][FIVE], chess);
		piece_enemy = new Pawn(chess.getBlack(), chess.getChessboard()[B][FIVE], chess);
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
				checklist.containsAll(piece_test.possibleMoves()) && piece_test.possibleMoves().containsAll(checklist));

		/**
		 * left friendly, right enemy
		 */
		piece_friendly.setPosition(chess.getChessboard()[B][FIVE]);
		piece_enemy.setPosition(chess.getChessboard()[G][FIVE]);
		checklist.add(chess.getChessboard()[G][FIVE]);
		checklist.remove(chess.getChessboard()[B][FIVE]);
		assertTrue(
				checklist.containsAll(piece_test.possibleMoves()) && piece_test.possibleMoves().containsAll(checklist));

		/**
		 * down enemy, up friendly
		 */
		piece_friendly.setPosition(chess.getChessboard()[D][SIX]);
		piece_enemy.setPosition(chess.getChessboard()[D][THREE]);
		checklist.add(chess.getChessboard()[A][FIVE]);
		checklist.add(chess.getChessboard()[B][FIVE]);
		checklist.add(chess.getChessboard()[H][FIVE]);
		checklist.remove(chess.getChessboard()[D][SIX]);
		checklist.remove(chess.getChessboard()[D][SEVEN]);
		assertTrue(
				checklist.containsAll(piece_test.possibleMoves()) && piece_test.possibleMoves().containsAll(checklist));

		assertTrue(chess.getChessboard()[A][ONE].getChesspiece().possibleMoves().isEmpty());
		assertTrue(chess.getChessboard()[A][EIGHT].getChesspiece().possibleMoves().isEmpty());

	}

	@Test
	public void testDiagonalMoves() {
		piece_test = new Bishop(chess.getWhite(), chess.getChessboard()[B][FIVE], chess);
	}
}

// @Test
// public void testMove() {
// Chesspiece piece_test = new Rook(chess.getWhite(),
// chess.getChessboard()[D][FIVE], chess);
// assertTrue(piece_test.getPosition().toString().equals("D5"));
// piece_test.possibleMoves();
//
// // right
// Chesspiece rook_1 = new Rook(chess.getWhite(),
// chess.getChessboard()[F][FIVE], chess);
// piece_test.possibleMoves();
// Chesspiece rook_enemy_1 = new Rook(chess.getBlack(),
// chess.getChessboard()[F][FIVE], chess);
// piece_test.possibleMoves();
// // left
// rook_1.setPosition(chess.getChessboard()[A][FIVE]);
// piece_test.possibleMoves();
// rook_enemy_1.setPosition(chess.getChessboard()[A][FIVE]);
// piece_test.possibleMoves();
//
// // up
// piece_test.setPosition(chess.getChessboard()[D][EIGHT]);
// piece_test.possibleMoves();
// piece_test.setPosition(chess.getChessboard()[D][FIVE]);
// rook_1.setPosition(chess.getChessboard()[D][SIX]);
// piece_test.possibleMoves();
// // down
// piece_test.setPosition(chess.getChessboard()[D][ONE]);
// piece_test.possibleMoves();
//
// Chesspiece bishop_test = new Bishop(chess.getWhite(),
// chess.getChessboard()[D][FIVE], chess);
// bishop_test.possibleMoves();
// // rook_1.setPosition(chess.getChessboard()[C][SIX]);
// // rook_enemy_1.setPosition(chess.getChessboard()[E][SIX]);
//
// LinkedList<Position> poslist = new LinkedList<>();
// poslist.add(chess.getChessboard()[A][EIGHT]);
// poslist.add(chess.getChessboard()[H][EIGHT]);
// poslist.add(chess.getChessboard()[A][ONE]);
// poslist.add(chess.getChessboard()[H][ONE]);
//
// for (Position pos : poslist) {
// bishop_test.setPosition(pos);
// bishop_test.possibleMoves();
// }
//
// for (Position pos : poslist) {
// bishop_test.setPosition(pos);
// bishop_test.possibleMoves();
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
