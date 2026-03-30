class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int s = 0;
        int[] cnt = new int[k];
        for(int i = 0;i < nums.length;i++){
            cnt[s] ++;
            s = ((s + nums[i])%k + k)%k;
            ans += cnt[s];
        }
        return ans;
    }
}