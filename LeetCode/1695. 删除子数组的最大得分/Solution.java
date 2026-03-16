class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    int ans = 0;
    int left = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (map.containsKey(nums[i])) {
        sum -= nums[left];
        map.remove(nums[left]);
        left++;
        // = Math.max(left,map.get(nums[i])+1);
      }

      map.put(nums[i], i);
      ans = Math.max(sum, ans);
    }
    return ans;
  }
}