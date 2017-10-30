// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.


class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) return -1;
        int head = 0, tail = nums.length -1;

        while(head < tail){
            int point = (head + tail) / 2;
            if (nums[head] == target) return head;
            if (nums[tail] == target) return tail;
            if (nums[point] == target) return point;

            if (nums[point] > nums[head]){
                if (nums[point] > target && nums[head] < target){
                    tail = point;
                } else {
                    head = point + 1;
                }
            } else {
                if (nums[point] < target && nums[tail] > target){
                    head = point + 1;
                } else {
                    tail = point;
                }
            }
        }
        if (nums[head] == target) return head;
        return -1;
    }
}
