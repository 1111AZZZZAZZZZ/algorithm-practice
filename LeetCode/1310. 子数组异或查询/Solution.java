class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] s = new int[arr.length+1];
        for(int i = 0;i < arr.length;i++){
            s[i+1] = s[i] ^ arr[i];
        }
        for(int i = 0;i < queries.length;i++){
            ans[i] = s[queries[i][1]+1] ^ s[queries[i][0]];
        }
        return ans;
    }
}