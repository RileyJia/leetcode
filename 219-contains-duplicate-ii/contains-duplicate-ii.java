//
// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//


import java.util.Hashtable;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       if (nums.length < 2) return false;
        if (k > 3000) return false;

        for(int i = 0 ; i < nums.length - 1; i++){
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++){
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
