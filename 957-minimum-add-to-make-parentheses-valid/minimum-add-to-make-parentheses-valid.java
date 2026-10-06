class Solution {
    public int minAddToMakeValid(String s) {
        int totalOpr = 0, curr = 0;
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(curr == 0) totalOpr++;
                else curr--;
            }
            else curr++;
        }
        return curr + totalOpr;
    }
}