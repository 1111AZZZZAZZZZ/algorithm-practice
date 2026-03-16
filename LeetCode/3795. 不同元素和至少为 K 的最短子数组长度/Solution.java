class Solution {
  public int minLength(int[] nums, int k) {
    int ans = Integer.MAX_VALUE / 2;
    int left = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 入
      if (!map.containsKey(nums[i])) {
        sum += nums[i];
        map.put(nums[i], 1);
      } else {
        map.replace(nums[i], map.get(nums[i]) + 1);
      }
      while (sum >= k) {
        // 更新答案
        ans = Math.min(ans, i - left + 1);
        // 出
        int out = nums[left];

        map.replace(nums[left], map.get(out) - 1);
        left++;
        if (map.get(out) == 0) {
          sum -= out;
          map.remove(out);
        }
      }
    }
    return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
  }
}