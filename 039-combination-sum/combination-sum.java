//
// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
//
//
// The same repeated number may be chosen from C unlimited number of times.
//
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
//
// [
//   [7],
//   [2, 2, 3]
// ]
//
//


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        findSum(candidates,target,result,0,0,list);
        return result;
    }

    private void findSum(int[] candidates, int target, List<List<Integer>> result, int position, int sum, List<Integer> list){
        if (sum == target) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (sum < target) {
            for(int i = position; i < candidates.length && candidates[i] <= target; i++){
                list.add(candidates[i]);
                findSum(candidates, target, result, i, sum + candidates[i], list);
                list.remove((Integer)candidates[i]);
            }
        } else {
            return;
        }
    }
}
