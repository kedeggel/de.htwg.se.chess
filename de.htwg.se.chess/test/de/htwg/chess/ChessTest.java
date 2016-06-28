package de.htwg.chess;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class ChessTest extends TestCase {
	String[] fastmate = { "e2-e3", "f7-f6", "f2-f4", "g7-g5", "d1-h5" };
	String[] transformToQueen = { "d2-a7", "d2-d4", "e7-e5", "d4-e5", "e8-e7", "e5-e6", "e7-d6", "e7-f6", "e6-e7",
			"d8-d7", "d7-d5", "e7-e8", "queen" };
	String[] transformToRook = { "d2-d4", "e7-e5", "d4-e5", "e8-e7", "e5-e6", "e7-d6", "e7-f6", "e6-e7", "d8-d7",
			"d7-d5", "e7-e8", "rook" };
	String[] transformToKnight = { "d2-d4", "e7-e5", "d4-e5", "e8-e7", "e5-e6", "e7-d6", "e7-f6", "e6-e7", "d8-d7",
			"d7-d5", "e7-e8", "knight" };
	String[] transformToBishop = { "d2-d4", "e7-e5", "d4-e5", "e8-e7", "e5-e6", "e7-d6", "e7-f6", "e6-e7", "d8-d7",
			"d7-d5", "e7-e8", "bish", "bishop" };
	String[] check = { "c2-c3", "d7-d6", "d1-a4", "c7-c6" };

	@Before
	public void setUp() {
		Chess.getInstance().getGui().disableGUI();
	}

	@Test
	public void testMain() {
		Chess.main(fastmate);
		 restart();
		 Chess.main(transformToQueen);
		 restart();
		 Chess.main(transformToRook);
		 restart();
		 Chess.main(transformToKnight);
		 restart();
		 Chess.main(transformToBishop);
		 restart();
		 Chess.main(check);
		 restart();
		 Chess.main(new String[] { "a2-a3", "a7-a5", "b2-b4", "print",
		 "printall", "ahsfl", "h" });
		 assertEquals("\u2659",
		 Chess.getInstance().getController().getSymboleByField('A', 3));
		 assertEquals("\u2659",
		 Chess.getInstance().getController().getSymboleByField('B', 4));
		 assertEquals("\u265F",
		 Chess.getInstance().getController().getSymboleByField('A', 5));
		 Chess.main(new String[] { "r", "q" });
	}

	@Test
	public void testGetInstance() {
		Chess game = Chess.getInstance();
		assertNotNull(game);
		assertNotNull(game.getGui());
	}

	private void restart() {
		Chess.main(new String[] { "r" });
	}
}