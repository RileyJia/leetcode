//
// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
//
// For example,
// If nums = [1,2,3], a solution is:
//
//
//
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
//


class Solution {
    private int[] nums;


    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        subset(0,ele,result);
        return result;
    }

    public void subset(int start, List<Integer> ele,List<List<Integer>> result) {
        result.add(new ArrayList<>(ele));

        for (int i = start; i < nums.length; i++){
            ele.add(nums[i]);
            subset(i + 1,ele,result);
            ele.remove((Integer)nums[i]);
        }
    }
}
