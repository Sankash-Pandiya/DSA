class Solution {
    public int maxPalindromes(String s, int k) {
       char[] st = new char[s.length() * 2 + 1];
       for(int i = 0; i < s.length(); i++) {
            st[2*i] = '#';
            st[(2*i) + 1] = s.charAt(i);
       }
       st[st.length - 1] = '#';
       int count = 0;
       int leftWall = -1;
       for(int i = 0; i < st.length; i++) {
            int leftIdx = i - 1;
            int rightIdx = i + 1;
            int currLen = 0;
            while(leftIdx >= 0 && rightIdx < st.length && st[leftIdx] == st[rightIdx]) {
                currLen++;
                if(currLen >= k && st[leftIdx] == '#') {
                    count++;
                    leftWall = rightIdx - 1;
                    i = rightIdx - 1;
                    break;
                }
                rightIdx++;
                leftIdx--;
                if(leftWall >= leftIdx) break;
            }
       }
       return count;
    }
}