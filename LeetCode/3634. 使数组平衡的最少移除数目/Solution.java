class Solution {
  public int minRemoval(int[] nums, int k) {
    int ans = 0;
    int min = 0;
    int max = 0;
    int left = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      max = nums[i];
      min = nums[left];
      while (max > (long) min * k) {
        left++;
        min = nums[left];
      }
      ans = Math.max(i - left + 1, ans);
    }
    return nums.length - ans;
  }
}