package gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tools.WrapLayout;

import controller.PanelController;
import engine.SudokuEngine;
import engine.SudokuSolver;
import java.awt.Insets;

public class SettingsPanel extends JPanel {
	
	
	JButton clearButton;
	//JButton undoButton;
	JButton hintButton;
	
	
	private JButton checkButton;
	private JButton solveButton;
	private JButton newMazeButton;
	private PanelController controller;
	private SudokuEngine engine;
	
	private JComboBox modeBox;
	
	public SettingsPanel(){
		initComponents();
	}
	
	public void setController(PanelController controller){
		this.controller = controller;
	}
	
	public void setEngine(SudokuEngine engine){
		this.engine = engine;
	}
	
	private void clear(){
		controller.clearGame();
	}
	
	private void initComponents(){
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
			
		});
		
		hintButton = new JButton("Hint");
		solveButton = new JButton("Auto-Solve");
		solveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				engine.setCells(controller.getCells());
				SudokuSolver sudokuSolver = new SudokuSolver();
				sudokuSolver.solveSudoku(engine.getCells());
				setNewSudoku(sudokuSolver.getSolvedSudoku());
				
			}
			
		});
		
		String[] modes = {"Novice", "Medium", "Hard", "Egle mode"};
		
		modeBox = new JComboBox(modes);
		modeBox.setSelectedIndex(0);
		
		newMazeButton = new JButton("New Sudoku");
		newMazeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				engine.createNewSudoku();
				
				engine.randomiseCells();
				engine.randomiseCells();
				
				int selectedMode = getMode();
				engine.removeCells(2*selectedMode);
				engine.removeColumns(selectedMode+1);
				
				
				int[][] newSudoku = engine.getCells();
				
				setNewSudoku(newSudoku);
				
			}
			
		});
		
		checkButton = new JButton("Check");
		checkButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				engine = new SudokuEngine();
				engine.setCells(controller.getCells());
				engine.printCells();
				if (!engine.checkRows()){
					JOptionPane.showMessageDialog(null,
						    "You managed to finish this! Good job!");
				}
				else{
					JOptionPane.showMessageDialog(null,
						    "The sudoku is not finished or has mistakes","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		setLayout(new WrapLayout());
		
		
		
		add(checkButton);
		
		//add(hintButton);
		
		add(solveButton);
		
		add(clearButton);
		
		add(modeBox);
		
		add(newMazeButton);
		
		
		
		
		
		
		
	}
	
	private void setNewSudoku(int[][] newSudoku){
		controller.setNewSudoku(newSudoku);
	}
	
	private int getMode(){
		char i = modeBox.getSelectedItem().toString().charAt(0);
		if (i == 'N'){
			return 1;
		}
		else if (i == 'M'){
			return 2;
		}
		else if (i == 'H'){
			return 3;
		}
		else{
			return 4;
		}
	}
}
