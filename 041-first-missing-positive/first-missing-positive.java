//
// Given an unsorted integer array, find the first missing positive integer.
//
//
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
//
//
// Your algorithm should run in O(n) time and uses constant space.
//


class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for (int i = 0; i< nums.length; i++){
            if (nums[i] < 1) continue;
            if (nums[i] != num) {
                if (nums[i] == num - 1) continue;
                return num;
            }
            num++;
        }
        return num++;
    }
}
