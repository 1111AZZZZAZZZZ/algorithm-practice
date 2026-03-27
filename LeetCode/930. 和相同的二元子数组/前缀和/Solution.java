class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        int[] sum = new int[n+1];
        for(int i = 0;i < n;i++){
            sum[i+1] = sum[i] + nums[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        // sum[j]-sum[i]=goal(j>i);->sum[i]=sum[j]-goal;
        for(int i = 0;i < n+1;i++){
            int diff = sum[i] - goal;
            if(map.containsKey(diff)){
                ans += map.get(diff);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return ans;
    }
}