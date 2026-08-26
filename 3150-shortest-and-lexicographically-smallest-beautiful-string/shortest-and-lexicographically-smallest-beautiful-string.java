class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int onecount = 0;
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        String ans = "";

        for(int right = 0; right < s.length(); right++) {
            if(s.charAt(right) == '1') onecount++;
            while(onecount > k) {
                if(s.charAt(left) == '1') onecount--;
                left++;
            }
            while(left <= right && s.charAt(left) == '0') left++;

            if(onecount == k) {
                String curr = s.substring(left, right + 1);
                if(curr.length() < minlen || curr.length() == minlen && curr.compareTo(ans) < 0) {
                    minlen = curr.length();
                    ans = curr;
                }
            }
        }

        return ans;
    }
}