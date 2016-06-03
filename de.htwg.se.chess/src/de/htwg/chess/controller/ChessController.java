package de.htwg.chess.controller;

import java.util.Observable;
import de.htwg.chess.model.Chessboard;
import de.htwg.chess.model.Chesspiece;
import de.htwg.chess.model.Field;
import de.htwg.chess.model.Team;
import de.htwg.chess.model.Team.Color;

import static de.htwg.chess.model.Team.Color.*;

public class ChessController extends Observable {
	private Chessboard board;
	private Team white;
	private Team black;
	private Team isOnTurn;
	private boolean isInCheckWhite;
	private boolean isInCheckBlack;
	private boolean checkmate;

	public ChessController() {
		board = new Chessboard();
		white = board.getTeam(WHITE);
		black = board.getTeam(BLACK);
		isOnTurn = white;
		checkmate = false;
		isInCheckWhite = false;
		isInCheckBlack = false;
	}

	public void nextRound() {
		isOnTurn = board.getTeam(isOnTurn.opponent());
	}

	public boolean move(Field start, Field target) {
		Chesspiece cp = start.getChesspiece();
		if (isOnTurn == white) {
			if (!white.getPieceList().contains(cp))
				return false;
			white.move(cp, target);
		} else if (isOnTurn == black) {

		}
		return false;
	}

	public void checkCheck(Team toTest) {
		for (Chesspiece cp : board.getTeam(toTest.opponent()).getPieceList()) {
			boolean check = cp.getPossibleMoves().contains(toTest.getKing().getField());
			toTest.getKing().setIsInCheck(check);
			setCheck(toTest, check);
		}
	}
	
	public void setCheck(Team team, boolean isInCheck) {
		if (team == white)
			isInCheckWhite = isInCheck;
		else if (team == black)
			isInCheckBlack = isInCheck;
	}

}
