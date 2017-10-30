// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
// For example,
// Given "egg", "add", return true.
//
// Given "foo", "bar", return false.
//
// Given "paper", "title", return true.
//
// Note:
// You may assume both s and t have the same length.


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0) return true;

        char[] map = new char[256];
        boolean[] check = new boolean[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        for(int i = 0; i < sc.length; i++){
            if (map[sc[i]] == 0){
                if (check[tc[i]]) return false;
                map[sc[i]] = tc[i];
                check[tc[i]] = true;
            } else {
                if (map[sc[i]] != tc[i]) return false;
                
            }
        }
        return true;
        
        /*HashMap<Character, Character> map = new HashMap<>();
        if(s == null || s.length() == 0) return true;
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();


        for (int i = 0; i < s.length(); i++){
            if(map.containsKey(sc[i])){
                if(tc[i] != map.get(sc[i])) return false;
            } else{
                if(map.containsValue(tc[i])) return false;
                map.put(sc[i],tc[i]);
            }
        }
        return true;*/
    }
}
