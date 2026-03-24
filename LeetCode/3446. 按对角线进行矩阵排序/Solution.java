class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int k = 1; k < m + n; k++) {
            int minJ = Math.max(n - k, 0);
            int maxJ = Math.min(m + n - 1 - k, n - 1);
            List<Integer> a = new ArrayList<>(maxJ - minJ + 1);
            for (int j = minJ; j <= maxJ; j++) {
                a.add(grid[k + j - n][j]);
            }
            a.sort(minJ > 0 ? null : Comparator.reverseOrder());
            for (int j = minJ; j <= maxJ; j++) {
                grid[k + j - n][j] = a.get(j - minJ);
            }
        }
        return grid;
    }
}