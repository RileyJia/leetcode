//
// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//
//
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
//
//
//
// You should return the indices: [0,9].
// (order does not matter).
//


class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int strLen = s.length();
        int wordLen = words[0].length();
        
        HashMap<String, Integer> wordmap = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if(wordmap.containsKey(words[i])){
                wordmap.put(words[i], wordmap.get(words[i]) + 1);
            } else {
                wordmap.put(words[i], 1);
            }
        }
        
        for (int i = 0; i < wordLen; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int head = i;
            int count = 0;
            for (int j = i; j <= strLen - wordLen; j = j + wordLen){
                String word = s.substring(j, j + wordLen);
                if (wordmap.containsKey(word)){
                    if (map.containsKey(word)){
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                    
                    count++;
                    
                    while (map.get(word) > wordmap.get(word)){
                        String temp = s.substring(head, head + wordLen);
                        map.put(temp, map.get(temp) - 1);
                        head = head + wordLen;
                        count--;
                        if (temp.equals(word)) {
                            break;
                        }
                    }
                    
                    if (count == words.length){
                        res.add(head);
                        String temp = s.substring(head, head + wordLen);
                        map.put(temp, map.get(temp) - 1);
                        head += wordLen;
                        count--;
                        
                    }
                } else {
                    count = 0;
                    map = new HashMap();
                    head = j + wordLen;
                }
            }
        }
        return res;
    }
}
