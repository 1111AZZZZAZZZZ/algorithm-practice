import java.util.*;
class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < cards.length;i++){
            if(map.containsKey(cards[i])){
                ans = Math.min(ans,i - map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}