package de.htwg.chess.controller.impl;

import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.impl.Chessboard;
import de.htwg.util.observer.Observable;

import static de.htwg.chess.model.impl.Team.Color.*;

import de.htwg.chess.controller.IChessController;

public class ChessController extends Observable implements IChessController {
	private IChessboard board;
	private ITeam white;
	private ITeam black;
	private ITeam isOnTurn;
	private boolean[] isInCheck;
	private boolean checkmate;
	private String statusMessage;
	private boolean moveAccepted;

	public ChessController() {
		board = new Chessboard();
		white = board.getTeam(WHITE);
		black = board.getTeam(BLACK);
		isOnTurn = white;
		isInCheck = new boolean[2];
		setCheckmate(false);
	}

	@Override
	public void nextRound() {
		isOnTurn = board.getTeam(isOnTurn.opponent());
		notifyObservers();
	}

	@Override
	public void move(char startX, int startY, char targetX, int targetY) {
		IField start = board.getField(startX - 'A', startY - 1);
		if (start == null) {
			statusMessage = startX + "" + startY + " is not a valid position.\n";
			moveAccepted = false;
			notifyObservers();
			return;
		}
		IField target = board.getField(targetX - 'A', targetY - 1);
		if (target == null) {
			statusMessage = targetX + "" + targetY + " is not a valid position.\n";
			moveAccepted = false;
			notifyObservers();
			return;
		}
		IChesspiece cp = start.getChesspiece();
		IChesspiece pieceOnTarget = target.getChesspiece();
		if (isOnTurn == white) {
			if (!white.getPieceList().contains(cp)) {
				if (cp == null)
					statusMessage = "No chesspiece on " + start.toString() + ".\n";
				else
					statusMessage = cp.toString() + " is not one of white's chesspieces.\n";
				moveAccepted = false;
				notifyObservers();
				return;
			}
			white.move(cp, target);

		} else if (isOnTurn == black) {
			if (!black.getPieceList().contains(cp)) {
				if (cp == null)
					statusMessage = "No chesspiece on " + start.toString() + ".\n";
				else
					statusMessage = cp.toString() + " is not one of black's chesspieces.\n";
				moveAccepted = false;
				notifyObservers();
				return;
			}
			black.move(cp, target);
		}

		if (target.getChesspiece() == pieceOnTarget) {
			statusMessage = start.toString() + "-" + target.toString() + " is not a valid draw.\n";
			moveAccepted = false;
			notifyObservers();
			return;
		} else if (pieceOnTarget != null && pieceOnTarget.getField() == null) {
			board.getTeam(isOnTurn.opponent()).removeChesspiece(pieceOnTarget);
			statusMessage = cp.toString() + " hit " + pieceOnTarget.toString() + " on " + target.toString() + ".\n";
		} else
			statusMessage = cp.toString() + " moved to " + target.toString() + ".\n";

		checkCheck(isOnTurn);
		if (getIsInCheck(isOnTurn)) {
			cp.setField(start);
			if (pieceOnTarget != null) {
				pieceOnTarget.setField(target);
				board.getTeam(isOnTurn.opponent()).addChesspiece(pieceOnTarget);
			}
			moveAccepted = false;
			isInCheck[teamToInt(isOnTurn)] = false;
			return;
		}

		checkCheck(board.getTeam(isOnTurn.opponent()));
		moveAccepted = true;
		nextRound();
		notifyObservers();
	}

	private void checkCheck(ITeam toTest) {
		for (IChesspiece cp : board.getTeam(toTest.opponent()).getPieceList()) {
			boolean wasInCheck = getIsInCheck(toTest);
			boolean check = cp.getPossibleMoves().contains(toTest.getKing().getField());
			setCheck(toTest, check);
			if (check) {
				statusMessage = new String(statusMessage + "Check!");
				break;
			}
			if (wasInCheck) {
				statusMessage = new String(statusMessage + "Broke check ;) !");
			}
		}
	}

	@Override
	public void setCheck(ITeam team, boolean isCheck) {
		isInCheck[teamToInt(team)] = isCheck;
		notifyObservers();
	}

	@Override
	public void restart() {
		board = new Chessboard();
		white = board.getTeam(WHITE);
		black = board.getTeam(BLACK);
		isOnTurn = white;
		setCheckmate(false);
		isInCheck = new boolean[2];
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

	private int teamToInt(ITeam team) {
		return team.getColor().ordinal();
	}

	private boolean getIsInCheck(ITeam team) {
		return isInCheck[team.getColor().ordinal()];
	}

}
