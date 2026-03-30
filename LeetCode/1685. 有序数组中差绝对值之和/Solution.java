class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] prefixLeft = new int[nums.length];
        int[] prefixRight = new int[nums.length];
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            prefix[i] = sum;
        }
        for(int i = 0;i < nums.length;i++){
            prefixLeft[i] = nums[i]*(i+1) - prefix[i];
            prefixRight[i] = prefix[nums.length-1] - prefix[i] - nums[i]*(nums.length-1-i);
            ans[i] = prefixLeft[i] + prefixRight[i];
        }
        return ans;
    }
}