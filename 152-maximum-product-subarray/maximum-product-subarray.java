//
// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.
//


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int global = 0;
        int localMax = 1;
        int localMin = 1;

        for (int i = 0; i < nums.length; i++) {
            int tempMax = localMax;
            int tempMin = localMin;
            localMax = Math.max(Math.max(tempMax * nums[i], nums[i]),tempMin * nums[i]);
            localMin = Math.min(Math.min(tempMax * nums[i], nums[i]),tempMin * nums[i]);
            global = Math.max(localMax, global);
        }

        return global;
    }
}
