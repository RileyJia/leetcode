// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in parentheses.
//
// For example,
//
// Given numerator = 1, denominator = 2, return "0.5".
// Given numerator = 2, denominator = 1, return "2".
// Given numerator = 2, denominator = 3, return "0.(6)".
//
//
//
// Credits:Special thanks to @Shangrila for adding this problem and creating all test cases.


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        long result = 0;

         long n = numerator;
        long d = denominator;


        StringBuilder str = new StringBuilder();
        if (n *  d < 0) {
            str.append("-");
        }

        n = Math.abs(n);
        d = Math.abs(d);

        if (n >= d){
            result = n / d;
            n -= d * result;
        }
        str.append(Long.toString(result));
        if (n != 0) str.append(".");

        HashMap<Long,Integer> divid = new HashMap<>();
        int index = str.length();


        divid.put(n,index);

        while (n != 0){
            n *= 10;
            Long di = n / d;
            str.append(Long.toString(di));

            n = n - d * di;

            if (divid.containsKey(n)){
                int position = divid.get(n);
                str.insert(position,"(");


                str.insert(str.length(),")");
                return str.toString();
            }

            index++;
            divid.put(n,index);
        }

        return str.toString();
    }
}
