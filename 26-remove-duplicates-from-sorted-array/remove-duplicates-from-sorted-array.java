class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int duplicates = 0;
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(!set.contains(nums[i])) {
                nums[k++] = nums[i];
                set.add(nums[i]);
            }
            else {
                duplicates++;
            }
        }
        return n - duplicates;
    }
}