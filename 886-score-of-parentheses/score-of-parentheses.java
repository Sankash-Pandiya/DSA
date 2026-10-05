class Solution {
    public int scoreOfParentheses(String s) {
        return f(s, 0, s.length());
    }

    private int f(String s, int i, int j) {
        int ans = 0, bal = 0;
        for(int k = i; k < j; k++) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if(bal == 0) {
                if (k - i == 1) {
                    ans++;
                }
                else {
                    ans += 2 * f(s, i + 1, k);
                }
                i = k + 1;
            }
        }
        return ans;
    }
}