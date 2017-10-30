// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note: The solution set must not contain duplicate quadruplets.
//
//
//
// For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
//


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);

        if (nums.length < 4) return result;
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] != target) return result;
        }
        if(nums[0] * 4 > target || nums[nums.length-1] * 4 < target) return result;


        for (int first = 0; first < nums.length - 3;){
            for (int second = first + 1; second < nums.length - 2; ){
                int third = second + 1;
                int fourth = nums.length - 1;
                while (third < fourth){
                    if (nums[first] + nums[second] + nums[third] + nums[fourth] == target){
                        List<Integer> ele = new LinkedList<Integer>();
                        ele.add(nums[first]);
                        ele.add(nums[second]);
                        ele.add(nums[third]);
                        ele.add(nums[fourth]);
                        result.add(ele);

                        for (int i = third + 1; ;i++){
                            if (nums[third] == nums [i] && i < nums.length - 1) continue;
                            third = i;break;
                        }

                        for (int i = fourth - 1;; i--){
                            if (nums[fourth] == nums[i] && i > 0) continue;
                            fourth = i;break;
                        }


                    } else if (nums[first] + nums[second] + nums[third] + nums[fourth] > target) {
                        for (int i = fourth - 1; ; i--){
                            if (nums[fourth] == nums[i] && i > 0) continue;
                            fourth = i; break;
                        }
                    } else {
                        for (int i = third + 1;;i++){
                            if (nums[third] == nums [i] && i < nums.length - 1) continue;
                            third = i;break;
                        }
                    }
                }

                for (int i = second + 1;;i++){
                    if (nums[second] == nums [i] && i< nums.length - 2) continue;
                    second = i;break;
                }
            }
            for (int i = first + 1;;i++){
                if (nums[first] == nums [i] && i< nums.length - 3) continue;
                first = i;break;
            }
        }

        return result;
    }
}
