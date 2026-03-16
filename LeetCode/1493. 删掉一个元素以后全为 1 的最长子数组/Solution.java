class Solution {
  public int longestSubarray(int[] nums) {
    int ans = 0;
    int left = 0;
    int[] cnt = new int[2];
    // int[] dNums = new int[nums.length - 1];
    // List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      cnt[nums[i]]++;
      while (cnt[0] > 1) {
        cnt[nums[left]]--;
        left++;
      }
      ans = Math.max(ans, i - left);
    }
    // if(cnt[0] <= 1 && cnt[1]!=0){
    // ans --;
    // }
    return ans;
  }
}