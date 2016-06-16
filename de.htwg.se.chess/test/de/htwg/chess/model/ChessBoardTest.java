package de.htwg.chess.model;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.impl.Chessboard;
import de.htwg.chess.model.impl.Team.Color;
import junit.framework.TestCase;

public final class ChessBoardTest extends TestCase {
	Chessboard chessboard;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
	}

	// @Test
	// public void testToString() {
	// assertTrue(chessboard.toString()
	// .equals("A1: Rook WHITE\nA2: Pawn WHITE\nA3: null\nA4: null\nA5:
	// null\nA6: null\nA7: Pawn "
	// + "BLACK\nA8: Rook BLACK\nB1: Knight WHITE\nB2: Pawn WHITE\nB3: null\nB4:
	// null\n"
	// + "B5: null\nB6: null\nB7: Pawn BLACK\nB8: Knight BLACK\nC1: Bishop
	// WHITE\n"
	// + "C2: Pawn WHITE\nC3: null\nC4: null\nC5: null\nC6: null\nC7: Pawn
	// BLACK\n"
	// + "C8: Bishop BLACK\nD1: Queen WHITE\nD2: Pawn WHITE\nD3: null\nD4:
	// null\n"
	// + "D5: null\nD6: null\nD7: Pawn BLACK\nD8: Queen BLACK\nE1: King WHITE\n"
	// + "E2: Pawn WHITE\nE3: null\nE4: null\nE5: null\nE6: null\nE7: Pawn
	// BLACK\n"
	// + "E8: King BLACK\nF1: Bishop WHITE\nF2: Pawn WHITE\nF3: null\nF4:
	// null\n"
	// + "F5: null\nF6: null\nF7: Pawn BLACK\nF8: Bishop BLACK\nG1: Knight
	// WHITE\n"
	// + "G2: Pawn WHITE\nG3: null\nG4: null\nG5: null\nG6: null\nG7: Pawn
	// BLACK\n"
	// + "G8: Knight BLACK\nH1: Rook WHITE H1\nH2: Pawn WHITE\nH3: null\nH4:
	// null\n"
	// + "H5: null\nH6: null\nH7: Pawn BLACK H7\nH8: Rook BLACK\n"));
	// }
	@Test
	public void testTeamGetter() {
		assertTrue(chessboard.getTeam(Color.WHITE).toString() == "WHITE");
		assertTrue(chessboard.getTeam(Color.BLACK).toString() == "BLACK");
	}

	@Test
	public void testMove() {
		System.out.println(chessboard.toString());
		System.out.println(chessboard.getField(1, 0).getChesspiece());
		chessboard.getTeam(Color.WHITE).move(chessboard.getField(1, 0).getChesspiece(), chessboard.getField(0, 2));
		System.out.println(chessboard.toString());
	}
}
