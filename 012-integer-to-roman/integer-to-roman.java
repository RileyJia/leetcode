// Given an integer, convert it to a roman numeral.
//
//
// Input is guaranteed to be within the range from 1 to 3999.


class Solution {
     public String intToRoman(int num) {
        String result = new String("");
        int digit = 0;

        String[] table= new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX",
                "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
                "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
                "","M","MM","MMM"};

        while(num !=0) {
            result = table[num % 10 + digit] + result;
            num /= 10;
            digit += 10;
        }

        return result;


    }
}
