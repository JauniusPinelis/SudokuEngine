package controller;

import gui.GamePanel;
import gui.SettingsPanel;

public class PanelController {
	
	private GamePanel gamePanel;
	private SettingsPanel settingsPanel;
	
	public PanelController(){
		
	}
	
	public void setGamePanel(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public void setSettingsPanel(SettingsPanel settingsPanel){
		this.settingsPanel = settingsPanel;
	}
	
	public void clearGame(){
		gamePanel.clear();
	}
	
	public int[][] getCells(){
		return gamePanel.getValues();
	}
	
	public void setNewSudoku(int[][] newSudoku){
		gamePanel.setNewSudoku(newSudoku);
	}
	
	
}
