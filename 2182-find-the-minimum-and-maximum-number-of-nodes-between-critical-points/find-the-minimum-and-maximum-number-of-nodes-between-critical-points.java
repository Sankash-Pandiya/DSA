/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        ListNode temp = head;
        int n = 0;
        int minDist = Integer.MAX_VALUE;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        if(n < 3) return ans;
        List<Integer> critIdx = new ArrayList<>();
        ListNode prev = head;
        temp = head;
        temp = temp.next;
        for(int i = 1; i < n - 1; i++) {
            if((temp.val < prev.val && temp.val < temp.next.val) || 
            (temp.val > prev.val && temp.val > temp.next.val)) {
                critIdx.add(i);
            }
            prev = temp;
            temp = temp.next;
        }
        if(critIdx.size() < 2) return ans;
        for(int i = 1; i < critIdx.size(); i++) {
            minDist = Math.min(minDist, critIdx.get(i) - critIdx.get(i - 1));
        }
        ans[0] = minDist;
        ans[1] = critIdx.get(critIdx.size() - 1) - critIdx.get(0);
        return ans;
    }
}