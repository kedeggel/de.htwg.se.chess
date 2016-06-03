package de.htwg.chess.model;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.Field;

public class FieldTest extends TestCase {
	Field pos;

	@Before
	public void setUp() {
		pos = new Field('A', 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testField() {
		new Field('I', 2);
	}

	@Test
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

	@Test
	public void testGetter() {
		assertTrue(pos.getX() == 'A');
		assertTrue(pos.getY() == 1);
	}

	@Test
	public void testSamePosition() {
		pos.setX('C');
		pos.setY(3);
		assertTrue((new Field('C', 3)).samePosition(pos));
	}

	@Test
	public void testToString() {
		pos.setPosition('B', 8);
		assertTrue(("B8").equals(pos.toString()));
	}
}
