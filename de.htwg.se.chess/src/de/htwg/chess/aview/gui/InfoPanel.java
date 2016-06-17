package de.htwg.chess.aview.gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.htwg.chess.controller.IChessController;

public class InfoPanel extends JPanel {
	private static final long serialVersionUID = 7984280983097395322L;
	private final JLabel infoLabel = new JLabel("WHITE");

	public InfoPanel(IChessController controller) {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		add(infoLabel);
	}

	public final void setText(String s) {
		infoLabel.setText(s);
	}

}
