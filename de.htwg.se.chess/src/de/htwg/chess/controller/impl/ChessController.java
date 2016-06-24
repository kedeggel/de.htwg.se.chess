package de.htwg.chess.controller.impl;

import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.impl.Bishop;
import de.htwg.chess.model.impl.Chessboard;
import de.htwg.chess.model.impl.Knight;
import de.htwg.chess.model.impl.Pawn;
import de.htwg.chess.model.impl.Queen;
import de.htwg.chess.model.impl.Rook;
import de.htwg.util.observer.Observable;
import static de.htwg.chess.model.impl.Team.Color.*;
import de.htwg.chess.controller.ExitEvent;
import de.htwg.chess.controller.IChessController;

public class ChessController extends Observable implements IChessController {
	private IChessboard board;
	private ITeam isOnTurn;
	private boolean[] isInCheck;
	private boolean checkmate;
	private String statusMessage;
	private boolean readyToTransform;
	private IChesspiece cpToTranform;
	private boolean wasMoved;

	public ChessController() {
		board = new Chessboard();
		isOnTurn = board.getTeam(WHITE);
		isInCheck = new boolean[2];
		checkmate = false;
	}

	@Override
	public void nextRound() {
		isOnTurn = board.getTeam(isOnTurn.opponent());
	}

	@Override
	public void move(char startX, int startY, char targetX, int targetY) {
		wasMoved = false;
		IField start = board.getField(startX - 'A', startY - 1);
		IField target = board.getField(targetX - 'A', targetY - 1);
		if (!existsFields(start, target, startX, startY, targetX, targetY)) {
			return;
		}
		IChesspiece cp = start.getChesspiece();
		saveWasMoved(cp);
		IChesspiece pieceOnTarget = target.getChesspiece();

		if (!isOnTurn.getPieceList().contains(cp)) {
			fieldNotInPosMoves(cp, start);
			return;
		}
		isOnTurn.move(cp, target);

		if (target.getChesspiece() == pieceOnTarget) {
			statusMessage = start.toString() + "-" + target.toString() + " is not a valid draw.\n";
			notifyObservers();
			return;
		}
		moveOrHit(cp, pieceOnTarget, target);

		board.getTeam(isOnTurn.opponent()).updatePosMoves();
		checkCheck(isOnTurn);
		if (getIsInCheck(isOnTurn)) {
			reactionOnUnvalidMove(cp, start, pieceOnTarget, target);
			return;
		}
		isOnTurn.updatePosMoves();
		checkCheck(board.getTeam(isOnTurn.opponent()));
		checkForMate();
		reactionOnMate();

		checkForTranform(cp, target);
		nextRound();
		notifyObservers();
	}

	private boolean existsFields(IField start, IField target, char startX, int startY, char targetX, int targetY) {
		if (start == null) {
			statusMessage = startX + "" + startY + " is not a valid position.\n";
			notifyObservers();
			return false;
		}
		if (target == null) {
			statusMessage = targetX + "" + targetY + " is not a valid position.\n";
			notifyObservers();
			return false;
		}
		return true;
	}

	private void reactionOnMate() {
		if (checkmate) {
			statusMessage = whoIsOnTurn().toString() + " won :) ! " + whoIsOnTurn().opponent().toString()
					+ " lost :( !";
		}
	}

	private void saveWasMoved(IChesspiece cp) {
		if (cp != null) {
			wasMoved = cp.getWasMoved();
		}
	}

	private void moveOrHit(IChesspiece cp, IChesspiece pieceOnTarget, IField target) {
		if (pieceOnTarget != null && pieceOnTarget.getField() == null) {
			board.getTeam(isOnTurn.opponent()).removeChesspiece(pieceOnTarget);
			statusMessage = cp.toString() + " hit " + pieceOnTarget.toString() + " on " + target.toString() + ".\n";
		} else
			statusMessage = cp.toString() + " moved to " + target.toString() + ".\n";
	}

	private void checkForTranform(IChesspiece cp, IField target) {
		if (cp instanceof Pawn && (target.getY() == 8 || target.getY() == 1)) {
			readyToTransform = true;
			cpToTranform = cp;
			statusMessage = new String(
					statusMessage + "Insert: QUEEN, ROOK, BISHOP or KNIGHT to tranform pawn into this.\n");
			return;
		}
		readyToTransform = false;
	}

	private void checkCheck(ITeam toTest) {
		boolean wasInCheck = getIsInCheck(toTest);
		boolean check = false;
		for (IChesspiece cp : board.getTeam(toTest.opponent()).getPieceList()) {
			check = cp.getPossibleMoves().contains(toTest.getKing().getField());
			setCheck(toTest, check);
			if (check) {
				statusMessage = new String(statusMessage + " Check!");
				break;
			}
		}
		if (!check && wasInCheck) {
			statusMessage = new String(statusMessage + " Broke check ;) !");
		}
	}

