// Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.  If a cell has less than 8 surrounding cells, then use as many as you can.
//
// Example 1:
//
// Input:
// [[1,1,1],
//  [1,0,1],
//  [1,1,1]]
// Output:
// [[0, 0, 0],
//  [0, 0, 0],
//  [0, 0, 0]]
// Explanation:
// For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
// For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
// For the point (1,1): floor(8/9) = floor(0.88888889) = 0
//
//
//
// Note:
//
// The value in the given matrix is in the range of [0, 255].
// The length and width of the given matrix are in the range of [1, 150].
//
//


class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0 ) return M;
        int[][] res = new int[M.length][M[0].length];
        int sum = 0,count = 1;
        if (M.length == 1 && M[0].length == 1){ return M;}
        else if (M.length == 1){
            for (int j = 0; j < M[0].length; j++){
                if (j == 0){
                    sum = M[0][0] + M[0][1];
                    count = 2;
                } else if ( j == M[0].length - 1){
                    sum = M[0][j] + M[0][j-1];
                    count = 2;
                } else {
                    //System.out.println(j+"," + (M[0].length - 1));
                    sum = M[0][j] + M[0][j-1] + M[0][j+1];
                    count = 3;
                }   
                res[0][j] = sum/count;
            }
        } else if (M[0].length == 1){
            for (int i = 0; i < M.length; i++){
                if (i == 0){
                    sum = M[0][0] + M[1][0];
                    count = 2;
                } else if ( i == M.length - 1){
                    sum = M[i][0] + M[i-1][0];
                    count = 2;
                } else {
                    //System.out.println(j+"," + (M[0].length - 1));
                    sum = M[i][0] + M[i-1][0] + M[i+1][0];
                    count = 3;
                }  
                res[i][0] = sum/count;
            }
        } else {
            for (int i = 0; i < M.length; i++){
                for (int j = 0; j < M[0].length; j++){
                    if (i == 0){
                        if (j == 0){
                            sum = M[0][0] + M[0][1] + M[1][0] + M[1][1];
                            count = 4;
                        } else if ( j == M[0].length - 1){
                            sum = M[0][j] + M[0][j-1] + M[1][j] + M[1][j-1];
                            count = 4;
                        } else {
                            //System.out.println(j+"," + (M[0].length - 1));
                            sum = M[0][j] + M[0][j-1] + M[0][j+1] + M [1][j] + M[1][j-1] + M[1][j+1];
                            count = 6;
                        }
                    } else if ( i == M.length - 1){
                        if (j == 0){
                            sum = M[i-1][0] + M[i-1][1] + M[i][0] + M[i][1];
                            count = 4;
                        } else if ( j == M[0].length - 1){
                            sum = M[i-1][j] + M[i-1][j-1] + M[i][j] + M[i][j-1];
                            count = 4;
                        } else{
                            sum = M[i-1][j] + M[i-1][j-1] + M[i-1][j+1] + M [i][j] + M[i][j-1] + M[i][j+1]; 
                            count = 6;
                        }
                    } else {
                        if (j == 0){
                            sum = M[i-1][0] + M[i-1][1] + M[i][0] + M[i][1] + M[i+1][0] + M[i+1][1];
                            count = 6;
                        } else if ( j == M[0].length - 1){
                            sum = M[i-1][j] + M[i-1][j-1] + M[i][j] + M[i][j-1] + M[i+1][j] + M[i+1][j-1];
                            count = 6;
                        } else{
                            sum = M[i-1][j] + M[i-1][j-1] + M[i-1][j+1] + M[i][j] + M[i][j-1] + M[i][j+1] + M[i+1][j] + M[i+1][j-1] + M[i+1][j+1];
                            count = 9;
                        }
                    }
                    res[i][j] = sum/count;
                }
            }
        }
        return res;
        
    }
}
