package de.htwg.se.chess.model;

import junit.framework.TestCase;

import static de.htwg.chess.model.FieldConstants.*;

import de.htwg.chess.model.Chessboard;
import de.htwg.chess.model.Player;

public final class PlayerTest extends TestCase {

	public void testNewPlayer() {
		Chessboard board = new Chessboard();
		Player white = new Player("white", board);
		// Player black = new Player("black", board);
		for (int i = 0; i < 8; i++)
			assertTrue(white.getPieceList().contains(board.getChessboard()[i][TWO].getChesspiece()));
		for (int i = 0; i < 8; i++)
			for (int j = THREE; j <= EIGHT; j++)
				assertFalse(white.getPieceList().contains(board.getChessboard()[i][j].getChesspiece()));
	}
}
