class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[] prefix = new int[n];
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
            prefix[i] = sum;
        }
        for(int i = 0;i < m;i++){
            int j = 0;
            while(j<n && prefix[j]<=queries[i]){
                j++;
            }
            ans[i] = j;
        }
        return ans;
    }
}