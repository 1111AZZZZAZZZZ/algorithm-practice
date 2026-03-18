class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        ans = cal(nums,goal) - cal(nums,goal+1);
        return ans;
    }
    
    public int cal(int[] nums, int goal) {
        int ans = 0;
        int left = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            while(sum >= goal && left <= i){
                sum -= nums[left];
                left ++;
            }
            ans += left;
        }
        return ans;
    }
}