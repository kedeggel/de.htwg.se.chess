package de.htwg.chess.controller.impl;

import org.junit.Before;
import org.junit.Test;
import de.htwg.chess.controller.IChessController;
import junit.framework.TestCase;

public class ChessControllerTest extends TestCase {
	IChessController controller;

	@Before
	public void setUp() {
		controller = new ChessController();
	}

	@Test
	public void testMove() {
		controller.move('I', 3, 'A', 5);
		assertTrue("I3 is not a valid position.\n".equals(controller.getStatusMessage()));
		controller.move('A', 3, 'I', 5);
		assertTrue("I5 is not a valid position.\n".equals(controller.getStatusMessage()));
		controller.move('A', 7, 'A', 6);
		assertTrue("Pawn BLACK is not one of WHITE's chesspieces.\n".equals(controller.getStatusMessage()));
		controller.move('A', 3, 'A', 5);
		assertTrue("No chesspiece on A3.\n".equals(controller.getStatusMessage()));
	}
	

}
