class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        ans[0] = lowerBound(nums,target);
        if(ans[0] == n || nums[ans[0]] != target){
            return new int[]{-1,-1};
        }
        ans[1] = lowerBound(nums,target+1)-1;
        // ans[0] = ans[0] == n? -1 : ans[0];
        return ans;
    }
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}