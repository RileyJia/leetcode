//
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
//
//
// Minimum window is "BANC".
//
//
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
//
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
//


class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        int minLen = s.length() + 1;
        int head = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                count++;

                if (map.get(s.charAt(i)) < 0) {
                    count--;
                }
                while (head < s.length() && !map.containsKey(s.charAt(head))) {
                    head++;
                }
            }

            if (count == t.length()){
                while (!map.containsKey(s.charAt(head)) || map.get(s.charAt(head)) < 0){
                    if (map.containsKey(s.charAt(head))) map.put(s.charAt(head), map.get(s.charAt(head)) + 1);
                    head++;
                }
                if (i - head + 1 < minLen) {
                    minLen = i - head + 1 ;
                    res = s.substring(head,i + 1);
                }
                map.put(s.charAt(head), map.get(s.charAt(head)) + 1);
                count--;
                head++;
                while (head < s.length() && !map.containsKey(s.charAt(head))) {
                    head++;
                }
            }
        }
        if (minLen > s.length()) return "";
        return res;
    }
}
