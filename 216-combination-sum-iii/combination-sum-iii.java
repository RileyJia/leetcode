//
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//
//
//  Example 1:
// Input:  k = 3,  n = 7
// Output: 
//
// [[1,2,4]]
//
//
//  Example 2:
// Input:  k = 3,  n = 9
// Output: 
//
// [[1,2,6], [1,3,5], [2,3,4]]
//
//
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        if ( n > (19 * k + k * k) / 2 || n < (k + k * k)/2) return result;
        List<Integer> ele = new ArrayList<>();
        combin(k,n,1,0, ele, result);
        return result;

    }

    private void combin(int k, int n, int start, int sum, List<Integer> ele, List<List<Integer>> result){
        if (ele.size() == k){
            if (sum == n){
                result.add(new ArrayList<>(ele));
                return;
            }
            return;
        }

        for (int i = start; i <= 9; i++){
            ele.add(i);
            combin(k, n,i + 1,sum + i, ele, result);
            ele.remove((Integer)i);
        }
    }
}
