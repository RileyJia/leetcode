// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example 1:
//
// [[1,3,1],
//  [1,5,1],
//  [4,2,1]]
//
// Given the above grid map, return 7. Because the path 1&rarr;3&rarr;1&rarr;1&rarr;1 minimizes the sum.
//


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return grid[0][0];


        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            result[i][0] = result[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++){
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int i = 1;i< m; i++){
            for (int j = 1; j < n; j++){
                result[i][j] = Math.min(result[i-1][j] ,result[i][j-1]) + grid[i][j];
            }
        }
        return result[m-1][n-1];
    }
}
