class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean even = false, odd = false;
        int minVal = nums1[0];
        for(int num : nums1) {
                if((num & 1) == 0) {
                    even = true;
                }
                else {
                    odd = true;
                }
                minVal = Math.min(minVal, num);
        }
        if(even && odd) {
            if(minVal % 2 == 0) return false;
            return true;
        }
        return true;
    }
}