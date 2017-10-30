// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
//
// Note:
//
// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//


class Solution {
    public String multiply(String num1, String num2) {
        char[] num01 = num1.toCharArray();
        char[] num02 = num2.toCharArray();
        int[] letterM = new int[num02.length + num01.length];
        for (int i = 0; i< letterM.length;i++){
            letterM[i] = 0;
        }
        for (int i = num02.length - 1; i >= 0; i--){
            for (int j = num01.length - 1; j >=0; j--){
                letterM[i + j + 1] += (num01[j] - '0') * (num02[i] - '0');
            }
        }
        String result = "";
        int inc= 0;
        for (int i = letterM.length-1; i>=0; i--){
            int letter = letterM[i] + inc;
            result = letter % 10 + result;
            inc = letter / 10;
        }
        for (int i = 0; i<letterM.length; i++){
            if(result.charAt(i) != '0') return result.substring(i);
        }

        return "0";
    }
}
