//
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum &ge; s. If there isn't one, return 0 instead.
//
//
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.
//
//
// click to show more practice.
//
// More practice:
//
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
//
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = start; i < nums.length;i++){
            sum += nums[i];

            while (sum >= s){
                minLen = Math.min(minLen,i - start + 1);
                sum -= nums[start++];
            }

        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }
}
