//
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//
// The replacement must be in-place, do not allocate extra memory.
//
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 &#8594; 1,3,2
// 3,2,1 &#8594; 1,2,3
// 1,1,5 &#8594; 1,5,1
//


class Solution {
    public void nextPermutation(int[] nums) {
        int index = 0;
        boolean flag = false;
        for (int i = nums.length - 2 ;i >= 0 ;i --) {
            if (nums[i] > nums[i + 1]) continue;
            else {
                for (int j = nums.length - 1; j > i; j-- ) {
                    if (nums[j] > nums[i]) {
                        int temp= nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        index = i + 1;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        int constant = index;
        for (int i = 1; i <= (nums.length - constant) / 2 ; i++) {
            int temp = nums [nums.length - i];
            nums [nums.length - i] = nums[index];
            nums[index] = temp;
            index++;
        }
    }
}
