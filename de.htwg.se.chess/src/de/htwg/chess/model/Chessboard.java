package de.htwg.chess.model;

/**
 * 
 * @author Sascha Nunes, Kevin Deggelmann (team 10)
 *
 */

public class Chessboard {
	private Field[][] chessboard;

	public Chessboard() {
		initChessboard();
	}

	private void initChessboard() {
		chessboard = new Field[8][8];
		for (char x = 'A'; x <= 'H'; x++) {
			for (int y = 1; y <= 8; y++) {
				chessboard[x - 'A'][y - 1] = new Field(x, y);
			}
		}
	}

	public Field[][] getChessboard() {
		return chessboard;
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
