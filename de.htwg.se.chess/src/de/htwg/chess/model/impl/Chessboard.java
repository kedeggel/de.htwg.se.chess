package de.htwg.chess.model.impl;

import static de.htwg.chess.model.impl.Team.Color.*;

import de.htwg.chess.model.IChessboard;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.IFieldFactory;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.MoveCheckerVisitor;

/**
 * 
 * @author Sascha Nunes, Kevin Deggelmann (team 10)
 *
 */

public class Chessboard implements IChessboard {
	private IField[][] board;
	private ITeam[] teamlist;
	private MoveCheckerVisitor moveChecker;
	private IFieldFactory fieldFactory;

	public Chessboard() {
		moveChecker = new MoveChecker(this);
		fieldFactory = new FieldFactory();
		initChessboard();
		initTeamlist();

	}

	private void initChessboard() {
		board = new Field[8][8];
		for (char x = 'A'; x <= 'H'; x++) {
			for (int y = 1; y <= 8; y++) {
				board[x - 'A'][y - 1] = fieldFactory.createField(x, y);
			}
		}
	}

	private void initTeamlist() {
		teamlist = new Team[2];
		teamlist[WHITE.ordinal()] = new Team(WHITE, this, moveChecker);
		teamlist[BLACK.ordinal()] = new Team(BLACK, this, moveChecker);
	}

	@Override
	public IField getField(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7)
			return null;
		return board[x][y];
	}

	@Override
	public ITeam getTeam(Team.Color color) {
		return teamlist[color.ordinal()];
	}

	@Override
	public void updateTeams() {
		for (ITeam team : teamlist)
			team.updatePosMoves();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				sb.append(board[j][i] + ": " + board[j][i].getChesspiece() + "\n");
		return sb.toString();
	}

	@Override
	public String toSimpleString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (board[j][i].getChesspiece() != null)
					sb.append(board[j][i] + ": " + board[j][i].getChesspiece() + "\n");
		return sb.toString();
	}

}
