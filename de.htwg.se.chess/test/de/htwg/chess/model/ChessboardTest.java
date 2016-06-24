package de.htwg.chess.model;

import org.junit.Before;
import org.junit.Test;
import de.htwg.chess.model.impl.Chessboard;
import junit.framework.TestCase;

public final class ChessboardTest extends TestCase {
	Chessboard chessboard;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
	}

	@Test
	public void testToString() {
		assertTrue(chessboard.toString()
				.equals("A1: Rook WHITE\nB1: Knight WHITE\nC1: Bishop WHITE\n"
						+ "D1: Queen WHITE\nE1: King WHITE\nF1: Bishop WHITE\nG1: Knight WHITE\n"
						+ "H1: Rook WHITE\nA2: Pawn WHITE\nB2: Pawn WHITE\nC2: Pawn WHITE\nD2: Pawn WHITE\n"
						+ "E2: Pawn WHITE\nF2: Pawn WHITE\nG2: Pawn WHITE\nH2: Pawn WHITE\nA3: null\n"
						+ "B3: null\nC3: null\nD3: null\nE3: null\nF3: null\nG3: null\nH3: null\n"
						+ "A4: null\nB4: null\nC4: null\nD4: null\nE4: null\nF4: null\nG4: null\n"
						+ "H4: null\nA5: null\nB5: null\nC5: null\nD5: null\nE5: null\nF5: null\n"
						+ "G5: null\nH5: null\nA6: null\nB6: null\nC6: null\nD6: null\nE6: null\n"
						+ "F6: null\nG6: null\nH6: null\nA7: Pawn BLACK\nB7: Pawn BLACK\n"
						+ "C7: Pawn BLACK\nD7: Pawn BLACK\nE7: Pawn BLACK\nF7: Pawn BLACK\nG7: Pawn BLACK\n"
						+ "H7: Pawn BLACK\nA8: Rook BLACK\nB8: Knight BLACK\nC8: Bishop BLACK\n"
						+ "D8: Queen BLACK\nE8: King BLACK\nF8: Bishop BLACK\nG8: Knight BLACK\nH8: Rook BLACK\n"));
	}

	@Test
	public void testToSimpleString() {
		assertTrue(chessboard.toSimpleString()
				.equals("A1: Rook WHITE\nB1: Knight WHITE\nC1: Bishop WHITE\n"
						+ "D1: Queen WHITE\nE1: King WHITE\nF1: Bishop WHITE\nG1: Knight WHITE\n"
						+ "H1: Rook WHITE\nA2: Pawn WHITE\nB2: Pawn WHITE\nC2: Pawn WHITE\nD2: Pawn WHITE\n"
						+ "E2: Pawn WHITE\nF2: Pawn WHITE\nG2: Pawn WHITE\nH2: Pawn WHITE\nA7: Pawn BLACK\nB7: Pawn BLACK\n"
						+ "C7: Pawn BLACK\nD7: Pawn BLACK\nE7: Pawn BLACK\nF7: Pawn BLACK\nG7: Pawn BLACK\n"
						+ "H7: Pawn BLACK\nA8: Rook BLACK\nB8: Knight BLACK\nC8: Bishop BLACK\n"
						+ "D8: Queen BLACK\nE8: King BLACK\nF8: Bishop BLACK\nG8: Knight BLACK\nH8: Rook BLACK\n"));
	}

	@Test
	public void testTeamGetter() {
		assertTrue(chessboard.getTeam(Color.WHITE).toString() == "WHITE");
		assertTrue(chessboard.getTeam(Color.BLACK).toString() == "BLACK");
	}

	@Test
	public void testFieldGetter() {
		assertNull(chessboard.getField(-1, -1));
		assertNull(chessboard.getField(8, 8));
	}

	@Test
	public void testMove() {
		chessboard.getTeam(Color.WHITE).move(chessboard.getField(1, 0).getChesspiece(), chessboard.getField(0, 2));
	}
}
