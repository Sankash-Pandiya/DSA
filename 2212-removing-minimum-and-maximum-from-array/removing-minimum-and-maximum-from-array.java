class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }

            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // Delete everything from the front
        int deleteFromFront = right + 1;

        // Delete everything from the back
        int deleteFromBack = n - left;

        // Delete some from front and some from back
        int deleteBothSides = (left + 1) + (n - right);

        return Math.min(
            deleteFromFront,
            Math.min(deleteFromBack, deleteBothSides)
        );
    }
}