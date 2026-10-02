class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0,0,"",n,res);
        return res;
    }

    private void helper(int open, int close, String s, int n, List<String> res) {
        if(open == close && open + close == 2*n) {
            res.add(s);
            return;
        }
        if(open < n) helper(open + 1, close, s + "(", n, res);
        if(close < open) helper(open, close + 1, s + ")", n, res);
    }
}