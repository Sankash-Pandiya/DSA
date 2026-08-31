class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        if(head == null || head.next == null || head.next.next == null) return ans;

        ListNode prev = head;
        ListNode curr = head.next;

        int idx = 1;
        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        while(curr.next != null) {
            if((curr.val > prev.val && curr.val > curr.next.val) ||
            (curr.val < prev.val && curr.val < curr.next.val)) {
                if(first == -1) first = idx;
                else minDist = Math.min(minDist, idx - last);
                last = idx;
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }  

        if(first == -1 || first == last) return ans;
        ans[0] = minDist;
        ans[1] = last - first;

        return ans;
    }
}