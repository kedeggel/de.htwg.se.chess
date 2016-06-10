package de.htwg.chess.model;

import de.htwg.chess.model.impl.Field;
import de.htwg.chess.model.impl.Team.Color;

public interface IChessboard {

	ITeam getTeam(Color white);

	Field getField(int x, int y);

	String toSimpleString();

}
