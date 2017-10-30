//
// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
//
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Write a function to determine if a given target is in the array.
//
// The array may contain duplicates.


class Solution {
    public boolean search(int[] nums, int target) {
        /* ************** BINARY SEARCH ************* */
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) return false;
        int head = 0, tail = nums.length -1;

        while(head < tail) {
            int point = (head + tail) / 2;
            if (nums[head] == target || nums[point] == target || nums[tail] == target) return true;
            if (nums[point] == nums[tail]){
                while (tail > point && nums[point] == nums[tail]) tail--;
            } else if (nums[point] < nums[tail]) {
                if (nums[point] < target && nums[tail] > target) {
                    head = point + 1;
                } else {
                    tail = point;
                }
            } else {
                if (nums[point] > target && nums[head] < target){
                    tail = point;
                } else {
                    head = point + 1;
                }
            }
        }
        if (nums[head] == target) return true;


        return false;

        /* ************** BRUTE FORCE ************** */
        /*if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) return false;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < target){
                if (nums[i] > nums[i + 1]) return false;
            } else if (nums[i] > target) {
                if (i != 0 && nums[i] < nums [i-1]) {
                    return false;
                }
                continue;
            } else return true;
        }
        return false;*/
    }
}
