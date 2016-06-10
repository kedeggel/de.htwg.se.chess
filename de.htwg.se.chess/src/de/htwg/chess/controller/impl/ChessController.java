package de.htwg.chess.controller.impl;

import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.impl.Chessboard;
import de.htwg.chess.model.impl.Chesspiece;
import de.htwg.chess.model.impl.Field;
import de.htwg.chess.model.impl.Team;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Observable;

import static de.htwg.chess.model.impl.Team.Color.*;

import de.htwg.chess.controller.IChessController;

public class ChessController extends Observable implements IChessController {
	private IChessboard board;
	private ITeam white;
	private ITeam black;
	private ITeam isOnTurn;
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

	@Override
	public void nextRound() {
		isOnTurn = board.getTeam(isOnTurn.opponent());
		notifyObservers();
	}

	@Override
	public boolean move(IField start, IField target) {
		Chesspiece cp = start.getChesspiece();
		if (isOnTurn == white) {
			if (!white.getPieceList().contains(cp))
				return false;
			white.move(cp, target);
		} else if (isOnTurn == black) {
			if (!black.getPieceList().contains(cp))
				return false;
			black.move(cp, target);
		}
		notifyObservers();
		return true;
	}

	@Override
	public void checkCheck(ITeam toTest) {
		for (IChesspiece cp : board.getTeam(toTest.opponent()).getPieceList()) {
			boolean check = cp.getPossibleMoves().contains(toTest.getKing().getField());
			setCheck(toTest, check);
		}
		notifyObservers();
	}

	@Override
	public void setCheck(ITeam team, boolean isInCheck) {
		if (team == white)
			isInCheckWhite = isInCheck;
		else if (team == black)
			isInCheckBlack = isInCheck;
		notifyObservers();
	}

	@Override
	public void restart() {
		notifyObservers();
	}

	@Override
	public void tranformToQueen() {
		notifyObservers();
	}

	@Override
	public void tranformToBishop() {
		notifyObservers();
	}

	@Override
	public void tranformToRook() {
		notifyObservers();
	}

	@Override
	public void tranformToKnight() {
		notifyObservers();
	}

	@Override
	public void addObserver(IObserver s) {
		// TODO Auto-generated method stub
		
	}


}
