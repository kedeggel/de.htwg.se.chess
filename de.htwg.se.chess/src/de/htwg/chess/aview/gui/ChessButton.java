package de.htwg.chess.aview.gui;

import javax.swing.JButton;

public class ChessButton extends JButton {
	private static final long serialVersionUID = 3117003292995993020L;
	private final char x;
	private final int y;

	public ChessButton(char x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	char getXCoor() {
		return x;
	}

	int getYCoor() {
		return y;
	}

}
