package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String color;
	private List<? extends Chesspiece> pieceList;
	
	public Player(String color) {
		this.color = color;
		pieceList = new LinkedList<>();
		if(color.equals("white")) {
			Chesspiece pawn_w_1 = new Pawn("Pawn1", "white", new Position('A', 2));
			Chesspiece pawn_w_2 = new Pawn("Pawn2", "white", new Position('B', 2));
			Chesspiece pawn_w_3 = new Pawn("Pawn3", "white", new Position('C', 2));
			Chesspiece pawn_w_4 = new Pawn("Pawn4", "white", new Position('D', 2));
			Chesspiece pawn_w_5 = new Pawn("Pawn5", "white", new Position('E', 2));
			Chesspiece pawn_w_6 = new Pawn("Pawn6", "white", new Position('F', 2));
			Chesspiece pawn_w_7 = new Pawn("Pawn7", "white", new Position('G', 2));
			Chesspiece pawn_w_8 = new Pawn("Pawn8", "white", new Position('H', 2));											
		} else if(color.equals("black")) {
			Chesspiece pawn_b_1 = new Pawn("Pawn1", "black", new Position('A', 7));
			Chesspiece pawn_b_2 = new Pawn("Pawn2", "black", new Position('B', 7));
			Chesspiece pawn_b_3 = new Pawn("Pawn3", "black", new Position('C', 7));
			Chesspiece pawn_b_4 = new Pawn("Pawn4", "black", new Position('D', 7));
			Chesspiece pawn_b_5 = new Pawn("Pawn5", "black", new Position('E', 7));
			Chesspiece pawn_b_6 = new Pawn("Pawn6", "black", new Position('F', 7));
			Chesspiece pawn_b_7 = new Pawn("Pawn7", "black", new Position('G', 7));
			Chesspiece pawn_b_8 = new Pawn("Pawn8", "black", new Position('H', 7));								
		}
	}

}
