package de.htwg.chess.model;

public class TestMain {

	public static void main(String[] args) {
		Player white = new Player("white");
		Player black = new Player("black");
		Pawn pawn_w_1 = new Pawn("Pawn1", white, new Position('A', 2));

		System.out.println(pawn_w_1);
		pawn_w_1.move(new Position('A', 3)); // move �ndert noch keine Werte an
												// den Objekten
		System.out.println(pawn_w_1);

		pawn_w_1.move(new Position('A', 2));
		System.out.println(pawn_w_1);
	}

}
