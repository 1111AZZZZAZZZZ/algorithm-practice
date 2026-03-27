class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] sum = new int[n+1];
        for(int i = 0;i < n;i++){
            sum[i+1] = sum[i] + nums[i];
        }
        // nums[j] - nums[i] = k(j>=i)--> nums[i] = nums[j] - k(j>=i) 
        for(int i = 0;i < n+1;i++){
            int num = sum[i] - k;
            ans += map.getOrDefault(num,0);
            map.merge(sum[i],1,Integer::sum);
        }
        return ans;
    }
}