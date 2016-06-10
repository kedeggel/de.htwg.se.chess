package de.htwg.chess.controller;

import de.htwg.chess.model.IField;
import de.htwg.chess.model.ITeam;
import de.htwg.chess.model.impl.Field;
import de.htwg.chess.model.impl.Team;
import de.htwg.util.observer.IObservable;

public interface IChessController extends IObservable {

	void nextRound();

	boolean move(IField start, IField target);

	void checkCheck(ITeam toTest);

	void setCheck(ITeam team, boolean isInCheck);

	void restart();

	void tranformToQueen();

	void tranformToRook();

	void tranformToBishop();

	void tranformToKnight();

}
