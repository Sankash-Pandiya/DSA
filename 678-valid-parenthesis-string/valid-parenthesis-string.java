class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n + 1][n + 1]; 
        return solve(s, 0, 0, dp);
    }
    private boolean solve(String s, int idx, int balance, Boolean[][] dp) {
        if(balance < 0) return false;
        if(idx == s.length()) return balance == 0;

        if(dp[idx][balance] != null) return dp[idx][balance];

        char c = s.charAt(idx);
        boolean res;

        if(c == '(') res = solve(s, idx + 1, balance + 1, dp);
        else if(c == ')') res = solve(s, idx + 1, balance - 1, dp);
        else {
            res = solve(s, idx + 1, balance, dp)
        || solve(s, idx + 1, balance + 1, dp)
        || solve(s, idx + 1, balance - 1, dp);
        }

        dp[idx][balance] = res;

        return res;
    }
}