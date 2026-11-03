class Solution {
    public int minMoves(int[] nums) {
        int maxVal = 0, sum = 0;
        for(int num : nums) {
            sum += num;
            maxVal = Math.max(maxVal, num); 
        }
        return maxVal * nums.length - sum;
    }
}