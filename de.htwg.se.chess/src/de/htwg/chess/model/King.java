package de.htwg.chess.model;

import de.htwg.chess.model.Team.Color;

public class King extends Chesspiece {
	private boolean isInCheck = false;

	public King(Color color, Field position) {
		super(color, position);
	}

	public boolean getIsInCheck() {
		return isInCheck;
	}

	public void setIsInCheck(boolean check) {
		isInCheck = check;
	}
	
	@Override
	public void checkPossibleMoves(MoveChecker mc) {
		// TODO Auto-generated method stub
		
	}

}
