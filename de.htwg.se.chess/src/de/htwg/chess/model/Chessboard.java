package de.htwg.chess.model;

public class Chessboard {
	private Position[][] chessboard;
	
	public Chessboard() {
		chessboard = new Position[8][8];
		for (char x = 'A'; x <= 'H'; x++) {
			for (int y = 1; y <= 8; y++) {
				chessboard[x - 'A'][y - 1] = new Position(x, y);
			}
		}
	}

	public Position[][] getChessboard() {
		return chessboard;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				sb.append(chessboard[i][j] + ": " + chessboard[i][j].getChesspiece() + "\n");
		return sb.toString();
	}

}
