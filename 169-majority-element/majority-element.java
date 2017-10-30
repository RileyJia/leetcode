// Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);

        int max = 0;
        int count = 1;
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i-1]) count++;
            else {
                if (nums[i] == nums[i-1]) count++;
                if (count > max) {
                    max = count;
                    maxNum = nums[i - 1];
                }
                count = 1;
            }
        }
        return maxNum;
    }
}
