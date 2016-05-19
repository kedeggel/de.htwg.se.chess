package de.htwg.chess.model;

import static de.htwg.chess.model.FieldConstants.*;
import java.util.LinkedList;
import java.util.List;

public class Team {
	public enum Color {
		WHITE, BLACK
	}

	private Color color;
	private List<Chesspiece> pieceList;
	private Chessboard chessboard;
	private MoveChecker mc;
	private King king;

	public Team(Color color, Chessboard chessboard, MoveChecker mc) {
		this.chessboard = chessboard;
		this.color = color;
		this.mc = mc;
		pieceList = new LinkedList<>();
		switch (color) {
		case WHITE:
			backRowInit(Color.WHITE, ONE);
			pawnRowInit(Color.WHITE, TWO);
			break;

		case BLACK:
			backRowInit(Color.WHITE, EIGHT);
			pawnRowInit(Color.WHITE, SEVEN);
			break;
		}
		updatePosMoves();
	}

	private void pawnRowInit(Color c, int y) {
		for (int x = A; x <= H; x++)
			pieceList.add(new Pawn(color, chessboard.getField(x, y)));
	}

	private void backRowInit(Color c, int y) {
		pieceList.add(new Rook(color, chessboard.getField(A, y)));
		pieceList.add(new Knight(color, chessboard.getField(B, y)));
		pieceList.add(new Bishop(color, chessboard.getField(C, y)));
		pieceList.add(new Queen(color, chessboard.getField(D, y)));
		king = new King(color, chessboard.getField(E, y));
		pieceList.add(king);
		pieceList.add(new Bishop(color, chessboard.getField(F, y)));
		pieceList.add(new Knight(color, chessboard.getField(G, y)));
		pieceList.add(new Rook(color, chessboard.getField(H, y)));
	}

	public void move(Chesspiece cp, Field target) {
		if (pieceList.contains(cp)) {
			updatePosMoves();
			cp.move(target);
			updatePosMoves();
		}
	}

	public List<Chesspiece> getPieceList() {
		return pieceList;
	}

	public Color getColor() {
		return color;
	}

	public void updatePosMoves() {
		for (Chesspiece piece : pieceList)
			piece.checkPossibleMoves(mc);
	}

	public void addChesspiece(Chesspiece cp) {
		pieceList.add(cp);
		updatePosMoves();
	}

	public King getKing() {
		return king;
	}

	@Override
	public String toString() {
		return color.toString();
	}

}