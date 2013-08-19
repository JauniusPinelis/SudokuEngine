package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuSolver {
	
	private ArrayList<Integer> winningSequence;
	private ArrayList<Integer> numbers;
	int[][] solvedSudoku;
	
	public SudokuSolver(){
		initVariables();
	}
	
	private void initVariables(){
		numbers = new ArrayList<Integer>();
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
	
	public boolean solveSudoku(int[][] board){
		 for (int r = 0; r < board.length; r++) {
		        for (int c = 0; c < board[0].length; c++) {
		            if (board[r][c] == 0) {
		                for (int k = 1; k <= 9; k++) {
		                    board[r][c] = k;
		                    if (isValid(board, r, c) && solveSudoku(board)) {
		                    	setSolvedSudoku(board);
		                        return true;
		                    } else {
		                        board[r][c] = 0;
		                    }
		                 }
		                return false;
		             }
		         }
		     }
		    return true;
	}
	
	public void setSolvedSudoku(int[][] board){
		solvedSudoku = board.clone();
	}
	
	public int[][] getSolvedSudoku(){
		return solvedSudoku;
	}
	
	public boolean isItSolved(int[][] board){
		// TODO check this
		 for (int i = 0; i < 8; i++){
			 for (int j = 0; j <= 8; j++){
				 int number = board[i][j];
				 numbers.add(number);
				 
				 
			 }
			 if (!winComb(numbers)){
				 System.out.println("row: " + (i+1) + "fails");
				 return false;
			 }
			 numbers.clear();
		 }
		 System.out.println("It is already solved");
		 return true;
	 }
	 
	 private boolean winComb(ArrayList<Integer> row){
		 Collections.sort(row);
		 printList(row);
		 printList(winningSequence);
		 if (row.equals(winningSequence)){
			 return true;
		 }
		 
		 return false;
	 }
	 
	 private void printList(ArrayList<Integer> list){
		 System.out.println("");
		 for (int i = 0; i < list.size(); i++){
			 System.out.print(list.get(i) + " ");
		 }
		 System.out.println("");
	 }
	 
	 public boolean isValid(int[][] board, int r, int c) {
			// check row
			boolean[] row = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[r][i] >= 1 && board[r][i] <= 9) {
					if (row[board[r][i] - 1] == false) {
						row[board[r][i] - 1] = true;
					} else {
						return false;
					}
				}
			}

			// check column
			boolean[] col = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][c] >= 1 && board[i][c] <= 9) {
					if (col[board[i][c] - 1] == false) {
						col[board[i][c] - 1] = true;
					} else {
						return false;
					}
				}
			}

			// check the 3*3 grid
			boolean[] grid = new boolean[9];
			for (int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
				for (int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
					if (board[i][j] >= 1 && board[i][j] <= 9) {
						if (grid[board[i][j] - 1] == false) {
							grid[board[i][j] - 1] = true;
						} else {
							return false;
						}
					}
				}
			}

			return true;
		}
	

}
