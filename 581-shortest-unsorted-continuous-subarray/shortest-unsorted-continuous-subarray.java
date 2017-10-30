// Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.  
//
// You need to find the shortest such subarray and output its length.
//
// Example 1:
//
// Input: [2, 6, 4, 8, 10, 9, 15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//
//
//
// Note:
//
// Then length of the input array is in range [1, 10,000].
// The input array may contain duplicates, so ascending order here means <=. 
//
//


class Solution {
     public int findUnsortedSubarray(int[] nums) {
        if (nums== null || nums.length < 2) return 0;
        int j=0,point1=0, point2 = 1;
        while(point2 < nums.length){
            if (nums[point1] > nums[point2]){
                break;
            } else if (nums[point1] == nums[point2]){
                point2++;
            } else {
                point1++; point2++;
            }
            if (point2==nums.length) return  0;
        }
        int end = point1 + 1,max = nums[point1],min = nums[point2];
        for (j = end; j < nums.length - 1; j++){
            if (nums[j] > nums[j + 1]) {
                end = j + 1;
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j+1]);
            }
        }
        int head = point1;
        for (j = 0; j < point1; j++) {
            if (nums[j] > min) {
                head = j;
                break;
            }
        }

        for (j = end + 1; j < nums.length; j++){
            if (nums[j] >= max) return j - head;
        }
        return nums.length - head;
    }
}
