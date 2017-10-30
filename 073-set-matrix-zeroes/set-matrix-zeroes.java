//
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//
// click to show follow up.
//
// Follow up:
//
//
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
//


class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 || (matrix.length == 1 && matrix[0].length == 1)) return;

        List<Integer> row = new LinkedList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        Collections.sort(row);
        Collections.sort(col);
        if (row.size() == 0 && col.size() ==0) return;

        for (int k = 0; k < row.size();) {
            int r = row.get(k);
            for (int j = 0; j < matrix[0].length; j++){
                matrix[r][j] = 0;
            }
            k++;
            while (k < row.size() && row.get(k - 1) == row.get(k)){
                k++;
            }

        }


        for (int k = 0; k < col.size();) {
            int c = col.get(k);
            for (int i = 0; i < matrix.length; i++){
                matrix[i][c] = 0;
            }
            k++;
            while (k < col.size() && col.get(k - 1) == col.get(k)){
                k++;
            }
            
        }
    }
}
