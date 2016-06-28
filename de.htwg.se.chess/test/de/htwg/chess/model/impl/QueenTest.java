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

public class QueenTest extends TestCase {
	IChessboard chessboard;
	IChesspiece queen_test;
	IChesspiece piece_friendly;
	IChesspiece piece_enemy;
	List<IField> checklist;

	@Before
	public void setUp() {
		chessboard = new Chessboard();
		queen_test = new Queen(Color.WHITE, chessboard.getField(D, FIVE));
		piece_friendly = new Pawn(Color.WHITE, chessboard.getField(G, FIVE));
		piece_enemy = new Pawn(Color.BLACK, chessboard.getField(B, FIVE));
		checklist = new LinkedList<>();
	}

	@Test
	public void testPossibleMoves() {
		/**
		 * right friendly, left enemy
		 */
		checklist.add(chessboard.getField(C, FIVE));
		checklist.add(chessboard.getField(B, FIVE));
		checklist.add(chessboard.getField(E, FIVE));
		checklist.add(chessboard.getField(F, FIVE));
		checklist.add(chessboard.getField(D, SIX));
		checklist.add(chessboard.getField(D, SEVEN));
		checklist.add(chessboard.getField(D, FOUR));
		checklist.add(chessboard.getField(D, THREE));
		checklist.add(chessboard.getField(C, SIX));
		checklist.add(chessboard.getField(B, SEVEN));
		checklist.add(chessboard.getField(E, FOUR));
		checklist.add(chessboard.getField(F, THREE));
		checklist.add(chessboard.getField(C, FOUR));
		checklist.add(chessboard.getField(B, THREE));
		checklist.add(chessboard.getField(E, SIX));
		checklist.add(chessboard.getField(F, SEVEN));
		chessboard.getTeam(Color.WHITE).addChesspiece(queen_test);
		chessboard.getTeam(Color.WHITE).addChesspiece(piece_friendly);
		chessboard.getTeam(Color.BLACK).addChesspiece(piece_enemy);

		assertTrue(checklist.containsAll(queen_test.getPossibleMoves()));

		/**
		 * left friendly, right enemy
		 */
		piece_friendly.setField(chessboard.getField(B, FIVE));
		piece_enemy.setField(chessboard.getField(G, FIVE));
		checklist.add(chessboard.getField(G, FIVE));
		checklist.remove(chessboard.getField(B, FIVE));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(queen_test.getPossibleMoves()));

		/**
		 * down enemy, up friendly
		 */
		piece_friendly.setField(chessboard.getField(D, SIX));
		piece_enemy.setField(chessboard.getField(D, THREE));
		checklist.add(chessboard.getField(A, FIVE));
		checklist.add(chessboard.getField(B, FIVE));
		checklist.add(chessboard.getField(H, FIVE));
		checklist.remove(chessboard.getField(D, SIX));
		checklist.remove(chessboard.getField(D, SEVEN));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(queen_test.getPossibleMoves()));
		assertTrue(chessboard.getField(A, ONE).getChesspiece().getPossibleMoves().isEmpty());
		assertTrue(chessboard.getField(A, EIGHT).getChesspiece().getPossibleMoves().isEmpty());

	}

	@Test
	public void testToSymbole() {
		assertTrue("\u2655".equals(new Queen(Color.WHITE, chessboard.getField(3, 3)).toSymbole()));
		assertTrue("\u265B".equals(new Queen(Color.BLACK, chessboard.getField(3, 3)).toSymbole()));
	}
	
}
