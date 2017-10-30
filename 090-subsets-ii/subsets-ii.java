//
// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
//
// For example,
// If nums = [1,2,2], a solution is:
//
//
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
//


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();

        if (nums.length == 0) return result;
        Arrays.sort(nums);
        subset(nums,1,0,ele,result);
        return result;
    }

    private void subset(int[]nums, int len, int start, List<Integer> ele, List<List<Integer>> result){
        result.add(new ArrayList<>(ele));
        
        for (int i = start; i < nums.length; i++) {
            ele.add(nums[i]);
            subset(nums, len, i + 1, ele, result);
            ele.remove((Integer) nums[i]);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

    }
}
