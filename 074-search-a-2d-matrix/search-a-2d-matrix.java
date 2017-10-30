// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
//
//
//
//
// For example,
//
// Consider the following matrix:
//
//
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
//
//
// Given target = 3, return true.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;

        int row = matrix.length - 1;
        for (int i = 1; i < matrix.length; i++) {
            if (target < matrix[i][0]) {
                row = i - 1;
                break;
            }
        }

        if (target > matrix[row][matrix[0].length - 1]) return false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (target < matrix[row][i]) {
                return false;
            } else if (target == matrix[row][i]) {
                return true;
            }
        }
        return false;
    }
}
