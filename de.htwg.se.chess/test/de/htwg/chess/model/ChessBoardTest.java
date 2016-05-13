package de.htwg.chess.model;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.Chessboard;
import de.htwg.chess.model.Team.Color;
import junit.framework.TestCase;

public final class ChessBoardTest extends TestCase {
	Chessboard chessboard;
	
	@Before
	public void setUp() {
		chessboard = new Chessboard();
	}

	@Test
	public void testToString() {
		System.out.println(chessboard.toString());
		assertTrue(chessboard.toString()
				.equals("A1: Rook WHITE A1\nA2: Pawn WHITE A2\nA3: null\nA4: null\nA5: null\nA6: null\nA7: Pawn "
						+ "BLACK A7\nA8: Rook BLACK A8\nB1: Knight WHITE B1\nB2: Pawn WHITE B2\nB3: null\nB4: null\n"
						+ "B5: null\nB6: null\nB7: Pawn BLACK B7\nB8: Knight BLACK B8\nC1: Bishop WHITE C1\n"
						+ "C2: Pawn WHITE C2\nC3: null\nC4: null\nC5: null\nC6: null\nC7: Pawn BLACK C7\n"
						+ "C8: Bishop BLACK C8\nD1: Queen WHITE D1\nD2: Pawn WHITE D2\nD3: null\nD4: null\n"
						+ "D5: null\nD6: null\nD7: Pawn BLACK D7\nD8: Queen BLACK D8\nE1: King WHITE E1\n"
						+ "E2: Pawn WHITE E2\nE3: null\nE4: null\nE5: null\nE6: null\nE7: Pawn BLACK E7\n"
						+ "E8: King BLACK E8\nF1: Bishop WHITE F1\nF2: Pawn WHITE F2\nF3: null\nF4: null\n"
						+ "F5: null\nF6: null\nF7: Pawn BLACK F7\nF8: Bishop BLACK F8\nG1: Knight WHITE G1\n"
						+ "G2: Pawn WHITE G2\nG3: null\nG4: null\nG5: null\nG6: null\nG7: Pawn BLACK G7\n"
						+ "G8: Knight BLACK G8\nH1: Rook WHITE H1\nH2: Pawn WHITE H2\nH3: null\nH4: null\n"
						+ "H5: null\nH6: null\nH7: Pawn BLACK H7\nH8: Rook BLACK H8\n"));
	}
	
	public void testTeamGetter() {
		assertTrue(chessboard.getTeam(Color.WHITE).toString() == "WHITE");
		assertTrue(chessboard.getTeam(Color.BLACK).toString() == "BLACK");
	}
}
