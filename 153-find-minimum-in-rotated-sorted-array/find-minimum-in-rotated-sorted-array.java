// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.


class Solution {
    public int findMin(int[] nums) {
        /* ************** BINARY SEARCH ************* */
        int head = 0, tail = nums.length -1, point;

        while (head < tail){
            point = (head + tail) / 2;
            if (nums[point] > nums[tail]) head = point + 1;
            else tail = point;
        }

        return nums[tail];

        /* ************** BRUTE FORCE ************** */

        /*if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]) return nums[i];
        }
        return nums[0];*/
    }
}
