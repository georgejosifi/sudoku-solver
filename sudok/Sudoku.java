package sudok;

public class Sudoku {

private int [][] board;
int row;
int column;

public Sudoku () {
	board = new int[9][9];
	
	
}


public int getValue(int i, int j) {
	return board[i][j];
}


public void setBoard(int[][] board) {
	this.board = board;
}


public boolean solveSudoku() {
	for (int r = 0; r < 9 ; r++) {
		for(int c = 0; c<9; c++) {	
	if (board[r][c] == 0) {
	
		for (int num = 1; num<=9; num++) {
		
		if (isSafe(r,c,num)) {
		
			board[r][c] = num;
			
			if(solveSudoku()) {
				return true;
			}else {
			
			board[r][c] = 0;
			}
		 }
		
	   }
	  return false;
     }
   }
 }		
	return true;
}




public void printBoard () {
	for (int i = 0; i < board.length; i ++) {
		System.out.println("");
		for (int j = 0; j<board[0].length; j++) {
			System.out.print(board[i][j] + "  ");
		} 
		
	}
}

public boolean isSafe(int r, int c, int n) {
	if (!(usedInRow(r,n) ||  usedInCol(c,n) || usedInBox(r-r%3, c-c%3, n)))
			{
		return true;
	}
	return false;
}



private boolean usedInRow(int r, int num) {
	for (int c = 0; c < 9; c++) {
		if (board[r][c] == num) {
			return true;
		}
	}
	return false;
}




private boolean usedInCol(int c, int num) {
	for (int r = 0; r < 9; r++) {
		if (board[r][c] == num) {
			return true;
		}
	}
	return false;
}




private boolean usedInBox (int boxStartRow, int boxStartCol, int num) {
	for (int r = 0; r<3; r++) {
		for (int c = 0; c<3; c++) {
			if(board[boxStartRow +r][boxStartCol + c] == num) {
				return true;
			}
		}
	}
	return false;
}



public  boolean addNumber(int row, int column, int number) {
	if (row<0 || row>8 || column<0 || column>8 || number<0 || number>9) {
		System.out.println("Cant add Number please try again");
	}
	board[row][column] = number;
	return true;
	
}


}
