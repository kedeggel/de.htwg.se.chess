package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import junit.framework.TestCase;

public final class MovementTest extends TestCase {
	public void testMove() {
		Chess chess = new Chess();
		Chesspiece rook_test = new Rook("Rook_test", chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		assertTrue(rook_test.getPosition().toString().equals("D5"));
		// for (Position pos : rook_test.possibleMoves())
		// System.out.println(pos);
	}
}
