// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[256];   // represent all ASCII code
        int start = 0, max = 0 , i = 0; 
        for(; i < s.length(); i++) {
            if (table[s.charAt(i)] != 0 && table[s.charAt(i)] >= start+1){
                max = Math.max(i-start, max);
                start = table[s.charAt(i)];
            }
            table[s.charAt(i)] = i+1;
        }
        return Math.max(i-start, max);
    }
        
        
// ************************** REGULAR SOLUTION *************************/        
//         if(s.equals("")) return 0;
//         char[] chs = s.toCharArray();
//         LinkedList<Character> result = new LinkedList<>();
//         LinkedList<Character> tempCh = new LinkedList<>();

//         int i = 1;
//         if (chs.length == 1) return 1;
//         tempCh.add(chs[0]);
//         result.add(chs[0]);
//         while(i < s.length()){
//             char temp = chs[i];
//             int length = tempCh.size();
//             for (int j = 0; j < length; j++){
//                 if(temp == tempCh.get(j)){
//                     for (int k = j ; k >=0; k--) tempCh.remove(k);
//                     tempCh.add(temp);
//                     break;
//                 } else if (j == tempCh.size() - 1) {
//                     tempCh.add(temp);
//                 }
//             }

//             if (tempCh.size() > result.size()){
//                 result = (LinkedList<Character>) tempCh.clone();
//             }
//             i++;
//         }
//         return result.size();
//   }
}
