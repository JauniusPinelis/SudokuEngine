package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import controller.PanelController;
import engine.SudokuEngine;

public class GUI extends JFrame {
	
	private SudokuEngine engine;
	
	public GUI(){
		initVariables();
		initFrame();
		initUI();
	}
	
	private void initVariables(){
		engine = new SudokuEngine();
	}
	
	/**
	 * Sets the frame parameters
	 */
	private void initFrame(){
		
		setTitle("Sudoku Engine");
		setSize(350, 280);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
	}
	
	/**
	 * Sets the panels of the game GUI
	 */
	private void initUI(){
		
		GamePanel gamePanel = new GamePanel();
		SettingsPanel settingsPanel = new SettingsPanel();
		
		PanelController panelController = new PanelController();
		panelController.setGamePanel(gamePanel);
		panelController.setSettingsPanel(settingsPanel);
		
		gamePanel.setController(panelController);
		settingsPanel.setController(panelController);
		settingsPanel.setEngine(engine);
		
		
		add(gamePanel,BorderLayout.NORTH);
		
		
		add(settingsPanel,BorderLayout.CENTER);
	}
	
	
}
