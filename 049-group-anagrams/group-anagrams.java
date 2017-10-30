// Given an array of strings, group anagrams together.
//
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note: All inputs will be in lower-case.


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        

        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String temp = String.valueOf(str);
            if ( map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            } else {
                List<String> ele = new ArrayList();
                ele.add(strs[i]);
                map.put(temp,ele);
            }
        }
        
        for (List<String> ele : map.values()) {
            res.add(ele);
        }
        return res; 
    }
}
