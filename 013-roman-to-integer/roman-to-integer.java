// Given a roman numeral, convert it to an integer.
//
// Input is guaranteed to be within the range from 1 to 3999.


class Solution {
    public int romanToInt(String s) {
         int[] chs = new int[s.length()];
        int result = 0;

        for (int i = 0; i < chs.length; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    chs[i] = 1; break;
                case 'V':
                    chs[i] = 5; break;
                case 'X':
                    chs[i] = 10; break;
                case 'L':
                    chs[i] = 50; break;
                case 'C':
                    chs[i] = 100; break;
                case 'D':
                    chs[i] = 500; break;
                case 'M':
                    chs[i] = 1000; break;
            }
        }
        for (int i = 0; i < chs.length; i++){
            if ( i == chs.length - 1){
                result += chs[i];
            } else if (chs[i] < chs [i + 1]){
                result = result - chs [i] ;
            } else result += chs[i];

        }
        return result;
    }
}
