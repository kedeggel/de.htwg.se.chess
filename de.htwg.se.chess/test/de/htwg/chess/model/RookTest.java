package de.htwg.chess.model;

import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import junit.framework.TestCase;

public final class RookTest extends TestCase {

	Chessboard chess;
	Chesspiece rook_test;
	Chesspiece piece_friendly;
	Chesspiece piece_enemy;
	List<Field> checklist;

	@Before
	public void setUp() {
		chess = new Chessboard();
		rook_test = new Rook(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		piece_friendly = new Pawn(chess.getWhite(), chess.getChessboard()[G][FIVE], chess);
		piece_enemy = new Pawn(chess.getBlack(), chess.getChessboard()[B][FIVE], chess);
		checklist = new LinkedList<>();
	}

	@Test
	public void testPossibleMoves() {
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
				checklist.containsAll(rook_test.possibleMoves()) && rook_test.possibleMoves().containsAll(checklist));

		/**
		 * left friendly, right enemy
		 */
		piece_friendly.setPosition(chess.getChessboard()[B][FIVE]);
		piece_enemy.setPosition(chess.getChessboard()[G][FIVE]);
		checklist.add(chess.getChessboard()[G][FIVE]);
		checklist.remove(chess.getChessboard()[B][FIVE]);
		assertTrue(
				checklist.containsAll(rook_test.possibleMoves()) && rook_test.possibleMoves().containsAll(checklist));

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
				checklist.containsAll(rook_test.possibleMoves()) && rook_test.possibleMoves().containsAll(checklist));
		
		assertTrue(chess.getChessboard()[A][ONE].getChesspiece().possibleMoves().isEmpty());
		assertTrue(chess.getChessboard()[A][EIGHT].getChesspiece().possibleMoves().isEmpty());
		
	}
}
