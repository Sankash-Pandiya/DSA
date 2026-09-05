class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int duplicates = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            else duplicates++;
        }
        return n - duplicates + 1;
    }
}