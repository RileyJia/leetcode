//
// Follow up for "Find Minimum in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
//
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// The array may contain duplicates.


class Solution {
    public int findMin(int[] nums) {
        int head = 0, tail = nums.length -1, point;

        while (head < tail){
            point = (head + tail) / 2;
            if (nums[point] == nums[tail]){
                while (tail > point && nums[point] == nums[tail]) tail--;
                //if (tail == -1) return nums[0];
                //tail++;
            }
            else if (nums[point] > nums[tail]) head = point + 1;
            else tail = point;
        }
        return nums[tail];
    }
}