	private void fieldNotInPosMoves(IChesspiece cp, IField start) {
		if (cp == null)
			statusMessage = "No chesspiece on " + start.toString() + ".\n";
		else
			statusMessage = cp.toString() + " is not one of " + isOnTurn.getColor() + "'s chesspieces.\n";
		notifyObservers();
	}

	private void reactionOnUnvalidMove(IChesspiece cp, IField start, IChesspiece pieceOnTarget, IField target) {
		cp.setField(start);
		if (pieceOnTarget != null) {
			pieceOnTarget.setField(target);
			board.getTeam(isOnTurn.opponent()).addChesspiece(pieceOnTarget);
		}
		cp.setWasMoved(wasMoved);
		isInCheck[teamToInt(isOnTurn)] = false;
		statusMessage = new String(
				start.toString() + "-" + target.toString() + " is not a valid draw (King were still in chess).\n");
		notifyObservers();
	}

	@Override
	public void setCheck(ITeam team, boolean isCheck) {
		isInCheck[teamToInt(team)] = isCheck;
	}

	@Override
	public void restart() {
		board = new Chessboard();
		isOnTurn = board.getTeam(WHITE);
		checkmate = false;
		isInCheck = new boolean[2];
		statusMessage = "";
		notifyObservers();
	}

	private void checkForMate() {
		if (!getIsInCheck(board.getTeam(isOnTurn.opponent())))
			return;
		ITeam toTest = board.getTeam(isOnTurn.opponent());
		for (IChesspiece cp : toTest.getPieceList()) {
			for (IField field : cp.getPossibleMoves()) {
				IField startfield = cp.getField();
				IChesspiece pieceOnTarget = field.getChesspiece();
				cp.setField(field);
				isOnTurn.removeChesspiece(pieceOnTarget);
				checkForThreat(toTest, cp, startfield);
				cp.setField(startfield);
				if (pieceOnTarget != null) {
					pieceOnTarget.setField(field);
					isOnTurn.addChesspiece(pieceOnTarget);
				}
				if (!checkmate)
					return;
			}
		}
	}

	private void checkForThreat(ITeam toTest, IChesspiece cp, IField startfield) {
		for (IChesspiece enemy : isOnTurn.getPieceList()) {
			if (enemy.getPossibleMoves().contains(toTest.getKing().getField())) {
				checkmate = true;
				cp.setField(startfield);
				break;
			}
			checkmate = false;
		}
	}

	@Override
	public void transformToQueen() {
		board.getTeam(cpToTranform.getColor()).removeChesspiece(cpToTranform);
		board.getTeam(cpToTranform.getColor())
				.addChesspiece(new Queen(cpToTranform.getColor(), cpToTranform.getField()));
		readyToTransform = false;
		statusMessage = "Pawn transformed to Queen";
		notifyObservers();
	}

	@Override
	public void transformToBishop() {
		board.getTeam(cpToTranform.getColor()).removeChesspiece(cpToTranform);
		board.getTeam(cpToTranform.getColor())
				.addChesspiece(new Bishop(cpToTranform.getColor(), cpToTranform.getField()));
		readyToTransform = false;
		statusMessage = "Pawn transformed to Bishop";
		notifyObservers();
	}

	@Override
	public void transformToRook() {
		board.getTeam(cpToTranform.getColor()).removeChesspiece(cpToTranform);
		board.getTeam(cpToTranform.getColor())
				.addChesspiece(new Rook(cpToTranform.getColor(), cpToTranform.getField()));
		readyToTransform = false;
		statusMessage = "Pawn transformed to Rook";
		notifyObservers();
	}

	@Override
	public void transformToKnight() {
		board.getTeam(cpToTranform.getColor()).removeChesspiece(cpToTranform);
		board.getTeam(cpToTranform.getColor())
				.addChesspiece(new Knight(cpToTranform.getColor(), cpToTranform.getField()));
		readyToTransform = false;
		statusMessage = "Pawn transformed to Knight";
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

	@Override
	public boolean isReadyToTransform() {
		return readyToTransform;
	}

	@Override
	public String getSymboleByField(char x, int y) {
		IChesspiece cp = board.getField(x - 'A', y - 1).getChesspiece();
		if (cp != null)
			return cp.toSymbole();
		return "";
	}

	@Override
	public void quit() {
		statusMessage = "Exit...";
		notifyObservers(new ExitEvent());
	}

}
