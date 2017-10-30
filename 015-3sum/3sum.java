// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note: The solution set must not contain duplicate triplets.
//
//
// For example, given array S = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new LinkedList();
        if (nums.length == 0) return result;

        List<Integer> ele;
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i-1] ==nums[i]) continue;
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail){
                if (nums[tail] + nums [head] == 0 - nums[i]) {
                    ele = new LinkedList<>();
                    ele.add(nums[i]);
                    ele.add(nums[head]);
                    ele.add(nums[tail]);
                    result.add(ele);
                    for (int j = 1;;j++){
                        if(nums[tail] == nums[tail-j] && tail - j > head)continue;
                        tail -=j;break;
                    }
                    for (int j = 1;;j++){
                        if(nums[head] == nums[head+j] && head + j < tail) continue;
                        head += j;break;
                    }

                } else if(nums[tail] + nums [head] < 0 - nums[i]){
                    head++;
                } else tail--;

            }

        }
        return result;
    }
}
