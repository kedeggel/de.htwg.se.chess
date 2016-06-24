package de.htwg.chess;

import org.junit.Test;
import junit.framework.TestCase;

public class ChessTest extends TestCase {
	@Test
	public void testMain() {
		Chess.main(new String[] { "a2-a3", "a7-a5", "b2-b4", "print", "printall", "ahsfl", "h" });
		assertEquals("\u2659", Chess.getInstance().getController().getSymboleByField('A', 3));
		assertEquals("\u2659", Chess.getInstance().getController().getSymboleByField('B', 4));
		assertEquals("\u265F", Chess.getInstance().getController().getSymboleByField('A', 5));
		Chess.main(new String[] { "r", "q" });
	}

	@Test
	public void testGetInstance() {
		Chess game = Chess.getInstance();
		assertNotNull(game);
		assertNotNull(game.getGui());
	}
}