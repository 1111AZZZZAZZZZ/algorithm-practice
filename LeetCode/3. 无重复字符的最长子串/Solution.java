import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int size = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) + 1);
                // left = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            ans = Math.max(i - left+1, ans); 
        }
        return ans;
    }
}