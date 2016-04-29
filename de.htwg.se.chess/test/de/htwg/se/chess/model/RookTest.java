package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import junit.framework.TestCase;

public final class RookTest extends TestCase {

	Chess chess;
	Chesspiece rook_test;
	Chesspiece piece_friendly;
	Chesspiece piece_enemy;
	List<Position> checklist;

	@Before
	public void setUp() {
		chess = new Chess();
		rook_test = new Rook(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		piece_friendly = new Pawn(chess.getWhite(), chess.getChessboard()[G][FIVE], chess);
		piece_enemy = new Pawn(chess.getBlack(), chess.getChessboard()[B][FIVE], chess);
		checklist = new LinkedList<>();
	}

	@Test
	public void testPossibleMoves() {
		/**
		 * right friendly left enemy
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
				checklist.containsAll(rook_test.possibleMoves()) && rook_test.possibleMoves().containsAll(checklist));

		/**
		 * left friendly right enemy
		 */
		piece_friendly.setPosition(chess.getChessboard()[B][FIVE]);
		piece_enemy.setPosition(chess.getChessboard()[G][FIVE]);
		checklist.add(chess.getChessboard()[G][FIVE]);
		checklist.remove(chess.getChessboard()[B][FIVE]);
		assertTrue(
				checklist.containsAll(rook_test.possibleMoves()) && rook_test.possibleMoves().containsAll(checklist));

	}
}
