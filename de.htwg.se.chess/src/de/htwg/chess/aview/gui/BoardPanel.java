package de.htwg.chess.aview.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.htwg.chess.controller.IChessController;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 8813550997072332166L;
	private static final int FIELDSIZE = 8;
	private List<JButton> buttonList;
	private IChessController controller;
	private char fromX;
	private int fromY;
	private boolean selected;
	private static final Color DARK = new Color(255, 228, 181);
	private static final Color BRIGHT = new Color(160, 82, 45);

	public BoardPanel(IChessController controller) {
		this.controller = controller;
		setLayout(new GridLayout(FIELDSIZE, FIELDSIZE));
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		buttonCreator(FIELDSIZE);
	}

	private void buttonCreator(int size) {
		buttonList = new ArrayList<>();
		for (int i = 0; i < FIELDSIZE; i++) {
			for (int j = 0; j < FIELDSIZE; j++) {
				ChessButton button = new ChessButton((char) (i - 'A'), j - 1);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (!selected) {
							System.out.println("selected");
							fromX = button.getXCoor();
							fromY = button.getYCoor();
							selected = true;
						} else {
							System.out.println("Not selected");
							controller.move(fromX, fromY, button.getXCoor(), button.getYCoor());
							selected = false;
						}

					}
				});
				buttonList.add(button);
				if ((i + j) % 2 == 0)
					button.setBackground(DARK);
				else
					button.setBackground(BRIGHT);

				this.add(button);
			}
		}
	}

}
