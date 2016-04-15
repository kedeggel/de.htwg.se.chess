package de.htwg.chess.model;

import static de.htwg.chess.model.FieldConstants.*;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.Chess;


public class Player {
	private String color;
	private Chess chess;
	private List<Chesspiece> pieceList;

	public Player(String color, Chess chess) {
		this.color = color;
		Position[][] board_matrix = chess.getChessboard();
		pieceList = new LinkedList<>();
		if (color.equals("white")) {
			Chesspiece pawn_w_1 = new Pawn("Pawn1", this, board_matrix[A][TWO], chess);
			Chesspiece pawn_w_2 = new Pawn("Pawn2", this, board_matrix[B][TWO], chess);
			Chesspiece pawn_w_3 = new Pawn("Pawn3", this, board_matrix[C][TWO], chess);
			Chesspiece pawn_w_4 = new Pawn("Pawn4", this, board_matrix[D][TWO], chess);
			Chesspiece pawn_w_5 = new Pawn("Pawn5", this, board_matrix[E][TWO], chess);
			Chesspiece pawn_w_6 = new Pawn("Pawn6", this, board_matrix[F][TWO], chess);
			Chesspiece pawn_w_7 = new Pawn("Pawn7", this, board_matrix[G][TWO], chess);
			Chesspiece pawn_w_8 = new Pawn("Pawn8", this, board_matrix[H][TWO], chess);
			Chesspiece rook_w_1 = new Rook("Rook1", this, board_matrix[A][ONE], chess);
			Chesspiece rook_w_2 = new Rook("Rook2", this, board_matrix[H][ONE], chess);

			pieceList.add(pawn_w_1);
			pieceList.add(pawn_w_2);
			pieceList.add(pawn_w_3);
			pieceList.add(pawn_w_4);
			pieceList.add(pawn_w_5);
			pieceList.add(pawn_w_6);
			pieceList.add(pawn_w_7);
			pieceList.add(pawn_w_8);
			pieceList.add(rook_w_1);
			pieceList.add(rook_w_2);
		} else if (color.equals("black")) {
			Chesspiece pawn_b_1 = new Pawn("Pawn1", this, board_matrix[A][SEVEN], chess);
			Chesspiece pawn_b_2 = new Pawn("Pawn2", this, board_matrix[B][SEVEN], chess);
			Chesspiece pawn_b_3 = new Pawn("Pawn3", this, board_matrix[C][SEVEN], chess);
			Chesspiece pawn_b_4 = new Pawn("Pawn4", this, board_matrix[D][SEVEN], chess);
			Chesspiece pawn_b_5 = new Pawn("Pawn5", this, board_matrix[E][SEVEN], chess);
			Chesspiece pawn_b_6 = new Pawn("Pawn6", this, board_matrix[F][SEVEN], chess);
			Chesspiece pawn_b_7 = new Pawn("Pawn7", this, board_matrix[G][SEVEN], chess);
			Chesspiece pawn_b_8 = new Pawn("Pawn8", this, board_matrix[H][SEVEN], chess);
			Chesspiece rook_b_1 = new Rook("Rook1", this, board_matrix[A][EIGHT], chess);
			Chesspiece rook_b_2 = new Rook("Rook2", this, board_matrix[H][EIGHT], chess);

			pieceList.add(pawn_b_1);
			pieceList.add(pawn_b_2);
			pieceList.add(pawn_b_3);
			pieceList.add(pawn_b_4);
			pieceList.add(pawn_b_5);
			pieceList.add(pawn_b_6);
			pieceList.add(pawn_b_7);
			pieceList.add(pawn_b_8);
			pieceList.add(rook_b_1);
			pieceList.add(rook_b_2);
		}

	}

	public List<? extends Chesspiece> getPieceList() {
		return pieceList;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
