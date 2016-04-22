package de.htwg.chess;

import java.util.LinkedList;
import java.util.List;

import de.htwg.chess.model.*;

public class TestMain {

	public static void main(String[] args) {
		Chess chess = new Chess();
		List<Chesspiece> list = new LinkedList<>(chess.getBlack().getPieceList());
		for (Chesspiece piece : list) {
			System.out.println(piece + ": ");
			for (Position pos : piece.possibleMoves())
				System.out.println("\t" + pos);
		}

		// Chesspiece rook_test = new Rook(chess.getWhite(),
		// chess.getChessboard()[D][FIVE], chess);
		// System.out.println(rook_test);
		// for (Position pos : rook_test.possibleMoves())
		// System.out.println(pos);
		// Chesspiece bishop_test = new Bishop(chess.getWhite(),
		// chess.getChessboard()[C][FOUR], chess);
		// System.out.println(bishop_test);
		// for (Position pos : bishop_test.possibleMoves())
		// System.out.println(pos);
		// for (int i = 0; i < 8; i++)
		// for (int j = 0; j < 8; j++)
		// System.out.println(board.getChessboard()[i][j]);
		// System.out.println(board);
		// System.out.println(white.getPieceList());

		/*
		 * Pawn pawn_w_1 = new Pawn("Pawn1", white,
		 * board.getChessboard()[A][ONE]);
		 * 
		 * for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++)
		 * System.out.println(board.getChessboard()[i][j]);
		 * System.out.println(board);
		 * 
		 * System.out.println(pawn_w_1); pawn_w_1.move(new Position('A', 3)); //
		 * move ändert noch keine Werte an // den Objekten
		 * System.out.println(pawn_w_1);
		 * 
		 * pawn_w_1.move(new Position('A', 2)); System.out.println(pawn_w_1);
		 * 
		 * private final static int A = 0; private final static int B = 1;
		 * private final static int C = 2; private final static int D = 3;
		 * private final static int E = 4; private final static int F = 5;
		 * private final static int G = 6; private final static int H = 7;
		 * private final static int ONE = 0; private final static int TWO = 1;
		 * private final static int THREE = 2; private final static int FOUR =
		 * 3; private final static int FIVE = 4; private final static int SIX =
		 * 5; private final static int SEVEN = 6; private final static int EIGHT
		 * = 7;
		 */

	}

}
