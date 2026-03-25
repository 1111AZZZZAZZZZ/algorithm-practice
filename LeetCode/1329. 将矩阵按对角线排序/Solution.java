class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // k = i - j + n;j = i - k + n;
        for(int k = 1;k < m + n;k++){
            int minJ = Math.max(0,n - k);
            int maxJ = Math.min(n - 1,m+n-k-1);
            List<Integer> list = new ArrayList<>();
            for(int j = minJ;j <= maxJ;j++){
                int i = k + j - n;
                list.add(mat[i][j]);
            }
            list.sort(null);
            for(int j = minJ;j <= maxJ;j++){
                int i = k + j - n;
                mat[i][j] = list.get(j - minJ);
            }
        }
        return mat;
    }
}