// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//
// A partially filled sudoku which is valid.
//
//
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
//


class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int LEN = 9;
        if (board.length != LEN || board[0].length != LEN) return false;
        for (int i = 0; i < LEN ; i++){
            for (int j = 0; j < LEN; j++){
                if (board[i][j] == '.') continue;
                for(int k = j + 1; k < LEN; k++){
                    if (board[i][j] == board[i][k]) return false;
                }
                for(int k = i + 1; k < LEN; k++) {
                    if (board[i][j] == board[k][j]) return false;
                }
                int col = j + 1;
                int row = i;
                int segC = j / 3;
                int segR = i / 3;
                while(row / 3 == segR){
                    while(col / 3 == segC) {
                        if (board[i][j] == board[row][col]) return false;
                        col++;

                    }
                    col = segC * 3;
                    row++;
                }

            }
        }
        return true;
    }
}
