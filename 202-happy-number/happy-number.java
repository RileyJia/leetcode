// Write an algorithm to determine if a number is "happy".
//
// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
// Example:&nbsp;19 is a happy number
//
//
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
//
//
// Credits:Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.


class Solution {
    public boolean isHappy(int n) {
        int slow = divide(n);
        int fast = divide(divide(n));
        while(slow != fast){
            slow = divide(slow);
            fast = divide(divide(fast));
        }
        if (slow == 1) return true;
        return false;
    }
    
    public int divide(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
        
 /*       int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n!=1){
            if (map.containsKey(n)){
                return false;
            }
            int temp = n; 
            while(n!=0){
                int digit = n % 10; 
                sum += digit * digit;  
                n /= 10;  
            }
            map.put(temp,sum);
            n = sum;
            sum = 0;
        }
        return true;
    }
    */
}
