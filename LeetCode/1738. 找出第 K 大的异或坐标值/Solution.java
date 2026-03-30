class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];
        int[] ans = new int[m*n];
        int cnt = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                prefix[i+1][j+1] = prefix[i+1][j]^prefix[i][j+1]^prefix[i][j]^matrix[i][j];
                ans[cnt++] = prefix[i+1][j+1];
            }
        }
        Arrays.sort(ans);
        return ans[m*n-k];
    }
}