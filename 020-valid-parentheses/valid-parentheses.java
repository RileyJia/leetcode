// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//


class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == 41 || s.charAt(0) == 93 || s.charAt(0) == 125) return false;
        stack.push(s.charAt(0));

        for (int i = 1; i< s.length() ;i ++) {

            if (s.charAt(i) == 41 || s.charAt(i) == 93 || s.charAt(i) == 125) {
                if (Math.abs(s.charAt(i) - stack.pop()) > 3) return false;
            }
            if (s.charAt(i) == 40 || s.charAt(i) == 91 || s.charAt(i) == 123) {
                stack.push(s.charAt(i));
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}
