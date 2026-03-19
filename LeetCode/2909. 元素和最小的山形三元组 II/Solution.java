class Solution {
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] surfix = new int[n];
        surfix[n - 1] = nums[n - 1];
        for(int i = n - 2;i > 0;i--){
            surfix[i] = Math.min(surfix[i+1],nums[i]);
        }
        int pre = nums[0];
        for(int i = 0;i < n - 1;i++){
            if(pre < nums[i] && nums[i] > surfix[i+1]){
                ans = Math.min(ans,pre + nums[i] + surfix[i+1]);
            }
            pre = Math.min(pre,nums[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}