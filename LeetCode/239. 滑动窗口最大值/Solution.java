class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> q = new ArrayDeque<>();
    int[] ans = new int[n - k + 1];
    for (int i = 0; i < n; i++) {
      // 维护单调性
      while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
        q.removeLast();
      }
      // 入
      q.addLast(i);
      // 出
      int left = i - k + 1;
      if (q.getFirst() < left) {
        q.removeFirst();
      }
      // 更新答案
      if (left >= 0) {
        ans[left] = nums[q.getFirst()];
      }
    }
    return ans;
  }
}