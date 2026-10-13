class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        for(int i = 0; i < n / 2; i++) ans -= nums[i];
        for(int i = n / 2; i < n; i++) ans += nums[i];
        return ans;
    }
}