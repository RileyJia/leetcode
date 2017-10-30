// Given numRows, generate the first numRows of Pascal's triangle.
//
//
// For example, given numRows = 5,
// Return
//
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
//
//


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele  = new ArrayList<>();
        if (numRows == 0) return res;

        ele.add(1);
        res.add(new ArrayList<>(ele));
        if (numRows == 1) {
            return res;
        }

        int temp = 1;
        for (int i = 0; i < numRows - 1; i++){
            for (int j = 1; j < ele.size(); j++) {
                ele.set(j, temp + ele.get(j));
                temp = ele.get(j) - temp;
            }
            ele.add(1);
            res.add(new ArrayList<>(ele));
        }

        return res;
    }
}
