class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        Set<Integer> set = new HashSet<>();
        // k = i - j + n;-> j = i - k + n;
        for(int k = 1;k < m + n;k++){
            int minJ = Math.max(0,n - k);
            int maxJ = Math.min(n - 1,m + n - k - 1);
            set.clear();
            for(int j = minJ;j <= maxJ;j++){
                int i = k + j - n;
                ans[i][j] = set.size();
                set.add(grid[i][j]);
            }
            set.clear();
            for(int j = maxJ;j >= minJ;j--){
                int i = k + j - n;
                ans[i][j] = Math.abs(ans[i][j] - set.size());
                set.add(grid[i][j]);
            }
        }
        return ans;
    }
}