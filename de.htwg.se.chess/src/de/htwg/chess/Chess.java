package de.htwg.chess;

import java.util.Scanner;
import de.htwg.chess.aview.tui.TextUI;
import de.htwg.chess.controller.IChessController;
import de.htwg.chess.controller.impl.ChessController;

public class Chess {
	private static IChessController controller;
	private static TextUI tui;
	private static Scanner scanner;

	private Chess() {
	}

	public static void main(String[] args) {
		controller = new ChessController();
		tui = new TextUI(controller);

		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
			continu = tui.processInputLine(scanner.next());
			controller.nextRound();
		}
	}
}