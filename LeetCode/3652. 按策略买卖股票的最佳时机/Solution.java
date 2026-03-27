class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] profit = new long[n+1];
        long[] sum = new long[n+1];
        long ans = 0;
        long maxProfit = 0;
        for(int i = 0;i < n;i++){
            profit[i+1] = profit[i] + prices[i]*strategy[i];
            sum[i+1] = sum[i] + prices[i];
        }
        ans = profit[n];
        for(int i = k;i <= n;i++){
             maxProfit = profit[i - k] + (profit[n] - profit[i]) + (sum[i]-sum[i-k/2]);
             ans = Math.max(ans,maxProfit);
        }
        return ans;
    }
}