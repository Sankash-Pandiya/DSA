class Solution {
    public int maxDepth(String s) {
        int max_depth = 0, curr_depth = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                curr_depth++;
                max_depth = Math.max(max_depth, curr_depth);
            }
            if(c == ')') curr_depth--; 
        }
        return max_depth;
    }
}