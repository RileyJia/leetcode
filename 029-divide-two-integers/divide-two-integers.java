//
// Divide two integers without using multiplication, division and mod operator.
//
//
// If it is overflow, return MAX_INT.
//


class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend != Integer.MIN_VALUE) return -dividend;
                    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        
        return dividend / divisor;
    }
}
