//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generate(n, result, 0, 0, "");
        return result;
    }

    private void generate(int n, List<String> result, int l, int r,String temp){
        if (l == n){
            for (int i = r + 1;i<=n; i++){
                temp += ")";
            }
            result.add(temp);
            return;
        }

        if (l > r) {
            generate(n, result, l , r + 1, temp + ")");
        }
        generate(n,result,l + 1, r,temp + "(");
    }
}
