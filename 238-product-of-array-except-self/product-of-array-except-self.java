//
// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
// Solve it without division and in O(n).
//
// For example, given [1,2,3,4], return [24,12,8,6].
//
// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] back = new int[nums.length];        
        int[] result = new int[nums.length];
        
        
        
        back[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            back[i] = nums[i+1] * back[i + 1];
        }

        int front = 1;
        result[0] = back[0];
        for (int i = 1; i < nums.length; i++){
            front *= nums[i - 1];
            result[i] = front * back[i];
        }
        return result;       
    }
}
