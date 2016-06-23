package de.htwg.chess.aview.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class InfoPanel extends JPanel {
	private static final long serialVersionUID = 7984280983097395322L;
	private final JLabel turnLabel = new JLabel("WHITE");
	private final JLabel statusLabel = new JLabel("");

	public InfoPanel() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		add(turnLabel);
		add(statusLabel);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public final void setTurn(String s) {
		turnLabel.setText(s);
	}

	public final void setStatus(String s) {
		statusLabel.setText(s);
	}
}
