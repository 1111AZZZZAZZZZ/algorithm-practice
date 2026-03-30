class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] sum = new int[m+1][n+1];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]-sum[i][j]+mat[i][j];
            }
        }
        int s = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int row1 = Math.max(0,i - k);
                int col1 = Math.max(0,j - k);
                int row2 = Math.min(m-1,i + k);
                int col2 = Math.min(n-1,j + k);
                ans[i][j] = sum[row2+1][col2+1]-sum[row2+1][col1]-sum[row1][col2+1]+sum[row1][col1];
            }
        }
        return ans;
    }
}