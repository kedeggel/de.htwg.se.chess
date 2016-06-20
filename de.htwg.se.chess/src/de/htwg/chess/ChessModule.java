package de.htwg.chess;

import com.google.inject.AbstractModule;
import de.htwg.chess.controller.IChessController;

public class ChessModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IChessController.class).to(de.htwg.chess.controller.impl.ChessController.class);
	}

}
