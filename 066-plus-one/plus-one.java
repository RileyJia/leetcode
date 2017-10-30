// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//
// You may assume the integer do not contain any leading zero, except the number 0 itself.
//
// The digits are stored such that the most significant digit is at the head of the list.


class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[0];
        if (digits.length == 1 && digits[0] == 0) return new int[]{1};

        int position = digits.length - 1;
        while (digits[position] == 9) {
            digits[position] = 0;
            position --;

            if (position < 0){
                int[] temp = new int[digits.length + 1];
                System.arraycopy(digits,0,temp,1, digits.length);
                position++;
                digits = temp;
            }
        }
        digits[position] += 1;

        return digits;
    }
}
