class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] stableIdx = new int[n];
        int leftMax = nums[0]; 
        for(int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            int rightMin = nums[i];
            for(int j = i; j < n; j++) rightMin = Math.min(rightMin, nums[j]);
            stableIdx[i] = leftMax - rightMin;
        }
        for(int i = 0; i < n; i++) {
            if(stableIdx[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}