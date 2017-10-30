// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
//


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;

        int num = 1;
        int cricle = 0;
        while (cricle < (n + 1) / 2) {
            int i = cricle, j = cricle;
            if(!(j < n - cricle)) break;

            while (j < n - cricle) {
                result[i][j] = num;
                num += 1;
                j += 1;
            }
            j -= 1;
            i += 1;
            if(!(i < n - cricle)) break;
            while (i < n - cricle) {
                result[i][j] = num;
                num += 1;
                i += 1;
            }
            i -= 1;
            j -= 1;
            if(!(j >= cricle)) break;
            while (j >= cricle) {
                result[i][j] = num;
                num += 1;
                j -= 1;
            }
            j += 1;
            i -= 1;
            if(!(i > cricle)) break;
            while (i > cricle) {
                result[i][j] = num;
                num += 1;
                i -= 1;
            }
            cricle += 1;
        }
        return result;
    }
}
