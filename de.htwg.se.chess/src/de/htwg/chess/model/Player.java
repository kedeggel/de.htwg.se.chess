package de.htwg.chess.model;

import static de.htwg.chess.model.FieldConstants.*;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String color;
	private Position[][] board;
	private List<Chesspiece> pieceList;

	public Player(String color, Chessboard chessboard) {
		this.color = color;
		this.board = chessboard.getChessboard();
		pieceList = new LinkedList<>();
		if (color.equals("white")) {
			Chesspiece pawn_w_1 = new Pawn("Pawn1", this, board[A][TWO]);
			Chesspiece pawn_w_2 = new Pawn("Pawn2", this, board[B][TWO]);
			Chesspiece pawn_w_3 = new Pawn("Pawn3", this, board[C][TWO]);
			Chesspiece pawn_w_4 = new Pawn("Pawn4", this, board[D][TWO]);
			Chesspiece pawn_w_5 = new Pawn("Pawn5", this, board[E][TWO]);
			Chesspiece pawn_w_6 = new Pawn("Pawn6", this, board[F][TWO]);
			Chesspiece pawn_w_7 = new Pawn("Pawn7", this, board[G][TWO]);
			Chesspiece pawn_w_8 = new Pawn("Pawn8", this, board[H][TWO]);
			Chesspiece rook_w_1 = new Rook("Rook1", this, board[A][ONE]);
			Chesspiece rook_w_2 = new Rook("Rook2", this, board[H][ONE]);

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
			Chesspiece pawn_b_1 = new Pawn("Pawn1", this, board[A][SEVEN]);
			Chesspiece pawn_b_2 = new Pawn("Pawn2", this, board[B][SEVEN]);
			Chesspiece pawn_b_3 = new Pawn("Pawn3", this, board[C][SEVEN]);
			Chesspiece pawn_b_4 = new Pawn("Pawn4", this, board[D][SEVEN]);
			Chesspiece pawn_b_5 = new Pawn("Pawn5", this, board[E][SEVEN]);
			Chesspiece pawn_b_6 = new Pawn("Pawn6", this, board[F][SEVEN]);
			Chesspiece pawn_b_7 = new Pawn("Pawn7", this, board[G][SEVEN]);
			Chesspiece pawn_b_8 = new Pawn("Pawn8", this, board[H][SEVEN]);
			Chesspiece rook_b_1 = new Rook("Rook1", this, board[A][EIGHT]);
			Chesspiece rook_b_2 = new Rook("Rook2", this, board[H][EIGHT]);
			
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
