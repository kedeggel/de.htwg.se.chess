package de.htwg.chess.model;

public class TestMain {

	public static void main(String[] args) {
		Chessboard board = new Chessboard();
		Player white = new Player("white");
		Player black = new Player("black");
		Pawn pawn_w_1 = new Pawn("Pawn1", white, board.getChessboard()[0][0]);

		// for (int i = 0; i < 8; i++)
		// for (int j = 0; j < 8; j++)
		// System.out.println(board.getChessboard()[i][j]);
		System.out.println(board);

		System.out.println(pawn_w_1);
		pawn_w_1.move(new Position('A', 3)); // move ändert noch keine Werte an
												// den Objekten
		System.out.println(pawn_w_1);

		pawn_w_1.move(new Position('A', 2));
		System.out.println(pawn_w_1);
	}

}
