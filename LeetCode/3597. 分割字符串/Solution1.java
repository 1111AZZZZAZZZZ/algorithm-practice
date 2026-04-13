class Solution1 {
  public List<String> partitionString(String s) {
    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();
    String t = "";
    for (char c : s.toCharArray()) {
      t += c;
      if (set.add(t)) {
        ans.add(t);
        t = "";
      }
    }
    return ans;
  }
}