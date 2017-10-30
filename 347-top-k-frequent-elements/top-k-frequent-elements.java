//
// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//
// Note: 
//
// You may assume k is always valid, 1 &le; k &le; number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for ( int i = 0; i< nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        List<Integer>[] sort = new List[nums.length + 1];
        for(int key : map.keySet()){
            int times = map.get(key);
            if (sort[times] == null){
                ArrayList<Integer> ele = new ArrayList<>();
                ele.add(key);
                sort[times] = ele;
            } else {
                sort[times].add(key);
            }
        }
        for (int i = sort.length - 1; i >= 0; i--){
            if(sort[i] != null){
                result.addAll(sort[i]);
                if (result.size() == k) break;
            }
        }
        return result;
    }
}
