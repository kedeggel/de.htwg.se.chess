package de.htwg.chess.aview.tui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.chess.controller.IChessController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	protected IChessController controller;
	private static final Logger LOGGER = LogManager.getLogger(TextUI.class.getName());
	private final String help = "HELP\n" + "h\t\t\thelp\nq\t\t\tquit\n" + "r\t\t\trestart\n"
			+ "print\t\t\tprint current chessboard w/o empty fields\n"
			+ "printall\t\tprint current chessboard with empty fields\n" + "u\t\t\tundo\n"
			+ "[A-H][1-8]-[A-H][1-8]\tMove from ... to ...";

	public TextUI(IChessController controller) {
		this.controller = controller;
		this.controller.addObserver(this);
		LOGGER.info("Welcome to CHESS!");
		LOGGER.info(help);
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
			LOGGER.entry(help);
			return true;
		} else if (line.matches("[a-zA-Z][0-9]-[a-zA-Z][0-9]")) {
			char startX = Character.toUpperCase(line.charAt(0));
			int startY = Integer.parseInt(line.substring(1, 2));
			char targetX = Character.toUpperCase(line.charAt(3));
			int targetY = Integer.parseInt(line.substring(4, 5));
			controller.move(startX, startY, targetX, targetY);
			LOGGER.info(controller.getStatusMessage());
			return true;
		} else if (controller.isCheckmate()) {
			LOGGER.entry(controller.whoIsOnTurn().toString() + " won :) !\n"
					+ controller.whoIsOnTurn().opponent().toString() + " lost :( !");
			return false;
		}
		return true;
	}

	@Override
	public void update(Event e) {
	}
}
