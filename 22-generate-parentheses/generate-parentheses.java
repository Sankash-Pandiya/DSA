class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(0,0,sb,n,res);
        return res;
    }

    private void helper(int open, int close, StringBuilder s, int n, List<String> res) {
        if(open == n && close == n) {
            res.add(s.toString());
            return;
        }
        if(open < n) {
            s.append('(');
            helper(open + 1, close, s, n, res);
            s.deleteCharAt(s.length() - 1);
        }
        if(close < open) {
            s.append(')');
            helper(open, close + 1, s, n, res);
            s.deleteCharAt(s.length() - 1);
        }
    }
}