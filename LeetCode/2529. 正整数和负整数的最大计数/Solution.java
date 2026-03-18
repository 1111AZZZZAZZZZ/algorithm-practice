class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - lowerBound(nums,1);
        int neg = lowerBound(nums,0);
        int ans = Math.max(pos,neg);
        return ans;
    }
    public int lowerBound(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}