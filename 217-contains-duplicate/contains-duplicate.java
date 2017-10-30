//
// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
//


class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < min) min = nums[i];
            else if (nums[i] > max) max = nums[i];
        }
        
        boolean[] map = new boolean[max - min + 1];
        for(int i = 0; i < nums.length; i++){
            if (map[nums[i] - min]) return true;
            map[nums[i] - min] = true;
        }
        return false;
        
        
        /* ************************ BRUTE FORCE *********************** */
        /*
        if (nums.length < 2) return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length;){
            int inc = 1;
            while (i + inc < nums.length && nums[i] == nums[i + inc]) {
                inc++;
            }
            if (inc != 1) return true;
            i += inc;
        }
        return false;*/
    }
}
