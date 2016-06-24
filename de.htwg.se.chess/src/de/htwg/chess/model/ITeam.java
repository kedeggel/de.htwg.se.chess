package de.htwg.chess.model;

import java.util.List;


public interface ITeam {

	Color opponent();

	List<IChesspiece> getPieceList();

	void move(IChesspiece cp, IField target);

	IChesspiece getKing();

	Color getColor();

	void removeChesspiece(IChesspiece cp);

	void addChesspiece(IChesspiece cp);

	void updatePosMoves();

}
