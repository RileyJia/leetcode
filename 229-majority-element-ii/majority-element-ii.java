// Given an integer array of size n, find all elements that appear more than &lfloor; n/3 &rfloor; times. The algorithm should run in linear time and in O(1) space.


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length;){
            int count = 1;
            while (i+count < nums.length && nums[i+count] == nums[i]){
                count++;
            }
            if (count > nums.length / 3) result.add(nums[i]);
            i += count;
        }
        return result;
    }
}
