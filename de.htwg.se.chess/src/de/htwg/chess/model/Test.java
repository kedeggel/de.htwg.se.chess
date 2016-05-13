package de.htwg.chess.model;

import static de.htwg.chess.model.FieldConstants.B;
import static de.htwg.chess.model.FieldConstants.C;
import static de.htwg.chess.model.FieldConstants.D;
import static de.htwg.chess.model.FieldConstants.E;
import static de.htwg.chess.model.FieldConstants.F;
import static de.htwg.chess.model.FieldConstants.FIVE;
import static de.htwg.chess.model.FieldConstants.FOUR;
import static de.htwg.chess.model.FieldConstants.G;
import static de.htwg.chess.model.FieldConstants.SEVEN;
import static de.htwg.chess.model.FieldConstants.SIX;
import static de.htwg.chess.model.FieldConstants.THREE;

import java.util.LinkedList;
import java.util.List;


import de.htwg.chess.model.Team.Color;

public class Test {

	public static void main(String[] args) {
		Chessboard chessboard;
		Chesspiece rook_test;
		Chesspiece piece_friendly;
		Chesspiece piece_enemy;
		List<Field> checklist;

			chessboard = new Chessboard();
			rook_test = new Rook(Color.WHITE, chessboard.getField(D, FIVE));
			piece_friendly = new Pawn(Color.WHITE, chessboard.getField(G, FIVE));
			piece_enemy = new Pawn(Color.BLACK, chessboard.getField(B, FIVE));
			checklist = new LinkedList<>();

			/**
			 * right friendly, left enemy
			 */
			checklist.add(chessboard.getField( C ,FIVE));
			checklist.add(chessboard.getField( B ,FIVE));
			checklist.add(chessboard.getField(E ,FIVE));
			checklist.add(chessboard.getField(F ,FIVE));
			checklist.add(chessboard.getField(D ,SIX));
			checklist.add(chessboard.getField(D ,SEVEN));
			checklist.add(chessboard.getField(D ,FOUR));
			checklist.add(chessboard.getField(D ,THREE));

	}

}