//
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//
// For example,
//
// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].
//


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if ( s == null || s.length() < 10) return result;
        
        int k = 0;
        
        for( int i = 0; i < s.length() ; i++){
            char temp = s.charAt(i);
            k = ((k << 3) | (temp & 0xf)) & 0x3fffffff;
            if ( i < 9) continue;
            if (map.containsKey(k)){
                map.put(k,map.get(k)+1);
                if(map.get(k) == 1) result.add(s.substring(i-9,i+1));
            } else {
                map.put(k,0);
            }
        }
        return result;
    }
}
