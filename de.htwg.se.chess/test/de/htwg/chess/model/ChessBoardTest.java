package de.htwg.chess.model;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.Chessboard;
import junit.framework.TestCase;

public final class ChessBoardTest extends TestCase {
	Chessboard chessboard;
	Team white;
	Team black;
	
	@Before
	public void setUp() {
		chessboard = new Chessboard();
	}

	@Test
	public void testToString() {
		System.out.println(chessboard.toString());
		assertTrue(chessboard.toString()
				.equals("A1: Rook white A1\nA2: Pawn white A2\nA3: null\nA4: null\nA5: null\nA6: null\nA7: Pawn "
						+ "black A7\nA8: Rook black A8\nB1: Knight white B1\nB2: Pawn white B2\nB3: null\nB4: null\n"
						+ "B5: null\nB6: null\nB7: Pawn black B7\nB8: Knight black B8\nC1: Bishop white C1\n"
						+ "C2: Pawn white C2\nC3: null\nC4: null\nC5: null\nC6: null\nC7: Pawn black C7\n"
						+ "C8: Bishop black C8\nD1: Queen white D1\nD2: Pawn white D2\nD3: null\nD4: null\n"
						+ "D5: null\nD6: null\nD7: Pawn black D7\nD8: Queen black D8\nE1: King white E1\n"
						+ "E2: Pawn white E2\nE3: null\nE4: null\nE5: null\nE6: null\nE7: Pawn black E7\n"
						+ "E8: King black E8\nF1: Bishop white F1\nF2: Pawn white F2\nF3: null\nF4: null\n"
						+ "F5: null\nF6: null\nF7: Pawn black F7\nF8: Bishop black F8\nG1: Knight white G1\n"
						+ "G2: Pawn white G2\nG3: null\nG4: null\nG5: null\nG6: null\nG7: Pawn black G7\n"
						+ "G8: Knight black G8\nH1: Rook white H1\nH2: Pawn white H2\nH3: null\nH4: null\n"
						+ "H5: null\nH6: null\nH7: Pawn black H7\nH8: Rook black H8\n"));
	}
}
