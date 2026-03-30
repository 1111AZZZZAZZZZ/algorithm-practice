class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                prefix[i+1][j+1] = prefix[i][j+1] + prefix[i+1][j]-prefix[i][j]+grid[i][j];
            }
        }
        // row1 = 0;col1 = 0;row2 = i;col2 = j
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int sum = prefix[i+1][j+1]-prefix[0][j+1]-prefix[i+1][0]+prefix[0][0];
                if(sum <= k){
                    ans++;
                }
            }
        }
        return ans;
    }
}