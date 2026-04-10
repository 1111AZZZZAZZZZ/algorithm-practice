class Solution {
  public int magicTower(int[] nums) {
    long blood = 1;
    int ans = 0;
    PriorityQueue<Integer> q = new PriorityQueue<>();
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      blood += (long) num;
      list.add(num);
    }
    if (blood < 1) {
      return -1;
    } else {
      blood = 1;
    }
    int i = 0;
    int n = list.size();
    while (i < n) {
      int num = list.get(i);
      if (num < 0) {
        q.add(num);
      }
      blood += (long) num;
      if (blood < 1) {
        blood -= (long) q.poll();
        ans++;
        list.remove(i);
        list.add(num);
        i--;
      }
      i++;
    }
    return blood < 0 ? -1 : ans;
  }
}