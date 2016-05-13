package de.htwg.chess.model;

import static de.htwg.chess.model.Team.Color.*;

/**
 * 
 * @author Sascha Nunes, Kevin Deggelmann (team 10)
 *
 */

public class Chessboard {
	private Field[][] chessboard;
	private Team white;
	private Team black;

	public Chessboard() {
		initChessboard();
		white = new Team(WHITE, this);
		black = new Team(BLACK, this);
	}

	private void initChessboard() {
		chessboard = new Field[8][8];
		for (char x = 'A'; x <= 'H'; x++) {
			for (int y = 1; y <= 8; y++) {
				chessboard[x - 'A'][y - 1] = new Field(x, y);
			}
		}
	}

	public Field getField(int x, int y) {
		return chessboard[x][y];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				sb.append(chessboard[i][j] + ": " + chessboard[i][j].getChesspiece() + "\n");
		return sb.toString();
	}

}
