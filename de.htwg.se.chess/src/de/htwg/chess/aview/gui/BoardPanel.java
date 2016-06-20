package de.htwg.chess.aview.gui;

import java.awt.Color;
import java.awt.Font;
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
	private List<ChessButton> buttonList;

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
		for (int i = FIELDSIZE; i > 0; i--) {
			for (int j = FIELDSIZE-1; j >= 0; j--) {
				ChessButton button = new ChessButton((char) (j + 'A'), i);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (!selected) {
							fromX = button.getXCoor();
							fromY = button.getYCoor();
							selected = true;
						} else {
							controller.move(fromX, fromY, button.getXCoor(), button.getYCoor());
							selected = false;
						}

					}
				});
				button.setText(controller.getSymboleByField(button.getXCoor(), button.getYCoor()));
				buttonList.add(button);
				if ((i + j) % 2 == 0)
					button.setBackground(DARK);
				else
					button.setBackground(BRIGHT);
				button.setFont(new Font("Dialog", 0, 50));
				this.add(button);
			}
		}
	}

	public List<ChessButton> getButtonList() {
		return buttonList;
	}
}
