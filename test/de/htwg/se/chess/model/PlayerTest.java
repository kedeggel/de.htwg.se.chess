package de.htwg.se.chess.model;

import junit.framework.TestCase;
import static de.htwg.chess.model.FieldConstants.*;
import de.htwg.chess.Chess;

public final class PlayerTest extends TestCase {
	Chess chess;

	public void testNewPlayer() {
		chess = new Chess();
		// Player black = new Player("black", board);
		for (int i = 0; i < 8; i++)
			assertTrue(chess.getWhite().getPieceList().contains(chess.getChessboard()[i][TWO].getChesspiece()));
		for (int i = 0; i < 8; i++)
			for (int j = THREE; j <= EIGHT; j++)
				assertFalse(chess.getWhite().getPieceList().contains(chess.getChessboard()[i][j].getChesspiece()));
	}
}
