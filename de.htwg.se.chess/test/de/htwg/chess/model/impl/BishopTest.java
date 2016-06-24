package de.htwg.chess.model.impl;

import static de.htwg.chess.model.impl.FieldConstants.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import org.junit.Test;

import de.htwg.chess.model.impl.Chessboard;
import de.htwg.chess.model.impl.Pawn;
import de.htwg.chess.model.Color;
import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.impl.Bishop;
import junit.framework.TestCase;

public class BishopTest extends TestCase {
	IChessboard chessboard;
	IChesspiece bishop_test;
	IChesspiece piece_friendly;
	IChesspiece piece_enemy;
	List<IField> checklist;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
		bishop_test = new Bishop(Color.WHITE, chessboard.getField(C, FOUR));
		piece_friendly = new Pawn(Color.WHITE, chessboard.getField(E, THREE));
		piece_enemy = new Pawn(Color.BLACK, chessboard.getField(E, SIX));
		checklist = new LinkedList<>();
	}

	@Test
	public void testPossibleMoves() {
		checklist.add(chessboard.getField(B, THREE));
		checklist.add(chessboard.getField(B, FIVE));
		checklist.add(chessboard.getField(A, SIX));
		checklist.add(chessboard.getField(D, THREE));
		checklist.add(chessboard.getField(D, FIVE));
		checklist.add(chessboard.getField(E, SIX));
		chessboard.getTeam(Color.WHITE).addChesspiece(bishop_test);
		chessboard.getTeam(Color.WHITE).addChesspiece(piece_friendly);
		chessboard.getTeam(Color.BLACK).addChesspiece(piece_enemy);
		assertTrue(checklist.containsAll(bishop_test.getPossibleMoves())
				&& bishop_test.getPossibleMoves().containsAll(checklist));

		bishop_test.setField(chessboard.getField(B, EIGHT));
		checklist = new LinkedList<>();
		checklist.add(chessboard.getField(A, SEVEN));
		checklist.add(chessboard.getField(C, SEVEN));
		chessboard.getTeam(Color.WHITE).updatePosMoves();
		assertTrue(checklist.containsAll(bishop_test.getPossibleMoves())
				&& bishop_test.getPossibleMoves().containsAll(checklist));
	}
}
