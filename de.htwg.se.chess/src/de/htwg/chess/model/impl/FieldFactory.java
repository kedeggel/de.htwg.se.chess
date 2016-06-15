package de.htwg.chess.model.impl;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.IFieldFactory;

public class FieldFactory implements IFieldFactory {

	@Override
	public IField createField(char x, int y) {
		return new Field(x, y);
	}

}
