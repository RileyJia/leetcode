// Given an array and a value, remove all instances of that value in place and return the new length.
//
//
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//
// Example:
// Given input array nums = [3,2,2,3], val = 3
//
//
// Your function should return length = 2, with the first two elements of nums being 2.


class Solution {
    public int removeElement(int[] nums, int val) {
     if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] == val) return 0;
            return 1;
        }
        int i, len = nums.length - 1;

        for (i = 0; i < len; i++) {
            if (nums[i] == val) {
                while (len >= 0 && nums[len] == val ) len--;
                if (len < 0) return 0;
                if (len<i) break;
                int temp = nums[len];
                nums[len] = nums[i];
                nums[i] = temp;
                len--;
            }
        }
        if (nums[i] == val) return i;
        return i + 1;
    }
}
