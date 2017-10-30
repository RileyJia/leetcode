// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//
//
// For example,
// Given the following matrix:
//
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
//
//
// You should return [1,2,3,6,9,8,7,4,5].
//


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return result;
        int circle = 0;
        while (circle < (matrix.length + 1) / 2) {
            int i = circle;
            int j = circle;
            if(!(j < matrix[0].length - circle)) break;
            for (; j < matrix[0].length - circle; j++) {
                result.add(matrix[i][j]);
            }
            i += 1;
            j -= 1;
            if(!(i < matrix.length - circle)) break;
            for (; i < matrix.length - circle; i++) {
                result.add(matrix[i][j]);
            }
            j -= 1;
            i -= 1;
            if(!(j >= circle)) break;
            for (; j >= circle; j--) {
                result.add(matrix[i][j]);
            }
            i -= 1;
            j += 1;
            if(!(i > circle)) break;
            for (; i > circle; i--) {
                result.add(matrix[i][j]);
            }
           circle += 1;
        }
        return result;
    }
}
