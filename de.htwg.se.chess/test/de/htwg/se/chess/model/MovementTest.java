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
		rook_test.possibleMoves();

		// right
		Chesspiece rook_1 = new Rook(chess.getWhite(), chess.getChessboard()[F][FIVE], chess);
		rook_test.possibleMoves();
		Chesspiece rook_enemy_1 = new Rook(chess.getBlack(), chess.getChessboard()[F][FIVE], chess);
		rook_test.possibleMoves();
		// left
		rook_1.setPosition(chess.getChessboard()[A][FIVE]);
		rook_test.possibleMoves();
		rook_enemy_1.setPosition(chess.getChessboard()[A][FIVE]);
		rook_test.possibleMoves();

		//up
		rook_test.setPosition(chess.getChessboard()[D][EIGHT]);
		rook_test.possibleMoves();
		rook_test.setPosition(chess.getChessboard()[D][FIVE]);
		rook_1.setPosition(chess.getChessboard()[D][SIX]);
		rook_test.possibleMoves();
		//down
		rook_test.setPosition(chess.getChessboard()[D][ONE]);
		rook_test.possibleMoves();
		
		
		Chesspiece bishop_test = new Bishop(chess.getWhite(), chess.getChessboard()[D][FIVE], chess);
		bishop_test.possibleMoves();
		//rook_1.setPosition(chess.getChessboard()[C][SIX]);
		//rook_enemy_1.setPosition(chess.getChessboard()[E][SIX]);
		
		
		LinkedList<Position> poslist= new LinkedList<>();
		poslist.add(chess.getChessboard()[A][EIGHT]);
		poslist.add(chess.getChessboard()[H][EIGHT]);
		poslist.add(chess.getChessboard()[A][ONE]);
		poslist.add(chess.getChessboard()[H][ONE]);
		
		for(Position pos : poslist) {
			bishop_test.setPosition(pos);
			bishop_test.possibleMoves();
		}
		
		for(Position pos : poslist) {
			bishop_test.setPosition(pos);
			bishop_test.possibleMoves();
		}
		
	}
}
