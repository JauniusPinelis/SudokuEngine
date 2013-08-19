package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PanelController;

import engine.SudokuEngine;

public class GamePanel extends JPanel {

	private int cellHeight = 9;
	private int cellWidth = 9;
	private JTextField[][] cells;
	private SudokuEngine engine;
	private boolean backgroundColor = false;
	private PanelController controller;

	/**
	 * Displaying the sudoku maze
	 */
	GamePanel() {
		setLayout(new GridLayout(cellHeight, cellWidth));
		cells = new JTextField[cellHeight][cellWidth];

		for (int i = 0; i < cellHeight; i++) {
			for (int j = 0; j < cellWidth; j++) {
				backgroundColor = checkForBackground(i, j);
				cells[i][j] = new JTextField(2);
				cells[i][j].setHorizontalAlignment(JTextField.CENTER);
				Font font = new Font("Verdana", Font.BOLD, 12);
				cells[i][j].setFont(font);
				if (backgroundColor) {
					cells[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					cells[i][j].setBackground(Color.WHITE);
				}
				add(cells[i][j]);
			}
		}

	}

	public void setController(PanelController controller) {
		this.controller = controller;
	}

	private boolean checkForBackground(int i, int j) {
		if ((j >= 0 && j <= 2) || (j >= 6 && j < 9)) {
			if ((i >= 0 && i <= 2) || (i >= 6 && i < 9)) {
				return true;
			}
		} else {
			if ((j >= 3 && j <= 6)) {
				if ((i >= 3 && i < 6)) {
					return true;
				}
			}
		}
		return false;
	}

	public int[][] getValues() {
		int[][] values = new int[9][9];
		for (int i = 0; i < cellHeight; i++) {
			for (int j = 0; j < cellWidth; j++) {
				try {
					values[i][j] = Integer.parseInt(cells[i][j].getText()
							.toString());
				} catch (Exception ex) {
					values[i][j] = 0;
				}
			}
		}

		return values;

	}

	public void setNewSudoku(int[][] newSudoku) {
		for (int i = 0; i < cellHeight; i++) {
			for (int j = 0; j < cellWidth; j++) {
				if (newSudoku[i][j] == 0) {
					cells[i][j].setText("");
					cells[i][j].setForeground(Color.BLACK);
				} else {
					
					cells[i][j].setForeground(Color.BLUE);
					cells[i][j].setText(Integer.toString(newSudoku[i][j]));
				}
			}
		}

	}
	
	public void clear(){
		for (int i = 0; i < cellHeight; i++) {
			for (int j = 0; j < cellWidth; j++) {
			cells[i][j].setText("");
			}
		}
	}
}
