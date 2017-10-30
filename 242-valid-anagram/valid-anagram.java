// Given two strings s and t, write a function to determine if t is an anagram of s. 
//
// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.
//
//
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() != s.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int [] map = new int[256];
        for (int i = 0; i < s.length(); i++){
            map[sc[i]]++;
        }
        for (int i =0; i <t.length(); i++){
            map[tc[i]]--;
            if (map[tc[i]]<0) return false;
        }
        return true;
        /*HashMap<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(sc[i])){
                map.put(sc[i],map.get(sc[i])+1);
            } else 
                map.put(sc[i],1);
        }
        
        for (int i = 0; i < t.length(); i++){
            if (map.containsKey(tc[i])){
                if (map.get(tc[i]) < 1) return false;
                map.put(tc[i],map.get(tc[i])-1);
            } else
                return false;
        }
        return true;*/
    }
}
