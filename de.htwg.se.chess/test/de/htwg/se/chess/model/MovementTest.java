package de.htwg.se.chess.model;

import de.htwg.chess.Chess;
import de.htwg.chess.model.*;
import static de.htwg.chess.model.FieldConstants.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public final class MovementTest extends TestCase {
	public void testMove() {
		Chess chess = new Chess();
		Chesspiece rook_test = new Rook(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		assertTrue(rook_test.getPosition().toString().equals("D5"));
		// for (Position pos : rook_test.possibleMoves())
		// System.out.println(pos);

//		Chesspiece rook_test_enemy = new Rook(chess.getBlack(), chess.getChessboard()[][], chess)
		LinkedList<Position> list = new LinkedList<>(rook_test.possibleMoves());
		Chesspiece rook_test_right = new Rook(chess.getWhite(), chess.getChessboard()[F][FIVE], chess);
		LinkedList<Position> list2 = new LinkedList<>(rook_test.possibleMoves());
		Chesspiece rook3_test_enemy_right = new Rook(chess.getBlack(), chess.getChessboard()[F][FIVE], chess);
		LinkedList<Position> list3 = new LinkedList<>(rook_test.possibleMoves());
		
		Chesspiece rook_test_left = new Rook(chess.getWhite(), chess.getChessboard()[A][FIVE], chess);
		LinkedList<Position> list4 = new LinkedList<>(rook_test.possibleMoves());
		Chesspiece rook3_test_enemy_left = new Rook(chess.getBlack(), chess.getChessboard()[A][FIVE], chess);
		LinkedList<Position> list5 = new LinkedList<>(rook_test.possibleMoves());

	}
}
