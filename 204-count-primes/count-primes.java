// Description:
// Count the number of prime numbers less than a non-negative number, n.
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        if (n < 2) return 0;

        for (int i = 2; i * i < n; i++){
            if (nums[i]) continue;
            for(int j = i; j * i < n; j++){
                nums[i * j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n ; i++){
            if (!nums[i]) {
                //System.out.println(i);
                count++;
            }
        }
        return count;
    }
}
