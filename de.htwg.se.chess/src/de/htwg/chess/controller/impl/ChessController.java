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
	private StringBuilder statusMessage;

	public ChessController() {
		board = new Chessboard();
		white = board.getTeam(WHITE);
		black = board.getTeam(BLACK);
		isOnTurn = white;
		setCheckmate(false);
		isInCheckWhite = false;
		isInCheckBlack = false;
	}

	@Override
	public void nextRound() {
		isOnTurn = board.getTeam(isOnTurn.opponent());
		notifyObservers();
	}

	@Override
	public boolean move(char startX, int startY, char targetX, int targetY) {
		IField start = board.getField(startX - 'A', startY - 1);
		IField target = board.getField(targetX - 'A', targetY - 1);
		IChesspiece cp = start.getChesspiece();
		IChesspiece pieceOnTarget = target.getChesspiece();
		//String victim = pieceOnTarget.toString();
		if (isOnTurn == white) {
			if (!white.getPieceList().contains(cp)) {
//				statusMessage = new StringBuilder(cp.toString() + " is not one of white's chesspieces.\n");
				return false;
			}
			white.move(cp, target);
		} else if (isOnTurn == black) {
			if (!black.getPieceList().contains(cp)) {
//				statusMessage = new StringBuilder(cp.toString() + " is not one of black's chesspieces.\n");
				return false;
			}
			black.move(cp, target);
		}
		if (target.getChesspiece() == pieceOnTarget) {
			//statusMessage = new StringBuilder(start.toString() + "-" + target.toString() + " is not a valid draw.\n");
			return false;
		} else
			//statusMessage = new StringBuilder(cp.toString() + " hit " + victim + ".\n");
		checkCheck(board.getTeam(isOnTurn.opponent()));
		notifyObservers();
		return true;
	}

	private void checkCheck(ITeam toTest) {
		for (IChesspiece cp : board.getTeam(toTest.opponent()).getPieceList()) {
			boolean check = cp.getPossibleMoves().contains(toTest.getKing().getField());
			setCheck(toTest, check);
			//statusMessage.append("Check!\n");
		}
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
		board = new Chessboard();
		white = board.getTeam(WHITE);
		black = board.getTeam(BLACK);
		isOnTurn = white;
		setCheckmate(false);
		isInCheckWhite = false;
		isInCheckBlack = false;
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
	public boolean isCheckmate() {
		return checkmate;
	}

	@Override
	public ITeam whoIsOnTurn() {
		return isOnTurn;
	}

	public void setCheckmate(boolean checkmate) {
		this.checkmate = checkmate;
	}

	@Override
	public String printBoard() {
		return board.toSimpleString();
	}

	@Override
	public String printTotalBoard() {
		return board.toString();
	}

	@Override
	public String getStatusMessage() {
		return statusMessage.toString();
	}

}