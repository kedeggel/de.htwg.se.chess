package de.htwg.chess;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.chess.aview.gui.ChessFrame;
import de.htwg.chess.aview.tui.TextUI;
import de.htwg.chess.controller.IChessController;

public class Chess {
	private IChessController controller;
	private TextUI tui;
	private static Scanner scanner;
	private static Chess instance = null;
	private ChessFrame gui;

	private Chess() {
		PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
		Injector injector = Guice.createInjector(new ChessModule());
		controller = injector.getInstance(IChessController.class);
		tui = new TextUI(controller);
		gui = new ChessFrame(controller);
	}

	public static Chess getInstance() {
		if (instance == null)
			instance = new Chess();
		return instance;
	}

	public TextUI getTui() {
		return tui;
	}
	
	public ChessFrame getGui() {
		return gui;
	}
    
    public IChessController getController() {
    	return controller;
    }

	public static void main(String[] args) {
		Chess game = Chess.getInstance();
		if (args.length == 0) {
			boolean continu = true;
			scanner = new Scanner(System.in);
			while (continu) {
				continu = game.getTui().processInputLine(scanner.next());
			}
		} else {
			for (String input : args) {
				game.getTui().processInputLine(input);
			}

		}
	}

}