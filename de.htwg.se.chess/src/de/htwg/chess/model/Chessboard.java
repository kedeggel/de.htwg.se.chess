package de.htwg.chess.model;


/**
 * 
 * @author Sascha Nunes, Kevin Deggelmann (team 10)
 *
 */

public class Chessboard {
	private Position[][] chessboard;
	private Player white;
	private Player black;

	public Chessboard() {
		chessboard = new ChessboardCreater().getChessboard();
	}

	
	public Position[][] getChessboard() {
		return chessboard;
	}

	public Player getWhite() {
		return white;
	}

	public Player getBlack() {
		return black;
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
