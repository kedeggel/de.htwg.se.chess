package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;
import junit.framework.TestCase;

public final class ChesspieceTest extends TestCase {
	public void testMove() {
		Chess chess = new Chess();
		Chesspiece rook_test = new Rook(chess.getWhite(), chess.getChessboard()[A][THREE], chess);
		rook_test.move(chess.getChessboard()[H][THREE]);
		assertTrue(rook_test.getPosition().samePosition(chess.getChessboard()[H][THREE]));
		rook_test.move(chess.getChessboard()[G][FOUR]);
		assertTrue(rook_test.getPosition().samePosition(chess.getChessboard()[H][THREE]));
	}
}
