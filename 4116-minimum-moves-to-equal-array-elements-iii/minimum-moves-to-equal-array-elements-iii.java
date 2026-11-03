class Solution {
    public int minMoves(int[] nums) {
        int maxVal = 0;
        for(int num : nums) maxVal = Math.max(maxVal, num);
        int moves = 0;
        for(int num : nums) moves += maxVal - num;
        return moves;
    }
}