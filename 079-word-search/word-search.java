//
// Given a 2D board and a word, find if the word exists in the grid.
//
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
// For example,
// Given board = 
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
//
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
//


class Solution {
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        boolean[][] used = new boolean[board.length][board[0].length];
        if (board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word.length() == 0) return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(i, j, 0, used)) return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int row, int col,int index, boolean[][] used){
        if (index == word.length()){
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length|| index >= word.length()) return false;
        if (board[row][col] != word.charAt(index) || used[row][col]) return false;
        
        used[row][col] = true;
        boolean res = findWord(row + 1, col,index + 1, used)
                || findWord(row, col + 1,index + 1, used)
                || findWord(row - 1, col,index + 1, used)
                || findWord(row, col - 1,index + 1, used);

        used[row][col] = false;
        return res;

    }
}
