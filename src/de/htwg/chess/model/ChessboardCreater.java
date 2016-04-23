package de.htwg.chess.model;

public class ChessboardCreater {
	private Position[][] chessboard;

	public ChessboardCreater() {
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
}
