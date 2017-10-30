//
// Given a sorted integer array without duplicates, return the summary of its ranges.
//
// Example 1:
//
// Input: [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
//
//
//
// Example 2:
//
// Input: [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
//
//
//
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }

        int head = nums[0], tail = nums[0];

        for (int i = 0; i < nums.length; i++){
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) continue;
            tail = nums[i];
            if (head == tail) result.add(Integer.toString(head));
            else result.add(head + "->" + tail);
            if (i < nums.length - 1) head = nums[i + 1];
        }

        return result;
    }
}
