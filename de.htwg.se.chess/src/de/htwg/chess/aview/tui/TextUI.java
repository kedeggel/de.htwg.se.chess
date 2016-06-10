package de.htwg.chess.aview.tui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.chess.controller.IChessController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	protected IChessController controller;
	private static final Logger LOGGER = LogManager.getLogger(TextUI.class.getName());

	public TextUI(IChessController controller) {
		this.controller = controller;
		this.controller.addObserver(this);
	}

	public boolean processInputLine(String line) {
		if (line.equalsIgnoreCase("q")) {
			return false;
		} else if (line.equalsIgnoreCase("r")) {
			controller.restart();
			return true;
		} else if (line.equalsIgnoreCase("print")) {
			LOGGER.entry(controller.printBoard());
			return true;
		} else if (line.equalsIgnoreCase("printall")) {
			LOGGER.entry(controller.printTotalBoard());
			return true;
		} else if (line.equalsIgnoreCase("h")) {
			LOGGER.entry("HELP\n" + "q\tquit\n" + "r\trestart\n" + "print\tprint current chessboard w/o empty fields\n"
					+ "printall\tprint current chessboard with empty fields\n" + "u\tundo\n"
					+ "[A-H][1-8]-[A-H][1-8]\tMove from ... to ...");
			return true;
		} else if (line.matches("[a-zA-Z][0-9]-[a-zA-Z][0-9]")) {
			char startX = Character.toUpperCase(line.charAt(0));
			int startY = Integer.parseInt(line.substring(1, 2));
			char targetX = Character.toUpperCase(line.charAt(3));
			int targetY = Integer.parseInt(line.substring(4, 5));
			controller.move(startX, startY, targetX, targetY);
			return true;
		} else if (controller.isCheckmate()) {
			LOGGER.entry(controller.whoIsOnTurn().toString() + " won :) !\n"
					+ controller.whoIsOnTurn().opponent().toString() + " lost :( !");
			return false;
		} else {
			LOGGER.entry(line + " is not a valid input!\n" + "HELP\n" + "q\tquit\n" + "r\trestart\n"
					+ "print\tprint current chessboard w/o empty fields\n"
					+ "printall\tprint current chessboard with empty fields\n" + "u\tundo\n"
					+ "[A-H][1-8] [A-H][1-8]\tMove from ... to ...");
			return true;
		}
	}

	@Override
	public void update(Event e) {
	}
}
