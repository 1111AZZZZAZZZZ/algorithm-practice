class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum,-1);
        for(int[] g:grid){
            for(int i = 0;i < n;i++){
                colSum[i] += g[i];
            }
        }
        int rowSum = -1;
        for(int[] g:grid){
            rowSum = -1;
            for(int i = 0;i < n;i++){
                rowSum += g[i];
            }
            for(int i = 0;i < n;i++){
                if(g[i] == 1){
                    ans += (rowSum)*(colSum[i]);
                }
            }
        }
        
        return ans;
    }
}