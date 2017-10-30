//
// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//
// Each number in C may only be used once in the combination.
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
// A solution set is: 
//
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
//
//


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        findSum(candidates,target,result,0,0,list);
        return result;
    }

    private void findSum(int[] candidates, int target, List<List<Integer>> result, int position, int sum, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (sum < target) {
            for (int i = position; i < candidates.length && candidates[i] <= target;i++ ) {
                if (i > position && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                list.add(candidates[i]);
                findSum(candidates, target, result, i+1, sum + candidates[i], list);
                list.remove((Integer) candidates[i]);
            
            }
        } else {
            return;
        }
    }
}
