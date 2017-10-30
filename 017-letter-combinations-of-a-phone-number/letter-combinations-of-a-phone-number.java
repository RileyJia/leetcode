// Given a digit string, return all possible letter combinations that the number could represent.
//
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
//
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.
//


class Solution {
   public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();

       
        List<String> result = new LinkedList<>();
        String[] table = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        char[] chd = digits.toCharArray();
        char[] element = new char[digits.length()];
        getElement(chd,0,result,table,digits,element);

        return result;
    }

    private void getElement(char[] chd,int index, List<String> re, String[] table, String digits, char[] element){
        if (index == chd.length){
            re.add(new String(element));
            return;
        }

        char strChar = digits.charAt(index);
        for (int i = 0; i < table[strChar-'0'].length(); i++) {
            element[index] = table[strChar-'0'].charAt(i);
            getElement(chd,index + 1, re, table, digits, element);
        }
    }
}
