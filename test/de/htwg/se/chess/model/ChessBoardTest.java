package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import junit.framework.TestCase;

public final class ChessBoardTest extends TestCase {
	public void testToString() {
		Chess ch = new Chess();
		assertTrue(ch.toString()
			.equals("A1: Rook white A1\nA2: Pawn white A2\nA3: null\nA4: null\nA5: null\nA6: null\n"
					+ "A7: Pawn black A7\nA8: Rook black A8\nB1: null\nB2: Pawn white B2\nB3: null\n"
					+ "B4: null\nB5: null\nB6: null\nB7: Pawn black B7\nB8: null\nC1: null\n"
					+ "C2: Pawn white C2\nC3: null\nC4: null\nC5: null\nC6: null\nC7: Pawn black C7\n"
					+ "C8: null\nD1: null\nD2: Pawn white D2\nD3: null\nD4: null\nD5: null\nD6: null\n"
					+ "D7: Pawn black D7\nD8: null\nE1: null\nE2: Pawn white E2\nE3: null\nE4: null\n"
					+ "E5: null\nE6: null\nE7: Pawn black E7\nE8: null\nF1: null\nF2: Pawn white F2\n"
					+ "F3: null\nF4: null\nF5: null\nF6: null\nF7: Pawn black F7\nF8: null\nG1: null\n"
					+ "G2: Pawn white G2\nG3: null\nG4: null\nG5: null\nG6: null\nG7: Pawn black G7\n"
					+ "G8: null\nH1: Rook white H1\nH2: Pawn white H2\nH3: null\nH4: null\nH5: null\n"
					+ "H6: null\nH7: Pawn black H7\nH8: Rook black H8\n"));
	}
}
