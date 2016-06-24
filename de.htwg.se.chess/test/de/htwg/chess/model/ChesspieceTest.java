package de.htwg.chess.model;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.impl.Chessboard;
import junit.framework.TestCase;

public class ChesspieceTest extends TestCase {
	IChessboard chessboard;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
	}

	@Test
	public void testGetterSetter() {
		IChesspiece cp = chessboard.getField(0, 1).getChesspiece();
		assertFalse(cp.getWasMoved());
		cp.move(chessboard.getField(0, 2));
		assertTrue(cp.getWasMoved());
		cp.setWasMoved(false);
		assertFalse(cp.getWasMoved());
	}
}
