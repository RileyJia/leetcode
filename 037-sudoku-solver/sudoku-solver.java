// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// Empty cells are indicated by the character '.'.
//
// You may assume that there will be only one unique solution.
//
//
//
// A sudoku puzzle...
//
//
//
//
// ...and its solution numbers marked in red.
//


class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        helper(board,0,0);
    }

    public boolean helper(char[][] board, int row, int col){
        if (row == 8 && col == 9)
            return true;
        if (col == 9 ) return helper(board,row+1,0);

        if (board[row][col] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[row][col] = (char) (k + '0');
                if (isValid(board, row, col, (char) (k + '0'))) {
                    if (helper(board,row,col + 1)) return true;
                }
            }
            board[row][col] = '.';
        } else {
            if (helper(board,row,col + 1)) return true;
        }
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, int num){
        for (int i = 0; i < 9; i++){
            if (i != row && board[i][col] == num) return false;
        }
        for (int j = 0; j < 9; j++){
            if (j != col && board[row][j] == num) return false;
        }

        int r = row % 3, c = col % 3;
        for (int i = row  - r; i < row  - r + 3; i++){
            for (int j = col - c; j < col - c + 3;j++){
                if((i != row && j != col) && board[i][j] == num) return false;
            }
        }
        return true;
    }
}
