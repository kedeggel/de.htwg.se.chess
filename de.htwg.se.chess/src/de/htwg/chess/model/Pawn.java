package de.htwg.chess.model;

import java.util.LinkedList;
import java.util.List;

public class Pawn extends Chesspiece {

	public Pawn(String name, Player player, Position position) {
		super(name, player, position);
	}

	@Override
	public List<Position> possibleMoves() {
		List<Position> listPossibleMoves = new LinkedList<>(); //to return at end
		
		if (getColor().equals("white")) {
			Position up_1 = new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
			List<Position> listMoves = new LinkedList<>();
			listMoves.add(up_1);
			if (drawCount == 0) {
				Position up_2 = new Position(this.getPosition().getX(), this.getPosition().getY() + 2);
				listMoves.add(up_2);
			}
			for (Position myposition : listMoves) {
				for (Chesspiece piece : player.getPieceList()) {
					if (piece.getPosition().equals(myposition)) {
						
					}
				}
			}
		}
		return listPossibleMoves;
	}

}
