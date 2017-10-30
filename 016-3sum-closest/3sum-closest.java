// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDif = Integer.MAX_VALUE;

        Arrays.sort(nums);
        
        for (int first = 0; first< nums.length; first++){
            int second = first + 1;
            int third = nums.length -1;
            
            while (second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if (sum - target == 0) {
                    return sum;
                } else { 
                    int diff = sum - target;
                    if (Math.abs(diff) < Math.abs(minDif)) minDif = diff;
                    if (sum < target) second++;
                    else if (sum > target) third--;
                }
                
            }
        }
        
        return target+minDif;
    }
}
