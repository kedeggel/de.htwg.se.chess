package de.htwg.chess;

import java.util.Scanner;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.chess.aview.gui.ChessFrame;
import de.htwg.chess.aview.tui.TextUI;
import de.htwg.chess.controller.IChessController;

public class Chess {
	private static IChessController controller;
	private static TextUI tui;
	private static Scanner scanner;
	private static Chess instance = null;

	private Chess() {
		Injector injector = Guice.createInjector(new ChessModule());
		controller = injector.getInstance(IChessController.class);
		tui = new TextUI(controller);
		new ChessFrame(controller);
	}

	public static Chess getInstance() {
		if (instance == null)
			instance = new Chess();
		return instance;
	}

	public TextUI getTui() {
		return tui;
	}

	public static void main(String[] args) {
		Chess game = Chess.getInstance();
		boolean continu = true;
		scanner = new Scanner(System.in);
		while (continu) {
			continu = game.getTui().processInputLine(scanner.next());
		}
	}

}