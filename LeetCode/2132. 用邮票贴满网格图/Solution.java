class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] s = new int[m+1][n+1];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + grid[i][j];
            }
        }
        int[][] d = new int[m+2][n+2];
        for(int i2 = stampHeight;i2 <= m;i2++){
            for(int j2 = stampWidth;j2<=n;j2++){
                int i1 = i2-stampHeight+1;
                int j1 = j2-stampWidth+1;
                if(s[i2][j2]-s[i2][j1-1]-s[i1-1][j2]+s[i1-1][j1-1]==0){
                    d[i1][j1]++;
                    d[i1][j2+1]--;
                    d[i2+1][j1]--;
                    d[i2+1][j2+1]++;
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                d[i+1][j+1]+=d[i+1][j]+d[i][j+1]-d[i][j];
                if(grid[i][j]==0&&d[i+1][j+1]==0){
                    return false;
                }
            }
        }
        return true;
    }
}