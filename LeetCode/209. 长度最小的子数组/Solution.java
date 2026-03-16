class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int ans = Integer.MAX_VALUE / 2;
    boolean flags = false;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= target) {
        flags = true;
        ans = Math.min(ans, i - left + 1);
        sum -= nums[left];
        left++;
      }
    }
    if (!flags) {
      ans = 0;
    }
    return ans;
  }
}