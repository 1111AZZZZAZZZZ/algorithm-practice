class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int mul = 1;
        if(k <= 1){
            return 0;
        }
        for(int i = 0;i < nums.length;i++){
            mul *= nums[i];
            while(mul >= k){
                mul /= nums[left];
                left++;
            }
            ans += i - left + 1; 
        }
        return ans;
    }
}
