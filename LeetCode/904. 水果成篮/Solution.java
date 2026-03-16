class Solution {
  public int totalFruit(int[] fruits) {
    int ans = 0;
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < fruits.length; i++) {
      map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
      while (map.size() > 2) {
        map.replace(fruits[left], map.get(fruits[left]) - 1);
        if (map.get(fruits[left]) == 0) {
          map.remove(fruits[left]);
        }
        left++;
      }
      ans = Math.max(ans, i - left + 1);
    }
    return ans;
  }
}