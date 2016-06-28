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

public class KnightTest extends TestCase{
	IChessboard chessboard;
	IChesspiece knight_test;
	IChesspiece piece_friendly;
	IChesspiece piece_enemy;
	List<IField> checklist;
	
	@Before
	public void setUp() {
		chessboard = new Chessboard();
		knight_test = new Knight(Color.WHITE, chessboard.getField(D, FIVE));
		piece_friendly = new Pawn(Color.WHITE, chessboard.getField(F, FOUR));
		piece_enemy = new Pawn(Color.BLACK, chessboard.getField(F, SIX));
		checklist = new LinkedList<>();
	}
	
	@Test
	public void testPossibleMoves() {
		/**
		 * right up enemy, right down friendly
		 */
		checklist.add(chessboard.getField(B, SIX));
		checklist.add(chessboard.getField(C, SEVEN));
		checklist.add(chessboard.getField(E, SEVEN));
		checklist.add(chessboard.getField(F, SIX));
		checklist.add(chessboard.getField(E, THREE));
		checklist.add(chessboard.getField(C, THREE));
		checklist.add(chessboard.getField(B, FOUR));

		chessboard.getTeam(Color.WHITE).addChesspiece(knight_test);
		chessboard.getTeam(Color.WHITE).addChesspiece(piece_friendly);
		chessboard.getTeam(Color.BLACK).addChesspiece(piece_enemy);

		assertTrue(checklist.containsAll(knight_test.getPossibleMoves()));
		assertTrue(knight_test.getPossibleMoves().containsAll(checklist));
		
		/**
		 * down right enemy, down left friendly
		 */
		piece_friendly.setField(chessboard.getField(C, THREE));
		piece_enemy.setField(chessboard.getField(E, THREE));
		checklist.add(chessboard.getField(F, FOUR));
		checklist.remove(chessboard.getField(C, THREE));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(knight_test.getPossibleMoves()));
		assertTrue(knight_test.getPossibleMoves().containsAll(checklist));
		
		/**
		 * down double row of friendly, left board-border
		 */
		knight_test.setField(chessboard.getField(A, THREE));
		checklist.clear();
		checklist.add(chessboard.getField(B, FIVE));
		checklist.add(chessboard.getField(C, FOUR));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(knight_test.getPossibleMoves()));
		assertTrue(knight_test.getPossibleMoves().containsAll(checklist));
		
		/**
		 * up double row of enemy (jump-over), right board-border
		 */
		knight_test.setField(chessboard.getField(G, SIX));
		checklist.clear();
		checklist.add(chessboard.getField(H, EIGHT));
		checklist.add(chessboard.getField(F, EIGHT));
		checklist.add(chessboard.getField(E, SEVEN));
		checklist.add(chessboard.getField(E, FIVE));
		checklist.add(chessboard.getField(F, FOUR));
		checklist.add(chessboard.getField(H, FOUR));
		chessboard.updateTeams();
		assertTrue(checklist.containsAll(knight_test.getPossibleMoves()));
		assertTrue(knight_test.getPossibleMoves().containsAll(checklist));
	}
	
	@Test
	public void testToSymbole() {
		assertTrue("\u2658".equals(new Knight(Color.WHITE, chessboard.getField(3, 3)).toSymbole()));
		assertTrue("\u265E".equals(new Knight(Color.BLACK, chessboard.getField(3, 3)).toSymbole()));
	}
	
}
