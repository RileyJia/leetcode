// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example:
//
// Input: "babad"
//
// Output: "bab"
//
// Note: "aba" is also a valid answer.
//
//
//
// Example:
//
// Input: "cbbd"
//
// Output: "bb"
//
//


class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        char[] chs = new char[s.length() * 2 + 1];
        chs[0]='#';
        for (int i = 1; i < s.length() * 2 + 1; i= i + 2){
            chs[i] = s.charAt(i / 2);
            chs[i+1] = '#';
        }

        char[] resultTrans = new char[1];
        resultTrans[0] = chs[0];
        int border = 0;

        for (int i = 1; i < chs.length ; i++){
            if (i > chs.length / 2) {
                border = chs.length - i -1;
            } else border = i;

            for (int j = 1; j <= border; j++){
                if (chs[i - j] != chs [i + j]) break;
                if ((i - j) > 0 && (i + j) < (chs.length - 1) && chs[i - j - 1] == chs [i + j + 1]) continue;
                char[] temp = new char[1 + 2 * j];
                System.arraycopy(chs, i-j,temp,0,1 + 2 * j);
                if (temp.length > resultTrans.length) {
                    resultTrans = temp;
                    if (resultTrans.length == chs.length) {
                        char[] result = new char[resultTrans.length / 2];
                        for (int k = 0; k < result.length; k++){
                            result[k]=resultTrans[k * 2 + 1];
                        }
                        return new String(result);
                    }
                }
            }
        }
        char[] result = new char[resultTrans.length / 2];
        for (int k = 0; k < result.length; k++){
            result[k]=resultTrans[k * 2 + 1];
        }
        return new String(result);
    }


}
