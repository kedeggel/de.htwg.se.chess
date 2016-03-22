package de.htwg.chess.model;

public class TestMain {

	public static void main(String[] args) {
		
		Pawn pawn_w_1 = new Pawn("Pawn1", "white", new Position('A', 2));
		
		System.out.println(pawn_w_1);
		pawn_w_1.move('A', 3); //move ändert noch keine Werte an den Objekten
		System.out.println(pawn_w_1);
		
	}

}
