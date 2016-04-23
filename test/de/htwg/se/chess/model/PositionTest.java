package de.htwg.se.chess.model;

import junit.framework.TestCase;
import de.htwg.chess.model.Position;

public class PositionTest extends TestCase {
	Position pos;

	public void setUp() {
		pos = new Position('A', 1);
	}

	public void testSetter() {
		for (char x = 'A'; x <= 'H'; x++) {
			for (int y = 1; y <= 8; y++) {
				assertTrue(pos.setPosition(x, y));
			}
		}
		for (char x = 'I'; x <= 'Z'; x++) {
			for (int y = 9; y <= 100; y++) {
				assertFalse(pos.setPosition(x, y));
			}
		}
		for (char x = 'A'; x <= 'H'; x++) {
			assertTrue(pos.setX(x));

		}
		for (int y = 1; y <= 8; y++) {
			assertTrue(pos.setY(y));
		}
	}

	public void testGetter() {
		pos.setX('C');
		pos.setY(3);
		assertTrue((new Position('C', 3)).samePosition(pos));
	}
	
	public void testToString() {
		pos.setPosition('B', 8);
		assertTrue(("B8").equals(pos.toString()));
	}
}
