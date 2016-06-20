package de.htwg.chess.model;

import org.junit.Test;

import de.htwg.chess.model.impl.Field;

public class FieldExceptionTest {
	@Test(expected = IllegalArgumentException.class)
	public void testField() {
		new Field('I', 2);
	}
}
