// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
//


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int head = 0;
        int tail = nums.length - 1;
        if (nums[head] > target || nums[tail] < target) return new int[]{-1,-1};
        if (nums[head] == target && nums[tail] == target) {
            return new int[]{head,tail};
        }
        while (head <= tail) {
            int point = (head + tail) / 2;
            if (nums[point] > target) {
                tail = point - 1;
                continue;
            } else if (nums[point] < target) {
                head = point + 1;
                continue;
            } else {
                int i = 1;
                if (point != nums.length - 1) {
                    for (i = 1; ; i++) {
                        if (point + i< nums.length && nums[point + i] == target) continue;
                        break;
                    }
                }
                tail = point + i - 1;
                i = 1;
                if (point!= 0) {
                    for (i = 1; ; i++) {
                        if (point - i >= 0 && nums[point - i] == target) continue;
                        break;
                    }
                }
                head = point + 1 - i;
                return new int[]{head,tail};
            }
        }
        return new int[]{-1,-1};      
    }
}
