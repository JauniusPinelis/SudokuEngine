package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SudokuEngine {
	
	private boolean isGameFinished;
	private boolean error;
	private int[][] cells;
	private ArrayList<Integer> winningSequence;
	private ArrayList<Integer> numbers;
	
	private final int[][] solvedSudoku = {
			{3,2,9,6,5,7,8,4,1},
			{7,4,5,8,3,1,2,9,6},
			{6,1,8,2,4,9,3,7,5},
			
			{1,9,3,4,6,8,5,2,7},
			{2,7,6,1,9,5,4,8,3},
			{8,5,4,3,7,2,6,1,9},
			
			{4,3,2,7,1,6,9,5,8},
			{5,8,7,9,2,3,1,6,4},
			{9,6,1,5,8,4,7,3,2}
	};
	
	 public SudokuEngine(){
		 initSequence();
		 initVariables();
	 }
	 
	 public void setCells(int[][] cells){
		 this.cells = cells;
	 }
	 
	 public void printCells(){
		 System.out.println("");
		 for (int i = 0; i <= 8; i++){
			 System.out.println("");
			 for (int j = 0; j <= 8; j++){
				 System.out.print("|" + cells[i][j]);
			 }
			 System.out.print(" |");
		 }
		 System.out.println("");
	 }
	 
	 private void initSequence(){
		 winningSequence = new ArrayList<Integer>();
		 winningSequence.add(1);
		 winningSequence.add(2);
		 winningSequence.add(3);
		 winningSequence.add(4);
		 winningSequence.add(5);
		 winningSequence.add(6);
		 winningSequence.add(7);
		 winningSequence.add(8);
		 winningSequence.add(9);
	 }
	 
	 private void initVariables(){
		 cells = new int[9][9];
		 
	 }
	 
	 public boolean checkRows(){
		 numbers = new ArrayList<Integer>();
		 for (int i = 0; i < 8; i++){
			 for (int j = 0; j < 8; j++){
				 int number = cells[i][j];
				 numbers.add(number);
				 if (winComb(numbers)){
					 
				 }
			 }
			 numbers.clear();
		 }
		 return false;
	 }
	 
	 private boolean winComb(ArrayList<Integer> row){
		 Collections.sort(row);
		 if (row.equals(winningSequence)){
			 return true;
		 }
		 return false;
	 }
	 
	 public void randomiseCells(){
		
		for (int i = 0; i <= 2; i++){
			int col1 = 0;
			int col2 = 0;
			while (col1 == col2){
				Random generator = new Random();
				col1 = generator.nextInt(3);
				col2 = generator.nextInt(3);
			}
			
			swapColumns(i*3,col1,col2);			
		}
		
		for (int i = 0; i <= 2; i++){
			int col1 = 0;
			int col2 = 0;
			while (col1 == col2){
				Random generator = new Random();
				col1 = generator.nextInt(3);
				col2 = generator.nextInt(3);
			}
			
			swapRows(i*3,col1,col2);			
		}
		
	 }
	 
	 
	 
	 private void swapColumns(int regionNr, int col1, int col2){
		 col1 = regionNr+col1;
		 col2 = regionNr+col2;
		 System.out.println("Swapping" + col1 + " and " + col2);
		 for (int i = 0; i <= 8; i++){
			 int temp = cells[i][col1];
			 cells[i][col1] = cells[i][col2];
			 cells[i][col2] = temp;
		 }
	 }
	 
	 private void swapRows(int regionNr, int row1, int row2){
		 row1 = regionNr+row1;
		 row2 = regionNr+row2;
		 
		 for (int i = 0; i <= 8; i++){
			 int temp = cells[row1][i];
			 cells[row1][i] = cells[row2][i];
			 cells[row2][i] = temp;
		 }
		 
	 }
	 
	 public void createNewSudoku(){
		 populateCells();
	 }
	 
	 
	 
	 public int[][] getCells(){
		 return cells;
	 }
	 
	 private void populateCells(){
		for (int i = 0; i <= 8; i++){
			for (int j = 0; j <= 8; j++){
				cells[i][j] = solvedSudoku[i][j];
			}
		}
		 
	 }
	 
	 public void removeCells(int input){
		 for (int i = 0; i < 9; i++){ 
			 for (int j = 0; j < input; j++){
				 Random generator = new Random();
				 int k = generator.nextInt(8);
				 cells[i][k] = 0;
			 }
			 
		 }
	 }
	 
	 public void removeColumns(int input){
		 for (int i = 0; i < 9; i++){ 
			 for (int j = 0; j < input; j++){
				 Random generator = new Random();
				 int k = generator.nextInt(8);
				 cells[k][i] = 0;
			 }
			 
		 }
	 }
}
