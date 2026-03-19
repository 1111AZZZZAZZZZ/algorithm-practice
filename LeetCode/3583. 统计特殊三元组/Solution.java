class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        int mx = 0;
        for(int num : nums){
            mx = Math.max(mx,num);
        }
        int[] sur = new int[mx + 1];
        for(int num : nums){
            sur[num] ++;
        }
        int[] pre = new int[mx + 1];
        for(int num : nums ){
            sur[num] --;
            if(num * 2 <= mx){
                ans += (long)pre[num * 2] * sur[num * 2];
            }
            pre[num]++;
        }
        return (int)(ans % MOD);
    }
}