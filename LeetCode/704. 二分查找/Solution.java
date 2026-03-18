class Solution {
    public int search(int[] nums, int target) {
        int ans = 0;
        ans = lowerBound(nums,target);
        if(ans == nums.length || nums[ans] != target){//nums[ans] != target
            return -1;
        }
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
