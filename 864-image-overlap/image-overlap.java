class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> arr1 = new ArrayList<>();
        List<int[]> arr2 = new ArrayList<>();
        for(int i = 0; i  < n; i++) {
            for(int j = 0;  j < n; j++) {
                if(img1[i][j] == 1) arr1.add(new int[]{i, j});
                if(img2[i][j] == 1) arr2.add(new int[]{i, j});
            }
        }
        int[][] count = new int[n * 2][n * 2];
        int best = 0;
        for(int[] a : arr1) {
            for(int[] b : arr2) {
                int dx = b[0] - a[0] + n;
                int dy = b[1] - a[1] + n;
                best = Math.max(best, ++count[dx][dy]); 
            }
        }
        return best;
    }
}