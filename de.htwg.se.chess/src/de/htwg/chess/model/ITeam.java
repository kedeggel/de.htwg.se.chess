package de.htwg.chess.model;

import java.util.List;

import de.htwg.chess.model.impl.Team.Color;

public interface ITeam {

	Color opponent();

	List<IChesspiece> getPieceList();

	void move(IChesspiece cp, IField target);

	IChesspiece getKing();


}
