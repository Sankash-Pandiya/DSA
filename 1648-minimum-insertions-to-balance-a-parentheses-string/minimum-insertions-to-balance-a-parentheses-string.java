class Solution {
    public int minInsertions(String s) {
        int balance = 0, totalOpr = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                if((balance & 1) == 1) {
                    balance--;
                    totalOpr++;
                }
                balance += 2;
            }
            else {
                balance--;
            }
            if(balance < 0) {
                totalOpr++;
                balance = 1;
            }
        }
        return totalOpr + balance;
    }
}