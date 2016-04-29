package de.htwg.chess.model;

import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.Chess;

public class Player {
	private String color;
	private List<Chesspiece> pieceList;

	public Player(String color, Chess chess) {
		this.color = color;
		Position[][] boardMatrix = chess.getChessboard();
		pieceList = new LinkedList<>();
		if ("white".equals(color)) {
			Chesspiece pawnW1 = new Pawn(this, boardMatrix[A][TWO], chess);
			Chesspiece pawnW2 = new Pawn(this, boardMatrix[B][TWO], chess);
			Chesspiece pawnW3 = new Pawn(this, boardMatrix[C][TWO], chess);
			Chesspiece pawnW4 = new Pawn(this, boardMatrix[D][TWO], chess);
			Chesspiece pawnW5 = new Pawn(this, boardMatrix[E][TWO], chess);
			Chesspiece pawnW6 = new Pawn(this, boardMatrix[F][TWO], chess);
			Chesspiece pawnW7 = new Pawn(this, boardMatrix[G][TWO], chess);
			Chesspiece pawnW8 = new Pawn(this, boardMatrix[H][TWO], chess);
			Chesspiece rookW1 = new Rook(this, boardMatrix[A][ONE], chess);
			Chesspiece knightW1 = new Knight(this, boardMatrix[B][ONE], chess);
			Chesspiece bishopW1 = new Bishop(this, boardMatrix[C][ONE], chess);
			Chesspiece queenW = new Queen(this, boardMatrix[D][ONE], chess);
			Chesspiece kingW = new King(this, boardMatrix[E][ONE], chess);
			Chesspiece bishopW2 = new Bishop(this, boardMatrix[F][ONE], chess);
			Chesspiece knightW2 = new Knight(this, boardMatrix[G][ONE], chess);
			Chesspiece rookW2 = new Rook(this, boardMatrix[H][ONE], chess);

			pieceList.add(pawnW1);
			pieceList.add(pawnW2);
			pieceList.add(pawnW3);
			pieceList.add(pawnW4);
			pieceList.add(pawnW5);
			pieceList.add(pawnW6);
			pieceList.add(pawnW7);
			pieceList.add(pawnW8);
			pieceList.add(rookW1);
			pieceList.add(knightW1);
			pieceList.add(bishopW1);
			pieceList.add(queenW);
			pieceList.add(kingW);
			pieceList.add(bishopW2);
			pieceList.add(knightW2);
			pieceList.add(rookW2);
		} else if ("black".equals(color)) {
			Chesspiece pawnB1 = new Pawn(this, boardMatrix[A][SEVEN], chess);
			Chesspiece pawnB2 = new Pawn(this, boardMatrix[B][SEVEN], chess);
			Chesspiece pawnB3 = new Pawn(this, boardMatrix[C][SEVEN], chess);
			Chesspiece pawnB4 = new Pawn(this, boardMatrix[D][SEVEN], chess);
			Chesspiece pawnB5 = new Pawn(this, boardMatrix[E][SEVEN], chess);
			Chesspiece pawnB6 = new Pawn(this, boardMatrix[F][SEVEN], chess);
			Chesspiece pawnB7 = new Pawn(this, boardMatrix[G][SEVEN], chess);
			Chesspiece pawnB8 = new Pawn(this, boardMatrix[H][SEVEN], chess);
			Chesspiece rookB1 = new Rook(this, boardMatrix[A][EIGHT], chess);
			Chesspiece knightB1 = new Knight(this, boardMatrix[B][EIGHT], chess);
			Chesspiece bishopB1 = new Bishop(this, boardMatrix[C][EIGHT], chess);
			Chesspiece queenB = new Queen(this, boardMatrix[D][EIGHT], chess);
			Chesspiece kingB = new King(this, boardMatrix[E][EIGHT], chess);
			Chesspiece bishopB2 = new Bishop(this, boardMatrix[F][EIGHT], chess);
			Chesspiece knightB2 = new Knight(this, boardMatrix[G][EIGHT], chess);
			Chesspiece rookB2 = new Rook(this, boardMatrix[H][EIGHT], chess);

			pieceList.add(pawnB1);
			pieceList.add(pawnB2);
			pieceList.add(pawnB3);
			pieceList.add(pawnB4);
			pieceList.add(pawnB5);
			pieceList.add(pawnB6);
			pieceList.add(pawnB7);
			pieceList.add(pawnB8);
			pieceList.add(rookB1);
			pieceList.add(knightB1);
			pieceList.add(bishopB1);
			pieceList.add(queenB);
			pieceList.add(kingB);
			pieceList.add(bishopB2);
			pieceList.add(knightB2);
			pieceList.add(rookB2);
		}

	}

	public List<Chesspiece> getPieceList() {
		return pieceList;
	}

	public String getColor() {
		return color;
	}

}
