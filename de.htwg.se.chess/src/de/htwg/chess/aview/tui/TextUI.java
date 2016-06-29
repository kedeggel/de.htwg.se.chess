package de.htwg.chess.aview.tui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.htwg.chess.controller.ExitEvent;
import de.htwg.chess.controller.IChessController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class TextUI implements IObserver {
	private static final Logger LOGGER = LogManager.getLogger(TextUI.class.getName());
	private static final String HELP = "HELP\n" + "h\t\t\thelp\nq\t\t\tquit\n" + "r\t\t\trestart\n"
			+ "print\t\t\tprint current chessboard w/o empty fields\n"
			+ "printall\t\tprint current chessboard with empty fields\n"
			+ "[A-H][1-8]-[A-H][1-8]\tMove from ... to ...";
	protected IChessController controller;
	private boolean quit;
	private boolean continu;

	public TextUI(IChessController controller) {
		this.controller = controller;
		this.controller.addObserver(this);
		LOGGER.info("Welcome to CHESS!");
		LOGGER.info(HELP);
	}

	public boolean processInputLine(String line) {
		if (quit) {
			continu = false;
		} else if (controller.isReadyToTransform()) {
			if (!transformTo(line))
				LOGGER.info(line + " is not a valid chesspiece");
			continu = true;
		} else if ("q".equalsIgnoreCase(line)) {
			controller.quit();
			continu = false;
		} else if ("r".equalsIgnoreCase(line)) {
			LOGGER.info("New Game");
			controller.restart();
			continu = true;
		} else if (prints(line)) {
			continu = true;
		} else if (line.matches("[a-zA-Z][0-9]-[a-zA-Z][0-9]")) {
			continu = checkMove(line);
		} else {
			LOGGER.info("Insert \'h\' for help");
			continu = true;
		}
		return continu;
	}

	private boolean prints(String line) {
		if ("print".equalsIgnoreCase(line)) {
			LOGGER.info(controller.printBoard());
			return true;
		} else if ("printall".equalsIgnoreCase(line)) {
			LOGGER.info(controller.printTotalBoard());
			return true;
		} else if ("h".equalsIgnoreCase(line)) {
			LOGGER.info(HELP);
			return true;
		}
		return false;
	}

	private boolean checkMove(String line) {
		char startX = Character.toUpperCase(line.charAt(0));
		int startY = Integer.parseInt(line.substring(1, 2));
		char targetX = Character.toUpperCase(line.charAt(3));
		int targetY = Integer.parseInt(line.substring(4, 5));
		controller.move(startX, startY, targetX, targetY);
		if (controller.isCheckmate()) {
			return false;
		}
		return true;
	}

	private boolean transformTo(String type) {
		if ("rook".equalsIgnoreCase(type)) {
			controller.transformToRook();
			return true;
		} else if ("queen".equalsIgnoreCase(type)) {
			controller.transformToQueen();
			return true;
		} else if ("bishop".equalsIgnoreCase(type)) {
			controller.transformToBishop();
			return true;
		} else if ("knight".equalsIgnoreCase(type)) {
			controller.transformToKnight();
			return true;
		}
		return false;
	}

	@Override
	public void update(Event e) {
		if (e instanceof ExitEvent) {
			this.quit = true;
		}
		printTUI();
	}

	private void printTUI() {
		LOGGER.info(controller.getStatusMessage());
	}
}