//
// Given two arrays, write a function to compute their intersection.
//
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//
// Note:
//
// Each element in the result must be unique.
// The result can be in any order.
//
//


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        
        List<Integer> res = new ArrayList<>();
        int max = nums1[0];
        int min = nums1[0];
        
        for(int i = 1; i < nums1.length; i++){
            if (nums1[i] > max) max = nums1[i];
            else if (nums1[i] < min) min = nums1[i];
        }            
        
        boolean[] map = new boolean[max - min + 1];
        
        for(int i = 0; i < nums1.length; i++){
             map[nums1[i] - min] = true;
        }
        
        for (int i = 0; i < nums2.length; i++){
            if(nums2[i] >= min && nums2[i] <= max){
                if(map[nums2[i]-min]){
                    res.add(nums2[i]);
                    map[nums2[i]-min] = false;
                }
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
