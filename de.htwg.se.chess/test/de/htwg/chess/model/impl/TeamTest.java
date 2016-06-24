package de.htwg.chess.model.impl;

import junit.framework.TestCase;

import static de.htwg.chess.model.impl.FieldConstants.*;
import static de.htwg.chess.model.Color.*;
import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.impl.Chessboard;

public final class TeamTest extends TestCase {
	IChessboard chessboard;
	ITeam white;
	ITeam black;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
		white = chessboard.getTeam(WHITE);
		black = chessboard.getTeam(BLACK);
	}

	@Test
	public void testNewTeam() {
		for (int i = 0; i < 8; i++) {
			assertTrue(white.getPieceList().contains(chessboard.getField(i, ONE).getChesspiece()));
			assertTrue(white.getPieceList().contains(chessboard.getField(i, TWO).getChesspiece()));
		}
		for (int i = 0; i < 8; i++)
			for (int j = THREE; j <= EIGHT; j++)
				assertFalse(white.getPieceList().contains(chessboard.getField(i, j).getChesspiece()));

		for (int i = 0; i < 8; i++) {
			assertTrue(black.getPieceList().contains(chessboard.getField(i, EIGHT).getChesspiece()));
			assertTrue(black.getPieceList().contains(chessboard.getField(i, SEVEN).getChesspiece()));
		}
		for (int i = 0; i < 8; i++)
			for (int j = SIX; j >= ONE; j--)
				assertFalse(black.getPieceList().contains(chessboard.getField(i, j).getChesspiece()));
	}

	@Test
	public void testMove() {
		IChesspiece testpiece = chessboard.getField(A, TWO).getChesspiece();
		white.move(testpiece, chessboard.getField(A, THREE));
		assertTrue(testpiece.getField() == chessboard.getField(A, THREE));
		assertNull(chessboard.getField(A, TWO).getChesspiece());

		white.move(testpiece, chessboard.getField(A, TWO));
		assertTrue(testpiece.getField() == chessboard.getField(A, THREE));
		assertNull(chessboard.getField(A, TWO).getChesspiece());

		testpiece = chessboard.getField(A, SEVEN).getChesspiece();
		white.move(testpiece, chessboard.getField(A, SIX));
		assertTrue(testpiece.getField() == chessboard.getField(A, SEVEN));
		assertNull(chessboard.getField(A, SIX).getChesspiece());

		black.move(testpiece, chessboard.getField(A, SIX));
		assertTrue(testpiece.getField() == chessboard.getField(A, SIX));
		assertNull(chessboard.getField(A, SEVEN).getChesspiece());

		assertTrue(testpiece.getColor() == BLACK);

	}

}
