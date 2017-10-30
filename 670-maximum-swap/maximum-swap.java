//
// Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
//
//
// Example 1:
//
// Input: 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
//
//
//
// Example 2:
//
// Input: 9973
// Output: 9973
// Explanation: No swap.
//
//
//
//
// Note:
//
// The given number is in the range [0, 108]
//
//


class Solution {
    public int maximumSwap(int num) {
        int[] temp = new int[8];
        int[] max = new int[8];
        int i = 0;
        int res = 0;
        while(num != 0){
            int digit = num % 10;
            temp[i] = digit;
            if (i == 0) max[i] = digit;
            else max[i] = Math.max(max[i-1],digit);
            i++;
            num = num / 10;
        }
        for ( int j = i - 1; j >= 0; j--){
            if (temp[j] == max[j]) res = res * 10 + temp[j];
            else {
                int swap = temp[j];
                res = res*10 + max[j];
                j--;
                while (j != 0 && max[j] == max[j-1]){
                    res = res*10 + temp[j];
                    j--;
                }
                res  = res * 10 + swap;
                for (int k = j - 1; k >= 0; k--){
                    res = res * 10 + temp[k];
                }
                break;
            }
        }
        return res;
    }
}
