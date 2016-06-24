package de.htwg.chess.model;


public interface IChessboard {

	ITeam getTeam(Color white);

	IField getField(int x, int y);

	String toSimpleString();

	void updateTeams();

}
