// Given a pattern and a string str, find if str follows the same pattern.
//  Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
// Examples:
//
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
//
//
//
//
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
//
//
// Credits:Special thanks to @minglotus6 for adding this problem and creating all test cases.


class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null || str.length() == 0) return true;
        HashMap<Character,String> map = new HashMap<>();
        int patternPointer = 0;
        int head = 0;
        int i = 0;
        while(i < str.length()){
            while(i < str.length() && str.charAt(i) != ' '){
                i++;
            }
            if (patternPointer >= pattern.length()) return false;
            String sub = str.substring(head,i);
            if (map.containsKey(pattern.charAt(patternPointer))){
                //System.out.println(sub + ", "+ map.get(pattern.charAt(patternPointer)));
                if (!sub.equals(map.get(pattern.charAt(patternPointer)))) return false;
            } else {
                if (map.containsValue(sub)) return false;
                map.put(pattern.charAt(patternPointer),sub);
            }
            head = i + 1;
            i++;
            patternPointer++;
        }   
        if (patternPointer != pattern.length()) return false;
        return true;
    }
}
