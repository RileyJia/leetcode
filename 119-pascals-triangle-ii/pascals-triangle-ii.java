// Given an index k, return the kth row of the Pascal's triangle.
//
//
// For example, given k = 3,
// Return [1,3,3,1].
//
//
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
//


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) return result;

        int temp = 1;
        for (int i = 0; i < rowIndex; i++){
            for (int j = 1; j < result.size(); j++) {
                result.set(j, temp + result.get(j));
                temp = result.get(j) - temp;
            }
            result.add(1);
        }
        return result;
    }
}
