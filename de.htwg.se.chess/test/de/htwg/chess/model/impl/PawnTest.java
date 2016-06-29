package de.htwg.chess.model.impl;

import static de.htwg.chess.model.impl.FieldConstants.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.htwg.chess.model.Color;
import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	IChessboard chessboard;
	IChesspiece pawn_test;
	IChesspiece piece_friendly;
	IChesspiece piece_enemy;
	List<IField> checklist;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
		pawn_test = new Pawn(Color.WHITE, chessboard.getField(D, THREE));
		piece_friendly = new Pawn(Color.WHITE, chessboard.getField(C, FOUR));
		piece_enemy = new Pawn(Color.BLACK, chessboard.getField(E, FOUR));
		checklist = new LinkedList<>();
	}

	@Test
	public void testPossibleMoves() {
		/**
		 * A-E
		 *  X
		 */
		checklist.add(chessboard.getField(D, FOUR));
		checklist.add(chessboard.getField(E, FOUR));
		
		chessboard.getTeam(Color.WHITE).addChesspiece(pawn_test);
		chessboard.getTeam(Color.WHITE).addChesspiece(piece_friendly);
		chessboard.getTeam(Color.BLACK).addChesspiece(piece_enemy);

		assertTrue(checklist.containsAll(pawn_test.getPossibleMoves()));
		assertTrue(pawn_test.getPossibleMoves().containsAll(checklist));

		/**
		 * E-A
		 *  X
		 */
		piece_friendly.setField(chessboard.getField(E, FOUR));
		piece_enemy.setField(chessboard.getField(C, FOUR));
		checklist.add(chessboard.getField(C, FOUR));
		checklist.remove(chessboard.getField(E, FOUR));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(pawn_test.getPossibleMoves()));
		assertTrue(pawn_test.getPossibleMoves().containsAll(checklist));
		
		/**
		 * -EA
		 *  X
		 */
		piece_enemy.setField(chessboard.getField(D, FOUR));
		checklist.clear();

		chessboard.updateTeams();
		assertTrue(checklist.containsAll(pawn_test.getPossibleMoves()));
		assertTrue(pawn_test.getPossibleMoves().containsAll(checklist));
		
		/**
		 * EA-
		 *  X
		 */
		piece_enemy.setField(chessboard.getField(C, FOUR));
		piece_friendly.setField(chessboard.getField(D, FOUR));
		checklist.add(chessboard.getField(C, FOUR));

		chessboard.updateTeams();
		assertTrue(checklist.containsAll(pawn_test.getPossibleMoves()));
		assertTrue(pawn_test.getPossibleMoves().containsAll(checklist));

	}

	@Test
	public void testToSymbole() {
		assertTrue("\u2659".equals(new Pawn(Color.WHITE, chessboard.getField(3, 3)).toSymbole()));
		assertTrue("\u265F".equals(new Pawn(Color.BLACK, chessboard.getField(3, 3)).toSymbole()));
	}
	
}
