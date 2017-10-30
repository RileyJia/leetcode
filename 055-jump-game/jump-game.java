//
// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//
// Each element in the array represents your maximum jump length at that position. 
//
//
// Determine if you are able to reach the last index.
//
//
//
// For example:
// A = [2,3,1,1,4], return true.
//
//
// A = [3,2,1,0,4], return false.
//


class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums.length == 0 || nums[0] == 0) return false;

        int maxJump = nums[0];
        int position;
        while (maxJump < nums.length - 1){
            position = maxJump;
            for (int i = 0; i <= Math.min(maxJump, nums.length - 1); i++){
                if (i + nums[i] > maxJump) {
                    maxJump = i + nums[i];
                    if (maxJump >= nums.length - 1) return true;
                }
            }
            if (position == maxJump)
                return false;
        }
        return true;
    }
}
